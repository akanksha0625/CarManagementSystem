package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Address;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.views.CustomerView;

public class CustomerUpdateProfileController {
	static Customer customer = ApplicationController.customer;
	static Address custAddress = new Address();
	static String userInput = "";
	static Statement statement=null;

	public static void updateProfile(Scanner input) throws SQLException {
		
		CustomerView.displayUpdateProfile(); //Display page header
		while(!userInput.equals("5"))
			displayMenu();
}
	
	static void displayMenu() throws SQLException {
		
		userInput=null;
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Update your Name.");
		System.out.println("\tEnter '2' to Update your Address.");
		System.out.println("\tEnter '3' to Update your Phone Number.");
		System.out.println("\tEnter '4' to Update your Password.");
		System.out.println("\tEnter '5' to Go Back");
		System.out.print("\nOption Selection : ");
		
		Scanner input=new Scanner(System.in);
		userInput = input.nextLine();
		statement=DBFacade.getConnection().createStatement();
		switch (userInput) {
		case "1":
		//	if(userInput.equals("1")) {
			System.out.print("User First Name : ");
			customer.setFirstName(input.nextLine());
			
			System.out.print("User Last Name : ");
			customer.setLastName(input.nextLine());
			System.out.println(LoginController.userLogin.getUserName());
			System.out.println(customer.getFirstName());
			System.out.println(customer.getLastName() );
				int tuples= statement.executeUpdate("UPDATE CUSTOMER SET FIRSTNAME = '" + customer.getFirstName() +
						 "' , LASTNAME = '"+ customer.getLastName() + "' WHERE USERNAME= '" + LoginController.userLogin.getUserName() + "'");
			break;
			//}
		case "2":
		
			System.out.print("User City : ");
			String city = input.nextLine();

			String state = "";
			// Check restriction of State Abreviation 
			do {
				System.out.print("User State Abbreviation (ex: NC) : ");
				state = input.nextLine();
			} while (state.length() > 2 || state.isEmpty());

			System.out.print("User Street Address : ");
			String street = input.nextLine();

			System.out.print("User Zip Code : ");
			String zip = input.nextLine();

			if (city != null && city != "")
				custAddress.setCity(city);

			if (state != null && state != "")
				custAddress.setState(state);

			if (street != null && street != "")
				custAddress.setStreet(street);

			if (zip != null && zip != "")
				custAddress.setZipCode(zip);

			customer.setAddress(custAddress);
			break;

		case "3":
			System.out.print("User Phone Number : ");
			customer.setPhoneNumber(userInput);
			break;
			
		case "4":
			System.out.print("User Password : ");
			// to do
			break;
			
		case "5" :
			break;
		default:
			System.out.println("Please select a valid option");
		}
	System.out.println("hello");	
	}
}
