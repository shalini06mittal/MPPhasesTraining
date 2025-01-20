package com.mongodb.springbootmongodb.controller;

import java.util.List;

import com.mongodb.springbootmongodb.model.User;

public class Response {
	
	Integer code;
	String message;
	List<User> users;
	public Response() {
		// TODO Auto-generated constructor stub
	}
	
	public Response(Integer code, String message, List<User> users) {
		super();
		this.code = code;
		this.message = message;
		this.users = users;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	

}
