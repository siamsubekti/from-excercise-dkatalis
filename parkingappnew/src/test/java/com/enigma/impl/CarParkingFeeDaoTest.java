package com.enigma.impl;

import com.enigma.dao.CarParkingFeeDao;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CarParkingFeeDaoTest {

    @Test
    public void calculateFee_should_return_a_dollar_valueOf_ten_when_one_hour() {
        CarParkingFeeDao carParkingFeeDao = new CarParkingFeeDaoImpl();
        BigDecimal expectedFee = new BigDecimal(10);
        BigDecimal actualFee = carParkingFeeDao.calculateFee(1);
        Assert.assertEquals(expectedFee, actualFee);
    }

    @Test
    public void calculateFee_should_return_a_dollar_valueOf_twenty_when_three_hour() {
        CarParkingFeeDao carParkingFeeDao = new CarParkingFeeDaoImpl();
        BigDecimal expectedFee = new BigDecimal(20);
        BigDecimal actualFee = carParkingFeeDao.calculateFee(3);
        Assert.assertEquals(expectedFee, actualFee);
    }

    @Test
    public void calculateFee_should_return_a_dollar_valueOf_fourty_when_five_hour(){
        CarParkingFeeDao carParkingFeeDao = new CarParkingFeeDaoImpl();
        BigDecimal expectedFee = new BigDecimal(40);
        BigDecimal actualFee = carParkingFeeDao.calculateFee(5);
        Assert.assertEquals(expectedFee, actualFee);
    }
}
