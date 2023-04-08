package com.vehiclemanagement.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vehiclemanagement.entities.User;
import com.vehiclemanagement.entities.Vehicles;

public interface VehiclesRepository extends JpaRepository<Vehicles, Long>{
@Query("SELECT v from Vehicles v WHERE v.user =:user")
List<Vehicles> findByUser(User user); 
}
