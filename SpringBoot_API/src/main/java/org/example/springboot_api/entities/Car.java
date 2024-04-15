package org.example.springboot_api.entities;

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
    private int id;

    @Column (length = 10, nullable = false)
    private int pirecePerDay;

    @Column(length = 30, nullable = false)
    private String factory;

    @Column(length = 30, nullable = false)
    private String modell;

    @Column(length = 15, nullable = false)
    private String registrationNumber;


    //För att se vad om den är bokad eller inte
    private boolean bookedStatus = false;

    //Skriv in vad bokning klass heter sen
    //@OneToOne     -       Kan vara manyToOne om man vill att flera ska kunna boka samma bil
    //@JsonIgnoreProperties("customer")
    //@JoinColumn(referencedColumnName = "id")
    //private Booking bookedInfo


    //Konstruktorer
    public Car() {
    }

    public Car(int id, int pirecePerDay, String factory, String modell, String registrationNumber, boolean bookedStatus) {
        this.id = id;
        this.pirecePerDay = pirecePerDay;
        this.factory = factory;
        this.modell = modell;
        this.registrationNumber = registrationNumber;
        this.bookedStatus = bookedStatus;
    }


    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPirecePerDay() {
        return pirecePerDay;
    }

    public void setPirecePerDay(int pirecePerDay) {
        this.pirecePerDay = pirecePerDay;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
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
}
