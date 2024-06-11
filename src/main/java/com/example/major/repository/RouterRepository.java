package com.example.major.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.major.entity.Routers;

@Repository
public interface RouterRepository extends JpaRepository<Routers,Long>{

	
	
	@Query("Select r from Routers r where r.routerID= ?1")
	Optional<Routers> findbyRouters(Long routerID);
	
	@Query("Select r from Routers r where r.accountNumber= ?1")
	Optional<Routers> findbyaccount(int accountNumber);
	
	
	@Query("Select r from Routers r where r.ssid= ?1")
	Optional<Routers> findbyssid(String ssid);
	
	
	@Query("Select r from Routers r where r.serialNumber= ?1")
	Optional<Routers> findbyserialNumber(String serialNumber);
	
	
	
}
