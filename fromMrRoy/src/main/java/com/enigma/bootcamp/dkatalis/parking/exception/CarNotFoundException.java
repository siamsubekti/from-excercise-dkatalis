package com.enigma.bootcamp.dkatalis.parking.exception;

public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(){
        super("Car not found");
    }
}
