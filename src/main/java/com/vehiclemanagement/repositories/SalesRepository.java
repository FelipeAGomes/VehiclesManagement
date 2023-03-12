package com.vehiclemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclemanagement.entities.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long>{

}
