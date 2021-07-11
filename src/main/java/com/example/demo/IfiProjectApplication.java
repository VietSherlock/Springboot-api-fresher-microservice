package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.service.CustomerServiceImp;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class })
@ComponentScan({ "com.example.demo.controller", "com.example.demo.service", "com.example.demo.model",
		"com.example.demo.util", "com.example.demo.security" })
@EntityScan(basePackages = { "com.example.demo.entity" })
@EnableJpaRepositories(basePackages = { "com.example.demo.repository" })
public class IfiProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(IfiProjectApplication.class, args);
		
		CustomerServiceImp customerServiceImp = context.getBean(CustomerServiceImp.class);
		customerServiceImp.findAll().forEach(System.out::println);
		
	}
	
}
