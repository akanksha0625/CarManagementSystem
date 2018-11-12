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
		
		try {
			/* Display all the notifications for the manager*/
			resultSet = statement.executeQuery("SELECT * FROM NOTIFICATION");
			
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
			
			try {
				/* Find the required Purchase Order */
				resultSet = statement.executeQuery("SELECT PO.ORDER_ID, PO.ORDER_DATE, P.PART_NAME, PO.ORDER_STATUS, PO.PART_QUANTITY, PO.SOURCE_TYPE, PO.SOURCE_ID, PO.SC_ID, SC.SC_NAME AS PURCHASER_NAME FROM PURCHASE_ORDER PO INNER JOIN SERVICE_CENTER SC ON SC.SC_ID = PO.SC_ID INNER JOIN PARTS P ON P.PART_ID = PO.PART_ID WHERE ORDER_ID = "+ response); // RESOLVE SC_ID COLUMN
				
				/* If query returned a value */
				if (resultSet.next()) {
					String sourceType, supplierName ="";
					sourceType = resultSet.getString("SOURCE_TYPE");
					float unitPrice=0, partQty = 0;
					
					if(sourceType.equals("ACME")) {
							try {
									resultSet1 = statement.executeQuery("SELECT * FROM ACME_INVENTORY AI INNER JOIN SERVICE_CENTER SC ON SC_ID = AI.SC_ID WHERE PART_ID = "+ resultSet.getString("PART_ID") + " AND AI.SC_ID = "+ resultSet.getString("SOURCE_ID"));
									resultSet1.next();
									supplierName = resultSet1.getString("SC_NAME");
									unitPrice = Float.parseFloat(resultSet1.getString("UNIT_PRICE"));
									partQty =  Float.parseFloat(resultSet.getString("PART_QUANTITY"));
	
							} catch (SQLException e) {
								System.out.println("Could'nt get the Purchaser details. " + e);
								e.printStackTrace();
							}
					} else {
							try {
								resultSet1 = statement.executeQuery("SELECT * FROM SUPPLIER_INVENTORY SI WHERE PART_ID = "+ resultSet.getString("PART_ID") + " AND SUPPLIER_ID = "+ resultSet.getString("SOURCE_ID"));
								resultSet1.next();
								supplierName = resultSet1.getString("SUPPLIER_NAME");
								unitPrice = Float.parseFloat(resultSet1.getString("UNIT_PRICE"));
								partQty =  Float.parseFloat(resultSet.getString("PART_QUANTITY"));
	
						} catch (SQLException e) {
							System.out.println("Could'nt get the Purchaser details. " + e);
							e.printStackTrace();
						}
					}
					System.out.println("Order_Id : "+ resultSet.getString("ORDER_ID"));
					System.out.println("Date : "+ resultSet.getString("ORDER_DATE"));
					System.out.println("Part Name : "+ resultSet.getString("PART_NAME"));
					System.out.println("Supplier Name : "+ supplierName);
					System.out.println("Purchase Name : "+ resultSet.getString("PURCHASER_NAME"));
					System.out.println("Quantity : "+ partQty);
					System.out.println("Unit Price : "+ unitPrice);
					System.out.println("Total Cost : "+ unitPrice * partQty);
					System.out.println("Order Status : "+ resultSet.getString("ORDER_STATUS"));
					System.out.println();
					System.out.println();		
				}
				}  catch (SQLException e) {
					System.out.println("Could'nt get the Order details. " + e);
					e.printStackTrace();
				}
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
