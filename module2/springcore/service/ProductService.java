package com.abc.springcore.service;

import com.abc.springcore.dao.ProductDao;
import com.abc.springcore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void saveProduct(Product product) {
        productDao.addProduct(product);
    }

    public void fetchAlProducts() {
        productDao.displayAll();
    }
}
