package com.enigma.config;

import com.enigma.dao.CarParkingFeeDao;
import com.enigma.dao.FixedReaderDao;
import com.enigma.impl.CarParkingFeeDaoImpl;
import com.enigma.impl.FixedReaderDaoImpl;
import com.enigma.impl.ParkingLotDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config  {

    @Bean
    public CarParkingFeeDao carParkingFeeDao() {
        return new CarParkingFeeDaoImpl();
    }

    @Bean
    public FixedReaderDao fixedReaderDao(){
        return new FixedReaderDaoImpl();
    }

    @Bean
    public ParkingLotDaoImpl parkingLotDao(){
        return new ParkingLotDaoImpl();
    }
}
