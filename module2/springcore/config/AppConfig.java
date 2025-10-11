package com.abc.springcore.config;

import com.abc.springcore.Greetings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "greetingBean")
    Greetings greetingBean() {
        Greetings greetings = new Greetings();
        greetings.setMessage("Hello World!");
        return greetings;
    }
}
