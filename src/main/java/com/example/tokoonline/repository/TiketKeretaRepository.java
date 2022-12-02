package com.example.tokoonline.repository;

import com.example.tokoonline.model.TiketKereta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiketKeretaRepository extends JpaRepository<TiketKereta, Long> {
}
