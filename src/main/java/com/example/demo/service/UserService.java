package com.example.demo.service;

import com.example.demo.Entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    /**
     * Created By Zhu Lin on 3/13/2018.
     */
        User findOne(String email);


        User save(User user);

        List<User> findAll();
        User update(User user);

}
