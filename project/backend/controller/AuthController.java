package com.examly.springdemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springdemo.model.User;
import com.examly.springdemo.service.AuthService;

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

   // @PostMapping("/login")
   // public ResponseEntity<String> doLogin(@RequestBody User user) {

   // }

}
