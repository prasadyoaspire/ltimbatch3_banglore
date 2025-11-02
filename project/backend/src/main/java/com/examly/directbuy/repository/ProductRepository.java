package com.examly.directbuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.directbuy.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>{

    @Query("SELECT p FROM Product p WHERE p.user.userId = :adminId")
    List<Product> findAllProductsByUser(@Param("adminId") int userId);

    @Query("SELECT p FROM Product p WHERE LOWER(p.productName) LIKE LOWER(CONCAT('%', :searchValue, '%'))")
    List<Product> searchProducts(@Param("searchValue") String searchValue);

    @Query("SELECT p FROM Product p WHERE p.user.userId = :userId AND " +
            "(:searchValue IS NULL OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :searchValue, '%')))")
    List<Product> findByUserIdAndSearchValue(@Param("userId") int userId,
                                             @Param("searchValue") String searchValue);

}
