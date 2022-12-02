package com.example.tokoonline.repository;

import com.example.tokoonline.model.PasaggerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasaggerTypeRepository extends JpaRepository<PasaggerType, Integer> {
}
