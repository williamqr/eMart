package com.example.demo.dao.impl;

import com.example.demo.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

        Person p = new Person(rs.getInt("id"), rs.getString("people_name"));
        return p;
    }
}
