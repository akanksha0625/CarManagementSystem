package com.java.dbms.proj.controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;

public class ManagerNewOrderController {
	
	public static void newOrder(Scanner input)  throws ClassNotFoundException, SQLException {
		
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet, inventoryResult, sequenceResult;
		String orderDeliverySource = "";
		int sourceId = 0;
		String scId = "";
		
		int minOrderThreshold =0;
		
		//TODO ask for part ID and quantity
		System.out.println("TAKE PART ORDER DETAILS\n");		
		
		System.out.println ("Please provide some details of the order to be placed.");
		
		System.out.print ( "Part ID : ");
		int partId = Integer.parseInt(input.nextLine());

		
		System.out.print ( "Quantity : ");
		int quantity = Integer.parseInt(input.nextLine());
		System.out.println(ApplicationController.employee.getServiceCenterId());
		//check the threshold order qty requirement of that table of that part in the service centers inventory
		try {
			resultSet = statement.executeQuery( "SELECT * FROM ACME_INVENTORY WHERE PART_ID = " + partId + " AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "'" );
			System.out.println ( "check for inventory." );

			if (resultSet.next()) {
				minOrderThreshold = Integer.parseInt(resultSet.getString("MIN_ORDER_THRESHOLD"));
				scId = resultSet.getString("SC_ID");
				
				if(minOrderThreshold > quantity ) {
					System.out.println ( "Min order quantity too low" );
				}
			} else {
				System.out.println ( "No such inventory exist for this service center." );
			}
		} catch ( SQLException e ) {
			System.out.println( "Unabel to access Inventory table : " + e.getMessage() );
			e.printStackTrace();
		}
		try {
			resultSet = statement.executeQuery( "SELECT * FROM ACME_INVENTORY WHERE PART_ID = " + partId + " AND SC_ID <> '" + ApplicationController.employee.getServiceCenterId() + "' AND (CURRENT_QUANTITY - "+ quantity+" ) >= MIN_QUANTITY " );
			
			if (!resultSet.next()) {
				//No such inventory exist for this service center. So we place an order in supplier
				resultSet = statement.executeQuery( "SELECT * FROM SUPPLIER_INVENTORY WHERE PART_ID = " + partId);	
				resultSet.next();
				orderDeliverySource = "SUPPLIER";		
				sourceId = Integer.parseInt(resultSet.getString("SUPPLIER_ID"));
			} else {
				orderDeliverySource = "ACME"; 
				sourceId = Integer.parseInt(resultSet.getString("SC_ID"));

			}
			
			try {
				//place the order
				sequenceResult = statement.executeQuery( "SELECT ACME_INVENTORY_SEQ.nextVal FROM dual");
				int index = 0;
				if ( sequenceResult.next() ) {
					index = resultSet.getInt( "NEXTVAL" );
				}
				
				 Date dNow = new Date(0 );
			     SimpleDateFormat ft =  new SimpleDateFormat ("dd-MM-yyyy");

			      System.out.println("Current Date: " + ft.format(dNow));
			      
			      
				int tuples = statement.executeUpdate( "INSERT INTO PURCHASE_ORDER VALUES (" + sourceId + ", '" + orderDeliverySource + "',"+ partId + ", "+ ft.format(dNow) + ","+ quantity +", " + index + ", 'PENDING' , " + scId + " )" );
				if ( tuples != 1 )
					System.out.println ( "Unable to place order Table." );
			} catch ( SQLException e ) {
				System.out.println( "Unabel to access User Login Table : " + e.getMessage() );
				e.printStackTrace();
			}
			
			
		} catch ( SQLException e ) {
			System.out.println( "Unabel to access Inventory table : " + e.getMessage() );
			e.printStackTrace();
		}
		
		
		
		
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
