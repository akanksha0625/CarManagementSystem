package com.java.dbms.proj.controller;

import java.util.Scanner;

public class EmployeeSearchCustomerController {
	
	public static void searchCustomer( Scanner input ) {
		//TODO ask for customer email and search in the database until valid customer is found then display customer details
		System.out.println("SEARCH FOR CUSTOMER PROFILE\n");
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Go Back." );
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
