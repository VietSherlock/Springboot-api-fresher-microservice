package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImpTest {

	@Mock private CustomerRepository customerRepository;
	private CustomerServiceImp underTest;

	@BeforeEach
	void setUp() throws Exception {
		underTest = new CustomerServiceImp(customerRepository);
	}

	@Test
	void canFindAll() {
		// when
		underTest.findAll();
		// Then
		verify(customerRepository).findAll();
	}

	@Test
	void canFindByCustomerID() {
		// given
		int customerID = 1;
		
		//when
		underTest.findByCustomerID(customerID);
		
		//then
		ArgumentCaptor<Integer> customerIDArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		verify(customerRepository).findByCustomerID(customerIDArgumentCaptor.capture());
		int capturedCustomerID = customerIDArgumentCaptor.getValue();
		assertThat(capturedCustomerID).isEqualTo(customerID);
	}

	@Test
	void canSave() {
		// given
		Customer customer = new Customer("Le Ngoc Viet");

		// when
		underTest.save(customer);

		// then
		//tao doi tuong captor
		ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
		
		//lay doi tuong customer trong function save ben customerServiceImp 
		// customerRepository.save(customer) lay customer nay
		verify(customerRepository).save(customerArgumentCaptor.capture());
		
		//lay value cua customer trong function save
		Customer capturedCustomer = customerArgumentCaptor.getValue();
		
		//so sanh customer duoc fake bang mock customerRepository va customer o customerService
		assertThat(capturedCustomer).isEqualTo(customer);

	}

	@Test
	void canDeleteById() {
		//given
		int customerID = 1;
		
		//when
		underTest.deleteById(customerID);
		
		//then
		ArgumentCaptor<Integer> customerIDArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		verify(customerRepository).deleteById(customerIDArgumentCaptor.capture());
		int captureCustomerID = customerIDArgumentCaptor.getValue();
		assertThat(captureCustomerID).isEqualTo(customerID);
	}

}
