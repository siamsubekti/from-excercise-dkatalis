package com.enigma.bootcamp.dkatalis.parking.model;

public class ParkingSlot {
    private Vehicle vehicle;
    private Integer slot;

    public ParkingSlot(Vehicle vehicle, Integer slot){
        this.vehicle = vehicle;
        this.slot = slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    @Override
    public String toString(){
        return String.format("%s %s", slot+1, vehicle.getRegistrationNumber());
    }
}
