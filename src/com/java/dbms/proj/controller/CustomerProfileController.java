package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.views.CustomerView;

public class CustomerProfileController {
	static String userInput = "";
//	public static void profileLanding(Scanner input) throws SQLException {
//		CustomerView.displayProfile(); //Display page header
//		userInput = "";
//		do {
//			customerProfile(input);
//		}while(!userInput.equals("3"));
//	}

	public static void customerProfile(Scanner input) throws SQLException {	
		CustomerView.displayProfile(); //Display page header	
		System.out.println("\n\nPlease select from the following user options:");
			System.out.println("\tEnter '1' to View Profile.");
			System.out.println("\tEnter '2' to Update Profile." );
			System.out.println("\tEnter '3' to Go Back." );
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
			
			switch(userInput) {
			
			case "1":
				/*Redirect to customer view profile*/
				CustomerViewProfileController.viewProfile(input);
				break;
			case "2" : 
				CustomerUpdateProfileController.updateProfile(input);
				break;
			case "3":
				break;
			default:
				System.out.println("Please select a valid option");
			}
	}
}
