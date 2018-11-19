package com.java.dbms.proj.entities;

import java.text.DecimalFormat;
import java.util.Date;

public class PayCheck {
	private String date= "";
	private String payPeriod= "";
	private String employeeID= "";
	private String employeeName= "";
	private double compensation = 0;;
	private String frequency= "";
	private double units= 0;
	private double currentEarnings = 0;
	private double yearToDateEarnings = 0;
	private String role = "";
	private String startDate= "";
	
	public void addUnits(double units) {
		this.units += units;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(String payPeriod) {
		this.payPeriod = payPeriod;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getCompensation() {
		return compensation;
	}
	public void setCompensation(double compensation) {
		this.compensation = compensation;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public double getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getCurrentEarnings() {
		return currentEarnings;
	}
	public void setCurrentEarnings(double currentEarnings) {
		this.currentEarnings = currentEarnings;
	}
	public double getYearToDateEarnings() {
		return yearToDateEarnings;
	}
	public void setYearToDateEarnings(double yearToDateEarnings) {
		this.yearToDateEarnings = yearToDateEarnings;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String toString() {
		String unitsAppend = "";
		double units;
		if(this.getFrequency().equalsIgnoreCase("hourly")) {
			unitsAppend = "hours";
			units = this.getUnits();
		}else {
			unitsAppend = "days";
			units = this.getUnits();
		}
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		return "*****************************************************************************" +
		       "\n\tPaycheck Date    :\t" + this.getDate() +
			   "\n\tPay Period       :\t" + this.getPayPeriod() +
			   "\n\tEmployee ID      :\t" + this.getEmployeeID() +
			   "\n\tEmployee Name    :\t" + this.getEmployeeName() +
			   "\n\tCompensation     :\t$" + df.format(this.getCompensation()) +
			   "\n\tFrequency        :\t" + this.getFrequency() +
			   "\n\tUnits            :\t" + units + " " + unitsAppend +
			   "\n\tCurrent Earnings :\t$" + df.format(this.getCurrentEarnings()) +
			   "\n\tYTD Earnings     :\t$" + df.format(this.getYearToDateEarnings()) +
			   "\n*****************************************************************************\n";
	}
}
