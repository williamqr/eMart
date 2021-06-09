package com.example.demo.service;

import com.example.demo.dao.NewProductDAO;
import com.example.demo.dao.impl.NewProductDAOImpl;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final NewProductDAO productDao = new NewProductDAOImpl();

    @Autowired
    public ProductServiceImpl() {

    }


    @Override
    public Product findOne(String name) {
        return productDao.getProduct(name);
    }


    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

    @Override
    public Product addProduct(Product product) {productDao.create(product);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }
}