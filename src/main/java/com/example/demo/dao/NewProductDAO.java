package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.model.Product;

import java.util.List;
import java.util.UUID;

public interface NewProductDAO {
    public void setDataSource();

    public boolean create(Product p);

    public Product getProduct(String name);

    public List<Product> getAllProduct();


    public boolean delete(int id);

    public boolean update(Person p);

    public void cleanup();
}
