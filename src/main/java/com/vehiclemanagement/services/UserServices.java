package com.vehiclemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiclemanagement.entities.User;
import com.vehiclemanagement.repositories.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();

	}

	public User findByEmail(String email, String password){
		Optional<User> obj = repository.findByEmail(email, password);
		return obj.get();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();

	}

	public User insert(User obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		repository.deleteById(id);

	}

	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);

	}

	public void updateData(User entity, User obj) {
		entity.setFirstName(obj.getFirstName());
		entity.setLastName(obj.getLastName());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());

	}
}
