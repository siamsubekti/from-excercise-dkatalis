package com.enigma.bootcamp.dkatalis.parking.exception;

public class ParkingSlotFullException extends RuntimeException{
    public ParkingSlotFullException(){
        super("Sorry, parking lot is full");
    }
}
