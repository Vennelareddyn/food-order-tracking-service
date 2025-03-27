package com.food.food_order_tracking_service.services;

import com.food.food_order_tracking_service.entity.FoodItem;
import com.food.food_order_tracking_service.repository.FoodItemRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {

  @Autowired private FoodItemRepository foodItemRepository;

  // Create or update a food item
  public FoodItem saveFoodItem(FoodItem foodItem) {
    return foodItemRepository.save(foodItem);
  }

  // Get all food items
  public List<FoodItem> getAllFoodItems() {
    return foodItemRepository.findAll();
  }

  // Get a food item by ID
  public Optional<FoodItem> getFoodItemById(Long id) {
    return foodItemRepository.findById(id);
  }

  // Delete a food item
  public void deleteFoodItem(Long id) {
    foodItemRepository.deleteById(id);
  }
}
