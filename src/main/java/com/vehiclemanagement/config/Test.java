package com.vehiclemanagement.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vehiclemanagement.entities.ExtraCost;
import com.vehiclemanagement.entities.Sales;
import com.vehiclemanagement.entities.User;
import com.vehiclemanagement.entities.Vehicles;
import com.vehiclemanagement.entities.enums.Status;
import com.vehiclemanagement.repositories.ExtraCostRepository;
import com.vehiclemanagement.repositories.SalesRepository;
import com.vehiclemanagement.repositories.UserRepository;
import com.vehiclemanagement.repositories.VehiclesRepository;

@Configuration
public class Test implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VehiclesRepository vehiclesRepository;

	@Autowired
	private SalesRepository salesRepository;

	@Autowired
	private ExtraCostRepository extraCostRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Rogerio", "Gomes", "rogerAuto@gmail.com", "1234");

		Sales sales1 = new Sales(null, 8000.0, Instant.parse("2023-02-20T19:53:07Z"), 5000.0, user1);
		Sales sales2 = new Sales(null, 98000.0, Instant.parse("2023-02-20T19:53:07Z"), 3500.0, user1);

		

		Vehicles vehicles1 = new Vehicles(null, "Mercedes", "GLA250", 1500.50, null, Status.SOLD, user1,
				sales1);
		Vehicles vehicles2 = new Vehicles(null, "Audi", "A6", 9900.50, null, Status.SOLD, user1, sales2);
		Vehicles vehicles3 = new Vehicles(null, "Volvo", "V40", 90900.50, null, Status.TO_SELL, user1, null);
		
		ExtraCost extracost1 = new ExtraCost(null, "Service", 150.0, vehicles1);
		ExtraCost extracost2 = new ExtraCost(null, "Service2", 1050.0, vehicles2);
		ExtraCost extracost3 = new ExtraCost(null, "Service3", 1500.0, vehicles1);
		
		
		userRepository.saveAll(Arrays.asList(user1));
		extraCostRepository.saveAll(Arrays.asList(extracost1, extracost2, extracost3));
		vehiclesRepository.saveAll(Arrays.asList(vehicles1, vehicles2, vehicles3));
		salesRepository.saveAll(Arrays.asList(sales1, sales2));
	}
}
