package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;

public class ManagerOrderHistoryController {
	public static void orderHistory(Scanner input) throws ClassNotFoundException, SQLException{
		com.java.dbms.proj.views.ManagerView.displayOrderHistory(); //Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		
		try {
			/* Find userName and userPassword match from 'LOGIN' table */
			resultSet = statement.executeQuery("SELECT * FROM PURCHASE_ORDER");
			
			/* If query returned a value */
			if (resultSet.next()) {
					
					System.out.println();
					System.out.println();			
				}
			}  catch (SQLException e) {
				System.out.println("Could'nt get the Inventory details. " + e);
				e.printStackTrace();
			}
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
