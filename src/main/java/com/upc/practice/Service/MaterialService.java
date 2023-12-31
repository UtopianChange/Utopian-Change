package com.upc.practice.Service;

import com.upc.practice.Model.Material;
import com.upc.practice.Repository.MaterialRepo;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private final MaterialRepo materialRepo;

    public MaterialService(MaterialRepo materialRepo) {
        this.materialRepo = materialRepo;
    }

    //Insertar
    public Material insert (Material material){ return materialRepo.save(material);}

    //Listar
    public List<Material> lsMaterial(){ return materialRepo.findAll();}

    //Buscar Precio por Nombre
    public Material listarPorNombre(String nombreM){
        return materialRepo.findByNombreMaterial(nombreM);
    }

    //modificar
    public Material modifica (Material material) throws Exception{
        Material mat= materialRepo.findById(material.getIdMaterial())
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de material no existe"));
        return materialRepo.save(material);
    }

    //Eliminar
    public Material eliminar(Long id) throws Exception{
        Material m=materialRepo.findById(id).orElseThrow(()->new OpenApiResourceNotFoundException("No se encontro el ID" + id));
        materialRepo.delete(m);
        return m;
    }
}
