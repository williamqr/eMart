package com.example.demo.service;

import com.example.demo.dao.NewCartDAO;
import com.example.demo.dao.NewUserDAO;
import com.example.demo.dao.impl.NewCartDAOImpl;
import com.example.demo.dao.impl.NewUserDAOImpl;
import com.example.demo.model.Cart;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final NewUserDAO newUserDAO = new NewUserDAOImpl();
    private final NewCartDAO newCartDAO = new NewCartDAOImpl();
    public UserServiceImpl(){

    }
    @Override
    public User findOne(String name) {
        return newUserDAO.getUser(name);
    }

    @Override
    public boolean addUser(User user) {
        Cart cart = new Cart(user);
        newCartDAO.createCart(user);
        return newUserDAO.createUser(user);
    }

    @Override
    public List<User> getAllUser() throws SQLException {
        return newUserDAO.getAllUser();
    }

    @Override
    public void delete(String name) {
        newUserDAO.deleteUser(name);
    }

    @Override
    public User verify(String name, String pwd) throws SQLException {return newUserDAO.verify(name, pwd);}
}
