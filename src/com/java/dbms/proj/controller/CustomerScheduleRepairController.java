package com.java.dbms.proj.controller;

import java.util.Scanner;

public class CustomerScheduleRepairController {
	public static void scheduleRepair(Scanner input) {
		com.java.dbms.proj.views.CustomerView.displayScheduleRepair1(); //Display page header
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to select \"Engine knock\"");
		System.out.println("\tEnter '2' to select \"Car drifts in a particular direction\"");
		System.out.println("\tEnter '3' to select \"Battery does not hold charge\"");
		System.out.println("\tEnter '4' to select \"Black/unclean exhaust\"");
		System.out.println("\tEnter '5' to select \"A/C or Heater not working\"");
		System.out.println("\tEnter '6' to select \"Head-lamps or Tail-lamps not working\"");
		System.out.println("\tEnter '7' to select \"Check engine light\"");
		System.out.println("\tEnter '8' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
				!userInput.equals("4") && !userInput.equals("5") && !userInput.equals("6") && 
				!userInput.equals("7") && !userInput.equals("8"));
		
		if(!userInput.equals("8")) {
			//TODO create diagnostic report and find service dates
			System.out.println("CREATE DIAGNOSTIC REPORT AND FIND DATES");
			
			com.java.dbms.proj.views.CustomerView.displayScheduleRepair2(); //Display second page header
			
			//TODO display report and service dates
			System.out.println("DISPLAY REPORT AND DATES");
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to schedule your date for Repair");
			System.out.println("\tEnter '2' Go Back");
			
			userInput = "";
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
			
			if(userInput.equals("1")) {
				//TODO sallow user to pick and schedule
				System.out.println("USER PICKS AND SCHEDULE DATE");
			}
		}
	}

}
