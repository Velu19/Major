package com.example.major.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.major.entity.Customers;


@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long>{
	
	@Query("Select c from Customers c where c.accountNumber=?1")
	Optional<Customers> findCustomerByaccountNum(int accountNumber);
	
	
	@Query("select c from Customers c where c.name=?1")
	Optional<Customers> findCustomerByName(String name);
	
	@Query("select c from Customers c where c.email=?1")
	Optional<Customers> findCustomerByEmail(String email);
	
	@Query("select c from Customers c where c.phonenumber=?1")
	Optional<Customers> findCustomerByPhone(String phonenumber);
	

}
