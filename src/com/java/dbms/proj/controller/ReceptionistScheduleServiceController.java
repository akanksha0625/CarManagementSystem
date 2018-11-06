package com.java.dbms.proj.controller;

import java.util.Scanner;

import com.java.dbms.proj.views.ReceptionistView;

public class ReceptionistScheduleServiceController {
	public static void scheduleServiceLanding(Scanner input) {
		ReceptionistView.displayScheduleService(); //Display page header
		
		//TODO ask for user input
		System.out.println("GATHER USER INPUT");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Schedule Maintenance");
		System.out.println("\tEnter '2' to Schedule Repair");
		System.out.println("\tEnter '3' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
		
		if(!userInput.equals("3")){
			scheduleService(userInput, input);
		}
	}
	public static void scheduleService(String response, Scanner input) {
			if(response.equals("1")) {
				ReceptionistScheduleMaintenanceController.scheduleMaintenance(input);
			}else if(response.equals("2")) {
				ReceptionistScheduleRepairController.scheduleRepair(input);
			}
			scheduleServiceLanding(input);
	}

}
