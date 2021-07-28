package com.example.demo.service;

import com.example.demo.Entity.OrderMain;

public interface OrderService {

    OrderMain findOne(Long orderId);


    OrderMain finish(Long orderId);

    OrderMain cancel(Long orderId);
}
