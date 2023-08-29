package com.newproject.entity;

public class Product extends User {
	protected int productId;
	private String productName;
	private String description;
	private double price;
	private int stockQuantity;
	private String productImageURL;
	private int categoryId;
	
	
	
	public Product(int productId, String productName, String description, double price, int stockQuantity, String productImageURL) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;;
		this.productImageURL = productImageURL;
	}
	
	public Product(String productName, String description, double price, int stockQuantity, String productImageURL, int categoryId) {
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.stockQuantity = stockQuantity;;
		this.productImageURL = productImageURL;
		this.categoryId = categoryId;
	}
	
	public Product() {
		
	}
	
	public int getproductId() {
		return productId;
	}
	public void setproductId(int productId) {
		this.productId = productId;
	}
	
	public int getcategoryId() {
		return categoryId;
	}
	public void setcategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	
	public double getprice() {
		return price;
	}
	public void setprice(double price) {
		this.price = price;
	}
	
	public int getstockQuantity() {
		return stockQuantity;
	}
	public void setstockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	public String getproductImageURL() {
		return productImageURL;
	}
	public void setproductImageURL(String productImageURL) {
		this.productImageURL = productImageURL;
	}
	
	
}
























