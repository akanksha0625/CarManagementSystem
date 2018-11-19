package com.java.dbms.proj.controller;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.java.dbms.proj.common.ApplicationConstants;
import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.common.Schedule;
import com.java.dbms.proj.common.SchedulerHelper;
import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.TimeSlot;

public class CustomerScheduleMaintenanceController {
	static ResultSet resultSet;
	static Statement statement;
	
	public static void scheduleMaintenance(Scanner input) throws SQLException, ParseException {
		com.java.dbms.proj.views.CustomerView.displayScheduleMaintenance1(); //Display page header
		statement = DBFacade.getConnection().createStatement();
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Find Service Date");
		System.out.println("\tEnter '2' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			
			Customer customer = ApplicationController.customer;
			Appointment appointment = CustomerScheduleServiceController.appointment;
			String licensePlateNumber = "";
			int mileage=0;
			int numOfSlots=0;
			Boolean isValidVehicle=false;
			if(appointment!=null && appointment.getVehicle()!=null) {
				licensePlateNumber = appointment.getVehicle().getLicense();
				mileage = appointment.getVehicle().getCurrentMileage();
			}
			isValidVehicle = HelperFunctions.validateCarDetails(customer,licensePlateNumber);
			
			if(isValidVehicle) {
			com.java.dbms.proj.views.CustomerView.displayScheduleMaintenance2(); //Display second page header
			
			//TODO display service dates
			System.out.println("DISPLAY SERVICE DATES");
			
			String serviceTobeScheduled = HelperFunctions.getServiceToBeScheduled(licensePlateNumber, mileage);   
			System.out.println("DISPLAY SERVICE DATES: lastServiceName"+ serviceTobeScheduled);
			int vehicleID = HelperFunctions.getVechileID(licensePlateNumber); 
			System.out.println("DISPLAY SERVICE DATES vehicleID" + vehicleID);
			float duration= HelperFunctions.calculateServiceDuration(ApplicationConstants.MAINTENANCE, serviceTobeScheduled, licensePlateNumber);
		
			System.out.println("DISPLAY SERVICE DATES duration" + duration);		
			
			System.out.println("Parts availability" + HelperFunctions.checkPartAvailability(ApplicationConstants.MAINTENANCE, serviceTobeScheduled, licensePlateNumber));
			
			numOfSlots = (int) Math.ceil((duration*60/30)); 
			System.out.println("Number Of slots"+numOfSlots);
			ArrayList<Schedule> scheduleList=new ArrayList<Schedule>();
			scheduleList = SchedulerHelper.getTimeSlot(appointment.getRequestedMechanicFirstName(),appointment.getRequestedMechanicLastName(),numOfSlots,customer.getServiceCenterId());
			for(int i=0;i<scheduleList.size();i++)
			{			
				Schedule schedule=new Schedule();
				TimeSlot t=schedule.getAvailableTimeSlot();
				Date date = schedule.getDate();
				System.out.println("\n\tAvailable Time Slots : \t\t" + SchedulerHelper.datetoString(date) + " - " + t.getStartTime());
			}
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Schedule on Date");
			System.out.println("\tEnter '2' to Go Back");
			
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
			
			if(userInput.equals("1")) {
					System.out.println("Please select from the following user options:");
				
					for(int i=0;i<scheduleList.size();i++)
					{			
						Schedule schedule=new Schedule();
						String mechanicName = SchedulerHelper.getEmployeeName(schedule.getMechanicId()); 
						TimeSlot t=schedule.getAvailableTimeSlot();
						Date date = schedule.getDate();
						System.out.println("\tEnter "+ i +" to Schedule on : " + SchedulerHelper.datetoString(date) + " : " + t.getStartTime() + "\tMechanic Name: " +  mechanicName);
					}
			
				do {
					System.out.print("\nOption Selection : ");
					userInput = input.nextLine();
				}while(!userInput.equals("1") && !userInput.equals("2"));	
				
				int counter=0;
				if(userInput.equals("1"))
				{
					counter = 1;
				}
				else
					counter = 2;
				
				resultSet = statement.executeQuery( "SELECT APPOINTMENT_SEQ.nextval from dual" );
				int index = 0;
				if ( resultSet.next() ) {
					index = resultSet.getInt( "NEXTVAL" );
				}
				String mechanicName = SchedulerHelper.getEmployeeName(scheduleList.get(counter).getMechanicId());
				
				/*statement.executeUpdate( "INSERT INTO APPOINTMENT VALUES ('" + index +"', '" + customer.getCustomerId() + "', '" + appointment.getVehicle().getLicense() + "', '" + 
										 SchedulerHelper.datetoString(scheduleList.get(counter).getDate()) + "', '" +  + "', '" + serviceCenters.get(serviceCenterSelection - 1) + 
										 "', '" + userName + "')");*/
				
			/*	 CREATE TABLE "AMOHAN7"."" 
				   (	"APPOINTMENT_ID" NUMBER(20,0) NOT NULL ENABLE, 
					"" NUMBER(20,0) NOT NULL ENABLE, 
					"VEHICLE_LICENSE" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
					"APPOINTMENT_DATE" VARCHAR2(20 BYTE), 
					"REQUESTED_MECHANIC" VARCHAR2(50 BYTE), 
					"SERVICE_TYPE" VARCHAR2(100 BYTE) NOT NULL ENABLE, 
					"STATE" VARCHAR2(9 BYTE) NOT NULL ENABLE, 
					"SLOT_ID" NUMBER, 
					"SERVICE_TYPE_ID" VARCHAR2(50 BYTE), 
					"UNIT_COST" FLOAT(126), 
					"MECHANIC_ID" NUMBER, */
				
				
				
			}
		}
			else {
				System.out.println("***\t\tThe entered car details could not be found. Please re-enter the car details registered with ACME.***\n\n\n\n");
			}
		}
	}

}
