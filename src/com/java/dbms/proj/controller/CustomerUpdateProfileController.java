package com.java.dbms.proj.controller;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.controller.ApplicationController;
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
		userInput="";
		do {
			displayMenu();
		}while(!userInput.equals("5"));
}
	
	static void displayMenu() throws SQLException {
		int tuples;
		userInput=null;
		System.out.println("\nPlease select from the following user options:");
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
			System.out.print("\nUser First Name : ");
			customer.setFirstName(input.nextLine());
			
			System.out.print("\nUser Last Name : ");
			customer.setLastName(input.nextLine());
			try {
				 tuples= statement.executeUpdate("UPDATE CUSTOMER SET FIRSTNAME = '" + customer.getFirstName() +
						 "' , LASTNAME = '"+ customer.getLastName() + "' WHERE USERNAME= '" + LoginController.userLogin.getUserName() + "'");
			}
			catch (SQLException e) {
				System.out.println( "System Query Error : " + e );
				e.printStackTrace();
			}
			break;
			//}
		case "2":
		
			System.out.print("\nUser Street Address : ");
			String street = input.nextLine();
			
			System.out.print("\nUser City : ");
			String city = input.nextLine();

			String state = "";
			// Check restriction of State Abreviation 
			do {
				System.out.print("\nUser State Abbreviation (ex: NC) : ");
				state = input.nextLine();
			} while (state.length() > 2 || state.isEmpty());

			System.out.print("\nUser Zip Code : ");
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
			try {
			 tuples= statement.executeUpdate("UPDATE CUSTOMER_ADDRESS SET CITY = '" + custAddress.getCity() +
					 "' , STATE = '"+ custAddress.getState() +
					 "' , STREET = '"+ custAddress.getStreet() +
					 "' , ZIP = '"+ custAddress.getZipCode() +
					 "' WHERE CID= '" + customer.getCustomerId() + "'");
			}
			catch (SQLException e) {
				System.out.println( "System Query Error : " + e );
				e.printStackTrace();
			}
		
			break;

		case "3":
			System.out.print("\nUser Phone Number : ");
			customer.setPhoneNumber(input.nextLine());
			
			 tuples= statement.executeUpdate("UPDATE CUSTOMER SET PHONE = '" + customer.getPhoneNumber()
					 + "' WHERE USERNAME= '" + LoginController.userLogin.getUserName() + "'");
			break;
			
		case "4":
			HelperFunctions.updatePassword(LoginController.userLogin.getUserName());
			break;
			
		case "5" :
			break;
		default:
			System.out.println("\n------------------------------");
			System.out.println("|  Invalid option selected.  |");
			System.out.println("------------------------------");
		}

	}
}
