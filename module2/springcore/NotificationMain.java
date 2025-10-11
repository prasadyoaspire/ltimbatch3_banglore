package com.abc.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NotificationMain {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        MyComponent myComponent = (MyComponent) context.getBean("myComponent");

        myComponent.sendNotification();
    }
}
