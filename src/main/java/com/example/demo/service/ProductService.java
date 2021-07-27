package com.example.demo.service;

import com.example.demo.Entity.Product;

import java.util.List;

public interface ProductService {
    Product findOne(String id);
    Product addProduct(Product product);
    List<Product> getAllProduct();
}
