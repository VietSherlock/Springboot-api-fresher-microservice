package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Entity
@Table(name = "customer")
public class Customer implements Serializable { // customer object can covert to stream by serializable interface

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increase
	@Column(nullable = false, updatable = false, unique = true) // column not null and not updated
	private int customerID;

	private String customerName;
	private String phoneNumber;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonManagedReference(value = "customer-invoice")
	private Set<Invoice> invoices;

	public Customer() {
		super();
	}

	public Customer(int customerID, String customerName, String phoneNumber) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}

	public Customer(String customerName, String phoneNumber) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
	}
	
	

	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Collection<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", phoneNumber=" + phoneNumber
				+ "]";
	}

}
