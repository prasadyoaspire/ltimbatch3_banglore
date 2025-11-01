package com.examly.directbuy.controller;

import java.util.HashMap;
import java.util.Map;

import com.examly.directbuy.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examly.directbuy.model.User;
import com.examly.directbuy.service.AuthService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

   @Autowired
   private AuthService authService;

   @PostMapping("/register")
   public ResponseEntity<Map<String,String>> doRegister(@RequestBody User user) {
      authService.register(user);

      Map<String, String> response = new HashMap<>();
      response.put("message", "success");

      return ResponseEntity.status(201).body(response);
   }

    @PostMapping("/login")
    public ResponseEntity<User> doLogin(@RequestBody LoginRequest loginRequest) {
      User user = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
       return ResponseEntity.status(200).body(user);
    }
}