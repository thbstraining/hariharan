package com.example.fooddelivery.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.model.Dish;
import com.example.fooddelivery.service.DishService;

@RestController
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Dish> getDishesByRestaurant(@PathVariable Long restaurantId) {
        return dishService.getDishesByRestaurant(restaurantId);
    }

    @PostMapping
    public Dish createDish(@RequestBody Dish dish) {
        return dishService.saveDish(dish);
    }

    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }
}
