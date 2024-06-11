package com.example.major;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MajorProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MajorProjectApplication.class, args);
	}

}
