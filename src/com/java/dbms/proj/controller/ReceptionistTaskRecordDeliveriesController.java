package com.java.dbms.proj.controller;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;

public class ReceptionistTaskRecordDeliveriesController {
	public static void recordDeliveries(Scanner input) throws ClassNotFoundException, SQLException {
		com.java.dbms.proj.views.ReceptionistView.displayTaskUpdateDeliveries(); //Display page header
		
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet, inventoryResult;
		
		String temp;
		int tuples=0;
		
		System.out.println("\nPlease select from the following user options:");
		System.out.println("\tEnter '1' to Enter Order ID");
		System.out.println("\tEnter '2' to Go Back");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
	
		if(userInput.equals("1")) {			
			System.out.print ( "\nPlease enter a comma separated list of Order IDs to be updated (i.e. 1,2,3) : ");
			temp = input.nextLine();
			
			try{
				int[] partIdsArray = Arrays.stream(temp.split(",")).mapToInt(Integer::parseInt).toArray();  
			}catch(NumberFormatException e) {
				System.out.println("\nThe list provided contained values that were non numeric. Aborting Transaction.\n");
				return;
			}
			
			try {
				resultSet = statement.executeQuery( "SELECT * FROM PURCHASE_ORDER WHERE ORDER_ID IN (" + temp + ") AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "' AND ORDER_STATUS != 'DELIVERED'" );
				while(resultSet.next()) {
					tuples= statement.executeUpdate("UPDATE ACME_INVENTORY SET CURRENT_QUANTITY = CURRENT_QUANTITY + "+ resultSet.getString("PART_QUANTITY") +" WHERE PART_ID = "+ resultSet.getString("PART_ID") +" AND SC_ID = '"+ resultSet.getString("SC_ID") + "'");
				}
			}catch (SQLException e) {
				System.out.println( "Cannot Access Orders. " + e );
				e.printStackTrace();
			}

			try {
				 tuples= statement.executeUpdate("UPDATE PURCHASE_ORDER SET ORDER_STATUS = 'DELIVERED' WHERE ORDER_ID IN (" + temp + ") AND ORDER_STATUS != 'DELIVERED' AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "'");
				 System.out.println(tuples + " Purchase orders Updated. ");
			}catch (SQLException e) {
				System.out.println( "System Query Error : Cannot Update orders. " + e );
				e.printStackTrace();
			}
		}
	
		//TODO change status of pending orders to delayed check details and notify manager
		System.out.println("CHANGING PENDING TO DELAYED & CREATE MANAGER NOTIFICATION");
		
	}
}
