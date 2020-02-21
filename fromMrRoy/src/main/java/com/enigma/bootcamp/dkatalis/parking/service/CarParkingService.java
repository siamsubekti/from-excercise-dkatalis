package com.enigma.bootcamp.dkatalis.parking.service;

import com.enigma.bootcamp.dkatalis.parking.exception.InvalidNumberOfSlotException;

public class CarParkingService extends ParkingService {

    public CarParkingService(Integer numberOfCarSlots) throws InvalidNumberOfSlotException {
        super(numberOfCarSlots);
    }

    public Double calculatePrice(Integer hour) {
        Double first2HourPrice = new Double(10);
        if(hour <= 2){
            return first2HourPrice;
        }else{
            return first2HourPrice + ((hour-2) * 10);
        }
    }


}
