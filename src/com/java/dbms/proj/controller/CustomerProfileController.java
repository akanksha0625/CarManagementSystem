package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.views.CustomerView;

public class CustomerProfileController {
	public static void profileLanding(Scanner input) throws SQLException {
		String userInput = "";
		do {
			CustomerView.displayProfile(); //Display page header
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to View Profile.");
			System.out.println("\tEnter '2' to Update Profile." );
			System.out.println("\tEnter '3' to Go Back." );
			
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
					!userInput.equals("4") && !userInput.equals("5"));
			
			if(userInput.equals("1")) {
				/*Redirect to customer view profile*/
				CustomerViewProfileController.viewProfile(input);
			} else if(userInput.equals("2")) {
				CustomerUpdateProfileController.updateProfile(input);
			}
		}while(!userInput.equals("3"));
	}

}
