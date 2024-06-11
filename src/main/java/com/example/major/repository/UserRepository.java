package com.example.major.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.major.entity.users;


@Repository
public interface UserRepository  extends JpaRepository<users,Long>{
	
	//users findbyEmail(String email);
	
	@Query("Select s from users s where s.email= ?1")
	Optional<users> findStudentByEmail(String email);
	
	
	@Query("Select s from users s where s.Phonenumber= ?1")
	Optional<users> findStudentByPhone(String Phonenumber);
}
