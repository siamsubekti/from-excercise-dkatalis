package com.enigma;

import com.enigma.constant.MessageConstant;
import com.enigma.dao.FixedReaderDao;
import com.enigma.dao.ParkingLotDao;
import com.enigma.impl.FixedReaderDaoImpl;
import com.enigma.impl.ParkingLotDaoImpl;
import com.enigma.model.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainApplication.class, args);

    }
}
