package com.java.dbms.proj.controller;

import java.util.Scanner;

public class CustomerInvoiceController {
	public static void invoice(Scanner input) {
		com.java.dbms.proj.views.CustomerView.displayInvoice(); //Display page header
		
		//TODO display all details of services
		System.out.println("DISPLAY ALL SERVICE DETAILS");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to View Invoice details");
		System.out.println("\tEnter '2' to Go back");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			com.java.dbms.proj.views.CustomerView.displayInvoiceDetails(); //Display second page header
			
			//TODO ask user for service id and output service details
			System.out.println("ASK FOR SERVICE ID & OUTPUT INVOICE DETAILS");
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Go back");
			
			userInput = "";
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1"));
		}
	}
}
