package com.enigma.impl;

import com.enigma.constant.MessageConstant;
import com.enigma.dao.CarParkingFeeDao;
import com.enigma.dao.ParkingLotDao;
import com.enigma.model.Car;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotDaoImpl implements ParkingLotDao {
    MessageConstant messageConstant = new MessageConstant();
    Map<Integer, Car> parkingSlots = new HashMap<>();
    Map<Integer, String> parkingSlot = new HashMap<>();
    private Integer capacity;
    private  Integer capacities = 6;
    private CarParkingFeeDao fee = new CarParkingFeeDaoImpl();

    public ParkingLotDaoImpl(Integer capacity) {
        this.capacity = capacity;
    }

    public ParkingLotDaoImpl() {
    }

    public String createParkingLot() {
        for (int slot=1; slot<=this.capacity; slot++) {
            parkingSlots.put(slot, null);
        } return String.format(MessageConstant.PARKING_LOT, this.capacity);
    }

    public String createParking(Integer capacities){
        for (int i=1; i<=capacities; i++){
            parkingSlots.put(i, null);
        }return String.format(MessageConstant.PARKING_LOT, capacities);
    }

    public String park(Car car) {
        if (parkingSlots.containsValue(car)) {
            return MessageConstant.PARKING_FAIL;
        }
        for (int slot = 1; slot <= this.capacity; slot++) {
            if (parkingSlots.get(slot) == null) {
                parkingSlots.put(slot, car);
                return String.format(MessageConstant.PARKING_SUCCES, slot);
            }
        }
        return MessageConstant.PARKING_LOT_FULL;
    }
        public String parking(String parkCar) {
//            if (parkingSlots.containsValue(parkCar)) {
//                return MessageConstant.PARKING_FAIL;
//            }
            for (int slot=1; slot<=this.capacities; slot++) {
                if (parkingSlots.get(slot) == null) {
                    parkingSlot.put(slot, parkCar);
                    return String.format(MessageConstant.PARKING_SUCCES, slot);
                }
            }
            return MessageConstant.PARKING_LOT_FULL;
    }
    public String leave(Car car, Integer duration) {
        car.setLincenseNumber(car.getLincenseNumber());
        for(Map.Entry<Integer, Car> slot : parkingSlots.entrySet()) {
            if (slot.getValue() != null) {
                Car selectedCar = slot.getValue();
                if (car.getLincenseNumber().equals(selectedCar.getLincenseNumber())){
                    parkingSlots.put(slot.getKey(),null);
                    return String.format(MessageConstant.PARKING_LEAVE_SUCCES, car.getLincenseNumber(),
                            slot.getKey(),
                            fee.calculateFee(duration));
                }
            }
        }
        return String.format(MessageConstant.PARKING_LEAVE_FAIL, car.getLincenseNumber());
    }

    public String getStatus() {
        StringBuilder string = new StringBuilder();
        string.append(MessageConstant.HEADER_STATUS);
        for (Map.Entry<Integer, Car> slot : parkingSlots.entrySet()) {
            if (slot.getValue() != null) {
                string.append(String.format(MessageConstant.RECORD_STATUS, slot.getKey(), slot.getValue().getLincenseNumber()));
            }
        }
        return string.toString();
    }

}
