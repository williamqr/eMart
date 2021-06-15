package com.example.demo.dao.impl;

import com.example.demo.dao.NewUserDAO;
import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class NewUserDAOImpl implements NewUserDAO {
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
    public boolean createUser(User user) {
        String sql = "INSERT INTO spring_db.user VALUES (?,?,?,?)";
        Object[] arg = {user.getId(), user.getName(), user.getEmail(), user.getPwd()};
        jdbcTemplate.update(sql, arg);
        return true;
    }

    @Override
    public boolean deleteUser(String name) {
        return false;
    }

    @Override
    public List<User> getAllUser() {
        String sqlQuery = "SELECT * FROM spring_db.user";
        return jdbcTemplate.query(sqlQuery, new UserRowMapper());
    }

    @Override
    public User getUser(String name) {
        return null;
    }
}
