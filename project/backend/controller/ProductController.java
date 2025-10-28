package com.examly.springdemo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springdemo.model.Product;
import com.examly.springdemo.service.ProductService;

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
}
