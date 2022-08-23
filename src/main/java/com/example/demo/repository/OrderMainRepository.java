package com.example.demo.repository;

import com.example.demo.Entity.OrderMain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMainRepository extends JpaRepository<OrderMain, Integer> {
    OrderMain findByOrderId(Long orderId);
}
