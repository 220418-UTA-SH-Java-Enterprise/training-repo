package com.revature.models;

import java.time.LocalDate;

public class Product {

	/*
	 * - Products
 * 			+ id (PK)
 * 			+ name
 * 			+ price
 * 			+ expiration_date
	 */
	
	private int productId;
	private String productName;
	private double productPrice;
	private LocalDate productExpDate;
	
	public Product() {
		super();
	}

	public Product(String productName, double productPrice, LocalDate productExpDate) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productExpDate = productExpDate;
	}

	public Product(int productId, String productName, double productPrice, LocalDate productExpDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productExpDate = productExpDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public LocalDate getProductExpDate() {
		return productExpDate;
	}

	public void setProductExpDate(LocalDate productExpDate) {
		this.productExpDate = productExpDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productExpDate=" + productExpDate + "]";
	}
}
