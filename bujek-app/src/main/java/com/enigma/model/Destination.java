package com.enigma.model;

public class Destination {
	private City departure;
	private City arrival;
	
	public Destination(City departure, City arrival) {
		super();
		this.departure = departure;
		this.arrival = arrival;
	}
	public City getDeparture() {
		return departure;
	}
	public void setDeparture(City departure) {
		this.departure = departure;
	}
	public City getArrival() {
		return arrival;
	}
	public void setArrival(City arrival) {
		this.arrival = arrival;
	}
}
