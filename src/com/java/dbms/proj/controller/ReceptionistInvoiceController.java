package com.java.dbms.proj.controller;

import java.util.Scanner;

public class ReceptionistInvoiceController {
	public static void invoice(Scanner input) {
		com.java.dbms.proj.views.ReceptionistView.displayInvoice(); //Display page header
		
		//TODO Ask for customer email and display customer invoice
		System.out.println("ASK FOR CUSTOMER EMAIL & DISPLAY INVOICE DETAILS\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}
}
