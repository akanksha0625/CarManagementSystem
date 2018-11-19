package com.java.dbms.proj.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;

import com.java.dbms.proj.entities.DailyTimeSlot;
import com.java.dbms.proj.entities.HourlyEmployee;
import com.java.dbms.proj.entities.TimeSlot;
import com.java.dbms.proj.entities.Vehicle;

public class SchedulerHelper {
	
		/* Necessary Variables for SQL Transactions */
		static ArrayList<Vehicle> carList = new ArrayList<Vehicle>();
		static ArrayList<String> cars = new ArrayList<String>();
		static Statement statement;
		static ResultSet resultSet;
		
		public static String getEmployeeName(int employeeId) throws SQLException {
			String empFirstName="";
			String empLastName="";
		resultSet = statement.executeQuery("SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE WHERE EID = '" + employeeId + "'");
		
		if(resultSet.next())
		{
			empFirstName=resultSet.getString("FIRSTNAME");
			empLastName=resultSet.getString("LASTNAME");
		}
		return empFirstName + " " + empLastName;
		}
		
		public static String datetoString(Date date) {
			int month = date.getMonth() + 1;
			int year = date.getYear() + 1900;
			String dateFormatted = date.getDate()+"-"+ month +"-" + year;
			dateFormatted = HelperFunctions.translateBack(dateFormatted);
			return dateFormatted;
		}
		
		public static ArrayList<Schedule> getTimeSlot(String mechanicFirstName, String mechanicLastName,
				int slotsRequired, String serviceCenterId) throws SQLException, ParseException {
			// add service center id logic to check only mechanics with same customer id as
			// customer			
			int empId = 0;
			ArrayList<Schedule>  result = new ArrayList<Schedule>();
			HourlyEmployee mechanic = new HourlyEmployee();
			
			if (mechanicFirstName != null && mechanicFirstName != "" && mechanicLastName != null && mechanicLastName != "")
				resultSet = statement.executeQuery("SELECT EID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName
						+ "' and LASTNAME = '" + mechanicLastName + "'");
			else if (mechanicFirstName != null && mechanicFirstName != ""
					&& (mechanicLastName == null || mechanicLastName == ""))
				resultSet = statement
						.executeQuery("SELECT EID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName + "'");
			
			if (resultSet.next()) {

				empId = Integer.parseInt(resultSet.getString("EID"));
				mechanic.setEmpId(empId);
				System.out.println("The employee id is " + empId);
			}
			
			// Fetch employee based on only last name information
			if (empId != 0) {
				String startTime = "";
				String endTime = "";

				final Calendar calendar = Calendar.getInstance();
				SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
				
				Date nextDate = new Date();
				
				while(result.size()<2) {
					//Incrementing a day
					calendar.setTime(nextDate);
					calendar.add(Calendar.DAY_OF_YEAR, 1);
					nextDate = calendar.getTime();
					int month = nextDate.getMonth() + 1;
					int year = nextDate.getYear() + 1900;

					String dateFormatted = nextDate.getDate() + "-" + month + "-" + year;			
					System.out.println("The new format looks like"+ HelperFunctions.translateBack(dateFormatted));
					resultSet = statement.executeQuery(
							"SELECT APPOINTMENT_DATE FROM APPOINTMENT WHERE STATE='PENDING' AND MECHANIC_ID = '"
									+ empId + "' and APPOINTMENT_DATE = '" + HelperFunctions.translateBack(dateFormatted)+"'");
					//If appointment is present on the next day
				if(resultSet.next()) {
					
					resultSet = statement.executeQuery(
							"SELECT APPOINTMENT_DATE,START_TIME,END_TIME FROM TIME_SLOT T, APPOINTMENT A WHERE T.APPOINTMENT_ID=A.APPOINTMENT_ID AND STATE='PENDING' AND A.MECHANIC_ID = '"
									+ empId + "' and APPOINTMENT_DATE = '" + HelperFunctions.translateBack(dateFormatted) + "'");

					DailyTimeSlot dailyTimeSlotObj = new DailyTimeSlot();
					ArrayList<TimeSlot> bookedTimeSlotList  = dailyTimeSlotObj.getTimeslotList();
					System.out.println(nextDate);
					dailyTimeSlotObj.setDate(nextDate);

					while (resultSet.next()) {
						boolean activeSlots = false;
						// Creating a daily timeslot for a mechanic
						// TimeSlot timeSlot=new TimeSlot();
						startTime = resultSet.getString("START_TIME");
						endTime = resultSet.getString("END_TIME");
						System.out.println("startTime"+startTime);
						System.out.println("endTime"+endTime);
						// bookedTimeSlotList.add(timeSlot);
						System.out.println("STime" + startTime + "+ end time" + endTime);
						for (int i = 0; i < ApplicationConstants.TIMESLOTS; i++) {
							System.out.println(
									"inside first loop of bookedtimelsot" + bookedTimeSlotList.get(i).getStartTime());
							if (startTime.equalsIgnoreCase(bookedTimeSlotList.get(i).getStartTime())) {
								activeSlots = true;
							}
							System.out.println("Outsie looop End time: "+endTime + "End time of slot :" + bookedTimeSlotList.get(i).getEndTime());
							if (endTime.equalsIgnoreCase(bookedTimeSlotList.get(i).getEndTime())) {
								System.out.println("End time: "+endTime + "End time of slot :" + bookedTimeSlotList.get(i).getEndTime());
								activeSlots = false;
								break;
							}
							if (activeSlots == true)
								bookedTimeSlotList.get(i).setIsbooked(true);

							System.out.println("activeSlots" + activeSlots);

							System.out.println(
									"inside first loop of bookedtimelsot" + bookedTimeSlotList.get(i).isIsbooked());
						}

						// search for free time slots

					}
					int countFreeSlots = 0;
					int firstIndex = -1;
					for (int i = 0; i < ApplicationConstants.TIMESLOTS; i++) {
						if (bookedTimeSlotList.get(i).isIsbooked() == false) {
							System.out.print(
									"Entered loop for seraching bookedtimeslot" + bookedTimeSlotList.get(i).isIsbooked());
							if (countFreeSlots == 0)
								firstIndex = i;

							countFreeSlots++;

							if (countFreeSlots == slotsRequired)
								break;
						} else {
							countFreeSlots = 0;
							firstIndex = -1;
						}
					}
					System.out.print("firstIndex" + firstIndex);
					System.out.print("countFreeSlots" + countFreeSlots);
					if (firstIndex != -1) {
						Schedule schedule =new Schedule();
						schedule.setAvailableTimeSlot(bookedTimeSlotList.get(firstIndex));
						schedule.setDate(nextDate);
						schedule.setMechanicId(empId);
						result.add(schedule);
						System.out.print("Booked Time slot" + bookedTimeSlotList.get(firstIndex).getStartTime());
					}
					
				}
				
				else {
					
					DailyTimeSlot dailyTimeSlotObj1 = new DailyTimeSlot();
					ArrayList<TimeSlot> firstTimeSlotList = dailyTimeSlotObj1.getTimeslotList();
					Schedule schedule =new Schedule();
					schedule.setAvailableTimeSlot(firstTimeSlotList.get(0));
					schedule.setDate(nextDate);
					schedule.setMechanicId(empId);
					result.add(schedule);
					System.out.println("First appointment is booked on" + nextDate + firstTimeSlotList.get(0).getStartTime());
				}
					
				}
			}
			
//			if(empId==0) {
//				
//				String startTime = "";
//				String endTime = "";
//
//				final Calendar calendar = Calendar.getInstance();
//				SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
//				
//				Date nextDate = new Date();
//				
//				while(result.size()<2) {
//					//Incrementing a day
//					calendar.setTime(nextDate);
//					calendar.add(Calendar.DAY_OF_YEAR, 1);
//					nextDate = calendar.getTime();
//					int month = nextDate.getMonth() + 1;
//					int year = nextDate.getYear() + 1900;
//
//					String dateFormatted = nextDate.getDate() + "-" + month + "-" + year;			
//					System.out.println("The new format looks like" + translateBack(dateFormatted));
//					
//					resultSet = statement.executeQuery(
//							"SELECT APPOINTMENT_DATE FROM APPOINTMENT WHERE STATE='PENDING' AND MECHANIC_ID = '"
//									+ empId + "' and APPOINTMENT_DATE = '" + translateBack(dateFormatted)+"'");
//					
//					
//					//If appointment is present on the next day
//				if(resultSet.next()) {
//					ArrayList<Integer> mechanicList = new ArrayList<Integer>();
//					resultSet = statement.executeQuery("SELECT EID FROM EMPLOYEE WHERE ROLE = 'MECHANIC'");
//
//					while(resultSet.next()) {
//						int mechanicId=resultSet.getInt("EID");
//						mechanicList.add(mechanicId);
//						
//					}
//					
//					resultSet = statement.executeQuery(
//							"SELECT APPOINTMENT_DATE,START_TIME,END_TIME FROM TIME_SLOT T, APPOINTMENT A WHERE T.APPOINTMENT_ID=A.APPOINTMENT_ID AND STATE='PENDING' AND APPOINTMENT_DATE = '" + translateBack(dateFormatted) + "'");
//
//					DailyTimeSlot dailyTimeSlotObj = new DailyTimeSlot();
//					ArrayList<TimeSlot> bookedTimeSlotList  = dailyTimeSlotObj.getTimeslotList();
//					System.out.println(nextDate);
//					dailyTimeSlotObj.setDate(nextDate);
//
//					while (resultSet.next()) {
//						boolean activeSlots = false;
//						// Creating a daily timeslot for a mechanic
//						// TimeSlot timeSlot=new TimeSlot();
//						startTime = resultSet.getString("START_TIME");
//						endTime = resultSet.getString("END_TIME");
//						System.out.println("startTime"+startTime);
//						System.out.println("endTime"+endTime);
//						// bookedTimeSlotList.add(timeSlot);
//						System.out.println("STime" + startTime + "+ end time" + endTime);
//						for (int i = 0; i < ApplicationConstants.TIMESLOTS; i++) {
//							System.out.println(
//									"inside first loop of bookedtimelsot" + bookedTimeSlotList.get(i).getStartTime());
//							if (startTime.equalsIgnoreCase(bookedTimeSlotList.get(i).getStartTime())) {
//								activeSlots = true;
//							}
//							System.out.println("Outsie looop End time: "+endTime + "End time of slot :" + bookedTimeSlotList.get(i).getEndTime());
//							if (endTime.equalsIgnoreCase(bookedTimeSlotList.get(i).getEndTime())) {
//								System.out.println("End time: "+endTime + "End time of slot :" + bookedTimeSlotList.get(i).getEndTime());
//								activeSlots = false;
//								break;
//							}
//							if (activeSlots == true)
//								bookedTimeSlotList.get(i).setIsbooked(true);
//
//							System.out.println("activeSlots" + activeSlots);
//
//							System.out.println(
//									"inside first loop of bookedtimelsot" + bookedTimeSlotList.get(i).isIsbooked());
//						}
//
//						// search for free time slots
//
//					}
//					int countFreeSlots = 0;
//					int firstIndex = -1;
//					for (int i = 0; i < ApplicationConstants.TIMESLOTS; i++) {
//						if (bookedTimeSlotList.get(i).isIsbooked() == false) {
//							System.out.print(
//									"Entered loop for seraching bookedtimeslot" + bookedTimeSlotList.get(i).isIsbooked());
//							if (countFreeSlots == 0)
//								firstIndex = i;
//
//							countFreeSlots++;
//
//							if (countFreeSlots == slotsRequired)
//								break;
//						} else {
//							countFreeSlots = 0;
//							firstIndex = -1;
//						}
//					}
//					System.out.print("firstIndex" + firstIndex);
//					System.out.print("countFreeSlots" + countFreeSlots);
//					if (firstIndex != -1) {
//						bookedTimeSlotList.get(firstIndex).setDate(nextDate);
//						result.put(empId, bookedTimeSlotList.get(firstIndex));
//						System.out.print("Booked Time slot" + bookedTimeSlotList.get(firstIndex).getStartTime());
//					}
//					
//				}
//				
//				else {
//					
//					DailyTimeSlot dailyTimeSlotObj1 = new DailyTimeSlot();
//					ArrayList<TimeSlot> firstTimeSlotList = dailyTimeSlotObj1.getTimeslotList();
//					firstTimeSlotList.get(0).setDate(nextDate);
//					result.put(empId, firstTimeSlotList.get(0));
//					System.out.println("First appointment is booked on" + nextDate + firstTimeSlotList.get(0).getStartTime());
//				}
//					
//				}
//				
//			}
			
			
			return result;

		}

}
