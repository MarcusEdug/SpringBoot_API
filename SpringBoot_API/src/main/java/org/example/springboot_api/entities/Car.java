package org.example.springboot_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

/*
    Klass är till för att skapa Cars objekt
    Den innehåller
    7st variablar
    2st Konstruktorer

 */

@Entity
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int car_id;

    @Column (length = 10, nullable = false)
    private int pricePerDay;

    @Column(length = 30, nullable = false)
    private String factory;

    @Column(length = 30, nullable = false)
    private String model;

    @Column(length = 15, nullable = false)
    private String registrationNumber;


    //För att se vad om den är bokad eller inte
    private boolean bookedStatus = false;

    //Tar in bokning objektet
    @OneToOne (mappedBy = "car", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = false)
    @JsonIgnoreProperties("customers")
    @JsonIgnore
    private Booking bookedInfo;


    //Konstruktorer
    public Car() {
    }

    public Car(int id, int pirecePerDay, String factory, String modell, String registrationNumber, boolean bookedStatus) {
        this.car_id = id;
        this.pricePerDay = pirecePerDay;
        this.factory = factory;
        this.model = modell;
        this.registrationNumber = registrationNumber;
        this.bookedStatus = bookedStatus;
    }

    public Car(int id, int pirecePerDay, String factory, String modell, String registrationNumber, boolean bookedStatus, Booking bookedInfo) {
        this.car_id = id;
        this.pricePerDay = pirecePerDay;
        this.factory = factory;
        this.model = modell;
        this.registrationNumber = registrationNumber;
        this.bookedStatus = bookedStatus;
        this.bookedInfo = bookedInfo;
    }

    //Getters and Setters
    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int id) {
        this.car_id = id;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pirecePerDay) {
        this.pricePerDay = pirecePerDay;
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

    public boolean isBookedStatus() {
        return bookedStatus;
    }

    public void setBookedStatus(boolean bookedStatus) {
        this.bookedStatus = bookedStatus;
    }

    public Booking getBookedInfo() {
        bookedStatus = true;
        return bookedInfo;
    }

    public void setBookedInfo(Booking bookedInfo) {
        if (bookedInfo == null){
            bookedStatus = false;
        }
        this.bookedInfo = bookedInfo;
    }
}
