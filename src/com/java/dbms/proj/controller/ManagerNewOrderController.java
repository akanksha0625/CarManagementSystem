package com.java.dbms.proj.controller;

import java.util.Scanner;

public class ManagerNewOrderController {
	
	public static void newOrder(Scanner input) {
		
		//TODO ask for part ID and quantity
		System.out.println("TAKE PART ORDER DETAILS\n");
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Place Order" );
		System.out.println( "\tEnter '2' to Go Back" );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) );
		
		if(userInput.equals("1")) {
			//TODO create and place order
			System.out.println("PLACE ORDER\n");
		}
	}

}
