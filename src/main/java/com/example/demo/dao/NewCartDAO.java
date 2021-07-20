package com.example.demo.dao;

import com.example.demo.model.Cart;
import com.example.demo.model.User;

public interface NewCartDAO {
    public void setDataSource();
    public boolean createCart(User user);
    public boolean deleteCart(User user);
    public Cart getCart(User user);
}
