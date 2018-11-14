package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.views.CustomerView;

public class CustomerServiceController {
	public static void serviceLanding(Scanner input) throws SQLException {
		CustomerView.displayService(); //Display page header
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to View Service History");
		System.out.println("\tEnter '2' to Schedule Service");
		System.out.println("\tEnter '3' to Reschedule Service");
		System.out.println("\tEnter '4' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") && !userInput.equals("4"));
		
		if(!userInput.equals("4")) {
			scheduleService(userInput, input);
		}
	}

		
	public static void scheduleService(String response, Scanner input) throws SQLException {
			if(response.equals("1")) {
				CustomerServiceHistoryController.serviceHistory(input);
			}else if(response.equals("2")) {
				CustomerScheduleServiceController.scheduleService(input);
			}else if(response.equals("3")) {
				CustomerRescheduleServiceController.rescheduleService(input);
			}
			serviceLanding(input);
	}

}
