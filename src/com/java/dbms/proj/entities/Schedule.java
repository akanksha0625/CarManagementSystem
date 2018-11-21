package com.java.dbms.proj.entities;

import java.util.Date;

import com.java.dbms.proj.entities.TimeSlot;

public class Schedule implements Comparable<Schedule>{
	
	public int mechanicId;
	public TimeSlot availableTimeSlot;
	public Date date;
	
	public int getMechanicId() {
		return mechanicId;
	}
	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}	

	public TimeSlot getAvailableTimeSlot() {
		return availableTimeSlot;
	}
	public void setAvailableTimeSlot(TimeSlot availableTimeSlot) {
		this.availableTimeSlot = availableTimeSlot;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public int compareTo(Schedule other) {
		if(this.getDate().compareTo(other.getDate())==0) {
		if(this.getAvailableTimeSlot().getSlotID()>other.getAvailableTimeSlot().getSlotID())
		return 1;
		else if(this.getAvailableTimeSlot().getSlotID()<other.getAvailableTimeSlot().getSlotID())
			return -1;
		return 0;
		}
		else if(this.getDate().compareTo(other.getDate())>=1)
			return 1;
		return -1;
		
	}
	public String toString() {
		return "mechanicId:"+mechanicId+"availableTimeSlot"+availableTimeSlot.getStartTime();
	}
	
}
