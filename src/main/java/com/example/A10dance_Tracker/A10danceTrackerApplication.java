package com.example.A10dance_Tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class A10danceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(A10danceTrackerApplication.class, args);
	}

}
