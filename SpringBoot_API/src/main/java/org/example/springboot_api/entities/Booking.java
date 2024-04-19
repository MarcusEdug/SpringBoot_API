package org.example.springboot_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private LocalDate startDateOfBooking;
    private LocalDate endDateOfBooking;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    @JsonIgnoreProperties({"booking", "bookedStatus"})
    private Car car;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties("bookingList")
    private Customer customers;
    private Boolean status;


    public Booking(LocalDate dateOfBooking, Car car, Customer customers) {
        this.startDateOfBooking = dateOfBooking;
        this.car = car;
        this.customers = customers;
    }

    public Booking() {

    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getStartDateOfBooking() {
        return startDateOfBooking;
    }

    public void setStartDateOfBooking(LocalDate dateOfBooking) {
        this.startDateOfBooking = dateOfBooking;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getEndDateOfBooking() {
        return endDateOfBooking;
    }

    public void setEndDateOfBooking(LocalDate endDateOfBooking) {
        this.endDateOfBooking = endDateOfBooking;
    }
}
