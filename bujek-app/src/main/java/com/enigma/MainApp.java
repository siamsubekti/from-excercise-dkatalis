package com.enigma;

import java.util.HashMap;
import java.util.Map;

import com.enigma.constant.ConstantCityLocation;
import com.enigma.model.City;

public class MainApp {
	
	Map<Integer, String> cities = new HashMap<Integer, String>(); 
	
	static City jakarta = ConstantCityLocation.A;
	static City bandung = ConstantCityLocation.B;
	static Double time = 15.00;
	
	public static void main(String[] args) {
		System.out.println("Distance of city :" + distance(jakarta, bandung));
		
		System.out.println("Charge per km " + chargePerKm(time));
		
		System.out.println("Total fee :" + totalFee(jakarta, bandung, time));
	}

	public static Integer distance(City cityA, City cityB) {
		if (cityA.getLocationPoint() > cityB.getLocationPoint()) {
			int dist = cityA.getLocationPoint() - cityB.getLocationPoint();
			return dist;
		}
		int dist = cityB.getLocationPoint() - cityA.getLocationPoint();
		return dist;
	}

	public static Integer chargePerKm(Double time) {
		if (time > 06.00 && time <= 09.00) {
			return 5000;
		} else if (time > 09.00 && time <= 15.00) {
			return 3000;
		} else if (time > 15.00 && time <= 20.00) {
			return 6000;
		}
		return 2000;
	}

	public static Integer totalFee(City cityA, City cityB, Double time) {
		int chargePerKm = chargePerKm(time);
		int distance = distance(cityA, cityB);
		return distance * chargePerKm;
	}

}
