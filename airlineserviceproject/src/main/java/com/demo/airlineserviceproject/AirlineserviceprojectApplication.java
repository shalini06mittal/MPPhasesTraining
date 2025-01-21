package com.demo.airlineserviceproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.airlineserviceproject.entity.Flight;
import com.demo.airlineserviceproject.repo.FlightRepo;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class AirlineserviceprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineserviceprojectApplication.class, args);
	}
	
	@Autowired
	private FlightRepo flightRepo;
	
	@PostConstruct
	public void initialize() {
		Flight f1 = new Flight();
		f1.setDestination("Mumbai");
		f1.setSource("Delhi");
		f1.setEndtime("14:00");
		f1.setStarttime("12:10");
		f1.setPrice(3000);
		f1.setFlightname("Air India");
		Flight f2 = new Flight();
		f2.setDestination("Mumbai");
		f2.setSource("Delhi");
		f2.setEndtime("8:50");
		f2.setStarttime("7:00");
		f2.setPrice(4000);
		f2.setFlightname("Air India");
		Flight f3 = new Flight();
		f3.setDestination("Mumbai");
		f3.setSource("Delhi");
		f3.setEndtime("22:00");
		f3.setStarttime("20:00");
		f3.setPrice(6000);
		f3.setFlightname("Indigo");
		Flight f4 = new Flight();
		f4.setDestination("Pune");
		f4.setSource("Hyd");
		f4.setEndtime("10:30");
		f4.setStarttime("8:10");
		f4.setPrice(4500);
		f4.setFlightname("Air India");
		Flight f5 = new Flight();
		f5.setDestination("Pune");
		f5.setSource("Hyd");
		f5.setEndtime("12:00");
		f5.setStarttime("10:10");
		f5.setPrice(5500);
		f5.setFlightname("Indigo");
		
		flightRepo.saveAll(Arrays.asList(f1, f2, f3, f4, f5));
	}

}
