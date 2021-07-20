package com.example.demo.dao;

import com.example.demo.model.Cart;
import com.example.demo.model.User;

import java.sql.SQLException;
import java.util.List;

public interface NewUserDAO {
    public void setDataSource();
    public boolean createUser(User user);
    public boolean deleteUser(String name);
    public List<User> getAllUser() throws SQLException;
    public User getUser(String name);

    public User verify(String name, String pwd) throws SQLException;


}
