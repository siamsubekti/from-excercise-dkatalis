package com.enigma.bootcamp.dkatalis.parking;

import com.enigma.bootcamp.dkatalis.parking.controller.CarParkingController;
import com.enigma.bootcamp.dkatalis.parking.model.Car;

public class MainApp {
    public static void main(String[] args) {
        /*
        create_parking_lot 6
        park KA-01-HH-1234
        park KA-01-HH-9999
        park KA-01-BB-0001
        park KA-01-HH-7777
        park KA-01-HH-2701
        park KA-01-HH-3141
        leave KA-01-HH-3141 4
        status
        park KA-01-P-333
        park DL-12-AA-9999
        leave KA-01-HH-1234 4
        leave KA-01-BB-0001 6
        leave DL-12-AA-9999 2
        park KA-09-HH-0987
        park CA-09-IO-1111
        park KA-09-HH-0123
        Status
         */
        CarParkingController parkLot = new CarParkingController(6);
        System.out.println(parkLot.park(new Car("KA-01-HH-1234")));
        System.out.println(parkLot.park(new Car("KA-01-HH-9999")));
        System.out.println(parkLot.park(new Car("KA-01-BB-0001")));
        System.out.println(parkLot.park(new Car("KA-01-HH-7777")));
        System.out.println(parkLot.park(new Car("KA-01-HH-2701")));
        System.out.println(parkLot.park(new Car("KA-01-HH-3141")));
        System.out.println(parkLot.leave(new Car("KA-01-HH-3141"), 4));
        System.out.println(parkLot.getStatus());
        System.out.println(parkLot.park(new Car("KA-01-P-333")));
        System.out.println(parkLot.park(new Car("DL-12-AA-9999")));
        System.out.println(parkLot.leave(new Car("KA-01-HH-1234"), 4));
        System.out.println(parkLot.leave(new Car("KA-01-BB-0001"), 6));
        System.out.println(parkLot.leave(new Car("DL-12-AA-9999"), 2));
        System.out.println(parkLot.park(new Car("KA-09-HH-0987")));
        System.out.println(parkLot.park(new Car("CA-09-IO-1111")));
        System.out.println(parkLot.park(new Car("KA-09-HH-0123")));
        System.out.println(parkLot.leave(new Car("KA-09-HH-0987"), 7));
        System.out.println(parkLot.leave(new Car("CA-09-IO-1111"), 9));

        System.out.println(parkLot.getStatus());
    }
}
