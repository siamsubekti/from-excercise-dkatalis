package com.enigma.bootcamp.dkatalis.parking.controller;

import com.enigma.bootcamp.dkatalis.parking.exception.CarNotFoundException;
import com.enigma.bootcamp.dkatalis.parking.exception.ParkingSlotFullException;
import com.enigma.bootcamp.dkatalis.parking.model.ParkingSlot;
import com.enigma.bootcamp.dkatalis.parking.model.Vehicle;
import com.enigma.bootcamp.dkatalis.parking.service.CarParkingService;

public class CarParkingController {
    CarParkingService carParkingService;
    public CarParkingController(Integer numberOfSlot){
        carParkingService = new CarParkingService(numberOfSlot);
        System.out.println(String.format("Created parking lot with %s slots", numberOfSlot));
    }

    public String park(Vehicle vehicle){
        try{
            ParkingSlot parkingSlot = carParkingService.park(vehicle);
            return String.format("Allocated slot number: %s", parkingSlot.getSlot()+1);
        }catch (ParkingSlotFullException exception){
            return exception.getMessage();
        }
    }

    public String leave(Vehicle vehicle, Integer hour){
        try {
            ParkingSlot parkingSlot = carParkingService.leave(vehicle);
            Double price = carParkingService.calculatePrice(hour);
            return String.format("Registration number %s with Slot Number %s is free with Charge %s", vehicle.getRegistrationNumber(), parkingSlot.getSlot()+1, String.valueOf(price));

        }catch (CarNotFoundException exception){
            return String.format("Registration number %s not found", vehicle.getRegistrationNumber());
        }
    }

    public String getStatus(){
        return carParkingService.getParkingSlotStatus();
    }
}
