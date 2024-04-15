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

    //Kund: Skapa en bokning av bil
    @Override
    public Booking createBooking(LocalDate dateOfBooking, Car car, Customer customer) {
        Booking booking = new Booking(dateOfBooking,car,customer);
        return bookingRepository.save(booking);
    }

    //Kund: Avboka
    @Override
    public void cancelBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    //Admin: Se alla bokningar
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByCustomer(Customer customer) {
        return bookingRepository.findByCustomerContaining(customer); //Behövs åtkomst till Customer-klassen för att metoden ska funka (tror jag)
    }

    @Override
    public List<Booking> getBookingsByCar(Car car) {
        return bookingRepository.findByCar(car); //Behövs åtkomst till Car-klassen för att metoden ska funka
    }

    //Kund: Se tidigare bokningar. Behövs läggas till funktion för att se tidigare och aktiva bokningar
    @Override
    public List<Booking> getPrevoiusBookingsByCustomer(Customer customer) {
        //Här behövs det läggas till funktionalitet för att hitta tidigare bokningar från en kund
        return List.of();
    }
    //Admin: Ta bort en bokning
    @Override
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
