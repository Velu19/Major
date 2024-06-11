package com.example.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.major.entity.Plans;



@Repository
public interface PlanRepository extends JpaRepository<Plans,Long> {
	
	//@Query("Select p from Plans p where p.")
	

}
