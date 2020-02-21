package com.enigma.impl;

import com.enigma.constant.MessageConstant;
import com.enigma.dao.ParkingLotDao;
import com.enigma.model.Car;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ParkingLotDaoImplTest {

    @Test
    public void should_able_to_createPark() {
        Integer expectedCapacity = 1;
        Integer expectedSlot = 1;
        String expectedStringResult = String.format(MessageConstant.PARKING_LOT, expectedSlot);
        ParkingLotDao parkingLotDao = new ParkingLotDaoImpl(expectedCapacity);
        String actualStringResult = parkingLotDao.createParkingLot();
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void should_able_to_park_when_given_one_capacity() {
        Integer expectedSlot = 1;
        Integer expectedCapacity = 1;
        String expectedStringResult = String.format(MessageConstant.PARKING_SUCCES, expectedSlot);
        ParkingLotDao parkingLotDao = new ParkingLotDaoImpl(expectedCapacity);
        Car car = new Car("B 123 TH");
        String actualStringResult = parkingLotDao.park(car);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }


    @Test
    public void should_able_to_park_when_parking_slot_is_empty() {
        Integer expectedSlot = 1;
        Integer expectedCapacity = 1;
        String expectedStringResult = String.format(MessageConstant.PARKING_LOT_FULL, expectedSlot);
        ParkingLotDao parkingLotDao = new ParkingLotDaoImpl(expectedCapacity);
        Car firstCar = new Car("B 123 TH");
        Car secondCar = new Car("B 1234 TH");
        parkingLotDao.park(firstCar);
        String actualStringResult = parkingLotDao.park(secondCar);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void park_should_not_be_able_to_park_when_license_number_is_same(){
        Integer expectedCapacity = 1;
        String expectedStringResult = String.format(MessageConstant.PARKING_FAIL);
        ParkingLotDao parkingLotDao = new ParkingLotDaoImpl(expectedCapacity);
        Car firstCar = new Car("B 123 AB");
        Car secondCar = new Car("B 123 AB");
        parkingLotDao.park(firstCar);
        String actualStringResult = parkingLotDao.park(secondCar);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void leave_should_return_num_of_available_slot() {
        Integer expectedSlot = 1;
        Integer expectedCapacity = 1;
        Integer duration = 1;
        BigDecimal expectedFee = new BigDecimal(10);
        ParkingLotDao parkingLotDao = new ParkingLotDaoImpl(expectedCapacity);
        Car car = new Car("B 1234 TH");
        String expectedStringResult = String.format(MessageConstant.PARKING_LEAVE_SUCCES,car.getLincenseNumber(),expectedSlot, expectedFee);
        parkingLotDao.park(car);
        String actualStringResult = parkingLotDao.leave(car, duration);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void leave_should_return_message_lincenseNumber_not_found() {
        Integer expectedCapacity = 1;
        Integer duration = 1;
        ParkingLotDao parkingLotDao = new ParkingLotDaoImpl(expectedCapacity);
        Car firstCar = new Car("B 124 TH");
        Car secondCar = new Car("B 12345 TH");
        String expectedStringResult = String.format(MessageConstant.PARKING_LEAVE_FAIL, firstCar.getLincenseNumber());
        parkingLotDao.park(secondCar);
        String actualStringResult = parkingLotDao.leave(firstCar, duration);
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }

    @Test
    public void get_parking_slot_status_should_return_description_of_parking_status() {
        StringBuilder builder = new StringBuilder();
        Integer expectedSlot = 1;
        Integer expectedCapacity = 1;
        ParkingLotDao parkingLotDao = new ParkingLotDaoImpl(expectedCapacity);
        Car car = new Car("B 1234 TH");
        parkingLotDao.park(car);
        builder.append(MessageConstant.HEADER_STATUS).toString();
        builder.append(String.format(MessageConstant.RECORD_STATUS, expectedSlot, car.getLincenseNumber()));
        String expectedStringResult = builder.toString();
        String actualStringResult = parkingLotDao.getStatus();
        Assert.assertEquals(expectedStringResult, actualStringResult);
    }
}