package org.example.springboot_api.services;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;
import org.example.springboot_api.entities.Customer;

import java.time.LocalDate;
import java.util.List;

public interface BookingServiceInterface {

    Booking createBooking(Booking booking);
    void cancelBooking(Booking booking);
    List<Booking> fetchAllBookings();
    List<Booking> getBookingsByCustomer(Customer customer);
    void deleteBooking(int bookingId);
}
