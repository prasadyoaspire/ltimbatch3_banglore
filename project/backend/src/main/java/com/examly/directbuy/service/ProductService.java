package com.examly.directbuy.service;

import java.io.IOException;
import java.util.List;

import com.examly.directbuy.model.Product;

public interface ProductService {
    
    Product saveProduct(int userId, Product product) throws IOException;
    Product getProductById(int productId) throws IOException;
    List<Product> getAllProducts();
    List<Product> getAllProductsByAdmin(int adminId);
    void deleteProduct(int productId);
    Product updateProduct(int productId, Product product);
}
