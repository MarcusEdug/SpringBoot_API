package org.example.springboot_api.controllers;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;
import org.example.springboot_api.entities.Customer;
import org.example.springboot_api.services.BookingService;
import org.example.springboot_api.services.CarService;
import org.example.springboot_api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    private CarService carService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CustomerService customerService;

    //Customers

    @GetMapping("/customers")
    public List<Customer> fetchAllCustomer(){
        return customerService.fetchAllCustomers();
    }

    @PostMapping("/addcustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @PutMapping("/updatecustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer existingCustomer){
        int id = existingCustomer.getId();
        return ResponseEntity.ok(customerService.updateCustomer(id, existingCustomer));
    }

    @DeleteMapping("/deletecustomer")
    public ResponseEntity<String> deleteCustomer(@RequestBody Customer existingCustomer){
        int id = existingCustomer.getId();
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }

    //Cars

    @PostMapping("/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);
    }

    @GetMapping("/allcars")
    public List<Car> fetchAllCar(){
        return carService.fetchAllCars();
    }

    @PutMapping("/updatecar")
    public ResponseEntity<Car> updateCar(@RequestBody Car existingCar){
        return ResponseEntity.ok(carService.updateCar(existingCar));
    }

    @DeleteMapping("/deletecar")
    public ResponseEntity<String> deleteCar(@RequestBody Car existingCar) {
        return new ResponseEntity<>(carService.deleteCar(existingCar.getCar_id()), HttpStatus.OK);
    }

    //Orders

    @GetMapping("/orders")
    public List<Booking> fetchAllBookings(){
        return bookingService.fetchAllBookings();
    }

    @DeleteMapping("/deleteorder")
    public ResponseEntity<String> deleteOrder(@RequestBody Booking existingBooking){
        int id = existingBooking.getBookingId();
        bookingService.deleteBooking(id);
        return new ResponseEntity<>("Order deleted", HttpStatus.OK);
    }
}
