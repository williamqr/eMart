package com.example.demo.repository;

import com.example.demo.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Product findProductByProductId(String productId);

    Page<Product> findAllByProductStatusOrderByProductIdAsc(Integer productStatus, Pageable pageable);


    Page<Product> findAllByOrderByProductId(Pageable pageable);
}
