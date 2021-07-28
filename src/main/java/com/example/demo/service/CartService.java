package com.example.demo.service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.ProductInOrder;
import com.example.demo.Entity.User;

import java.util.Collection;
import java.util.List;

public interface CartService {
    Cart getCart(User user);
    List<Cart> getAll(List<User> users);

    void checkout(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

}
