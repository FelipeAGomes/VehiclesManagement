package com.vehiclemanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehiclemanagement.entities.Sales;
import com.vehiclemanagement.entities.User;


public interface SalesRepository extends JpaRepository<Sales, Long>{
@Query("SELECT s from Sales s WHERE s.user =:user")
List<Sales> findByUser(User user);
}
