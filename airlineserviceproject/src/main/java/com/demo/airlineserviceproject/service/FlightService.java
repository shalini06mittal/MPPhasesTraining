package com.demo.airlineserviceproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.airlineserviceproject.entity.Flight;
import com.demo.airlineserviceproject.repo.FlightRepo;


import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FlightService {

	@Autowired
	private FlightRepo repo;

	public List<Flight> fetchAllFlights(){

		return repo.findAll();
	}
	public Flight addNewFlight(Flight flight){
		if(repo.existsById(flight.getFlightid()))
			throw new EntityExistsException("Cannot add "+flight.getFlightid()+" already exists");
		return repo.save(flight);

	}
	
	public Flight getFlightById(int id){
		if(!repo.existsById(id))
			throw new EntityNotFoundException(id+" not found");
		return repo.findById(id).get();
	}

	public List<Flight> fetchAllFlightsSourceToDestination(String source, String destination){

		return repo.findAllBySourceAndDestination(source, destination);
	}
	

}
