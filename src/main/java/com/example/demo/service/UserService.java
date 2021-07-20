package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User findOne(String name);
    boolean addUser(User user);
    List<User> getAllUser() throws SQLException;
    void delete(String name);
    User verify(String name, String pwd) throws SQLException;
}
