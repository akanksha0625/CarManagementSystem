package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Customer;


public class CustomerRegisterCarController {
	public static void registerCar(Scanner input) throws SQLException {
		com.java.dbms.proj.views.CustomerView.displayCarRegistration(); //Display page header
		Customer customer=ApplicationController.customer;
		
		ResultSet resultSet;
		Statement statement = DBFacade.getConnection().createStatement();
		
		//TODO gather user information about car
		System.out.println("GATHER USER INFORMATION ABOUT CAR");
		int inp;
		String licence;
		String purchaseDate;
		String make;
		String model;
		String year;
		String currentMileage;
		String lastServiceDate="";
		int vid = 0;
		int cid;
		cid=customer.getCustomerId();
		System.out.println("Please enter Licence plate:");
		licence=input.nextLine();
		System.out.println("Please enter Purchase Date:");
		purchaseDate=input.nextLine();
		System.out.println("Please enter Make:");
		make=input.nextLine();
		System.out.println("Please enter Model:");
		model=input.nextLine();
		System.out.println("Please enter Year:");
		year=input.nextLine();
		System.out.println("Please enter Current Mileage:");
		currentMileage=input.nextLine();
		System.out.println("Please enter Last service date:");
		lastServiceDate=input.nextLine();
				try {
					resultSet = statement.executeQuery( "SELECT VID FROM VEHICLE_TYPE WHERE MAKE = '" + make + "' and MODEL = '" + model + "'" );
					if (resultSet.next())
					{
						vid=resultSet.getInt("VID");
					}
				}
				catch ( SQLException e ) {
					System.out.println( "Invalid Vehicle Type : " + e.getMessage() );
				}
				
					
		
		System.out.println("Please select from the following user options:");
		
		System.out.println("\tEnter '1' to Register");
		
		System.out.println("\tEnter '2' to Cancel");
		
		
		
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			//TODO register car
			statement.executeUpdate( "INSERT INTO VEHICLE VALUES ('" + licence + "', '" + purchaseDate + "', '" + currentMileage + "','" + lastServiceDate + "', '" + "" + "', '" + vid + "', '" + year + "','" + cid + "')" );
			System.out.println("REGISTER CAR");
		}
		
	}
	

}
