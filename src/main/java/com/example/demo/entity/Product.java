package com.example.demo.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "product")
@Data
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false, unique = true)
	private int productID;
	
	@Column(name = "product_name")
	private String productName;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference(value = "invoiceDetail-product")
    private Set<InvoiceDetail> invoiceDetails;
	
	public Product() {
		super();
	}

	public Product(int productID, String productName) {
		super();
		this.productID = productID;
		this.productName = productName;
	}
	
	public Product(String productName, Set<InvoiceDetail> invoiceDetails) {
		super();
		this.productName = productName;
		this.invoiceDetails = invoiceDetails;
	}
	
	public Product(String productName) {
		super();
		this.productName = productName;
	}
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", invoiceDetails=" + invoiceDetails
				+ "]";
	}
	
}