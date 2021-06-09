package com.example.demo.model;


import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private String name;
    private int id;
    private int price;
    private int stock;
    private String description;

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {

    }
    public Product(@JsonProperty("name") String name, @JsonProperty("price") int price, @JsonProperty("id") int id) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.stock = 0;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

}

