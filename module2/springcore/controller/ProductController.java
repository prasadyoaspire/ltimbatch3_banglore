package com.abc.springcore.controller;

import com.abc.springcore.model.Product;
import com.abc.springcore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public void insertProduct(Product product) {
        productService.saveProduct(product);
    }

    public void displayAllProductData() {
        productService.fetchAlProducts();
    }
}
