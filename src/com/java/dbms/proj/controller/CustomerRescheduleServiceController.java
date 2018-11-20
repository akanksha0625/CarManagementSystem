package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.java.dbms.proj.common.ApplicationConstants;
import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.Schedule;
import com.java.dbms.proj.common.SchedulerHelper;
import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.TimeSlot;
import com.java.dbms.proj.entities.Vehicle;

public class CustomerRescheduleServiceController {
	static ResultSet resultSet;
	static Statement statement;
	public static void rescheduleService(Scanner input) throws SQLException, ParseException {
		com.java.dbms.proj.views.CustomerView.displayReschedule1();
		statement = DBFacade.getConnection().createStatement();
		Customer customer = ApplicationController.customer;
		Appointment appointment = new Appointment();
		Vehicle vehicle = new Vehicle();
		HelperFunctions.displayServiceHistory(ApplicationController.customer,ApplicationConstants.PENDING);
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Pick a service");
		System.out.println("\tEnter '2' to Go back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			
			System.out.print("\nEnter Service ID :");
			String inputString = input.nextLine();
			com.java.dbms.proj.views.CustomerView.displayReschedule2();
			resultSet = statement.executeQuery("SELECT * FROM APPOINTMENT WHERE APPOINTMENT_ID = '"
					+ inputString + "' and STATE ='" + ApplicationConstants.PENDING + "'");
			appointment.setAppointmentID(Integer.parseInt(inputString));
			if(resultSet.next())
			{
				String mechanicName=resultSet.getString("REQUESTED_MECHANIC");
				String name[]=mechanicName.split(" ");
				
				appointment.setAppointmentDate(resultSet.getString("APPOINTMENT_DATE"));
				appointment.setRequestedMechanicFirstName(name[0]);
				appointment.setRequestedMechanicLastName(name[1]);
				appointment.setServiceType(resultSet.getString("SERVICE_TYPE").trim());
				appointment.setServiceID(resultSet.getString("SERVICE_TYPE_ID").trim());
				vehicle.setLicense(resultSet.getString("VEHICLE_LICENSE").trim());
				vehicle.setVid(HelperFunctions.getVechileID(vehicle.getLicense()));
				
				System.out.println("getServiceType"+appointment.getServiceType());
				System.out.println("getServiceID"+appointment.getServiceID());
				System.out.println("getLicense"+vehicle.getLicense());
				System.out.println("getApp Date"+appointment.getAppointmentDate());
		
				
				float duration= HelperFunctions.calculateServiceDuration(appointment.getServiceType(), appointment.getServiceID(), vehicle.getLicense());
				System.out.println("DISPLAY SERVICE DATES duration" + duration);
				int numOfSlots = (int) Math.ceil((duration*60/30)); 
				System.out.println("Number Of slots"+numOfSlots);
				ArrayList<Schedule> scheduleList=new ArrayList<Schedule>();
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				Date nextDate = sdf.parse(appointment.getAppointmentDate());
				System.out.println("The formatted appointment date is "+ nextDate);
				scheduleList = SchedulerHelper.getTimeSlot(appointment.getRequestedMechanicFirstName(),appointment.getRequestedMechanicLastName(),numOfSlots,customer.getServiceCenterId(),nextDate);
				System.out.println("\n\t\t***********Available Time Slots Details***********");
				for(int i=0;i<scheduleList.size();i++)
				{		int index = i+1;	
					Schedule schedule=scheduleList.get(i);
					TimeSlot t=schedule.getAvailableTimeSlot();
					 mechanicName = SchedulerHelper.getEmployeeName(schedule.getMechanicId()); 
					Date date = schedule.getDate();
					
					System.out.println("\t\t " + SchedulerHelper.datetoString(date) + " : " + t.getStartTime() + "\tMechanic Name: " +  mechanicName);
				}
				System.out.println("\t\t**************************************************\t\t");
				System.out.println("\nPlease select from the following user options:");
				System.out.println("\tEnter '1' to Reschedule date");
				System.out.println("\tEnter '2' to Go back");
				
				do {
					System.out.print("\nOption Selection : ");
					userInput = input.nextLine();
				}while(!userInput.equals("1") && !userInput.equals("2"));
				
				if(userInput.equals("1")) {
						System.out.println("Please select from the following user options:");
					
						for(int i=0;i<scheduleList.size();i++)
						{			
							int index = i+1;
							Schedule schedule=scheduleList.get(i);
							 mechanicName = SchedulerHelper.getEmployeeName(schedule.getMechanicId());
							TimeSlot t=schedule.getAvailableTimeSlot();
							Date date = schedule.getDate();
							System.out.println("\tEnter "+ index +" to Schedule on : " + SchedulerHelper.datetoString(date) + " : " + t.getStartTime() + "\tMechanic Name: " +  mechanicName);
						}
				
					do {
						System.out.print("\nOption Selection : ");
						userInput = input.nextLine();
					}while(!userInput.equals("1") && !userInput.equals("2"));	
					
					int counter=0;
					if(userInput.equals("1"))
						counter = 0;
					else
						counter = 1;
					
					 mechanicName = SchedulerHelper.getEmployeeName(scheduleList.get(counter).getMechanicId());
					 int tuples=0;
					 System.out.println("appointment.getAppointmentID()"+appointment.getAppointmentID());
					try {
						 tuples= statement.executeUpdate("UPDATE APPOINTMENT SET APPOINTMENT_DATE = '" + SchedulerHelper.datetoString(scheduleList.get(counter).getDate()) +
								 "' , REQUESTED_MECHANIC = '"+ mechanicName +    "' , MECHANIC_ID = '"   + scheduleList.get(counter).getMechanicId() 
								 +  "' WHERE APPOINTMENT_ID = '" + appointment.getAppointmentID() + "'");
					}
					
					catch (SQLException e) {
						System.out.println( "System Query Error : " + e );
						e.printStackTrace();
					}
					System.out.println("tuples"+tuples);
					String startTime = scheduleList.get(counter).getAvailableTimeSlot().getStartTime() ;
					String endTime  = SchedulerHelper.searchEndSlot(startTime,numOfSlots);
					System.out.println("Start time is "+ startTime);
					System.out.println("End time is "+ endTime);
					System.out.println("End numOfSlots is "+ numOfSlots);
					
					try {
						 tuples= statement.executeUpdate("UPDATE TIME_SLOT SET START_TIME = '" + startTime +
								 "' , END_TIME = '"+ endTime +    "' , MECHANIC_ID = '"   + scheduleList.get(counter).getMechanicId() 
								 +  "' WHERE APPOINTMENT_ID = '" + appointment.getAppointmentID() + "'");
					}
					catch (SQLException e) {
						System.out.println( "System Query Error : " + e );
						e.printStackTrace();
					}	
					
					if(tuples > 0 )
					{
						System.out.println("\t Thank you. Your appointment has been rescheduled. \n-------------------------------------------------------------------------------------------------------------------------------------");
						
					}
				
				}
				
			}
			else {
				System.out.println("\t\t***Invalid Service Id.***\n\n");
			}

			
		}
	}
}
