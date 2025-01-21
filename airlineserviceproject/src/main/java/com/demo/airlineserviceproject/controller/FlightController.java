package com.demo.airlineserviceproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.airlineserviceproject.entity.Flight;
import com.demo.airlineserviceproject.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {

	
	@Autowired
	private FlightService service;
	
	@GetMapping
	public List<Flight> getAllFlights(@RequestParam(required = false) String source, 
			@RequestParam(required = false) String destination){
		if(source != null && destination!=null)
			return service.fetchAllFlightsSourceToDestination(source, destination);
		return service.fetchAllFlights();
	}
	
	@PostMapping
	public Flight addFlight(@RequestBody Flight flight) {
		System.out.println("Flight "+flight);
		return service.addNewFlight(flight);
	}
	@GetMapping("/{id}")
	public Flight getFlightById(@PathVariable int id){
		
		return service.getFlightById(id);
	}
	
}

