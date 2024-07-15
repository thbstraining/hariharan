package com.example.fooddelivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fooddelivery.model.Dish;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.repository.DishRepository;
import com.example.fooddelivery.repository.RestaurantRepository;

@Service
public class DishService {
    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    public DishService(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Dish> getDishesByRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return dishRepository.findAll().stream()
                .filter(dish -> dish.getRestaurant().equals(restaurant))
                .toList();
    }

    public Dish saveDish(Dish dish) {
        return dishRepository.save(dish);
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}
