package com.java.dbms.proj.entities;

public class Customer {
	int CID;
	String First;
	String Last;
	int Phone;
	String Email;
	String Username;
	Address address = new Address();
	public int getCID() {
		return CID;
	}
	public Address getAddress() {
		return address;
	}
	
	public void setCID(int cID) {
		CID = cID;
	}
	public String getFirst() {
		return First;
	}
	public void setFirst(String first) {
		First = first;
	}
	public String getLast() {
		return Last;
	}
	public void setLast(String last) {
		Last = last;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}

}
