package com.examly.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springdemo.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
    
}
