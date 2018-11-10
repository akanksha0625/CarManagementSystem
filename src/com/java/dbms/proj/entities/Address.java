package com.java.dbms.proj.entities;

public class Address {
	
	int ADD_ID;
	String street;
	String city;
	String state;
	String zipCode;
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public int getADD_ID() {
		return ADD_ID;
	}
	public void setADD_ID(int aDD_ID) {
		ADD_ID = aDD_ID;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
