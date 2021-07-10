package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImpTest {

	@Mock
	private ProductRepository productRepository;
	private ProductServiceImp underTest;

	@BeforeEach
	void setUp() throws Exception {
		underTest = new ProductServiceImp(productRepository);
	}

	@Test
	void canFindAll() {
		// when
		underTest.findAll();

		// then
		verify(productRepository).findAll();
	}

	@Test
	void canFindByProductID() {

		// given
		int productID = 1;

		// when
		underTest.findByProductID(productID);

		// then
		ArgumentCaptor<Integer> productIDArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		verify(productRepository).findByProductID(productIDArgumentCaptor.capture());
		int capturedProductID = productIDArgumentCaptor.getValue();
		assertThat(capturedProductID).isEqualTo(productID);

	}

	@Test
	void canSave() {

		// given
		Product product = new Product("Iphone 11 Pro");

		// when
		underTest.save(product);

		// then
		// tao doi tuong captor
		ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);

		// lay doi tuong product trong function save ben productServiceImp
		// productRepository.save(product) lay product nay
		verify(productRepository).save(productArgumentCaptor.capture());

		// lay value cua product trong function save
		Product capturedProduct = productArgumentCaptor.getValue();

		// so sanh product duoc fake bang mock productRepository va product o
		// customerService
		assertThat(capturedProduct).isEqualTo(product);
	}

	@Test
	void canDeleteById() {

		// given
		int productID = 1;

		// when
		underTest.deleteById(productID);

		// then
		ArgumentCaptor<Integer> productIDArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		verify(productRepository).deleteById(productIDArgumentCaptor.capture());
		int captureProductID = productIDArgumentCaptor.getValue();
		assertThat(captureProductID).isEqualTo(productID);

	}

}
