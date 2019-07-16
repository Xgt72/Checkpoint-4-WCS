package com.checkpoint.wcs.wildcircus.controllers;

import com.checkpoint.wcs.wildcircus.entities.Customer;
import com.checkpoint.wcs.wildcircus.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CustomerController {

    public CustomerController() { }

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getOneById(@PathVariable("id") Long id) {
        return customerRepository.findById(id).get();
    }

    @PostMapping("/customer")
    public Customer create(@RequestBody Customer customer) throws Exception {
        return customerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public Customer update(@PathVariable("id") Long id, @RequestBody Customer customer) throws Exception {
        Customer current = customerRepository.findById(id).get();

        if (customer.getFirstname() != null) {
            current.setFirstname(customer.getFirstname());
        }
        if (customer.getLastname() != null) {
            current.setLastname(customer.getLastname());
        }
        if (customer.getEmail() != null) {
            current.setEmail(customer.getEmail());
        }
        return customerRepository.save(current);
    }

    @DeleteMapping("/customer/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        customerRepository.deleteById(id);
        return true;
    }
}
