package com.demo.airlinefrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.demo.airlinefrontend.model.Flight;

@Controller
public class FlightController {

	@Autowired
	private RestTemplate template;
	String url = "http://localhost:8080/flights";
	
	@GetMapping("/list")
	public String getAllFlights(@RequestParam(required = false) String source,
			@RequestParam(required = false) String destination,Model model){
		ResponseEntity<List<Flight>> response = null;
		if(source != null && destination!=null) {
			response = template.exchange(url+"?source="+source+"&destination="+destination, HttpMethod.GET, null, new ParameterizedTypeReference<List<Flight>>() {
			});
		}
		else
		response = template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Flight>>() {
		});
		List<Flight> flights = response.getBody();
		model.addAttribute("flights", flights);
		return "flightlist";
		
	}
	
	@GetMapping("/add")
	public String addFlightForm() {
		return "flightform";
	}
	@PostMapping("/add")
	public String addNewFlight(@ModelAttribute Flight flight) {
		
		flight.setFlightid(0);
		System.out.println(flight);
		Flight flightsaved = template.postForObject(url, flight, Flight.class);
		
		System.out.println(flightsaved);
		
		return "redirect:/list";
	}
	
}
