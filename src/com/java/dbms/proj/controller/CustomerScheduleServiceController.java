package com.java.dbms.proj.controller;

import java.util.Scanner;

public class CustomerScheduleServiceController {
	public static void scheduleService(Scanner input) {
		com.java.dbms.proj.views.CustomerView.displayScheduleService();
		
		//TODO ask user for details
		System.out.println("ASK USER FOR INPUT ABOUT CAR");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Schedule Maintenance");
		System.out.println("\tEnter '2' to Schedule Repair");
		System.out.println("\tEnter '3' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
		
		if(userInput.equals("1")) {
			CustomerScheduleMaintenanceController.scheduleMaintenance(input);
		}else if(userInput.equals("2")) {
			CustomerScheduleRepairController.scheduleRepair(input);
		}		
	}
}
