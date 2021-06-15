package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User findOne(String name);
    boolean addUser(User user);
    List<User> getAllUser();
    void delete(String name);
}
