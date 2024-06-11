package com.example.major.configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.major.entity.Customers;
import com.example.major.entity.users;

import com.example.major.repository.UserRepository;

@Configuration
public class usersConfiguration {
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository ) {
		return args ->{
			
			users velu = new users(
					"naveen@gmail.com",
					"+917904482942",
					"hello",
					"Naveen PK",
					1
					);
			
			users guru = new users(
					"guru@gmail.com",
					"+919344062366",
					"hello",
					"guru",
					2
					);
			
			
		
			
			users nivi = new users(
					"nivi@gmail.com",
					"+919789096749",
					"hello",
					"nivedha",
					4
					);
			
			users srija  = new users(
					"srija@gmail.com",
					"+919361675460",
					"hello",
					"srija",
					5
					);
			
			
			userRepository.saveAll(List.of(velu,guru,nivi,srija));
			
			
		};

	}

}
