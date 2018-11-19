package com.java.dbms.proj.entities;

import java.util.ArrayList;

public class HourlyEmployee extends Employee {
	double hourlyRate;
	int hourlyID;
	ArrayList<TimeSlot> dailyTimeSlot;
	
	public ArrayList<TimeSlot> getDailyTimeSlot() {
		return dailyTimeSlot;
	}
	public void setDailyTimeSlot(ArrayList<TimeSlot> dailyTimeSlot) {
		this.dailyTimeSlot = dailyTimeSlot;
	}
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
