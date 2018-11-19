package com.java.dbms.proj.entities;
import java.util.Date;


public class Vehicle {
	private String license;
	private String datePurchsed;
	private int currentMileage;
	private String lastServiceDate;
	private String lastServiceType;
	private String lastServiceName;
	public String getLastServiceName() {
		return lastServiceName;
	}
	

	public void setLastServiceName(String lastServiceName) {
		this.lastServiceName = lastServiceName;
	}

	public void setDatePurchsed(String datePurchsed) {
		this.datePurchsed = datePurchsed;
	}

	private int vid;
	private int year;
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	

	private String make;
	private String model;
	public String getDatePurchsed() {
		return datePurchsed;
	}

	public void setDatePurchased(String datePurchsed) {
		this.datePurchsed = datePurchsed;
	}

	public int getCurrentMileage() {
		return currentMileage;
	}

	public void setCurrentMileage(int currentMileage) {
		this.currentMileage = currentMileage;
	}

	public String getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(String date) {
		this.lastServiceDate = date;
	}

	public String getLastServiceType() {
		return lastServiceType;
	}

	public void setLastServiceType(String lastServiceType) {
		this.lastServiceType = lastServiceType;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	
	public String toString() {
		return "\n\tLicense           :\t" + this.getLicense() +
			   "\n\tYear              :\t" + this.getYear() +
			   "\n\tDate Purchased    :\t" + this.getDatePurchsed().toString() +
			   "\n\tLast Service Date :\t" + this.getLastServiceDate().toString() +
			   "\n\tLast Service Type :\t" + this.getLastServiceType() +
			   "\n\tCurrent Mileage   :\t" + this.getCurrentMileage() +
			   "\n\tVehicle ID        :\t" + this.getVid() + "\n";
	}
}
