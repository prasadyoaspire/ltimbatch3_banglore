package com.abc.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingMain {
    public static void main(String[] args) {

//        Greetings greetings = new Greetings();
//        greetings.setMessage("Hello How are you?");

        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        Greetings greetings = (Greetings) context.getBean("greetingBean");

        System.out.println(greetings.getMessage());

    }
}
