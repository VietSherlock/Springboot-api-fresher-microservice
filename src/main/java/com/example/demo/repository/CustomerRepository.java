package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	List<Customer> findByCustomerName(String customerName);
	Customer findByCustomerID(int customerID);
	
}
