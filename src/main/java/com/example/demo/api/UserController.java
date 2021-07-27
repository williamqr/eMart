package com.example.demo.api;

import com.example.demo.Entity.User;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserServiceImpl userService;
    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    @GetMapping(path = "{email}")
    public User getUser(@PathVariable("email") String email) {
        return userService.findOne(email);
    }


    /*
    @DeleteMapping(path = "{name}")
    public int deleteUser(@PathVariable("name") String name) {
        userService.delete(name);
        return 1;
    }

     */
    @GetMapping
    @CrossOrigin(origins ="http://localhost:8080")
    public List<User> getAllUser() throws SQLException {
        return userService.getAllUser();
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.save(user);
    }

}
