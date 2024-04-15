package org.example.springboot_api.controllers;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;
import org.example.springboot_api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/api/v1/orderacar")
    public Booking createBooking(LocalDate dateOfBooking, Car car, Customer customer) {
        bookingService.createBooking(dateOfBooking, car, customer);
    }

    //Kund: Se bokningar. Behöver lägga till funktion för att se tidigare och aktiva bokningar
    @GetMapping("/api/v1/myorders")
    public List<Booking> getAllBookingsByCustomer(Customer customer) {
        return bookingService.getBookingsByCustomer(customer);
    }

    //Kund: Avboka en bokning. Behöver @Pathvariable eller skickar man med en body?
    @PutMapping("/api/v1/cancelorder")
    public void cancelBooking(@RequestBody Booking booking) {
        int bookingId = booking.getBookingId();
        bookingService.cancelBooking(bookingId);
    }

    //Admin: Lista alla bokningar
    @GetMapping("/api/v1/orders")
    public List<Booking> getBookings() {
        return bookingService.getAllBookings();
    }

    //Admin: Ta bort en bokning. Pathvariable eller skicka med en body?
    @DeleteMapping("/api/v1/deleteorder")
    public void deleteBooking(@RequestBody Booking booking) {
        int bookingId = booking.getBookingId();
        bookingService.deleteBooking(bookingId);
    }
}
