package com.examly.directbuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.directbuy.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>{

    @Query("select p from Product p where p.user.userId = :adminId")
    List<Product> findAllProductsByUser(@Param("adminId") int userId);

}
