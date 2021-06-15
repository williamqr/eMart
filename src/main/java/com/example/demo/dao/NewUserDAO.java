package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface NewUserDAO {
    public void setDataSource();
    public boolean createUser(User user);
    public boolean deleteUser(String name);
    public List<User> getAllUser();
    public User getUser(String name);


}
