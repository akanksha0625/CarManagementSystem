package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Vehicle;

public class CustomerScheduleServiceController {
	
	public static Appointment appointment=new Appointment();
	static Vehicle vehicle = new Vehicle();
	static String inputString="";
	static String userInput="";
	
	public static void displayScheduleService(Scanner input) throws SQLException, ParseException {		
		System.out.println("Please enter the below mandatory* details to schedule a service:\n");
		do {
			System.out.print("License Plate* :");
			inputString=input.nextLine();
			if(inputString == null && inputString!="")
				System.out.println("Please enter License Plate Number.");
		}while(inputString.equals("")|| inputString.equals(null));
		
		vehicle.setLicense(inputString);
		
		do {
			System.out.print("Current Mileage* : ");
			inputString=input.nextLine();
			if(inputString == null && inputString!="")
				System.out.println("Please enter Current Mileage of the vehicle.");
		}while(inputString.equals("")|| inputString.equals(null));
		
		int mileage=Integer.parseInt(inputString);		
		vehicle.setCurrentMileage(mileage);
		
		System.out.println("Please enter Mechanic Details if you have a preference:");
		System.out.print("Mechanic First Name:");
		inputString=input.nextLine();
		if(inputString != null && inputString != "")
			appointment.setRequestedMechanicFirstName(inputString);
		
		System.out.print("Mechanic Last Name:");
		inputString=input.nextLine();	
		if(inputString != null && inputString != "")
		appointment.setRequestedMechanicLastName(inputString);
			
		appointment.setVehicle(vehicle);
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Schedule Maintenance");
		System.out.println("\tEnter '2' to Schedule Repair");
		System.out.println("\tEnter '3' to Go Back");
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
		
		if(userInput.equals("1")) {
			CustomerScheduleMaintenanceController.scheduleMaintenance(input);
		}else if(userInput.equals("2")) {
			CustomerScheduleRepairController.scheduleRepair(input);
		}		
	}
	
	public static void scheduleService(Scanner input) throws SQLException, ParseException {
		com.java.dbms.proj.views.CustomerView.displayScheduleService();
		
		while(!userInput.equals("3"))
			displayScheduleService(input);
		
}
}
