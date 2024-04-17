package org.example.springboot_api.services;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Car;
import org.example.springboot_api.entities.Customer;
import org.example.springboot_api.exceptions.ResourceNotFoundException;
import org.example.springboot_api.repositories.BookingRepository;
import org.example.springboot_api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BookingService implements BookingServiceInterface {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    //Kund: Skapa en bokning av bil
    @Override
    public Booking createBooking(Booking booking) {
        booking.setStatus("Active");
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

    //Kund: Se aktiva/tidigare bokningar
    @Override
    public List<Booking> getBookingsByCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElseThrow(() -> new ResourceNotFoundException("Car", "id", customer.getId()));
        if (existingCustomer != null) {
            List<Booking> listOfBookings = existingCustomer.getBookingList();
            Collections.sort(listOfBookings, new Comparator<Booking>() {
                @Override
                public int compare(Booking o1, Booking o2) {
                    int startDateComparison = o1.getStartDateOfBooking().compareTo(o2.getStartDateOfBooking());

                    if(startDateComparison == 0) {
                        return o1.getEndDateOfBooking().compareTo(o2.getEndDateOfBooking());
                    }
                    return startDateComparison;
                }
            });

            return existingCustomer.getBookingList();


        } else {
            return Collections.emptyList(); //Returnerar en tom lista om kund = null
        }

    }

    //Admin: Ta bort en bokning
    @Override
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
