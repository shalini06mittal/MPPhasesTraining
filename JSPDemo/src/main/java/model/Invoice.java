package model;

import java.time.LocalDate;

public class Invoice {

	private int invno;
	private String customer;
	private LocalDate invdate;
	private LocalDate deldate;
	private double amount;
	private String address;
	public Invoice() {
		// TODO Auto-generated constructor stub
	}
	public Invoice(String customer, LocalDate deldate, double amount, String address) {
		super();
		this.customer = customer;
		this.deldate = deldate;
		this.amount = amount;
		this.address = address;
	}
	public int getInvno() {
		return invno;
	}
	public void setInvno(int invno) {
		this.invno = invno;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public LocalDate getInvdate() {
		return invdate;
	}
	public void setInvdate(LocalDate invdate) {
		this.invdate = invdate;
	}
	public LocalDate getDeldate() {
		return deldate;
	}
	public void setDeldate(LocalDate deldate) {
		this.deldate = deldate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Invoice [invno=" + invno + ", customer=" + customer + ", invdate=" + invdate + ", deldate=" + deldate
				+ ", amount=" + amount + ", address=" + address + "]";
	}
	
}
