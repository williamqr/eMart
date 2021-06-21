package com.example.demo.model;

public class Cart {
    private Product[] products;
    private int cartId;
    public Cart(int id){
        // the id is the same as the User id
        this.cartId = id;
    }

}
