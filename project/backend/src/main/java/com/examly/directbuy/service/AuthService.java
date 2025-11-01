package com.examly.directbuy.service;

import com.examly.directbuy.model.User;

public interface AuthService {
    
    User register(User user);

    User login(String email, String password);
}
