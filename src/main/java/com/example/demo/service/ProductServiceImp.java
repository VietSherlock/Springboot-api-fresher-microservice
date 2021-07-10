package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImp(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/************ Read Products *****************/

	// get all products
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	// get a product by productID
	public Product findByProductID(int productID) {
		return productRepository.findByProductID(productID);
	}

//	// get list product by productName
//	public List<Product> findByProductName(String productName) {
//		return productRepository.findByProductName(productName);
//	}

	/***************** Save Product ************************/

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	/***************** Delete Product ************************/

	// delete product by productID
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}

}
