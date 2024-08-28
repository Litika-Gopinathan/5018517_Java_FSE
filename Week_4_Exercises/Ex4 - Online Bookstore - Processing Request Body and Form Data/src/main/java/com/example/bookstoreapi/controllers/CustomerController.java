package com.example.bookstoreapi.controllers;

import com.example.bookstoreapi.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setId((long) (customers.size() + 1)); // Simulate ID generation
        customers.add(customer);
        return customer;
    }

    @PostMapping("/form")
    public Customer createCustomerForm(@RequestParam String name, @RequestParam String email) {
        Customer customer = new Customer();
        customer.setId((long) (customers.size() + 1));
        customer.setName(name);
        customer.setEmail(email);
        customers.add(customer);
        return customer;
    }
}

