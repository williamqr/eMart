package com.example.demo.dao.impl;

import com.example.demo.dao.NewCartDAO;
import com.example.demo.model.Cart;
import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class NewCartDAOImpl implements NewCartDAO {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
    @Override
    public void setDataSource() {
        this.jdbcTemplate = new JdbcTemplate(getDataSource());
    }
    public DataSource getDataSource() {
        String url = "jdbc:mysql://localhost:3306/spring_db";
        String username = "root";
        String pwd = "13904712181Qw";

        DataSource dataSource = new DriverManagerDataSource(url, username, pwd);
        return dataSource;
    }

    @Override
    public boolean createCart(User user) {
        String sql = "INSERT INTO spring_db.cart VALUES (?)";
        Object[] arg = {user.getId()};
        jdbcTemplate.update(sql, arg);
        return true;
    }

    @Override
    public boolean deleteCart(User user) {
        return false;
    }

    @Override
    public Cart getCart(User user) {
        return null;
    }
}
