package com.java.dbms.proj.common;

import com.java.dbms.proj.entities.TimeSlot;

public interface ApplicationConstants {

	String MAINTENANCE = "Maintenance";
	String REPAIR = "Repair";
	String DATE_FORMAT = "dd-MMM-yyyy";
	String COMPLETE = "COMPLETE";
	String PENDING = "PENDING";
	String SERVICEA= "A";
	String SERVICEB= "B";
	String SERVICEC= "C";
	
	TimeSlot fixedTimeSlot = new TimeSlot();
	
}
