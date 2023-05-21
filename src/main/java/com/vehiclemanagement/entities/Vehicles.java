package com.vehiclemanagement.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vehiclemanagement.entities.enums.Status;

@Entity
@Table(name = "tb_vehicles")
public class Vehicles implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String model;
	private Double costPrice;
	
	@OneToMany(mappedBy = "vehicles")
	private List<ExtraCost> extraCost = new ArrayList<>();
	
	// import from enum
	private Integer status;

	// @JsonBackReference to stop infinite loop and @JsonManagedReference on class user
	// @JsonManagedReference annotation for the first objects instantiated
	// @JsonBackReference annotation for the second objects instantiated
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Sales sales;

	public Vehicles() {

	}

	public Vehicles(Long id, String brand, String model, Double costPrice, Double totalCost,
			Status status, User user, Sales sales) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.costPrice = costPrice;
		setStatus(status);
		this.user = user;
		this.sales = sales;
	}

	public Sales getSales() {
		return sales;
	}

	public void setSales(Sales sales) {
		this.sales = sales;
	}

	public List<ExtraCost> getExtraCost() {
		return extraCost;
	}
	
	// TOTAL COST
	public Double getTotalCost() {
		double sum = 0.0;
		for(ExtraCost x : extraCost) {
			sum += x.getTotalCost();
		}	
		return costPrice + sum;
	}

	//TOTAL EXTRA COST
	public Double getTotalExtraCost() {
		double sum = 0.0;
		for(ExtraCost x : extraCost) {
			sum += x.getTotalCost();
		}	
		return sum;
	}

	// User getter and setter
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// Status getter and setter
	public Status getStatus() throws IllegalAccessException {
		return Status.valueOf(status);
	}

	public void setStatus(Status status) {
		if (status != null) {
			this.status = status.getCode();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
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
		Vehicles other = (Vehicles) obj;
		return Objects.equals(id, other.id);
	}

}
