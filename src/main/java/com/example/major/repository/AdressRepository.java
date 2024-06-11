package com.example.major.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.major.entity.Address;
import com.example.major.entity.Routers;


@Repository
public interface AdressRepository extends JpaRepository<Address,Long>{
	
	@Query("Select a from Address a where a.area= ?1")
	Optional<Address> findbyarea(String area);
	
	
}
