package com.examly.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springdemo.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
