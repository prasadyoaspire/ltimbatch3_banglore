package com.examly.springdemo.service;

import com.examly.springdemo.model.User;

public interface AuthService {
    
    User register(User user);

    User login(String email, String password);
}
