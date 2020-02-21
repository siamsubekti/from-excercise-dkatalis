package com.enigma.bootcamp.dkatalis.parking.model;

public class Car extends Vehicle {

    public Car(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return  false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Car car = (Car)obj;

        return this.getRegistrationNumber().equals(car.getRegistrationNumber());

    }
}
