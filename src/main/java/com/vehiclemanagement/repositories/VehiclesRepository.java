package com.vehiclemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehiclemanagement.entities.Vehicles;

public interface VehiclesRepository extends JpaRepository<Vehicles, Long>{

}
