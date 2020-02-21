package com.enigma;

import com.enigma.model.City;
import com.enigma.model.Customer;
import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        System.out.println(CalcultaeFee("00:00"));
        System.out.println(DistanceCalculate(new City("A", 3)));

        City city = new City("A-B", 3);
        City city2 = new City("B-C", 10);
        City city1 = new City("C-D", 8);
    }

    public Integer TimeOrder() {
        return null;
    }

    public Integer PickUp() {
        return null;
    }

    public static Integer DistanceCalculate(String pickUp, String dropOff) {
        Integer A = 0;
        Integer B = 3;
        String C = "13";
        String D = "21";

        if (city.equals(A)) {
            return 0;
        } else if (cities.equals("B")) {
            return 3;
        } else if (cities.equals("C")) {
            return 10;
        } else if (cities.equals("D")) {
            return 21;''
        }
        return null;
    }

    public static Integer CalcultaeFee(String hour){
        String [] hours = hour.split(":");
        Integer split = Integer.valueOf(hours[0]+hours[1]);
        System.out.println("time : "+split);
        System.out.println("time : "+ hours[0]+ " dan " + hours[1]);

        if (split <= 0 && split < 600 ) {
            return 2000;
        } else if (split >= 600 && split < 900) {
            return 5000;
        } else if (split >= 900 && split < 1500) {
            return 3000;
        } else if (split >= 1500 && split < 2000) {
            return 6000;
        }
        return 2000;
    }
}
