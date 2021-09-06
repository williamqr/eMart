package com.example.demo.service;

import com.example.demo.Entity.Product;
import com.example.demo.Enums.ProductStatusEnum;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public Product findOne(String id) {
        return productRepository.findProductByProductId(id);
    }

    @Override
    @Transactional
    public void increaseStock(String productId, int amount) {
        Product productInfo = findOne(productId);

        int update = productInfo.getStock() + amount;
        productInfo.setStock(update);
        productRepository.save(productInfo);
    }

    @Override
    @Transactional
    public void decreaseStock(String productId, int amount) {
        Product productInfo = findOne(productId);

        int update = productInfo.getStock() - amount;

        productInfo.setStock(update);
        productRepository.save(productInfo);
    }


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> findUpAll(Pageable pageable) {
        return productRepository.findAllByProductStatusOrderByProductIdAsc(ProductStatusEnum.UP.getCode(),pageable);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAllByOrderByProductId(pageable);
    }

    @Override
    public void delete(String productId) {
        Product productInfo = findOne(productId);
        productRepository.delete(productInfo);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}