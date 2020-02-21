package com.enigma.model;

public class Order {
	private Customer customer;
	private Destination destinantion;
	private Double time;
	
	public Order(Customer customer, Destination destinantion, Double time) {
		this.customer = customer;
		this.destinantion = destinantion;
		this.time = time;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Destination getDestinantion() {
		return destinantion;
	}
	public void setDestinantion(Destination destinantion) {
		this.destinantion = destinantion;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	} 
		
}
