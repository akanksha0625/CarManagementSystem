package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.views.ManagerView;

public class ManagerViewOrdersController {
	public static void viewOrders(String response, Scanner input)  throws ClassNotFoundException, SQLException{
		if( response.equals( "1" ) ) {
			/*Redirect to view order history page*/
			ManagerOrderHistoryController.orderHistory(input);
			orderLanding(input);
		} else if( response.equals( "2" ) ){
			/*Redirect to new order page*/
			ManagerNewOrderController.newOrder(input);
			orderLanding(input);
		}
	}
	
	public static void orderLanding(Scanner input)  throws ClassNotFoundException, SQLException{
		ManagerView.displayOrders(); //Display page header
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Order History" );
		System.out.println( "\tEnter '2' to New Order" );
		System.out.println( "\tEnter '3' to Go Back" );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) && !userInput.equals( "3" ) );
		
		viewOrders(userInput, input);
	}
}
