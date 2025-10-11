package com.abc.springcore.dao;

import com.abc.springcore.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductDao {

    private ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void  displayAll() {
        productList.forEach(p-> System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice()));
    }

}
