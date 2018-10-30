package com.java.dbms.proj.entities;

public class HourlyEmployee extends Employee {
	double hourlyRate;
	int hourlyID;
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public int getHourlyID() {
		return hourlyID;
	}
	public void setHourlyID(int hourlyID) {
		this.hourlyID = hourlyID;
	}
	
}
