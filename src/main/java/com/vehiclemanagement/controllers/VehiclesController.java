package com.vehiclemanagement.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vehiclemanagement.entities.User;
import com.vehiclemanagement.entities.Vehicles;
import com.vehiclemanagement.services.VehiclesServices;

@RestController
@RequestMapping(value = "/vehicles")
public class VehiclesController {

	@Autowired
	private VehiclesServices service;

	@GetMapping
	public ResponseEntity<List<Vehicles>> findAll() {
		List<Vehicles> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/user/{id}")
	public ResponseEntity<List<Vehicles>> findByUser(User user){
		List<Vehicles> list = service.findByUser(user);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Vehicles> findById(@PathVariable Long id) {
		Vehicles obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}

	@PostMapping
	public ResponseEntity<Vehicles> insert(@RequestBody Vehicles obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Vehicles> update(@PathVariable Long id, @RequestBody Vehicles obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
