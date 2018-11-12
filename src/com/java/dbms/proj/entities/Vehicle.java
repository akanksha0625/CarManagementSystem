package com.java.dbms.proj.entities;
import java.util.Date;

public class Vehicle {
	private String license;
	private Date datePurchsed;
	private int currentMileage;
	private Date lastServiceDate;
	private String lastServiceType;
	private int vid;
	private int year;

	public Date getDatePurchsed() {
		return datePurchsed;
	}

	public void setDatePurchased(Date datePurchsed) {
		this.datePurchsed = datePurchsed;
	}

	public int getCurrentMileage() {
		return currentMileage;
	}

	public void setCurrentMileage(int currentMileage) {
		this.currentMileage = currentMileage;
	}

	public Date getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(Date lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
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
