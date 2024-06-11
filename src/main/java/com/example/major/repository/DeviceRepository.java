package com.example.major.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.major.entity.Devices;


@Repository
public interface DeviceRepository extends JpaRepository<Devices,Long>{
	
	
	
	@Query("Select d from Devices d where d.mac  = ?1")
	Optional<Devices> findbymac(String mac);
	
	@Query("Select d from Devices d where d.deviceId  = ?1")
	Optional<Devices> findbydeviceId(String deviceId);
	
	

}
