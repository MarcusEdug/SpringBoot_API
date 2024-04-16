package org.example.springboot_api.repositories;

import org.example.springboot_api.entities.Booking;
import org.example.springboot_api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    //List<Booking> findByCustomersContaining(Customer customer);
}
