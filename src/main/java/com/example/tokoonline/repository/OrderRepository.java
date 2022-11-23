package com.example.tokoonline.repository;

import com.example.tokoonline.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select * from orders where pemilik = :pemilik", nativeQuery = true)
    Optional<Order> findByPemilik(String pemilik);
}
