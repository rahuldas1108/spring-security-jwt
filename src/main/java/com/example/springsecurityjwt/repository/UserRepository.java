package com.example.springsecurityjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurityjwt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String username);

}
