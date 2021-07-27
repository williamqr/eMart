package com.example.demo.service;

import com.example.demo.Entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public Product findOne(String id) {
        return productRepository.findProductById(id);
    }



    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}