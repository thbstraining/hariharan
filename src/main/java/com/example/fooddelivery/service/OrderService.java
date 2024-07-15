package com.example.fooddelivery.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.fooddelivery.model.Dish;
import com.example.fooddelivery.model.Order;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.repository.DishRepository;
import com.example.fooddelivery.repository.OrderRepository;
import com.example.fooddelivery.repository.RestaurantRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;

    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository, DishRepository dishRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.dishRepository = dishRepository;
    }

    public Order placeOrder(Long restaurantId, Map<Long, Integer> dishQuantities) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Map<Dish, Integer> orderedDishes = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : dishQuantities.entrySet()) {
            Dish dish = dishRepository.findById(entry.getKey())
                    .orElseThrow(() -> new RuntimeException("Dish not found"));
            orderedDishes.put(dish, entry.getValue());
        }

        Order order = new Order();
        order.setRestaurant(restaurant);
        order.setOrderedDishes(orderedDishes);

        return orderRepository.save(order);
    }
}
