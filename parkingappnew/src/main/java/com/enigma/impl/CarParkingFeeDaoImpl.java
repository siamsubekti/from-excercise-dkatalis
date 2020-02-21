package com.enigma.impl;

import com.enigma.dao.CarParkingFeeDao;

import java.math.BigDecimal;

public class CarParkingFeeDaoImpl implements CarParkingFeeDao {

    public static final Integer firstHours = 2;
    public static final BigDecimal feefirstHours = new BigDecimal(10);
    public static final BigDecimal feeNextHour = new BigDecimal(10);

    @Override
    public BigDecimal calculateFee(Integer duration) {
        if (duration <=firstHours) {
            return feefirstHours;
        }
        return feefirstHours.add(((BigDecimal.valueOf(duration - firstHours))).multiply(feeNextHour));
    }
}
