package com.enigma.bootcamp.dkatalis.parking.service;

import com.enigma.bootcamp.dkatalis.parking.exception.CarNotFoundException;
import com.enigma.bootcamp.dkatalis.parking.exception.InvalidNumberOfSlotException;
import com.enigma.bootcamp.dkatalis.parking.exception.ParkingSlotFullException;
import com.enigma.bootcamp.dkatalis.parking.model.ParkingSlot;
import com.enigma.bootcamp.dkatalis.parking.model.Vehicle;

public abstract class ParkingService {
    protected ParkingSlot[] parkingSlots;
    protected Integer numOfAvailableSlots;

    public ParkingService(Integer numberOfCarSlots) throws InvalidNumberOfSlotException {
        if(numberOfCarSlots == null || numberOfCarSlots < 1)
            throw new InvalidNumberOfSlotException(numberOfCarSlots);

        //System.out.println(String.format("Created parking lot with %s slots", numberOfCarSlots));
        parkingSlots = new ParkingSlot[numberOfCarSlots];
        numOfAvailableSlots = numberOfCarSlots;
    }

    public synchronized ParkingSlot park(Vehicle vehicle){
        if(numOfAvailableSlots < 1){
            throw new ParkingSlotFullException();
        }

        for (int i = 0; i < parkingSlots.length; i++) {
            if(parkingSlots[i]==null){
                parkingSlots[i] = new ParkingSlot(vehicle, i);
                numOfAvailableSlots--;
                return parkingSlots[i];
            }
        }

        throw new ParkingSlotFullException();
    }

    public synchronized ParkingSlot leave(Vehicle vehicle){
        for (int i = 0; i < parkingSlots.length; i++) {
            if(parkingSlots[i]!=null && parkingSlots[i].getVehicle()!=null && vehicle.equals(parkingSlots[i].getVehicle())){
                ParkingSlot exitingSlot = parkingSlots[i];
                parkingSlots[i] = null;
                numOfAvailableSlots++;
                return exitingSlot;
            }
        }
        throw new CarNotFoundException();
    }

    public Integer getNumOfAvailableSlots() {
        return numOfAvailableSlots;
    }

    public String getParkingSlotStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Slot No. Registration No. \n");

        for (ParkingSlot parkingSlot: parkingSlots) {
            if(parkingSlot!=null){
                sb.append(parkingSlot);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public abstract Double calculatePrice(Integer hour);
}
