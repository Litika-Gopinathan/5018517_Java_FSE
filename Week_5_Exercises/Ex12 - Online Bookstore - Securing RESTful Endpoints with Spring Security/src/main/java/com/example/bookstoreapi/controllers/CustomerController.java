package com.example.bookstoreapi.controllers;

import com.example.bookstoreapi.dto.CustomerDTO;
import com.example.bookstoreapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // GET all customers with HATEOAS links
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers().stream()
            .map(customerDTO -> addHateoasLinks(customerDTO))
            .collect(Collectors.toList());
        return ResponseEntity.ok(customers);
    }

    // GET a customer by ID with HATEOAS links
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        CustomerDTO customer = customerService.getCustomerById(id);
        addHateoasLinks(customer);
        return ResponseEntity.ok(customer);
    }

    // POST a new customer
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO savedCustomer = customerService.createCustomer(customerDTO);
        addHateoasLinks(savedCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

    // PUT update a customer by ID
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(id, customerDTO);
        addHateoasLinks(updatedCustomer);
        return ResponseEntity.ok(updatedCustomer);
    }

    // DELETE a customer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    // Helper method to add HATEOAS links
    private CustomerDTO addHateoasLinks(CustomerDTO customerDTO) {
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CustomerController.class).getCustomerById(customerDTO.getId())).withSelfRel();
        customerDTO.add(selfLink);
        return customerDTO;
    }
}
