package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.views.ManagerView;

public class ManagerNotificationsController {
	public static void notifications(Scanner input)  throws ClassNotFoundException, SQLException{
		ManagerView.displayNotifications(); //Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		
		try {
			/* Find userName and userPassword match from 'LOGIN' table */
			resultSet = statement.executeQuery("SELECT * FROM NOTIFICATION");
			
			/* If query returned a value */
			if (resultSet.next()) {
					
					System.out.println();
					System.out.println();			
				}
			}  catch (SQLException e) {
				System.out.println("Could'nt get the Inventory details. " + e);
				e.printStackTrace();
			}
		//TODO display notifications
		System.out.println("DISPLAY NOTIFICATIONS\n");
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to	Order ID" );
		System.out.println( "\tEnter '2' to	Go Back" );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while(!userInput.equals( "1" ) && !userInput.equals( "2" ) );
		
		if(userInput.equals("1")) {
			System.out.println( "What Order ID would you like to view? : " );
			String	response = input.nextLine();
			//TODO add logic to check for correct order ID
			
			ManagerView.displayNotificationsDetail(); //Display new page header
			//display the information about this order ID notification with the details view
			System.out.println("GET NOTIFICATION DETAILS for orderID : " + response );
			
			System.out.println( "Please select from the following user options:" );
			System.out.println( "\tEnter '1' to	Go Back" );
			
			do {
				System.out.print( "\nOption Selection : " );
				userInput = input.nextLine();
			}while( !userInput.equals( "1" ) );
			
		}
	}
}
