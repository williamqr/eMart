package com.example.demo.model;


import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;



public class Product {
    private String name;


    private int id;
    private int price;
    private int stock;
    private String description;

    private String photo;

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

    public void setPhoto(String photo) { this.photo = photo;}

    public String getPhoto(){
        return this.photo;
    }

    public Product() {

    }


    public Product(@JsonProperty("name") String name, @JsonProperty("price") int price,
                   @JsonProperty("id") int id, @JsonProperty("stock") int stock,
                   @JsonProperty("description") String description,
                   @JsonProperty("photo") String photo) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.stock = stock;
        this.description = description;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

}

