package com.vehiclemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclemanagement.entities.ExtraCost;
import com.vehiclemanagement.repositories.ExtraCostRepository;

@Service
public class ExtraCostServices {

	@Autowired
	private ExtraCostRepository repository;

	public List<ExtraCost> findAll() {
		return repository.findAll();

	}

	public ExtraCost findById(Long id) {
		Optional<ExtraCost> obj = repository.findById(id);
		return obj.get();

	}

	public ExtraCost insert(ExtraCost obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		repository.deleteById(id);

	}

	public ExtraCost update(Long id, ExtraCost obj) {
		ExtraCost entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);

	}

	public void updateData(ExtraCost entity, ExtraCost obj) {
		entity.setDescription(obj.getDescription());
		entity.setTotalCost(obj.getTotalCost());
	}
}
