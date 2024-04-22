package org.example.springboot_api.services;

import org.apache.log4j.Logger;
import org.example.springboot_api.entities.Customer;
import org.example.springboot_api.exceptions.ResourceNotFoundException;
import org.example.springboot_api.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceInterface{

    private static final Logger logger = Logger.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        logger.info("Admin added customer with id " + customer.getId());

        return customer;
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepository.save(customer);
        logger.info("Admin updated customer with id " + customer.getId());
        return customer;
    }

    @Override
    public void deleteCustomerById(int id) {
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepository.deleteById(id);
        logger.info("Admin deleted customer with id " + id);
  }
}
