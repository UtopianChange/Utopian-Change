package com.upc.practice.Repository;

import com.upc.practice.Model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Long> {
}