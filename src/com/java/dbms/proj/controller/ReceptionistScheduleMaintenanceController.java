package com.java.dbms.proj.controller;

import java.util.Scanner;

import com.java.dbms.proj.views.ReceptionistView;

public class ReceptionistScheduleMaintenanceController {
	public static void scheduleMaintenance(Scanner input) {
		ReceptionistView.displayScheduleMaintenance1(); //Display page header
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Find Service Date");
		System.out.println("\tEnter '2' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			ReceptionistView.displayScheduleMaintenance2(); //Display next page header
			
			//TODO find 2 service dates
			System.out.println("FIND & OFFER SERVICE DATES");
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Schedule On Date");
			System.out.println("\tEnter '2' to Go Back");
			
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
			
			if(userInput.equals("1")) {
				//TODO Schedule service
				System.out.println("SCHEDULE SERVICE");
			}
		}
	}

}
