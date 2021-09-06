package com.example.demo.service;

import com.example.demo.Entity.OrderMain;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.ProductInOrder;
import com.example.demo.Enums.orderStatusEnum;
import com.example.demo.repository.OrderMainRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMainRepository orderMainRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;
    @Override
    public OrderMain findOne(Long orderId) {
        return orderMainRepository.findByOrderId(orderId);
    }

    @Override
    public OrderMain finish(Long orderId) {
        OrderMain orderMain = findOne(orderId);
        orderMain.setOrderStatus(orderStatusEnum.FINISHED.getCode());
        orderMainRepository.save(orderMain);
        return orderMainRepository.findByOrderId(orderId);
    }

    @Override
    public OrderMain cancel(Long orderId) {

        OrderMain orderMain = findOne(orderId);
        orderMain.setOrderStatus(orderStatusEnum.CANCELED.getCode());
        orderMainRepository.save(orderMain);

        Iterable<ProductInOrder> products = orderMain.getProducts();
        for(ProductInOrder productInOrder : products) {
            Product productInfo = productRepository.findProductByProductId(productInOrder.getProductId());
            if(productInfo != null) {
                productService.increaseStock(productInOrder.getProductId(), productInOrder.getCount());
            }
        }
        return orderMainRepository.findByOrderId(orderId);

    }
}
