package com.example.demo.service;

import com.example.demo.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product findOne(String id);
    // increase stock
    void increaseStock(String productId, int amount);

    // All selling products
    Page<Product> findUpAll(Pageable pageable);
    // All products
    Page<Product> findAll(Pageable pageable);

    void delete(String productId);
    //decrease stock
    void decreaseStock(String productId, int amount);
    Product addProduct(Product product);
    List<Product> getAllProduct();
}
