package com.examly.springdemo.service;

import java.io.IOException;
import java.util.List;

import com.examly.springdemo.model.Product;

public interface ProductService {
    
    Product saveProduct(int userId, Product product) throws IOException;
    Product getProductById(int productId) throws IOException;
    List<Product> getAllProducts();
    void deleteProduct(int productId);
    Product updateProduct(int productId, Product product);
}
