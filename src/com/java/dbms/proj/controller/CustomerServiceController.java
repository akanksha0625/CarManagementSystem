package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.java.dbms.proj.views.CustomerView;

public class CustomerServiceController {
	static String userInput = "";
	public static void serviceLanding(Scanner input) throws SQLException, ParseException {
		CustomerView.displayService(); //Display page header
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to View Service History");
		System.out.println("\tEnter '2' to Schedule Service");
		System.out.println("\tEnter '3' to Reschedule Service");
		System.out.println("\tEnter '4' to Go Back");
		
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") && !userInput.equals("4"));
		
		if(!userInput.equals("4")) {
			scheduleService(input);
		}
	}

		
	public static void scheduleService(Scanner input) throws SQLException, ParseException {
			if(userInput.equals("1")) {
				CustomerServiceHistoryController.serviceHistory(input);
			}else if(userInput.equals("2")) {
				CustomerScheduleServiceController.scheduleService(input);
			}else if(userInput.equals("3")) {
				CustomerRescheduleServiceController.rescheduleService(input);
			}
			serviceLanding(input);
	}

}
