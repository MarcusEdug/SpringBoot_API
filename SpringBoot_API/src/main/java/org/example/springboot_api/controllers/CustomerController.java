package org.example.springboot_api.controllers;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;
import org.example.springboot_api.entities.Customer;
import org.example.springboot_api.services.BookingService;
import org.example.springboot_api.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CarService carService;
    @Autowired
    private BookingService bookingService;


    @GetMapping("/api/v1/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        return ResponseEntity.ok(carService.fetchAllAvailableCars());
    }


    @PostMapping("/api/v1/ordercar")
    public ResponseEntity<String> bookCar(@RequestBody Booking booking){
        bookingService.createBooking(booking);
        return new ResponseEntity<>("Car ordered", HttpStatus.OK);
    }


    @PutMapping("/api/v1/cancelorder")
    public ResponseEntity<String> cancelBooking(@RequestBody Booking booking){
        bookingService.cancelBooking(booking);
        return new ResponseEntity<>("Order canceled", HttpStatus.OK);
    }


    @GetMapping("/api/v1/myorders")
    public ResponseEntity<List<Booking>> getBookings(@RequestBody Customer customer){
        bookingService.getBookingsByCustomer(customer);
        return ResponseEntity.ok(bookingService.getBookingsByCustomer(customer));
    }


}
