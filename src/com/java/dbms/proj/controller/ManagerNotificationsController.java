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
		ResultSet resultSet, resultSet1;
		float totalPrice;
		int orderId;
		
		try {
			/* Display all the notifications for the manager*/
			resultSet = statement.executeQuery("SELECT * FROM NOTIFICATION WHERE SC_ID = '"+  ApplicationController.employee.getServiceCenterId() + "' AND SHOW = 1");
			
			/* If query returned a value */
			if (resultSet.next()) {
					
					System.out.println();
					System.out.println();			
				}
			}  catch (SQLException e) {
				System.out.println("Could'nt get the Notification details. " + e);
				e.printStackTrace();
			}
		//TODO display notifications
		System.out.println("DISPLAY NOTIFICATIONS Here (Incomplete)\n");
		
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
			String response = input.nextLine();
			//TODO add logic to check for correct order ID
			
			orderId = Integer.parseInt(response);
			try {
				/* Get all order details */
				resultSet = statement.executeQuery("(SELECT PO.ORDER_STATUS, PO.ORDER_ID, PO.ORDER_DATE, P.PART_NAME, SC.SC_NAME AS PURCHASER_NAME, SI.UNIT_COST, PO.PART_QUANTITY, SI.SUPPLIER_NAME AS SUPPLIER_NAME FROM PURCHASE_ORDER PO INNER JOIN SERVICE_CENTER SC ON SC.SC_ID = PO.SC_ID INNER JOIN PARTS P ON PO.PART_ID = P.PART_ID INNER JOIN SUPPLIER_INVENTORY SI ON SI.SUPPLIER_ID = PO.SOURCE_ID WHERE PO.SOURCE_TYPE = 'SUPPLIER' AND SI.PART_ID = PO.PART_ID AND PO.ORDER_ID = "+ orderId +" ) UNION (SELECT PO.ORDER_STATUS, PO.ORDER_ID, PO.ORDER_DATE, P.PART_NAME, SC.SC_NAME AS PURCHASER_NAME, AI.UNIT_COST, PO.PART_QUANTITY, SC2.SC_NAME AS SUPPLIER_NAME FROM PURCHASE_ORDER PO INNER JOIN SERVICE_CENTER SC ON SC.SC_ID = PO.SC_ID INNER JOIN PARTS P ON PO.PART_ID = P.PART_ID INNER JOIN ACME_INVENTORY AI ON AI.SC_ID = PO.SOURCE_ID INNER JOIN SERVICE_CENTER SC2 ON SC2.SC_ID = AI.SC_ID WHERE PO.SOURCE_TYPE = 'ACME' AND AI.PART_ID = PO.PART_ID AND PO.ORDER_ID = "+ orderId +")");	
				/* If query returned a value */
				while (resultSet.next()) {
						totalPrice = Float.parseFloat(resultSet.getString("PART_QUANTITY"))* Float.parseFloat(resultSet.getString("UNIT_COST"));
						System.out.println("Order_Id : "+ resultSet.getString("ORDER_ID"));
						System.out.println("Date : "+ resultSet.getString("ORDER_DATE"));
						System.out.println("Part Name : "+ resultSet.getString("PART_NAME"));
						System.out.println("Supplier Name : "+ resultSet.getString("SUPPLIER_NAME"));
						System.out.println("Purchase Name : "+ resultSet.getString("PURCHASER_NAME"));
						System.out.println("Quantity : "+ resultSet.getString("PART_QUANTITY"));
						System.out.println("Unit Price : "+ resultSet.getString("UNIT_COST"));
						System.out.println("Total Cost : "+ totalPrice);
						System.out.println("Order Status : "+ resultSet.getString("ORDER_STATUS"));
						System.out.println();
						System.out.println();	
					}
				}  catch (SQLException e) {
					System.out.println("Could'nt get the Order details. " + e);
					e.printStackTrace();
				}
			
			ManagerView.displayNotificationsDetail(); //Display new page header
			
			System.out.println( "Please select from the following user options:" );
			System.out.println( "\tEnter '1' to	Go Back" );
			
			do {
				System.out.print( "\nOption Selection : " );
				userInput = input.nextLine();
			}while( !userInput.equals( "1" ) );
			
		}
	}
}
