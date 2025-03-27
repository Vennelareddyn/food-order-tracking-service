package com.food.food_order_tracking_service.controllers;

import com.food.food_order_tracking_service.entity.Order;
import com.food.food_order_tracking_service.services.OrderService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  @Autowired private OrderService orderService;

  // Create or update an order
  @PostMapping
  public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
    Order savedOrder = orderService.saveOrder(order);
    return ResponseEntity.ok(savedOrder);
  }

  // Get all orders
  @GetMapping
  public ResponseEntity<List<Order>> getAllOrders() {
    List<Order> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }

  // Get order by ID
  @GetMapping("/{id}")
  public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
    Optional<Order> order = orderService.getOrderById(id);
    return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  // Delete an order
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
    orderService.deleteOrder(id);
    return ResponseEntity.noContent().build();
  }
}
