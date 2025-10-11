package com.abc.springcore;

import com.abc.springcore.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavConfigMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Greetings greetings = (Greetings) context.getBean("greetingBean");
        Greetings greetings = context.getBean(Greetings.class);

        System.out.println(greetings.getMessage());
    }
}
