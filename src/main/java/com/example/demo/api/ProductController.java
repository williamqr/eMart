package com.example.demo.api;

import com.example.demo.Entity.Product;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    /*
    @DeleteMapping(path = "{name}")
    public int deleteProduct(@PathVariable("name") String name) {
        productService.delete(name);
        return 1;
    }

     */
    @GetMapping
    public Page<Product> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "3") Integer size) {
        PageRequest request = PageRequest.of(page - 1, size);
        return productService.findAll(request);
    }

    @GetMapping("/{productId}")
    public Product showOne(@PathVariable("productId") String productId) {

        Product productInfo = productService.findOne(productId);

//        // Product is not available
//        if (productInfo.getProductStatus().equals(ProductStatusEnum.DOWN.getCode())) {
//            productInfo = null;
//        }

        return productInfo;
    }
    @PostMapping
    public void addProduct(@RequestBody Product product){

            productService.addProduct(product);

    }


    @DeleteMapping("/seller/product/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") String productId) {
        productService.delete(productId);
        return ResponseEntity.ok().build();
    }


}
