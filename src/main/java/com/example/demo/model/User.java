package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private int id;
    private String name;
    private String email;
    private String pwd;
    private Cart cart;
    public User(@JsonProperty("id") int id,@JsonProperty("name") String name,
                @JsonProperty("email") String email, @JsonProperty("pwd") String pwd){
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.cart = new Cart(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
