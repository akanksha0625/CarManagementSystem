package com.java.dbms.proj.controller;

import java.util.Scanner;

public class ManagerInventoryController {
	public static void displayInventory( Scanner input ) {
		com.java.dbms.proj.views.ManagerView.displayInventory(); //Display page header
		
		//TODO dump the details in
		System.out.println("GET INVENTORY DETAILS\n" );
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Go Back" );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
