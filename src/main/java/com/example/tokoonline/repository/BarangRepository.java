package com.example.tokoonline.repository;

import com.example.tokoonline.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Integer> {
}
