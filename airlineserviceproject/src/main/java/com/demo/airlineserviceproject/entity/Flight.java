package com.demo.airlineserviceproject.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightid;
	private String flightname;
	private String starttime;
	private String endtime;
	private String source;
	private String destination;
	private double price;
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(Integer flightid, String flightname, String starttime, String endtime, String source,
			String destination, double price) {
		super();
		this.flightid = flightid;
		this.flightname = flightname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.source = source;
		this.destination = destination;
		this.price = price;
	}

	public int getFlightid() {
		return flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	public String getFlightname() {
		return flightname;
	}

	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", flightname=" + flightname + ", starttime=" + starttime + ", endtime="
				+ endtime + ", source=" + source + ", destination=" + destination + ", price=" + price + "]";
	}
	
}
