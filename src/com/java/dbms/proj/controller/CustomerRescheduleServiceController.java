package com.java.dbms.proj.controller;

import java.util.Scanner;

public class CustomerRescheduleServiceController {
	public static void rescheduleService(Scanner input) {
		com.java.dbms.proj.views.CustomerView.displayReschedule1();
		
		//TODO display details for upcoming services
		System.out.println("DISPLAY DETAILS OF UPCOMING SERVICES");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Pick a service");
		System.out.println("\tEnter '2' to Go back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			//TODO ask for serviceID and find dates
			System.out.println("ASK FOR SERVICE ID & FIND DATES");
			
			com.java.dbms.proj.views.CustomerView.displayReschedule2(); //Display second page header
			
			//TODO display dates
			System.out.println("DISPLAY DATES");
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Reschedule date");
			System.out.println("\tEnter '2' to Go back");
			
			userInput = "";
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
			
			if(userInput.equals("1")) {
				//TODO user picks date and schedule
				System.out.println("USER PICKS DATE AND SCHEDULES");
			}
		}
	}
}
