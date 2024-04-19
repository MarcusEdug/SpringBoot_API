package org.example.springboot_api.services;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarServiceInterface {

    Car addCar(Car car);
    List<Car> fetchAllCars();
    List<Car> fetchAllAvailableCars();
    Car updateCar(Car car);
    void deleteCar(int id);
}
