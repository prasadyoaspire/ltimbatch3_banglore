package com.examly.directbuy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.directbuy.model.Product;
import com.examly.directbuy.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/product")
    public ResponseEntity<Map<String,String>> addProduct(@RequestParam("userId") int userId,@RequestBody Product product) throws IOException {
        
        productService.saveProduct(userId, product);

        Map<String,String> response = new HashMap<>();
        response.put("message", "Product added successfully");

        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/api/product/{productId}") 
    public ResponseEntity<Product> getProductDetails(@PathVariable int productId) throws IOException {        
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(200).body(product);
    }

    @GetMapping("/api/product/user/{userId}")
    public ResponseEntity<List<Product>> getProductsByUser(@PathVariable int userId) throws IOException {
        List<Product> products = productService.getAllProductsByAdmin(userId);
        return ResponseEntity.status(200).body(products);
    }
}
