package com.enigma.impl;

import com.enigma.dao.FixedReaderDao;
import com.enigma.dao.ParkingLotDao;
import com.enigma.model.Car;

import java.io.*;

public class FixedReaderDaoImpl implements FixedReaderDao {
    private static ParkingLotDao parkingLotDao;

    //this constructor non propherty
    public FixedReaderDaoImpl() {
    }

    @Override
    public String read(BufferedReader bufferedReader) throws IOException {
        //looping to retrieve string files one by one line
        String text;
        //conditions if the readline () method of bufferReader runs null it will break,
        //and if it still reads it will run the for loop
        while ((text = bufferedReader.readLine()) != null) {
            String [] array = text.trim().split("\\s+");
            //loop to find the key and parameters of each line
            for (int i=0; i < array.length; i++) {
                switch ((array[i]).toLowerCase()) {
                    case "create_parking_lot":
                        Integer capacity = Integer.parseInt(array[i +1]);
                        parkingLotDao = new ParkingLotDaoImpl(capacity);
                        System.out.println(parkingLotDao.createParkingLot());
                        break;
                    case "park":
                        String lincenseNumber = array[i + 1];
                        System.out.println(parkingLotDao.park(new Car(lincenseNumber)));
                        break;
                    case "leave":
                        String lincenseNumberLeave = array[i + 1];
                        Integer hour = Integer.parseInt(array[i + 2]);
                        System.out.println(parkingLotDao.leave(new Car(lincenseNumberLeave), hour));
                        break;
                    case "status":
                        System.out.println(parkingLotDao.getStatus());
                    default:
                        break;
                }
            }
        }
        return text;
    }
}
