package org.example.springboot_api.services;

import org.example.springboot_api.entities.Customer;

import java.util.List;

public interface CustomerServiceInterface {

    List<Customer> fetchAllCustomers();
    Customer addCustomer(Customer customer);
    Customer updateCustomer(int id, Customer customer);
    void deleteCustomerById(int id);

}
