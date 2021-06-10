package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product findOne(String name);
    Product addProduct(Product product);
    List<Product> getAllProduct();
    void delete(String name);
}
