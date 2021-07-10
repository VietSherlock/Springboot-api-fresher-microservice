package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.entity.Product;

@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	ProductRepository underTest;

	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}

	@Test
	void itShouldFindProductByID() {

		// given
		Product product = new Product("Iphone 11 Pro");
		Product productTest = underTest.save(product);

		// when
		Product expected = underTest.findByProductID(productTest.getProductID());

		// then
		assertThat(expected).isEqualTo(productTest);

	}

	@Test
	void itShouldNotFindProductByID() {

		// given
		int productId = 1;

		// when
		Product productTest = underTest.findByProductID(productId);

		// then
		boolean expected = true;
		if (productTest == null)
			expected = true;
		else
			expected = false;

		assertThat(expected).isTrue();
	}

}
