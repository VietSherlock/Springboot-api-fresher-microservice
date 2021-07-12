package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private int invoiceID;

//	@Column(name = "customerID")
//	private int customerID;

	@Column(name = "paymentMethod")
	private String paymentMethod;

	@Column(name = "invoiceDate")
	private Date invoiceDate;

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<InvoiceDetail> invoiceDetails;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customerID", nullable = false)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Customer customer;

	public Invoice() {
		super();
	}

//	public Invoice(int invoiceID, int customerID, String paymentMethod, Date invoiceDate) {
//		super();
//		this.invoiceID = invoiceID;
//		this.customerID = customerID;
//		this.paymentMethod = paymentMethod;
//		this.invoiceDate = invoiceDate;
//	}

	public Invoice(int invoiceID, String paymentMethod, Date invoiceDate, Collection<InvoiceDetail> invoiceDetails,
			Customer customer) {
		super();
		this.invoiceID = invoiceID;
		this.paymentMethod = paymentMethod;
		this.invoiceDate = invoiceDate;
		this.invoiceDetails = invoiceDetails;
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

	public Collection<InvoiceDetail> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(Collection<InvoiceDetail> invoiceDetails) {
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
				+ ", invoiceDetails=" + invoiceDetails + ", customer=" + customer + "]";
	}
	
}
