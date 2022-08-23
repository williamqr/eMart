package com.example.demo.service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public User findOne(String email) {
        return usersRepository.getOne(email);
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
        try {
            User savedUser = usersRepository.save(user);

            Cart savedCart = cartRepository.save(new Cart(savedUser));

            savedUser.setCart(savedCart);

            return usersRepository.save(savedUser);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public User update(User user) {
        User oldUser = findOne(user.getEmail());
        oldUser.setPwd(user.getPwd());
        oldUser.setName(user.getName());
        return usersRepository.save(oldUser);
    }

    public List<User> getAllUser(){
        return usersRepository.findAll();
    }
}
