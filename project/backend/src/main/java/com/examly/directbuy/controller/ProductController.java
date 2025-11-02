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
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Map<String,String>> addProduct(@RequestParam("userId") int userId,@RequestBody Product product) throws IOException {
        productService.saveProduct(userId, product);
        Map<String,String> response = new HashMap<>();
        response.put("message", "Product added successfully");
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductDetails(@PathVariable int productId) throws IOException {        
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(200).body(product);
    }

    @GetMapping("/user/{userId}")
    public List<Product> getProductsByUser(
            @PathVariable int userId,
            @RequestParam(required = false) String searchValue) {

        return productService.getProductsByUser(userId, searchValue);
    }

    @GetMapping
    public List<Product> getAllProducts(
            @RequestParam(defaultValue = "asc") String sortOrder,
            @RequestParam(required = false) String searchValue) {
        return productService.getProducts(sortOrder, searchValue);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Map<String,String>> editProduct(@PathVariable int productId,@RequestBody Product product) throws IOException {
        productService.updateProduct(productId,product);
        Map<String,String> response = new HashMap<>();
        response.put("message", "Product updated successfully");
        return ResponseEntity.status(200).body(response);
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Map<String,String>> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        Map<String,String> response = new HashMap<>();
        response.put("message", "Product deleted successfully");
        return ResponseEntity.status(200).body(response);
    }
}
