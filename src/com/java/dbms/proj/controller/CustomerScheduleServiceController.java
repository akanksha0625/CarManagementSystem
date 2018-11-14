package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Service;
import com.java.dbms.proj.entities.Vehicle;

public class CustomerScheduleServiceController {
	
	static Appointment appointment=new Appointment();
	static Vehicle vehicle = new Vehicle();
	
	public static void scheduleService(Scanner input) throws SQLException {
		com.java.dbms.proj.views.CustomerView.displayScheduleService();
		
		String inputString="";
		System.out.println("Please enter the below mandatory* details to schedule a service:\n");
		do {
			System.out.print("License Plate* :");
			inputString=input.nextLine();
			if(inputString == null && inputString!="")
				System.out.println("Please enter License Plate Number.");
		}while(inputString!=null && inputString!="");
		
		vehicle.setLicense(inputString);
		
		do {
			System.out.print("Current Mileage* : ");
			inputString=input.nextLine();
			if(inputString == null && inputString!="")
				System.out.println("Please enter Current Mileage of the vehicle.");
		}while(inputString!=null && inputString!="");
		
		vehicle.setCurrentMileage(Integer.parseInt(input.nextLine()));
		
		System.out.print("Mechanic Name: ");
		inputString=input.nextLine();
		
		if(inputString != null && inputString != "")
			appointment.setRequestedMechanic(inputString);
			
		appointment.setVehicle(vehicle);
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Schedule Maintenance");
		System.out.println("\tEnter '2' to Schedule Repair");
		System.out.println("\tEnter '3' to Go Back");
		
		String userInput = "";
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
}
