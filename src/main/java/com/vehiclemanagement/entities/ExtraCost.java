package com.vehiclemanagement.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_extraCost")
public class ExtraCost implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Double totalCost;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicles vehicles;

	public ExtraCost() {

	}

	public ExtraCost(Long id, String description, Double totalCost, Vehicles vehicles) {
		super();
		this.id = id;
		this.description = description;
		this.totalCost = totalCost;
		this.vehicles = vehicles;
	}

	public Vehicles getVehicles() {
		return vehicles;
		
	}
	
	public void setVehicles(Vehicles vehicles) {
		this.vehicles = vehicles;
	}
	
	public Long getId() {
		return id;

	}

	public void setId(Long id) {
		this.id = id;

	}

	public String getDescription() {
		return description;

	}

	public void setDescription(String description) {
		this.description = description;

	}

	public Double getTotalCost() {
		return totalCost;

	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;

	}

	@Override
	public int hashCode() {
		return Objects.hash(id);

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtraCost other = (ExtraCost) obj;
		return Objects.equals(id, other.id);

	}

}
