package com.java.dbms.proj.controller;

import java.util.Scanner;

public class CustomerViewProfileController {
	public static void viewProfile(Scanner input) {
		com.java.dbms.proj.views.CustomerView.displayViewProfile(); //Display page header
		
		//TODO display customer profile information
		System.out.println("DISPLAY CUSTOMER PROFILE INFORMATION");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back." );
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}
}
