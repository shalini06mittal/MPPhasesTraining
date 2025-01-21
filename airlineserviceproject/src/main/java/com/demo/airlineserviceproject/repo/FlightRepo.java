package com.demo.airlineserviceproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.airlineserviceproject.entity.Flight;

public interface FlightRepo extends JpaRepository<Flight, Integer>{

	public List<Flight> findAllBySourceAndDestination(String source, String destintion);
}
