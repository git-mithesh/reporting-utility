package com.ssn.utility.encryptdecrypt.beans;

public class User {

	String name;
	String email;
	public User() {
		super(); 
	}
	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
