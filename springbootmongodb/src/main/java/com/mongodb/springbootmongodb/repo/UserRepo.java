package com.mongodb.springbootmongodb.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.springbootmongodb.model.User;

public interface UserRepo extends MongoRepository<User, String>{

}
