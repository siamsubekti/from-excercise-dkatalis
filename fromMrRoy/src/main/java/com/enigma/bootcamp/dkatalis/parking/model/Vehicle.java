package com.enigma.bootcamp.dkatalis.parking.model;

import java.util.Objects;

public abstract class Vehicle {
    protected String registrationNumber;
    protected String color;

    public Vehicle(String registrationNumber){
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
