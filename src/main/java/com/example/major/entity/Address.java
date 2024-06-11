package com.example.major.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Address {
	
	@Id
	@SequenceGenerator(
			name="address_sequence",
			sequenceName = "address_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "address_sequence"
	)
	private Long AddressId;
	
	private String area;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy="address", cascade = CascadeType.ALL)
	private List<Routers> router;
	
	
	
	public Address() {
		
	}


	public Address(Long addressId, String area, List<Routers> router) {
		super();
		this.AddressId = addressId;
		this.area = area;
		this.router = router;
	}



	public Address(String area) {
		super();
		this.area = area;
	}



	public Long getAddressId() {
		return AddressId;
	}



	public void setAddressId(Long addressId) {
		AddressId = addressId;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public List<Routers> getRouter() {
		return router;
	}



	public void setRouter(List<Routers> router) {
		this.router = router;
	}



	@Override
	public String toString() {
		return "Address [AddressId=" + AddressId + ", area=" + area + ", router=" + router + "]";
	}
	
	
	
	
	

}
