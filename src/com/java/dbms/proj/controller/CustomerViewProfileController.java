package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.Address;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.views.CustomerView;

public class CustomerViewProfileController {
	public static void viewProfile(Scanner input) throws SQLException {
		CustomerView.displayViewProfile(); //Display page header
		Customer customer=ApplicationController.customer;	
		Address custAddress=customer.getAddress();
			
		HelperFunctions.displayCustomerProfile(customer);
		System.out.println("\nPlease select from the following user options:");
		System.out.println("\tEnter '1' to Go Back." );
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}
}
