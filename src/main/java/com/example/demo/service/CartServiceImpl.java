package com.example.demo.service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.OrderMain;
import com.example.demo.Entity.ProductInOrder;
import com.example.demo.Entity.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.OrderMainRepository;
import com.example.demo.repository.ProductInOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderMainRepository orderMainRepository;
    @Autowired
    ProductInOrderRepository productInOrderRepository;
    @Autowired
    ProductService productService;
    @Override
    public Cart getCart(User user) {
        return user.getCart();
    }


    public List<Cart> getAll(List<User> users) {
        List<Cart> carts = new ArrayList<>();
        for(User user : users) {
            Cart cart = user.getCart();
            carts.add(cart);
        }
        return carts;
    }


    @Override
    @Transactional
    public void checkout(User user) {
        // Create an order
        OrderMain order = new OrderMain(user);
        orderMainRepository.save(order);

        // clear cart's foreign key & set order's foreign key& decrease stock
        user.getCart().getProducts().forEach(productInOrder -> {
            productInOrder.setCart(null);
            productInOrder.setOrderMain(order);
            productService.decreaseStock(productInOrder.getProductId(), productInOrder.getCount());
            productInOrderRepository.save(productInOrder);
        });

    }


    @Override
    @Transactional
    public void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user) {
        Cart finalCart = user.getCart();
        productInOrders.forEach(productInOrder -> {
            Set<ProductInOrder> set = finalCart.getProducts();
            Optional<ProductInOrder> old = set.stream().filter(e -> e.getProductId().equals(productInOrder.getProductId())).findFirst();
            ProductInOrder prod;
            if (old.isPresent()) {
                prod = old.get();
                prod.setCount(productInOrder.getCount() + prod.getCount());
            } else {
                prod = productInOrder;
                prod.setCart(finalCart);
                finalCart.getProducts().add(prod);
            }
            productInOrderRepository.save(prod);
        });
        cartRepository.save(finalCart);

    }
}
