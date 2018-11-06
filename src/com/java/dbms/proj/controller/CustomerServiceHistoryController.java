package com.java.dbms.proj.controller;

import java.util.Scanner;

public class CustomerServiceHistoryController {
	public static void serviceHistory(Scanner input) {
		com.java.dbms.proj.views.CustomerView.displayServiceHistory(); //Display page header
		
		//TODO display customer's service history
		System.out.println("DISPLAY CUSTOMER SERVICE HISTORY\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}
}
