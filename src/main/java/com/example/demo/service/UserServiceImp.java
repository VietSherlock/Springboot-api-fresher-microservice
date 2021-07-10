package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomUserDetails;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImp implements UserService, UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {

		User user = userRepository.findByUsername(username);

		if (user == null)
			throw new UsernameNotFoundException(username);

		return new CustomUserDetails(user);
	}

	@Override
	public UserDetails loadUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	@Transactional
//	public UserDetails loadUserById(Long id) {
//		User user = userRepository.findById(id)
//				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));
//
//		return new CustomUserDetails(user);
//	}

}
