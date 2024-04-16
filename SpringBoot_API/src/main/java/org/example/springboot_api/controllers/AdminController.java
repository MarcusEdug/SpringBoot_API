package org.example.springboot_api.controllers;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;
import org.example.springboot_api.entities.Customer;
import org.example.springboot_api.services.BookingService;
import org.example.springboot_api.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private CarService carService;

    @Autowired
    private BookingService bookingService;
/*
    @Autowired
    private CustomerService customerService;

    //Customers

    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @PostMapping("/addcustomer")
    @ResponseBody
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/updatecustomer")
    @ResponseBody
    public ResponseEntity<Customer> updateCustomer(@RequestParam("id") int id, @RequestBody Customer customer){
        return ResponseEntity.ok(carService.updateCustomer(id, customer));
    }

    @DeleteMapping("/deletecustomer")
    @ResponseBody
    public ResponseEntity<String> deleteCustomer(@RequestParam("id") int id){
        customerService.deteleCustomer(id);
        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }


 */
    //Cars

    @PostMapping("/addcar")
    @ResponseBody
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);
    }

    @GetMapping("/allcars")
    @ResponseBody
    public List<Car> getAllCar(){
        return carService.getAllCars();
    }

    @PutMapping("/updatecar")
    @ResponseBody
    public ResponseEntity<Car> updateCar(@RequestBody Map<String, Object> existingCar){
        int id = (int) existingCar.get("id");

        Car updatedCar = new Car();
        updatedCar.setId(id);

        if (existingCar.get("pireceperday") != null) {
            int pirecePerDay = (int) existingCar.get("pireceperday");
            updatedCar.setPirecePerDay(pirecePerDay);
        }

        if (existingCar.get("factory") != null) {
            updatedCar.setFactory((String) existingCar.get("factory"));
        }

        if (existingCar.get("modell") != null) {
            updatedCar.setModell((String) existingCar.get("modell"));
        }

        if (existingCar.get("registrationnumber") != null) {
            updatedCar.setRegistrationNumber((String) existingCar.get("registrationnumber"));
        }

        if (existingCar.get("bookedstatus") != null) {
            updatedCar.setBookedStatus((Boolean) existingCar.get("bookedstatus"));
        }

        if (existingCar.get("bookedinfo") != null) {
            updatedCar.setBookedInfo((Booking) existingCar.get("bookedinfo"));
        }
        return ResponseEntity.ok(carService.updateCar(id, updatedCar));
    }

    @DeleteMapping("/deletecar")
    @ResponseBody
    public ResponseEntity<String> deleteCar(@RequestBody Map<String, Object> existingCar) {
        int id = (int) existingCar.get("id");

        carService.deleteCar(id);

        return new ResponseEntity<>("Car deleted", HttpStatus.OK);
    }

    //Orders

    @GetMapping("/orders")
    @ResponseBody
    public List<Booking> getAllOrders(){
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/deleteorder")
    @ResponseBody
    public ResponseEntity<String> deleteOrder(@RequestParam("id") int id){
        bookingService.deleteBooking(id);
        return new ResponseEntity<>("Order deletet", HttpStatus.OK);
    }

}
