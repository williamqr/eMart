package com.example.demo.service;

import com.example.demo.Entity.ProductInOrder;
import com.example.demo.Entity.User;

public interface ProductInOrderService {

    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
