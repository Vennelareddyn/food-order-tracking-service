package com.food.food_order_tracking_service.controllers;

import com.food.food_order_tracking_service.entity.Customer;
import com.food.food_order_tracking_service.services.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  @Autowired private CustomerService customerService;

  // Create or update a customer
  @PostMapping
  public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
    Customer savedCustomer = customerService.saveCustomer(customer);
    return ResponseEntity.ok(savedCustomer);
  }

  // Get all customers
  @GetMapping
  public ResponseEntity<List<Customer>> getAllCustomers() {
    List<Customer> customers = customerService.getAllCustomers();
    return ResponseEntity.ok(customers);
  }

  // Get a customer by ID
  @GetMapping("/{id}")
  public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
    Optional<Customer> customer = customerService.getCustomerById(id);
    return customer.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  // Delete a customer
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    return ResponseEntity.noContent().build();
  }
}
