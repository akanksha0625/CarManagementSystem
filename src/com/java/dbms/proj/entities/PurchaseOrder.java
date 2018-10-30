package com.java.dbms.proj.main;

import java.util.Date;

public class PurchaseOrder {
	int sourceID;
	String sourceType;
	int partID;
	Date orderDate;
	int partQuantity;
	int orderID;
	String state;
	
	public int getSourceID() {
		return sourceID;
	}
	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public int getPartID() {
		return partID;
	}
	public void setPartID(int partID) {
		this.partID = partID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getPartQuantity() {
		return partQuantity;
	}
	public void setPartQuantity(int partQuantity) {
		this.partQuantity = partQuantity;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
