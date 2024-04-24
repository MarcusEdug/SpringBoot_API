package org.example.springboot_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int car_id;

    @Column (length = 10, nullable = false)
    private double pricePerDay;

    @Column(length = 30, nullable = false)
    private String factory;

    @Column(length = 30, nullable = false)
    private String model;

    @Column(length = 15, nullable = false)
    private String registrationNumber;

    private boolean IsAvailable = false;

    @OneToMany (mappedBy = "car", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("customers")
    @JsonIgnore
    private List<Booking> bookedInfo;

    public Car() {
    }

    public Car(int id, double pricePerDay, String factory, String modell, String registrationNumber, boolean bookedStatus) {
        this.car_id = id;
        this.pricePerDay = pricePerDay;
        this.factory = factory;
        this.model = modell;
        this.registrationNumber = registrationNumber;
        this.IsAvailable = bookedStatus;
    }

    public Car(int car_id, double pricePerDay, String factory, String model, String registrationNumber, boolean bookedStatus, List<Booking> bookedInfo) {
        this.car_id = car_id;
        this.pricePerDay = pricePerDay;
        this.factory = factory;
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.IsAvailable = bookedStatus;
        this.bookedInfo = bookedInfo;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int id) {
        this.car_id = id;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String modell) {
        this.model = modell;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isIsAvailable() {
        return IsAvailable;
    }

    public void setIsAvailable(boolean bookedStatus) {
        this.IsAvailable = bookedStatus;
    }

    public List<Booking> getBookedInfo() {
        return bookedInfo;
    }

    public void setBookedInfo(List<Booking> bookedInfo) {
        this.bookedInfo = bookedInfo;
    }
}
