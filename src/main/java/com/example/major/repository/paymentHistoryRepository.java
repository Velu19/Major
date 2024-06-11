package com.example.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.major.entity.paymentHistory;

@Repository
public interface paymentHistoryRepository extends JpaRepository <paymentHistory,Long>{

	
	
}
