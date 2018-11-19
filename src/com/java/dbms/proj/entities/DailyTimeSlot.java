package com.java.dbms.proj.entities;

import java.util.ArrayList;
import java.util.Date;

public class DailyTimeSlot {
	
	ArrayList<TimeSlot> timeslotList;
	Date date;
	String mechanicName;
	
	public String getMechanicName() {
		return mechanicName;
	}

	public void setMechanicName(String mechanicName) {
		this.mechanicName = mechanicName;
	}

	public DailyTimeSlot() {
		timeslotList = new ArrayList<TimeSlot>();
		
		 TimeSlot timeSlot1 = new TimeSlot();
		 timeSlot1.setStartTime("08:00 am");
		 timeSlot1.setEndTime("08:30 am");
		 timeSlot1.setIsbooked(false);
		 timeslotList.add(timeSlot1);
		
		 TimeSlot timeSlot2 = new TimeSlot();
		 timeSlot2.setStartTime("08:30 am");
		 timeSlot2.setEndTime("09:00 am");
		 timeSlot2.setIsbooked(false);
		 timeslotList.add(timeSlot2);
		 
		 TimeSlot timeSlot3 = new TimeSlot();
		 timeSlot3.setStartTime("09:00 am");
		 timeSlot3.setEndTime("09:30 am");
		 timeSlot3.setIsbooked(false);
		 timeslotList.add(timeSlot3);
		 
		 TimeSlot timeSlot4 = new TimeSlot();
		 timeSlot4.setStartTime("09:30 am");
		 timeSlot4.setEndTime("10:00 am");
		 timeSlot4.setIsbooked(false);
		 timeslotList.add(timeSlot4);
		 
		 TimeSlot timeSlot5 = new TimeSlot();
		 timeSlot5.setStartTime("10:00 am");
		 timeSlot5.setEndTime("10:30 am");
		 timeSlot5.setIsbooked(false);
		 timeslotList.add(timeSlot5);
		 
		 
		 TimeSlot timeSlot6 = new TimeSlot();
		 timeSlot6.setStartTime("10:30 am");
		 timeSlot6.setEndTime("11:00 am");
		 timeSlot6.setIsbooked(false);
		 timeslotList.add(timeSlot6);
		 
		 TimeSlot timeSlot7 = new TimeSlot();
		 timeSlot7.setStartTime("11:00 am");
		 timeSlot7.setEndTime("11:30 am");
		 timeSlot7.setIsbooked(false);
		 timeslotList.add(timeSlot7);
		 
		 TimeSlot timeSlot8 = new TimeSlot();
		 timeSlot8.setStartTime("11:30 am");
		 timeSlot8.setEndTime("12:00 pm");
		 timeSlot8.setIsbooked(false);
		 timeslotList.add(timeSlot8);
		 
		 TimeSlot timeSlot9 = new TimeSlot();
		 timeSlot9.setStartTime("12:00 pm");
		 timeSlot9.setEndTime("12:30 pm");
		 timeSlot9.setIsbooked(false);
		 timeslotList.add(timeSlot9); 
		 
		 TimeSlot timeSlot10 = new TimeSlot();
		 timeSlot10.setStartTime("12:30 pm");
		 timeSlot10.setEndTime("01:00 pm");
		 timeSlot10.setIsbooked(false);
		 timeslotList.add(timeSlot10); 
		 
		 TimeSlot timeSlot11 = new TimeSlot();
		 timeSlot11.setStartTime("01:00 pm");
		 timeSlot11.setEndTime("01:30 pm");
		 timeSlot11.setIsbooked(false);
		 timeslotList.add(timeSlot11); 
		 
		 TimeSlot timeSlot12 = new TimeSlot();
		 timeSlot12.setStartTime("01:30 pm");
		 timeSlot12.setEndTime("02:00 pm");
		 timeSlot12.setIsbooked(false);
		 timeslotList.add(timeSlot12); 
		 
		 TimeSlot timeSlot13 = new TimeSlot();
		 timeSlot13.setStartTime("02:00 pm");
		 timeSlot13.setEndTime("02:30 pm");
		 timeSlot13.setIsbooked(false);
		 timeslotList.add(timeSlot13);
		 
		 TimeSlot timeSlot14 = new TimeSlot();
		 timeSlot14.setStartTime("02:30 pm");
		 timeSlot14.setEndTime("03:00 pm");
		 timeSlot14.setIsbooked(false);
		 timeslotList.add(timeSlot14); 
		 
		 TimeSlot timeSlot15 = new TimeSlot();
		 timeSlot15.setStartTime("03:00 pm");
		 timeSlot15.setEndTime("03:30 pm");
		 timeSlot15.setIsbooked(false);
		 timeslotList.add(timeSlot15); 
		 
		 TimeSlot timeSlot16 = new TimeSlot();
		 timeSlot16.setStartTime("03:30 pm");
		 timeSlot16.setEndTime("04:00 pm");
		 timeSlot16.setIsbooked(false);
		 timeslotList.add(timeSlot16); 
		 
		 TimeSlot timeSlot17 = new TimeSlot();
		 timeSlot17.setStartTime("04:00 pm");
		 timeSlot17.setEndTime("04:30 pm");
		 timeSlot17.setIsbooked(false);
		 timeslotList.add(timeSlot17);
		 
		 TimeSlot timeSlot18 = new TimeSlot();
		 timeSlot18.setStartTime("04:30 pm");
		 timeSlot18.setEndTime("05:00 pm");
		 timeSlot18.setIsbooked(false);
		 timeslotList.add(timeSlot18);
		 
		 TimeSlot timeSlot19 = new TimeSlot();
		 timeSlot19.setStartTime("05:00 pm");
		 timeSlot19.setEndTime("05:30 pm");
		 timeSlot19.setIsbooked(false);
		 timeslotList.add(timeSlot19);
		 
		 TimeSlot timeSlot20 = new TimeSlot();
		 timeSlot20.setStartTime("05:30 pm");
		 timeSlot20.setEndTime("06:00 pm");
		 timeSlot20.setIsbooked(false);
		 timeslotList.add(timeSlot20); 
		 
		 TimeSlot timeSlot21 = new TimeSlot();
		 timeSlot21.setStartTime("06:00 pm");
		 timeSlot21.setEndTime("06:30 pm");
		 timeSlot21.setIsbooked(false);
		 timeslotList.add(timeSlot21);
		 
		 TimeSlot timeSlot22 = new TimeSlot();
		 timeSlot22.setStartTime("06:30 pm");
		 timeSlot22.setEndTime("07:00 pm");
		 timeSlot22.setIsbooked(false);
		 timeslotList.add(timeSlot22);
	}
	
	public ArrayList<TimeSlot> getTimeslotList() {
		return timeslotList;
	}
	public void setTimeslotList(ArrayList<TimeSlot> timeslotList) {
		this.timeslotList = timeslotList;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
