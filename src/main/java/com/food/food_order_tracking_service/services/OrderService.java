package com.food.food_order_tracking_service.services;

import com.food.food_order_tracking_service.entity.Order;
import com.food.food_order_tracking_service.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired private OrderRepository orderRepository;


  // Create or update an order
  public Order saveOrder(Order order) {

    Order savedOrder = orderRepository.save(order);

    return savedOrder;
  }

  // Get all orders
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  // Get an order by ID
  public Optional<Order> getOrderById(Long id) {
    return orderRepository.findById(id);
  }

  // Delete an order
  public void deleteOrder(Long id) {
    orderRepository.deleteById(id);
  }
}
