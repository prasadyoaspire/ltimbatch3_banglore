package com.abc.springcore;

import com.abc.springcore.config.MyAppConfig;
import com.abc.springcore.controller.ProductController;
import com.abc.springcore.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ProductController pController = (ProductController) context.getBean("pController");

        ApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
        ProductController pController = context.getBean(ProductController.class);

        Product p1 = new Product();
        p1.setId(10);
        p1.setName("Samsung");
        p1.setPrice(90000);

        Product p2 = new Product();
        p2.setId(20);
        p2.setName("Iphone");
        p2.setPrice(90000);

        pController.insertProduct(p1);
        pController.insertProduct(p2);

        pController.displayAllProductData();
    }
}
