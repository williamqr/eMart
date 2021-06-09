package com.example.demo;

import com.example.demo.dao.NewPersonDAO;
import com.example.demo.dao.impl.NewPersonDAOImpl;
import com.example.demo.model.Person;

import java.util.List;
import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        NewPersonDAO newPersonDAO = new NewPersonDAOImpl();

        List<Person> personList = newPersonDAO.getAllPerson();
        for(Person p : personList) {
            System.out.println(p.getId());
            System.out.println(p.getName());
        }

    }
}
