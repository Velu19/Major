package com.example.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.major.entity.Bills;

public interface BillRepository extends JpaRepository<Bills,Long>{

}
