package com.vehiclemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclemanagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
