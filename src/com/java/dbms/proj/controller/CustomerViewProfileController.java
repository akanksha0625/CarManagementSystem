package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.entities.Address;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.views.CustomerView;

public class CustomerViewProfileController {
	public static void viewProfile(Scanner input) throws SQLException {
		CustomerView.displayViewProfile(); //Display page header
		Customer customer=ApplicationController.customer;	
		Address custAddress=customer.getAddress();
		System.out.println("CUSTOMER PROFILE INFORMATION");		
		System.out.println("Customer ID:\t\t"+ customer.getCustomerId());	
		System.out.println("Name :\t\t\t"+ customer.getFirstName()+ " " + customer.getLastName());	
		System.out.println("Address:\t\t"+ custAddress.getStreet()+ ", " + custAddress.getCity() + ", "+ custAddress.getState()+ ", " + custAddress.getZipCode());
		System.out.println("Email Address:\t\t"+ customer.getEmail());
		System.out.println("Phone Number:\t\t"+ customer.getPhoneNumber());
		System.out.println("List of All Cars:\t"+ customer.getCustomerId());
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back." );
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}
}
