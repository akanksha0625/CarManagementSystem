package com.java.dbms.proj.controller;

import java.util.Scanner;

public class ManagerInvoicesController {
	public static void invoices(Scanner input) {
		com.java.dbms.proj.views.ManagerView.displayInvoices(); //Display page header
		
		//TODO dump in details
		System.out.println("GET INVOICE DETAILS\n");
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Go Back" );
		
		String userInput = "";
		
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
