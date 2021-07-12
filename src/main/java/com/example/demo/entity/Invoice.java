package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false, unique = true, nullable = false)
	private int invoiceID;

	@Column(name = "paymentMethod")
	private String paymentMethod;

	@Column(name = "invoiceDate")
	private Date invoiceDate;

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonManagedReference(value = "invoice-invoiceDetail")
	private Set<InvoiceDetail> invoiceDetails;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customerID", nullable = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonBackReference(value = "customer-invoice")
	private Customer customer;

	public Invoice() {
		super();
	}

	public Invoice(int invoiceID, String paymentMethod, Date invoiceDate, Set<InvoiceDetail> invoiceDetails,
			Customer customer) {
		super();
		this.invoiceID = invoiceID;
		this.paymentMethod = paymentMethod;
		this.invoiceDate = invoiceDate;
		this.invoiceDetails = invoiceDetails;
		this.customer = customer;
	}

	public Invoice(int invoiceID, String paymentMethod, Date invoiceDate, Customer customer) {
		super();
		this.invoiceID = invoiceID;
		this.paymentMethod = paymentMethod;
		this.invoiceDate = invoiceDate;
		this.customer = customer;
	}

	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Set<InvoiceDetail> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceID=" + invoiceID + ", paymentMethod=" + paymentMethod + ", invoiceDate=" + invoiceDate
				+ ", customer=" + customer + "]";
	}
	
}
