package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Customer;

public class CustomerViewProfileController {
	public static void viewProfile(Scanner input) throws SQLException {
		com.java.dbms.proj.views.CustomerView.displayViewProfile(); //Display page header
		Customer customer=ApplicationController.customer;	
		System.out.println("CUSTOMER PROFILE INFORMATION");		
		System.out.println("Customer ID:\t"+ customer.getCustomerId());	
		System.out.println("Address:\t"+ customer.getCustomerId());
		System.out.println("Email Address:\t"+ customer.getEmail());
		System.out.println("Phone Number:\t"+ customer.getPhoneNumber());
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
