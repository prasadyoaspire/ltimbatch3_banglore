package com.abc.springcore;

import com.abc.springcore.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        Product product = (Product) context.getBean("pBean");

        System.out.println("Id : "+ product.getId());
        System.out.println("Name : "+ product.getName());
        System.out.println("Price : "+ product.getPrice());
    }
}
