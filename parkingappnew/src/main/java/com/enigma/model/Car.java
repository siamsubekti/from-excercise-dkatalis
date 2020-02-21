package com.enigma.model;

import java.util.Objects;

public class Car {
    private String lincenseNumber;

    public Car(String lincenseNumber) {
        this.lincenseNumber = lincenseNumber;
    }

    public String getLincenseNumber() {
        return lincenseNumber;
    }

    public void setLincenseNumber(String lincenseNumber) {
        this.lincenseNumber = lincenseNumber;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Car car = (Car) obj;
        return this.hashCode() == car.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(lincenseNumber);
    }
}
