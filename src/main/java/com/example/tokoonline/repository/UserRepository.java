package com.example.tokoonline.repository;

import com.example.tokoonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    to select * from user where email / query
    @Query(value = "select * from user where email = :email", nativeQuery = true)
        Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
