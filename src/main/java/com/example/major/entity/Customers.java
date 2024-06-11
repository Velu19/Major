package com.example.major.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {
	
	
	@Id
	@SequenceGenerator(
			name="customer_sequence",
			sequenceName = "customer_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "customer_sequence"
	)
	private Long customer_num;
	
	private String name;
	
	private String address;
	
	@Column(unique=true)
	private String email;
	
	
	@Column(unique=true)
	private String phonenumber;
	
	@Column(unique=true)
	private int accountNumber;
	
	
	@JsonManagedReference("customers-plans")
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
	private List<Plans> plans;
	
	@JsonManagedReference
	@OneToMany(mappedBy="customerhistory", cascade = CascadeType.ALL)
	private List<paymentHistory> payments;

	
	
	public Customers() {
		
	}
	
	

	public Customers(Long customer_num, String name, String address, String email, String phonenumber,
			int accountNumber, List<Plans> plans) {
		super();
		this.customer_num = customer_num;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phonenumber = phonenumber;
		this.accountNumber = accountNumber;
		this.plans = plans;
	}



	public Customers(String name, String address, String email, String phonenumber, int accountNumber) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phonenumber = phonenumber;
		this.accountNumber = accountNumber;
	}

	public Customers(Long customer_num, String name, String address, String email, String phonenumber,
			int accountNumber) {
		super();
		this.customer_num = customer_num;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phonenumber = phonenumber;
		this.accountNumber = accountNumber;
	}
	
	
	
	
	
	public Customers(String name, String address, String email, String phonenumber, int accountNumber,
			List<Plans> plans, List<paymentHistory> payments) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.phonenumber = phonenumber;
		this.accountNumber = accountNumber;
		this.plans = plans;
		this.payments = payments;
	}



	public Long getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(Long customer_num) {
		this.customer_num = customer_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getphonenumber() {
		return phonenumber;
	}

	public void setphonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	public List<Plans> getPlans() {
		return plans;
	}



	public void setPlans(List<Plans> plans) {
		this.plans = plans;
	}
	

	public List<paymentHistory> getPayments() {
		return payments;
	}



	public void setPayments(List<paymentHistory> payments) {
		this.payments = payments;
	}



	@Override
	public String toString() {
		return "Customers [customer_num=" + customer_num + ", name=" + name + ", address=" + address + ", email="
				+ email + ", phonenumber=" + phonenumber + ", accountNumber=" + accountNumber + ", plans=" + plans
				+ ", payments=" + payments + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
