package com.example.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fooddelivery.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
}
