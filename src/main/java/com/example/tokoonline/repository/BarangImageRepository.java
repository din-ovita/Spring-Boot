package com.example.tokoonline.repository;

import com.example.tokoonline.model.BarangImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangImageRepository extends JpaRepository<BarangImage, Long> {
}
