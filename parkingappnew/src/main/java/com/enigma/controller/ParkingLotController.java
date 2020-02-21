package com.enigma.controller;

import com.enigma.dao.ParkingLotDao;
import com.enigma.impl.ParkingLotDaoImpl;
import com.enigma.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingLotController {

    @Autowired
    ParkingLotDao parkingLotDao;

    @Autowired
    ParkingLotDaoImpl parkingLotDaoimpl;

    @PostMapping("/create")
    public String createParking(@RequestBody Integer capacity){
        return parkingLotDaoimpl.createParking(capacity);

    }

    @GetMapping("/park/getstatus")
    public String getStatus(){
        return parkingLotDaoimpl.getStatus();
    }

    @PostMapping("/create/park")
    public String park(@RequestBody String car){
        return parkingLotDaoimpl.parking(car);
    }
}
