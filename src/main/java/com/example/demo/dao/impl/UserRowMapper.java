package com.example.demo.dao.impl;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("pwd"));
        return user;
    }
}
