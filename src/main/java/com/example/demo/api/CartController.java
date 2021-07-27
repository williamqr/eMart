package com.example.demo.api;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.User;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @GetMapping(path ="{email}")
    public Cart getCart(@PathVariable("email") String email) {
        User user = userService.findOne(email);
        return cartService.getCart(user);
    }

    @GetMapping
    public List<Cart> getAllCart() {
        return cartService.getAll(userService.findAll());
    }

}
