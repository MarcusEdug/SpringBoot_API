package org.example.springboot_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String userName;
    @Column(length = 80, nullable = false)
    private String name;
    @Column(length = 120, nullable = false)
    private String address;
    @Column(length = 80)
    private String email;
    @Column(length = 15)
    private String phone;

    @JsonIgnoreProperties("bookingList")
    @JsonIgnore
    @OneToMany(mappedBy = "customers", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Booking> bookingList;

    public Customer() {
    }

    public Customer(String userName, String name, String address, String email, String phone, List<Booking> bookingList) {
        this.userName = userName;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.bookingList = bookingList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }
}
