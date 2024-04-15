package org.example.springboot_api.services;


import org.example.springboot_api.entities.Car;
import org.example.springboot_api.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(int id, Car car) {
        Car existingCar = carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
        if(car.getPirecePerDay() != 0){
            existingCar.setPirecePerDay(car.getPirecePerDay());
        }
        if(car.getFactory() != null){
            existingCar.setFactory(car.getFactory());
        }
        if(car.getModell() != null){
            existingCar.setModell(car.getModell());
        }
        if(car.getRegistrationNumber() != null){
            existingCar.setRegistrationNumber(car.getRegistrationNumber());
        }
        if(car.getBookedInfo() != null){
            existingCar.setBookedInfo(car.getBookedInfo());
        }


        carRepository.save(existingCar);
        return existingCar;
    }

    @Override
    public void deleteCar(int id) {
        carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));
        carRepository.deleteById(id);
    }
}
