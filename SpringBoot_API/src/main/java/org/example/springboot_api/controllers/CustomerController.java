package org.example.springboot_api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    // @Autowired
    // private CustomerService customerService;

    // Lista tillgängliga bilar - Get /api/v1/cars
    @GetMapping("/api/v1/cars")
    public void getAllCars(){
        // returnera en lista med bilar
    }


    // Beställa hyrbil - Post /api/v1/ordercar
    @PostMapping("/api/v1/ordercar")
    public void orderCar(){
        // Returnera ?
    }


    // Avboka - Put /api/v1/cancelorder
    @PutMapping("/api/v1/cancelorder")
    public void cancelOrder(){
        // Returnera ?
    }


    // Se tidigare och aktiva bokningar - Get /api/v1/myorders
    @GetMapping("/api/v1/myorders")
    public void getOrders(){
        // Returnera lista med bokningar
    }


}
