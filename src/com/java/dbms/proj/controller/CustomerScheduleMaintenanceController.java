package com.java.dbms.proj.controller;

import java.util.Scanner;

public class CustomerScheduleMaintenanceController {
	public static void scheduleMaintenance(Scanner input) {
		com.java.dbms.proj.views.CustomerView.displayScheduleMaintenance1(); //Display page header
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Find Service Date");
		System.out.println("\tEnter '2' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			//TODO validate car details and find service dates
			System.out.println("VALIDATE CAR DETAILS & FIND SERVICE DATE");
			com.java.dbms.proj.views.CustomerView.displayScheduleMaintenance2(); //Display second page header
			
			//TODO display service dates
			System.out.println("DISPLAY SERVICE DATES");
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Schedule on Date");
			System.out.println("\tEnter '2' to Go Back");
			
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
			
			if(userInput.equals("1")) {
				//TODO have user select from two dates and schedule
				System.out.println("ALLOW USER TO PICK AND SCHEDULE DATE");
			}
		}
	}

}
