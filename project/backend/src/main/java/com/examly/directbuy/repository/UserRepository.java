package com.examly.directbuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.directbuy.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer>{

    Optional<User> findByEmail(String email);
}
