package org.example.springboot_api.services;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;
import org.example.springboot_api.entities.Customer;
import org.example.springboot_api.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class BookingService implements BookingServiceInterface {

    @Autowired
    private BookingRepository bookingRepository;

    //Kund: Skapa en bokning av bil
    @Override
    public Booking createBooking(LocalDate dateOfBooking, Car car, Customer customer) {
        Booking booking = new Booking(dateOfBooking,car, customer);
        return bookingRepository.save(booking);
    }

    //Kund: Avboka
    @Override
    public void cancelBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    //Admin: Se alla bokningar
    @Override
    public List<Booking> fetchAllBookings() {
        return bookingRepository.findAll();
    }

    //Kund: Se aktiva bokningar
    @Override
    public List<Booking> getBookingsByCustomer(Customer customer) {
        if (customer != null) {
           // return bookingRepository.findByCustomersContaining(customer);
            //Todo Skapa en funktion som gör att man kan kolla om datumet är gällande för bokningen
        } else {
            return Collections.emptyList(); //Returnerar en tom lista om kund = null
        }
        return null;
    }

    //Kund: Se tidigare bokningar.
    @Override
    public List<Booking> getPrevoiusBookingsByCustomer(Customer customer) {
       //Todo Skapa en funktion för att kolla om bokningen är förbrukad med hjälp av datum
        return null;
    }
    //Admin: Ta bort en bokning
    @Override
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
