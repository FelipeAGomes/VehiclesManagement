package com.vehiclemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclemanagement.entities.Vehicles;
import com.vehiclemanagement.repositories.VehiclesRepository;

@Service
public class VehiclesServices {

	@Autowired
	private VehiclesRepository repository;

	public List<Vehicles> findAll() {
		return repository.findAll();

	}

	public Vehicles findById(Long id) {
		Optional<Vehicles> obj = repository.findById(id);
		return obj.get();

	}

	public Vehicles insert(Vehicles obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		repository.deleteById(id);

	}

	public Vehicles update(Long id, Vehicles obj) {
		Vehicles entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);

	}

	public void updateData(Vehicles entity, Vehicles obj) {
		entity.setBrand(obj.getBrand());
		entity.setCostPrice(obj.getCostPrice());
		entity.setModel(obj.getModel());

	}
}
