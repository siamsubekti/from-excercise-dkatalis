package com.enigma.bootcamp.dkatalis.parking.exception;

public class InvalidNumberOfSlotException extends RuntimeException {
    public InvalidNumberOfSlotException(){
        super("invalid number of parking slots");
    }
    public InvalidNumberOfSlotException(Integer numberOfCarSlots){
        super(String.format("%s is invalid number of parking slots", numberOfCarSlots));
    }
}
