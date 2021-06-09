package com.example.demo.dao.impl;

import com.example.demo.dao.NewProductDAO;
import com.example.demo.model.Person;
import com.example.demo.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class NewProductDAOImpl implements NewProductDAO {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
    @Override
    public void setDataSource() {
        jdbcTemplate = new JdbcTemplate(getDataSource());
    }

    @Override
    public boolean create(Product p) {
        String sql = "INSERT INTO spring_db.product VALUES (?,?,?)";
        Object[] arg = {p.getId(), p.getName(), p.getPrice()};
        jdbcTemplate.update(sql, arg);
        return true;
    }

    @Override
    public Product getProduct(String name) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        String sqlQuery = "SELECT * FROM spring_db.product";
        return jdbcTemplate.query(sqlQuery, new ProductRowMapper());
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Person p) {
        return false;
    }

    @Override
    public void cleanup() {

    }

    public DataSource getDataSource() {
        String url = "jdbc:mysql://localhost:3306/spring_db";
        String username = "root";
        String pwd = "13904712181Qw";

        DataSource dataSource = new DriverManagerDataSource(url, username, pwd);
        return dataSource;
    }
}
