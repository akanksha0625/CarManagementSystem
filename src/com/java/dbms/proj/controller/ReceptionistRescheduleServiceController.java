package com.java.dbms.proj.controller;

import java.util.Scanner;

import com.java.dbms.proj.views.ReceptionistView;

public class ReceptionistRescheduleServiceController {
	public static void rescheduleService(Scanner input) {
		ReceptionistView.displayRescheduleService1(); //Display page header

		//TODO ask for customer email display upcoming services for that customer
		System.out.println("GET USER EMAIL AND OUTPUT UPCOMING SERVICES");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Pick a Service");
		System.out.println("\tEnter '2' to	Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			System.out.println("Enter the Service ID of the service you would like to reschedule : ");
			userInput = input.nextLine();
			//TODO add controller to verify service ID and select two dates for service
			System.out.println("VERIFY ID AND SELECT TWO DATES FOR SERVICE");
			
			ReceptionistView.displayRescheduleService2(); //Display second page header
			
			//TODO display service date
			System.out.println("OFFER SERVICE DATES");
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to  Reschedule Date");
			System.out.println("\tEnter '2' to	Go Back");
			
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
						
			if(userInput.equals("1")) {
				//TODO have user choose from the two dates
				System.out.println("HAVE CUSTOMER SELECT THE DATE & RESCHEDULE");
			}
		}
	}
}
