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
import com.java.dbms.proj.entities.Schedule;
import com.java.dbms.proj.common.SchedulerHelper;

import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.TimeSlot;

public class CustomerScheduleMaintenanceController {
	static ResultSet resultSet;
	static Statement statement;

	public static void scheduleMaintenance(Scanner input) throws SQLException, ParseException {
		com.java.dbms.proj.views.CustomerView.displayScheduleMaintenance1(); // Display page header
		statement = DBFacade.getConnection().createStatement();
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Find Service Date");
		System.out.println("\tEnter '2' to Go Back");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		} while (!userInput.equals("1") && !userInput.equals("2"));

		if (userInput.equals("1")) {

			Customer customer = ApplicationController.customer;
			Appointment appointment = CustomerScheduleServiceController.appointment;
			String licensePlateNumber = "";
			int mileage = 0;
			int numOfSlots = 0;
			Boolean isValidVehicle = false;
			if (appointment != null && appointment.getVehicle() != null) {
				licensePlateNumber = appointment.getVehicle().getLicense();
				mileage = appointment.getVehicle().getCurrentMileage();
			}

			isValidVehicle = HelperFunctions.validateCarDetails(customer,licensePlateNumber);
			
			boolean isValidMechanic = SchedulerHelper.checkValidMechanic(appointment.getRequestedMechanicFirstName(),appointment.getRequestedMechanicLastName(),customer.getServiceCenterId());
			if(isValidMechanic==false && !appointment.getRequestedMechanicFirstName().isEmpty())
			{
				appointment.setRequestedMechanicFirstName("");
				appointment.setRequestedMechanicLastName("");
				System.out.println("\n\t\tThe entered mechanic is not associated with this service center. \n\t\t We would schedule you with the mechanics working only at this service center.\n");
			}
			if(isValidVehicle) {
	
			com.java.dbms.proj.views.CustomerView.displayScheduleMaintenance2(); //Display second page header
			
			
			String serviceTobeScheduled = HelperFunctions.getServiceToBeScheduled(licensePlateNumber, mileage);   
			int vehicleID = HelperFunctions.getVechileID(licensePlateNumber); 
			
			int partsavailability = HelperFunctions.checkPartAvailability(ApplicationConstants.MAINTENANCE, serviceTobeScheduled, licensePlateNumber,customer.getServiceCenterId());
			if(partsavailability == 0) {
			float duration= HelperFunctions.calculateServiceDuration(ApplicationConstants.MAINTENANCE, serviceTobeScheduled, licensePlateNumber);
			
			numOfSlots = (int) Math.ceil((duration*60/30)); 
			
			ArrayList<Schedule> scheduleList=new ArrayList<Schedule>();
			Date nextDate = new Date();
			scheduleList = SchedulerHelper.getTimeSlot(appointment.getRequestedMechanicFirstName(),appointment.getRequestedMechanicLastName(),numOfSlots,customer.getServiceCenterId(),nextDate);
			
			System.out.println("\n\t\t***********Available Time Slots Details***********");
			for(int i=0;i<scheduleList.size();i++)
			{		int index = i+1;	
				Schedule schedule=scheduleList.get(i);
				TimeSlot t=schedule.getAvailableTimeSlot();
				String mechanicName = SchedulerHelper.getEmployeeName(schedule.getMechanicId()); 
				Date date = schedule.getDate();
				System.out.println("\t\t " + SchedulerHelper.datetoString(date) + " : " + t.getStartTime() + "\tMechanic Name: " +  mechanicName);
			}
			System.out.println("\t\t**************************************************\t\t");
			System.out.println("\nPlease select from the following user options:");
			System.out.println("\tEnter '1' to Schedule on Date");
			System.out.println("\tEnter '2' to Go Back");
			
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
			
					if (userInput.equals("1")) {
						System.out.println("Please select from the following user options:");

						for (int i = 0; i < scheduleList.size(); i++) {
							int index = i + 1;
							Schedule schedule = scheduleList.get(i);
							String mechanicName = SchedulerHelper.getEmployeeName(schedule.getMechanicId());
							TimeSlot t = schedule.getAvailableTimeSlot();
							Date date = schedule.getDate();
							System.out.println(
									"\tEnter " + index + " to Schedule on : " + SchedulerHelper.datetoString(date)
											+ " : " + t.getStartTime() + "\tMechanic Name: " + mechanicName);
						}

						do {
							System.out.print("\nOption Selection : ");
							userInput = input.nextLine();
						} while (!userInput.equals("1") && !userInput.equals("2"));

						int counter = 0;
						if (userInput.equals("1")) {
							counter = 0;
						} else
							counter = 1;

						resultSet = statement.executeQuery("SELECT APPOINTMENT_SEQ.nextval from dual");
						int appindex = 0;
						if (resultSet.next()) {
							appindex = resultSet.getInt("NEXTVAL");
						}
						String mechanicName = SchedulerHelper
								.getEmployeeName(scheduleList.get(counter).getMechanicId());

						statement.executeUpdate("INSERT INTO APPOINTMENT VALUES ('" + appindex + "', '"
								+ customer.getCustomerId() + "', '" + appointment.getVehicle().getLicense() + "', '"
								+ SchedulerHelper.datetoString(scheduleList.get(counter).getDate()) + "', '"
								+ mechanicName + "', '" + ApplicationConstants.MAINTENANCE + "', '"
								+ ApplicationConstants.PENDING + "' , '" + serviceTobeScheduled + "' , '"
								+ scheduleList.get(counter).getMechanicId() + "')");

						resultSet = statement.executeQuery("SELECT TIME_SLOT_SEQ.nextval from dual");

						int index = 0;

						if (resultSet.next()) {
							index = resultSet.getInt("NEXTVAL");
						}
				
				String startTime = scheduleList.get(counter).getAvailableTimeSlot().getStartTime() ;
				
				String endTime  = SchedulerHelper.searchEndSlot(startTime,numOfSlots);
			int res = statement.executeUpdate( "INSERT INTO TIME_SLOT VALUES ('" + index +"', '" + appindex + "', '" + scheduleList.get(counter).getMechanicId() + "', '" + 
						startTime + "', '" + endTime + "')");		
				
				if(res > 0 )
				{
					System.out.println("\t Thank you your appointment has been scheduled. \n-------------------------------------------------------------------------------------------------------------------------------------");
					
				}
			
			}
			}
			
			else {
				System.out.println("\t The parts required for the service are currently not availabile. Please try scheduling after " + partsavailability + " days.\t\n Sorry for inconvenience. \n-------------------------------------------------------------------------------------------------------------------------------------");
				
			}
		}
			else {
				System.out.println("\t\t******The entered car details could not be found registered in your name. Please re-enter your car details registered with ACME.******\n\n");
				

			}
		}

	}

}
