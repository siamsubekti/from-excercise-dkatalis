package com.enigma.bootcamp.dkatalis.parking.service;

import com.enigma.bootcamp.dkatalis.parking.exception.CarNotFoundException;
import com.enigma.bootcamp.dkatalis.parking.exception.ParkingSlotFullException;
import com.enigma.bootcamp.dkatalis.parking.model.Car;
import org.junit.*;

public class CarParkingServiceTest {

    @Test(expected = ParkingSlotFullException.class)
    public void parkTest_shouldThrowParkFullException_whenSlotIsFull() {

        CarParkingService carParkingService = new CarParkingService(1);
        carParkingService.park(new Car("B1793EOG"));
        carParkingService.park(new Car("B1794EOG"));

    }

    @Test(expected = CarNotFoundException.class)
    public void leaveTest_shouldThrowCarNotFoundException_whenRegNumberNotFound(){
        CarParkingService carParkingService = new CarParkingService(6);
        carParkingService.leave(new Car("B1793EOG"));

    }

    @Test
    public void parkTest_shouldDeductAvailableSlot_whenSuccessfullyPark() {

        CarParkingService carParkingService = new CarParkingService(6);
        carParkingService.park(new Car("B1793EOG"));

        Integer expected = 5;
        Integer actual = carParkingService.getNumOfAvailableSlots();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void leaveTest_shouldReclaimAvailableSlot_whenSuccessfullyLeave() {

        CarParkingService carParkingService = new CarParkingService(6);
        carParkingService.park(new Car("B1793EOG"));
        carParkingService.leave(new Car("B1793EOG"));

        Integer expected = 6;
        Integer actual = carParkingService.getNumOfAvailableSlots();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getNumOfAvailableSlotsTest_shouldReturnRealTimeAvailableSlot() {
        CarParkingService carParkingService = new CarParkingService(6);

        Integer expected = 6;
        Integer actual = carParkingService.getNumOfAvailableSlots();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getParkingSlotStatusTest_shouldReturnDescriptionOfParkingLotStatus() {
        CarParkingService carParkingService = new CarParkingService(6);
        carParkingService.park(new Car("B1793EOG"));

        String expected = "Slot No. Registration No. \n" +
                            "1 B1793EOG\n";
        String actual = carParkingService.getParkingSlotStatus();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculatePriceTest_shouldReturn10_when1Hour() {
        CarParkingService carParkingService = new CarParkingService(6);
        Double expected = 10d;
        Double actual = carParkingService.calculatePrice(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculatePriceTest_shouldReturn20_when3Hour() {
        CarParkingService carParkingService = new CarParkingService(6);
        Double expected = 20d;
        Double actual = carParkingService.calculatePrice(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculatePriceTest_shouldReturn40_when5Hour() {
        CarParkingService carParkingService = new CarParkingService(6);
        Double expected = 40d;
        Double actual = carParkingService.calculatePrice(5);
        Assert.assertEquals(expected, actual);
    }
}