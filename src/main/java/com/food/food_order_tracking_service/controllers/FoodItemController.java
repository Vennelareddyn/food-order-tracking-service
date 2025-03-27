package com.food.food_order_tracking_service.controllers;

import com.food.food_order_tracking_service.entity.FoodItem;
import com.food.food_order_tracking_service.services.FoodItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food-items")
public class FoodItemController {

  @Autowired private FoodItemService foodItemService;

  // Create or update a food item
  @PostMapping
  public ResponseEntity<FoodItem> saveFoodItem(@RequestBody FoodItem foodItem) {
    FoodItem savedFoodItem = foodItemService.saveFoodItem(foodItem);
    return ResponseEntity.ok(savedFoodItem);
  }

  // Get all food items
  @GetMapping
  public ResponseEntity<List<FoodItem>> getAllFoodItems() {
    List<FoodItem> foodItems = foodItemService.getAllFoodItems();
    return ResponseEntity.ok(foodItems);
  }

  // Get a food item by ID
  @GetMapping("/{id}")
  public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
    Optional<FoodItem> foodItem = foodItemService.getFoodItemById(id);
    return foodItem.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  // Delete a food item
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
    foodItemService.deleteFoodItem(id);
    return ResponseEntity.noContent().build();
  }
}
