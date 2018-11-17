package com.java.dbms.proj.controller;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import com.java.dbms.proj.common.DBFacade;

public class ReceptionistRegisterCarController {
	public static void registerCar(Scanner input) throws SQLException {
		com.java.dbms.proj.views.ReceptionistView.displayRegisterCar(); //Display page header
		ResultSet resultSet;
		Statement statement = DBFacade.getConnection().createStatement();
		
		//TODO ask for car details for registration
		System.out.println("ASK FOR DETAILS FOR CAR REGISTRATION");
		int cid = 0;
		String licence = null;
		String purchaseDate = null;
		String make;
		String model;
		String year = null;
		String currentMileage = null;
		String lastServiceDate="";
		int vid = 0;
		System.out.println("Please enter Customer email address");
		String email="";
		email = input.nextLine();
		
		try {
			resultSet = statement.executeQuery( "SELECT CID FROM CUSTOMER WHERE EMAIL = '" + email + "'" );
			if (resultSet.next())
			{
				cid=resultSet.getInt("CID");
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
				
				
			}
			
		}
		catch ( SQLException e ) {
			System.out.println( "Unable to access the Customer Address table : " + e.getMessage() );
		}
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Register");
		System.out.println("\tEnter '2' to Cancel");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			//TODO register car
			statement.executeUpdate( "INSERT INTO VEHICLE VALUES ('" + licence + "', '" + purchaseDate + "', '" + currentMileage + "','" + lastServiceDate + "', '" + "" + "', '" + vid + "', '" + year + "','" + cid + "')" );
			System.out.println("REGISTER CAR");
		}
	}
		
}
		
