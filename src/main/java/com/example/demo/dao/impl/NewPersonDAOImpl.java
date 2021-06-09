package com.example.demo.dao.impl;

import com.example.demo.dao.NewPersonDAO;
import com.example.demo.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class NewPersonDAOImpl implements NewPersonDAO {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
    @Override
    public void setDataSource() {
        jdbcTemplate = new JdbcTemplate(getDataSource());
    }

    public DataSource getDataSource() {
        String url = "jdbc:mysql://localhost:3306/spring_db";
        String username = "root";
        String pwd = "13904712181Qw";

        DataSource dataSource = new DriverManagerDataSource(url, username, pwd);
        return dataSource;
    }

    @Override
    public boolean create(Person p) {
        String sql = "INSERT INTO spring_db.people VALUES (?,?)";
        Object[] arg = {p.getId(), p.getName()};
        jdbcTemplate.update(sql, arg);
        return true;
    }

    @Override
    public Person getPerson(UUID id) {
        return null;
    }

    @Override
    public List<Person> getAllPerson() {
        String sqlQuery = "SELECT * FROM spring_db.people";
        return jdbcTemplate.query(sqlQuery, new PersonRowMapper());
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean update(Person p) {
        return false;
    }

    @Override
    public void cleanup() {

    }
}
