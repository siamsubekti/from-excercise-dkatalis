package com.enigma.dao;

import java.math.BigDecimal;

public interface CarParkingFeeDao {
    public BigDecimal calculateFee(Integer duration);
}
