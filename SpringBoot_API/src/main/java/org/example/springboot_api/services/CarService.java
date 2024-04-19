package org.example.springboot_api.services;


import org.example.springboot_api.entities.Car;
import org.example.springboot_api.exceptions.ResourceNotFoundException;
import org.example.springboot_api.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarService implements CarServiceInterface {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> fetchAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> fetchAllAvailableCars() {
        List<Car> availableCar = new ArrayList<>();
        for (Car c : carRepository.findAll()) {
            if(!c.isBookedStatus()){
                availableCar.add(c);
            }
        }
        return availableCar;
    }

    @Override
    public Car updateCar(Car car) {
        Car existingCar = carRepository.findById(car.getCar_id()).orElseThrow(() -> new ResourceNotFoundException("Car", "id", car.getCar_id()));
        if(car.getPricePerDay() != 0){
            existingCar.setPricePerDay(car.getPricePerDay());
        }
        if(car.getFactory() != null){
            existingCar.setFactory(car.getFactory());
        }
        if(car.getModel() != null){
            existingCar.setModel(car.getModel());
        }
        if(car.getRegistrationNumber() != null){
            existingCar.setRegistrationNumber(car.getRegistrationNumber());
        }
        if(car.getBookedInfo() != null){
            existingCar.setBookedInfo(car.getBookedInfo());
        }

        existingCar.setBookedStatus(car.isBookedStatus());



        carRepository.save(existingCar);
        return existingCar;
    }

    @Override
    public void deleteCar(int id) {
        carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
        carRepository.deleteById(id);
    }
}
