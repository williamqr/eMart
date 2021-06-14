package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.model.Product;
import com.example.demo.service.PersonService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/product")
@RestController
public class ProductController {
    private final ProductServiceImpl productService;
    @Autowired
    public ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }

    @GetMapping(path = "{name}")
    public Product getProduct(@PathVariable("name") String name) {
        return productService.findOne(name);
    }
    @DeleteMapping(path = "{name}")
    public int deleteProduct(@PathVariable("name") String name) {
        productService.delete(name);
        return 1;
    }
    @GetMapping
    @CrossOrigin(origins ="http://localhost:8080")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }



}
