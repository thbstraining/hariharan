package com.example.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.fooddelivery.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
