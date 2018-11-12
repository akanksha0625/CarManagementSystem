package com.java.dbms.proj.entities;

public class MonthlyEmployee extends Employee {
	int monthlyID;
	double monthlyRate;
	
	public int getMonthlyID() {
		return monthlyID;
	}
	public void setMonthlyID(int monthlyID) {
		this.monthlyID = monthlyID;
	}
	public double getMonthlyRate() {
		return monthlyRate;
	}
	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}
}
