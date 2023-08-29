package com.newproject.entity;

public class User {
	
	protected int userId;
	private String userFname;
	private String userLname;
	private String userMobile;
	private String userEmail;
	private String userPassword;
	private String userType;
	
	public User(int userId, String userFname, String userLname, String userMobile, String userEmail, String userPassword, String userType) {
		this.userId = userId;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userMobile = userMobile;
		this.userEmail = userEmail;;
		this.userPassword = userPassword;
		this.userType = userType;
	}
	
	public User(String userFname, String userLname, String userMobile, String userEmail, String userPassword, String userType) {
		this.userFname = userFname;
		this.userLname = userLname;
		this.userMobile = userMobile;
		this.userEmail = userEmail;;
		this.userPassword = userPassword;
		this.userType = userType;
	}
	public User() {
		
	}
	
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}
	
	public String getuserFname() {
		return userFname;
	}
	public void setuserFname(String userFname) {
		this.userFname = userFname;
	}
	
	public String getuserLname() {
		return userLname;
	}
	public void setuserLname(String userLname) {
		this.userLname = userLname;
	}
	
	public String getuserMobile() {
		return userMobile;
	}
	public void setuserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	
	public String getuserEmail() {
		return userEmail;
	}
	public void setuserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getuserPassword() {
		return userPassword;
	}
	public void setuserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getuserType() {
		return userType;
	}
	public void setuserType(String userType) {
		this.userType = userType;
	}
	
}
