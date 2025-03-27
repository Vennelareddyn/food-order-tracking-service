package com.food.food_order_tracking_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_status", nullable = false)
  private String status;

  @Column(name = "order_date", nullable = false)
  private LocalDateTime orderDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @ManyToMany
  @JoinTable(
      name = "order_food_items",
      joinColumns = @JoinColumn(name = "order_id"),
      inverseJoinColumns = @JoinColumn(name = "food_item_id"))
  private List<FoodItem> foodItems;

  // Getters and Setters
}
