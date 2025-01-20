package com.mongodb.springbootmongodb.model;

public class Address {

	String addrline;
	String city;
	String state;
	String zipcode;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(String addrline, String city, String state, String zipcode) {
		super();
		this.addrline = addrline;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public String getAddrline() {
		return addrline;
	}
	public void setAddrline(String addrline) {
		this.addrline = addrline;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Address [addrline=" + addrline + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	
}
