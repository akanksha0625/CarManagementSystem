package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.Vehicle;
import com.java.dbms.proj.views.ReceptionistView;

public class ReceptionistScheduleServiceController {
	
	public static Appointment appointment=new Appointment();
	static Vehicle vehicle = new Vehicle();
	static String inputString="";
	static String userInput="";
	public static Customer customer= new Customer();
	static Statement statement = null;
	static ResultSet resultSet;
	
	public static void scheduleServiceLanding(Scanner input) throws SQLException, ParseException {
		ReceptionistView.displayScheduleService(); //Display page header
		statement = DBFacade.getConnection().createStatement();
		
		System.out.println("Please enter the below mandatory* details to schedule a service:\n");	
		do {
			System.out.print("Customer Email Address* :");
			inputString=input.nextLine();
			if(inputString == null || inputString=="")
				System.out.println("Please enter Customer Email Address.");
		}while(inputString.equals("")|| inputString.equals(null));
		customer.setEmail(inputString);
		do {
			System.out.print("License Plate* :");
			inputString=input.nextLine();
			if(inputString == null || inputString=="")
				System.out.println("Please enter License Plate Number.");
		}while(inputString.equals("")|| inputString.equals(null));
		
		vehicle.setLicense(inputString);
		
		do {
			System.out.print("Current Mileage* : ");
			inputString=input.nextLine();
			if(inputString == null || inputString=="")
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
		
		if(userInput.equals("1") || userInput.equals("2"))
		{

			System.out.print("emial"+ApplicationController.employee.getServiceCenterId());
			try {
				resultSet = statement.executeQuery("SELECT * FROM CUSTOMER WHERE EMAIL = '" + customer.getEmail()
						+ "' AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "'");

				if (resultSet.next()) {
					System.out.println("Hello"+customer.getCustomerId());
					if (resultSet.getString("CID") != null && resultSet.getString("CID") != "")
						customer.setCustomerId(resultSet.getInt("CID"));
					System.out.println(customer.getCustomerId());
					if (resultSet.getString("SC_ID") != null && resultSet.getString("SC_ID") != "")
						customer.setServiceCenterId(resultSet.getString("SC_ID"));
				
				}
				
				else {
					System.out.println("\n\tCustomer email \"" + customer.getEmail() + "\" is not associated with this service center.\n");
					return;
				}
			} catch (SQLException e) {
				System.out.println(
						"\nUnable to access the Customer Table : " + e.getMessage() + " : Aborting Transaction.\n");
				return;
			}
			
		
		
		}
		
		if(!userInput.equals("3")){	
			scheduleService(input);
		}
	}
	public static void scheduleService(Scanner input) throws SQLException, ParseException {
		if(userInput.equals("1")) {
				ReceptionistScheduleMaintenanceController.scheduleMaintenance(input);
			}else if(userInput.equals("2")) {
				ReceptionistScheduleRepairController.scheduleRepair(input);
			}
			scheduleServiceLanding(input);
	}

}
