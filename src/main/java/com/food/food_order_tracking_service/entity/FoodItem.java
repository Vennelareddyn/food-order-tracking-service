package com.food.food_order_tracking_service.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "food_items")
public class FoodItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "price", nullable = false)
  private BigDecimal price;

  @ManyToMany(mappedBy = "foodItems")
  private List<Order> orders;

  // Getters and Setters
}
