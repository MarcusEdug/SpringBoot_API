package org.example.springboot_api.services;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;
import org.example.springboot_api.entities.Customer;

import java.time.LocalDate;
import java.util.List;

public interface BookingServiceInterface {

    Booking createBooking(LocalDate dateOfBooking, Car car, Customer customer);
    void cancelBooking(int bookingId);
    List<Booking> getAllBookings();
    List<Booking> getBookingsByCustomer(Customer customer);
    List<Booking> getBookingsByCar(Car car);
    List<Booking> getPrevoiusBookingsByCustomer(Customer customer);
    void deleteBooking(int bookingId);
}
