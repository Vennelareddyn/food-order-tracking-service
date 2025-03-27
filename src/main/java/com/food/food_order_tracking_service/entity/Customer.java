package com.food.food_order_tracking_service.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "name", nullable = false)
  private String name;



  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "email", unique = true, nullable = false)
  private String emails;

  @Column(name = "phone_number", unique = true, nullable = false)
  private String phoneNumber;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Order> orders;

  // Getters and Setters
}
