package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;

public class ManagerInventoryController {
	public static void displayInventory( Scanner input )  throws ClassNotFoundException, SQLException {
		com.java.dbms.proj.views.ManagerView.displayInventory(); //Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		
		try {
			/* Get inventory details */
			resultSet = statement.executeQuery("SELECT * FROM ACME_INVENTORY WHERE SC_ID = '"+ ApplicationController.employee.getServiceCenterId() + 	"'");
			
			/* If query returned a value */
			while (resultSet.next()) {
					System.out.println("Part ID : "+ resultSet.getString("PART_ID"));
					System.out.println("Part Name : "+ resultSet.getString("PART_NAME"));
					System.out.println("Make : "+ resultSet.getString("MAKE"));
					System.out.println("Quantity : "+ resultSet.getString("CURRENT_QUANTITY"));
					System.out.println("Unit Price : "+ resultSet.getString("UNIT_COST"));
					System.out.println("Minimum Quantity Threshold : "+ resultSet.getString("MIN_QUANTITY"));
					System.out.println("Minimum Order Threshold : "+ resultSet.getString("MIN_ORDER_THRESHOLD"));
					System.out.println();
					System.out.println();			
				}
			}  catch (SQLException e) {
				System.out.println("Could'nt get the Inventory details. " + e);
				e.printStackTrace();
			}

		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Go Back" );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
