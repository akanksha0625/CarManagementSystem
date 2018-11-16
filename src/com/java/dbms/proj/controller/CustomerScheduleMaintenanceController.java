package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.common.ApplicationConstants;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Customer;

public class CustomerScheduleMaintenanceController {
	public static void scheduleMaintenance(Scanner input) throws SQLException {
		com.java.dbms.proj.views.CustomerView.displayScheduleMaintenance1(); //Display page header
		
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
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Schedule on Date");
			System.out.println("\tEnter '2' to Go Back");
			
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
			
			if(userInput.equals("1")) {
				//TODO have user select from two dates and schedule
				System.out.println("ALLOW USER TO PICK AND SCHEDULE DATE");
			}
		}
			else {
				System.out.println("***\t\tThe entered car details could not be found. Please re-enter the car details registered with ACME.***\n\n\n\n");
			}
		}
	}

}
