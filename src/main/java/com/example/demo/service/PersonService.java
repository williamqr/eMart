package com.example.demo.service;

import com.example.demo.dao.NewPersonDAO;
import com.example.demo.dao.impl.NewPersonDAOImpl;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final NewPersonDAO newPersonDAO = new NewPersonDAOImpl();

    @Autowired
    public PersonService() {
    }

    public boolean addPerson(Person person){
        return newPersonDAO.create(person);
    }

    public List<Person> getAllPeople() {
        return newPersonDAO.getAllPerson();
    }

    public boolean deletePersonById(UUID id) {return newPersonDAO.delete(id); }

    public boolean updatePersonById(UUID id, Person person) { return newPersonDAO.update(person); }

}
