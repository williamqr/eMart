package com.example.demo.service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.User;
import com.example.demo.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepository cartRepository;
    @Override
    public Cart getCart(User user) {
        return user.getCart();
    }


    public List<Cart> getAll(List<User> users) {
        List<Cart> carts = new ArrayList<>();
        for(User user : users) {
            Cart cart = user.getCart();
            carts.add(cart);
        }
        return carts;
    }
}
