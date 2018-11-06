package com.java.dbms.proj.controller;

import java.util.Scanner;

import com.java.dbms.proj.views.ReceptionistView;

public class ReceptionistScheduleRepairController {
	public static void scheduleRepair(Scanner input) {
		ReceptionistView.displayScheduleRepair1(); //Display page header
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Engine Knock");
		System.out.println("\tEnter '2' to Car drifts in a particular direction");
		System.out.println("\tEnter '3' to Battery does not hold charge");
		System.out.println("\tEnter '4' to Black/Unclean exhaust");
		System.out.println("\tEnter '5' to A/C-Heater not working");
		System.out.println("\tEnter '6' to Headlamps/Taillamps not working");
		System.out.println("\tEnter '7' to Check engine light");
		System.out.println("\tEnter '8' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
				!userInput.equals("4") && !userInput.equals("5") && !userInput.equals("6") && !userInput.equals("7") && !userInput.equals("8"));

		if(!userInput.equals("8")) {
			//TODO create diagnostic report and find service dates
			System.out.println("CREATE DIAGNOSTIC REPORT & FIND TWO SERVICE DATES");
			ReceptionistView.displayScheduleRepair2(); //Display next page header
			
			//TODO call controller to find service date
			System.out.println("CALL CONTROLLER TO OFFER SERVICE DATES");
			
			//TODO display the information for the service
			System.out.println("DISPLAY INFORMATION FOR THE SERVICE");
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Repair on date");
			System.out.println("\tEnter '2' to Go Back");
			
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
			
			if(userInput.equals("1")) {
				//TODO have customer choose from the two dates
				System.out.println("HAVE CUSTOMER SELECT THE DATE");
			}
		}
	}
}
