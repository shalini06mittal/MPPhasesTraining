package com.training.springbootrestdemo.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloRestController {

	@GetMapping // fetch - select, have verbs, REST API endpoint - nouns
	public String getData() {
		//
		return "getting data";
	}
	@PostMapping // insert
	public String postData() {
		return "inserting data";
	}
	@DeleteMapping// delete
	public String deleteData() {
		return "deleting data";
	}
	@PutMapping// update
	public String putData() {
		return "updating data";
	}
}
// postman