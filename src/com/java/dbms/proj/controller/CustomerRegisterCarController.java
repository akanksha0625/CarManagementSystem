package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.Customer;


public class CustomerRegisterCarController {
	public static void registerCar(Scanner input) throws SQLException {
		com.java.dbms.proj.views.CustomerView.displayCarRegistration(); //Display page header
		Customer customer=ApplicationController.customer;
		
		ResultSet resultSet;
		Statement statement = DBFacade.getConnection().createStatement();
		
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
		System.out.print("Please enter Licence plate :");
		licence=input.nextLine();
		
		do{
			System.out.print("\nPlease enter Purchase Date (i.e. dd-MMM-yyyy) : ");
			purchaseDate=input.nextLine();
		}while(!HelperFunctions.checkDate(purchaseDate));
		
		System.out.print("\nPlease enter Make :");
		make=input.nextLine();
		System.out.print("\nPlease enter Model :");
		model=input.nextLine();
	
		try {
			resultSet = statement.executeQuery( "SELECT VID FROM VEHICLE_TYPE WHERE MAKE = '" + make + "' and MODEL = '" + model + "'" );
			if (resultSet.next())
			{
				vid=resultSet.getInt("VID");
			} else {
				System.out.println("\nSorry, but we are uable to accommodate this vechile type \"" + make + " " + model + "\" at this time");
				return;
			}
		}
		catch ( SQLException e ) {
			System.out.println( "Invalid Vehicle Type : " + e.getMessage() );
		}
		System.out.print("\nPlease enter Year :");
		year=input.nextLine();
		System.out.print("\nPlease enter Current Mileage :");
		currentMileage=input.nextLine();
		do {
			System.out.print("\nPlease enter Last service date (i.e. dd-MMM-yyyy) :");
			lastServiceDate=input.nextLine();
		}while(!HelperFunctions.checkDate(lastServiceDate));
		System.out.println();
	
		System.out.println("Please select from the following user options:");
		
		System.out.println("\tEnter '1' to Register");
		
		System.out.println("\tEnter '2' to Cancel");
		
		
		
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			statement.executeUpdate( "INSERT INTO VEHICLE VALUES ('" + licence + "', '" + purchaseDate + "', '" + currentMileage + "','" + lastServiceDate + "', '((null))', '" + vid + "', '" + year + "','" + cid + "', '(null)', '(null)', '(null)', '(null)')" );
		}
		
	}
	

}
