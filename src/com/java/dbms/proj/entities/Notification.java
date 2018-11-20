package com.java.dbms.proj.entities;

import java.util.Date;

public class Notification {
	int NotificationId;
	Date notificationDate;
	Date orderDate;
	String notificationTime;
	int orderID;
	int deliveryWindow;
	int show;
	
	
	public int getNotificationId() {
		return NotificationId;
	}
	
	public void setNotificationId(int NotificationId) {
		this.NotificationId = NotificationId;
	}
	public void setNotificationTime(String notificationTime) {
		this.notificationTime = notificationTime;
	}
	public String getNotificationTime() {
		return notificationTime;
	}

	public int getShow() {
		return show;
	}
	public void setShow(int show) {
		this.show = show;
	}
	public Date getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getDeliveryWindow() {
		return deliveryWindow;
	}
	public void setDeliveryWindow(int deliveryWindow) {
		this.deliveryWindow = deliveryWindow;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

}
