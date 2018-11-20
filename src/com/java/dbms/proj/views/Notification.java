package com.java.dbms.proj.views;

import com.java.dbms.proj.common.HelperFunctions;

public class Notification {
	private String notificationID;
	private String notificationDate;
	private String notificationTime;
	private String orderID;
	private String supplierName;
	private String supplierID;
	private String supplierType;

	public String getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(String notificationDate) {
		this.notificationDate = notificationDate;
	}

	public String getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(String notificationID) {
		this.notificationID = notificationID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public String toString() {
		return "\tNotification ID        : " + this.notificationID + "\n\tNotification Date|Time : "
				+ this.notificationDate + " | " + this.notificationTime + "\n\tOrder ID               : " + this.orderID
				+ "\n\tSupplier Name          : " + this.supplierName + "\n\tSupplier ID          : "
				+ this.supplierID + "\n\n\t--------\n";
	}

	public String getNotificationTime() {
		return notificationTime;
	}

	public void setNotificationTime(String notificationTime) {
		this.notificationTime = notificationTime;
	}

	public String getSupplierType() {
		return supplierType;
	}

	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}

}
