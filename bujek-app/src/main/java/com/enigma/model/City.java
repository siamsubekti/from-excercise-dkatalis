package com.enigma.model;

public class City {
	private String name;
	private Integer locationPoint;
	
	public City(String name, Integer locationPoint) {
		this.name = name;
		this.locationPoint = locationPoint;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLocationPoint() {
		return locationPoint;
	}
	public void setLocationPoint(Integer locationPoint) {
		this.locationPoint = locationPoint;
	}
	
	
	
	

}
