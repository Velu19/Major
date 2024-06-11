package com.example.major.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class users {
	
	@Id
	@SequenceGenerator(
			name="user_sequence",
			sequenceName = "user_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "user_sequence"
	)
	private Long user_num;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true)
	private String Phonenumber;
	
	private String password;
	
	private String name;
	
	@Column(unique=true)
	private int accountNumber;
	
	
	public users() {
		
	}


	public users(String email, String phonenumber, String password,String name, int accountNumber) {
		super();
		this.email = email;
		this.Phonenumber = phonenumber;
		this.password = password;
		this.name = name;
		this.accountNumber = accountNumber;
	}


	public users(Long user_num, String email, String phonenumber, String password,String name, int accountNumber) {
		super();
		this.user_num = user_num;
		this.email = email;
		this.Phonenumber = phonenumber;
		this.password = password;
		this.name= name;
		this.accountNumber = accountNumber;
	}


	public Long getUser_num() {
		return user_num;
	}


	public void setUser_num(Long user_num) {
		this.user_num = user_num;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhonenumber() {
		return Phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.Phonenumber = phonenumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "users [user_num=" + user_num + ", email=" + email + ", Phonenumber=" + Phonenumber + ", password="
				+ password + ", name=" + name + ", accountNumber=" + accountNumber + "]";
	}



	
	
	
	
	

	
	

}
