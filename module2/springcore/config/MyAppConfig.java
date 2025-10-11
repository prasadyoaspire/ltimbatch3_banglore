package com.abc.springcore.config;


import com.abc.springcore.controller.ProductController;
import com.abc.springcore.dao.ProductDao;
import com.abc.springcore.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.abc.springcore")
public class MyAppConfig {

//    @Bean
//    ProductController productControllerBean() {
//        ProductController pController = new ProductController();
////        pController.setProductService(productServiceBean()); //explicitly injecting
//        return pController;
//    }
//
//    @Bean
//    ProductService productServiceBean() {
//        ProductService pService = new ProductService();
////        pService.setProductDao(productDaoBean()); //explicitly injecting
//        return pService;
//    }
//
//    @Bean
//    ProductDao productDaoBean() {
//        ProductDao pDao = new ProductDao();
//        return  pDao;
//    }
}
