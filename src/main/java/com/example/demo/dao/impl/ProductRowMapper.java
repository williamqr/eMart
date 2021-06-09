package com.example.demo.dao.impl;

import com.example.demo.model.Person;
import com.example.demo.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product p = new Product(rs.getString("name"), rs.getInt("price"), rs.getInt("id"));
        return p;
    }
}
