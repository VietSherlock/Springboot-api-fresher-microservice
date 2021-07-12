package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "invoiceDetail")
public class InvoiceDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(insertable = false, nullable = false, updatable = false)
	private int invoiceDetailID;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "unitPrice")
	private int unitPrice;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "invoiceID", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference(value = "invoice-invoiceDetail")
    private Invoice invoice;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false) 
    @JoinColumn(name = "productID", nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference(value = "invoiceDetail-product")
    private Product product;
	
	public InvoiceDetail() {
		super();
	}
	
	public InvoiceDetail(int invoiceDetailID, int quantity, int unitPrice, Invoice invoice, Product product) {
		super();
		this.invoiceDetailID = invoiceDetailID;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.invoice = invoice;
		this.product = product;
	}

	public int getInvoiceDetailID() {
		return invoiceDetailID;
	}

	public void setInvoiceDetailID(int invoiceDetailID) {
		this.invoiceDetailID = invoiceDetailID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "InvoiceDetail [invoiceDetailID=" + invoiceDetailID + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + ", invoice=" + invoice + ", product=" + product + "]";
	}
	
	
}
