package com.example.demo.service;

import com.example.demo.dao.NewUserDAO;
import com.example.demo.dao.impl.NewUserDAOImpl;
import com.example.demo.model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final NewUserDAO newUserDAO = new NewUserDAOImpl();

    public UserServiceImpl(){

    }
    @Override
    public User findOne(String name) {
        return newUserDAO.getUser(name);
    }

    @Override
    public boolean addUser(User user) {
        return newUserDAO.createUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return newUserDAO.getAllUser();
    }

    @Override
    public void delete(String name) {
        newUserDAO.deleteUser(name);
    }
}
