package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Product findByProductID(int productID);
	
//	List<Product> findByProductName(String productName);

}
