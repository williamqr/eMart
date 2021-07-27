package com.example.demo.service;

import com.example.demo.Entity.Product;

import java.util.List;

public interface ProductService {
    Product findOne(String id);
    // increase stock
    void increaseStock(String productId, int amount);

    //decrease stock
    void decreaseStock(String productId, int amount);
    Product addProduct(Product product);
    List<Product> getAllProduct();
}
