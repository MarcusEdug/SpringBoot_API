package org.example.springboot_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    // @Autowired
    // private CarService carService;
    // @Autowired
    // private BookingService bookingService;

    // Lista tillgängliga bilar - Get /api/v1/cars
    @GetMapping("/api/v1/cars")
    public void getAllCars(){
        // getAllCars()
        // ResponseEntity<List<Car>>
        // return ResponseEntity.ok(carService.fetchAllCars());
    }


    // Beställa hyrbil - Post /api/v1/ordercar
    // Ta in den bil som ska läggas till i bokning
    @PostMapping("/api/v1/ordercar")
    public void bookCar(){
        // createBooking(date, car, customer)
        // Returnera ?
    }


    // Avboka - Put /api/v1/cancelorder
    // Ta in den order som ska tas bort från kunden
    @PutMapping("/api/v1/cancelorder")
    public void cancelBooking(){
        // cancelBooking(int bookingId)
        // Returnera ?
    }


    // Se tidigare och aktiva bokningar - Get /api/v1/myorders
    @GetMapping("/api/v1/myorders")
    public void getBookings(){
        // getBookingsByCustomer(customer)
        // ResponseEntity<List<Booking>>
        // return ResponseEntity.ok()
    }


}
