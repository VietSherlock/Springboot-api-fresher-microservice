package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Customer;

@DataJpaTest
class CustomerRepositoryTest {

	@Autowired
	CustomerRepository underTest;

	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}

	@Test
	void itShouldFindCustomerByID() {

		// given
		Customer customer = new Customer("Nguyen Van A");
		Customer customerTest = underTest.save(customer);

		// when
		Customer expected = underTest.findByCustomerID(customerTest.getCustomerID());

		// then
		assertThat(expected).isEqualTo(customerTest);
	}

	@Test
	void itShouldNotFindCustomerByID() {

		// given
		int customerId = 1;

		// when
		Customer customerTest = underTest.findByCustomerID(customerId);
		
		// then
		boolean expected = true;
		if(customerTest == null)
			expected = true;
		else expected = false;
		
		assertThat(expected).isTrue();
	}

}
