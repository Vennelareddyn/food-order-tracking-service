package com.food.food_order_tracking_service.services;

import com.food.food_order_tracking_service.entity.Customer;
import com.food.food_order_tracking_service.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  @Autowired private CustomerRepository customerRepository;

  // Create or update a customer
  public Customer saveCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  // Get all customers
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  // Get a customer by ID
  public Optional<Customer> getCustomerById(Long id) {
    return customerRepository.findById(id);
  }

  // Delete a customer
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }
}
