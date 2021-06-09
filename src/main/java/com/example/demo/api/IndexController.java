package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/index")
@RestController
public class IndexController {
    @GetMapping
    public String printIndex() {return "Index";}
}
