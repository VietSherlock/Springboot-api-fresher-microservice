package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.User;

public interface UserService {
	
	UserDetails loadUserByUsername(String username);
	
	UserDetails loadUserById(Long id);
}
