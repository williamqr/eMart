package com.example.demo.api;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.service.ProductServiceImpl;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserServiceImpl userService;
    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping(path = "{name}")
    public User getUser(@PathVariable("name") String name) {
        return userService.findOne(name);
    }
    @DeleteMapping(path = "{name}")
    public int deleteUser(@PathVariable("name") String name) {
        userService.delete(name);
        return 1;
    }
    @GetMapping
    @CrossOrigin(origins ="http://localhost:8080")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping
    public void addProduct(@RequestBody User user){
        userService.addUser(user);
    }

}
