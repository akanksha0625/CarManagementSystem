package com.java.dbms.proj.controller;

import java.util.Scanner;

public class ManagerOrderHistoryController {
	public static void orderHistory(Scanner input){
		com.java.dbms.proj.views.ManagerView.displayOrderHistory(); //Display page header
		//TODO dump order history details into view
		System.out.println("GET ORDER DETAILS\n");
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Go Back" );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
