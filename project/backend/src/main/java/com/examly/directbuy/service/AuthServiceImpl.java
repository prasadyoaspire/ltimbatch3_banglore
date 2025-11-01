package com.examly.directbuy.service;

import com.examly.directbuy.exception.InvalidCredentialsException;
import com.examly.directbuy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.directbuy.model.User;
import com.examly.directbuy.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {

       Optional<User> optionalUser =  userRepository.findByEmail(email);
       if(optionalUser.isEmpty()) {
           throw new ResourceNotFoundException("User not registered");
       }
       User user = optionalUser.get();
       if(!user.getPassword().equals(password)) {
           throw new InvalidCredentialsException("Invalid Email or Password");
       }
       return user;
    }
}