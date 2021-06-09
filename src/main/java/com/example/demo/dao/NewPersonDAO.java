package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface NewPersonDAO {

    public void setDataSource();

    public boolean create(Person p);

    public Person getPerson(UUID id);

    public List<Person> getAllPerson();


    public boolean delete(UUID id);

    public boolean update(Person p);

    public void cleanup();
}
