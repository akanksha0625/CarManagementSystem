package com.java.dbms.proj.controller;

import java.util.Scanner;

public class ReceptionistServiceHistoryController {
	public static void serviceHistory( Scanner input ) {
		//TODO ask for customer email and look up customer service history
		System.out.println("ASK FOR CUSTOMER EMAIL AND DISPLAY SERVICE HISTORY");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}

}
