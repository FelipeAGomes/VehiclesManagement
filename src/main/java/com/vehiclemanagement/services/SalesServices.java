package com.vehiclemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclemanagement.entities.Sales;
import com.vehiclemanagement.entities.User;
import com.vehiclemanagement.repositories.SalesRepository;

@Service
public class SalesServices {

	@Autowired
	private SalesRepository repository;

	public List<Sales> findAll() {
		return repository.findAll();

	}

	public Sales findById(Long id) {
		Optional<Sales> obj = repository.findById(id);
		return obj.get();

	}

	public List<Sales> findByUser(User user){
		return repository.findByUser(user);
	}

	public Sales insert(Sales obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		repository.deleteById(id);

	}

	public Sales update(Long id, Sales obj) {
		Sales entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);

	}

	public void updateData(Sales entity, Sales obj) {
		entity.setData(obj.getData());
		entity.setPrice(obj.getPrice());
		entity.setVehicles(obj.getVehicles());
	}
}
