package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final int id;
    private final String name;
    private Cart cart;

    public Person(@JsonProperty("id") int id,
                  @JsonProperty("name") String name){
        this.id = id;
        this.name = name;

    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

}
