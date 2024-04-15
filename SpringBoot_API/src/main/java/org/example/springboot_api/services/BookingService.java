package org.example.springboot_api.services;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;
import org.example.springboot_api.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService implements BookingServiceInterface {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(LocalDate dateOfBooking, Car car, Customer customer) {
        return null;
    }

    @Override
    public void cancelBooking(int bookingId) {

    }

    @Override
    public List<Booking> getAllBookings() {
        return List.of();
    }

    @Override
    public List<Booking> getBookingsByCustomer(Customer customer) {
        return List.of();
    }

    @Override
    public List<Booking> getBookingsByCar(Car car) {
        return List.of();
    }

    @Override
    public List<Booking> getPrevoiusBookingsByCustomer(Customer customer) {
        return List.of();
    }

    @Override
    public void deleteBooking(int bookingId) {

    }
}
