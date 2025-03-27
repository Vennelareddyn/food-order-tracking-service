package com.food.food_order_tracking_service.repository;

import com.food.food_order_tracking_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  // Custom query methods can be added if needed
}
