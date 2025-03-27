package com.food.food_order_tracking_service.repository;

import com.food.food_order_tracking_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  // Custom query methods can be added if needed
}
