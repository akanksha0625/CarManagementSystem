package com.java.dbms.proj.controller;

import java.util.Scanner;

public class ReceptionistTaskRecordDeliveriesController {
	public static void recordDeliveries(Scanner input) {
		com.java.dbms.proj.views.ReceptionistView.displayTaskUpdateDeliveries(); //Display page header
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Enter Order ID");
		System.out.println("\tEnter '2' to	Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
	
		if(userInput.equals("1")) {
			//TODO take in a comma separated list of deliveries to be updated
			System.out.println("TAKE IN LIST OF DELIVERIES TO BE UPDATED");
			
			//TODO run a pending order update
			System.out.println("UPDATE ORDERS & SHOW MESSAGE");
		}
		
		//TODO change status of pending orders to delayed check details and notify manager
		System.out.println("CHANGING PENDING TO DELAYED & CREATE MANAGER NOTIFICATION");
	}
}
