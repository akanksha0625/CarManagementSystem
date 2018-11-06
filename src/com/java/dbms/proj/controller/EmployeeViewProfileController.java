package com.java.dbms.proj.controller;

import java.util.Scanner;

public class EmployeeViewProfileController {
	
	public static void viewProfile( Scanner input ) {
		
		com.java.dbms.proj.views.EmployeeView.displayViewProfile(); //Display page header
		
		//TODO call the controller to drop employee info into this view
		System.out.println("INSERT EMPLOYEE PROFILE DETAILS\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back." );

		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}

}
