package com.newproject.entity;

public class Cart extends Product {
	
	private int cart_id;
	private int quantity;
	
	
	
	//contructors
	public Cart() {	
	}
	public Cart (int cart_id, int productId, int userId, int quantity) {
		this.cart_id = cart_id;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;	
	}
	
	
	
	
	//getters and setters
	public int getcart_id() {
		return cart_id;
	}
	public void setcart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	
	
	
	public int getquantity() {
		return quantity;
	}
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
}
