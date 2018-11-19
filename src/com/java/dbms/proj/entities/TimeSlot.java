package com.java.dbms.proj.entities;

import java.util.Date;

public class TimeSlot {
	int SlotID;
	String StartTime;
	String EndTime;
	boolean isbooked;
	
	public boolean isIsbooked() {
		return isbooked;
	}
	public void setIsbooked(boolean isbooked) {
		this.isbooked = isbooked;
	}
	public int getSlotID() {
		return SlotID;
	}
	public void setSlotID(int slotID) {
		SlotID = slotID;
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	

}
