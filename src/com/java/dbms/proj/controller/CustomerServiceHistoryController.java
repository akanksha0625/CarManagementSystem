package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.common.ApplicationConstants;
import com.java.dbms.proj.common.HelperFunctions;

public class CustomerServiceHistoryController {
	public static void serviceHistory(Scanner input) throws SQLException {
		com.java.dbms.proj.views.CustomerView.displayServiceHistory(); //Display page header
		HelperFunctions.displayServiceHistory(ApplicationController.customer,ApplicationConstants.COMPLETE);
		System.out.println("\nPlease select from the following user options:");
		System.out.println("\tEnter '1' to  Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}
}
