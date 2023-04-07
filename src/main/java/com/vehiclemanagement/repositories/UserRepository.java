package com.vehiclemanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehiclemanagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.email = :email and u.password = :password")
    Optional<User> findByEmail(String email, String password);
}
