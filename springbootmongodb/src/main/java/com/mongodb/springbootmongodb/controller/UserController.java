package com.mongodb.springbootmongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.springbootmongodb.model.Address;
import com.mongodb.springbootmongodb.model.User;
import com.mongodb.springbootmongodb.repo.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	@PostMapping
	public ResponseEntity<Response> addUser(@RequestBody User user){
		
		
		System.out.println(user);
		try {
		
			System.out.println(userRepo.save(user));
		
		Response response =new Response(101, "User saved", userRepo.findAll());
		
		return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}catch(Exception e) {
			Response response =new Response(301, "User not saved "+e.getMessage(), null);
			
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
