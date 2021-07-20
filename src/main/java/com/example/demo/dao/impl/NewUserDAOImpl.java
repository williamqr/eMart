package com.example.demo.dao.impl;

import com.example.demo.dao.NewUserDAO;
import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
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
    public List<User> getAllUser() throws SQLException {
        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/spring_db", "root", "13904712181Qw");

        String sql = "" +
                "SELECT * " +
                "FROM spring_db.user";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        List<User> list = new ArrayList<>();
        while(rs.next()){
            User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("pwd"));
            list.add(user);
        }
        return list;
    }



    @Override
    public User getUser(String name) {
        return null;
    }

    @Override
    public User verify(String name, String pwd) throws SQLException {

        Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/spring_db", "root", "13904712181Qw");

        String sql = "" +
                "SELECT * " +
                "FROM spring_db.user WHERE name='" + name + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            if(rs.getString("pwd").equals(pwd)){
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("pwd"));
            }
            else return null;
        }
        return null;
    }
}
