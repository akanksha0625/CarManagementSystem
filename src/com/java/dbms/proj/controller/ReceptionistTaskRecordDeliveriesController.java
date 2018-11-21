package com.java.dbms.proj.controller;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.Notification;
import com.java.dbms.proj.entities.NotificationDetail;
import com.java.dbms.proj.entities.PurchaseOrder;
import com.java.dbms.proj.entities.Service;

public class ReceptionistTaskRecordDeliveriesController {
	public static void recordDeliveries(Scanner input) throws ClassNotFoundException, SQLException, ParseException {
		com.java.dbms.proj.views.ReceptionistView.displayTaskUpdateDeliveries(); //Display page header
		
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet, inventoryResult, sequenceResult;
		
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
			
			ArrayList<PurchaseOrder> purchaseOrder = new ArrayList<PurchaseOrder>();

				try {
					resultSet = statement.executeQuery( "SELECT * FROM PURCHASE_ORDER WHERE ORDER_ID IN (" + temp + ") AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "' AND ORDER_STATUS != 'DELIVERED'" );
					while(resultSet.next()) {
						PurchaseOrder order = null;
						order = new PurchaseOrder();
						
						order.setPartID(Integer.parseInt(resultSet.getString("PART_ID")));
						order.setOrderID(Integer.parseInt(resultSet.getString("ORDER_ID")));
						order.setSourceType(resultSet.getString("SOURCE_TYPE"));
						order.setSourceID(resultSet.getString("SOURCE_ID"));
						order.setPartQuantity(Integer.parseInt(resultSet.getString("PART_QUANTITY")));
						purchaseOrder.add(order);

					}
					
					if (purchaseOrder.size() == 0) {
						System.out.println("There are no Orders associationed with the given inputs.\n");
					}
					
					for (int index = 0; index < purchaseOrder.size(); index++) {
						tuples= statement.executeUpdate("UPDATE ACME_INVENTORY SET CURRENT_QUANTITY = CURRENT_QUANTITY + "+ purchaseOrder.get(index).getPartQuantity() +" WHERE PART_ID = "+ purchaseOrder.get(index).getPartID() +" AND SC_ID = '"+ ApplicationController.employee.getServiceCenterId() + "'");
					}
					
					for (int index = 0; index < purchaseOrder.size(); index++) {
						if(purchaseOrder.get(index).getSourceType().equals("ACME")) {
							tuples= statement.executeUpdate("UPDATE ACME_INVENTORY SET CURRENT_QUANTITY = CURRENT_QUANTITY - "+ purchaseOrder.get(index).getPartQuantity() +" WHERE PART_ID = "+ purchaseOrder.get(index).getPartID() +" AND SC_ID = '"+ purchaseOrder.get(index).getSourceID() + "'");
						}
					}
					
					tuples= statement.executeUpdate("UPDATE PURCHASE_ORDER SET ORDER_STATUS = 'DELIVERED' WHERE ORDER_ID IN (" + temp + ") AND ORDER_STATUS != 'DELIVERED' AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "'");
					System.out.println(tuples + " Purchase orders Updated. ");
					 
				}catch (SQLException e) {
					System.out.println( "Cannot Access Orders. " + e );
					e.printStackTrace();
				}
			
			/*
			
			System.out.print ( "\nAfter input : ");

			try {
				resultSet = statement.executeQuery( "SELECT * FROM PURCHASE_ORDER WHERE ORDER_ID IN (" + temp + ") AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "' AND ORDER_STATUS != 'DELIVERED'" );
				while(resultSet.next()) {
					System.out.print ( "\nInside while : ");
					tuples= statement.executeUpdate("UPDATE ACME_INVENTORY SET CURRENT_QUANTITY = CURRENT_QUANTITY + "+ resultSet.getString("PART_QUANTITY") +" WHERE PART_ID = "+ resultSet.getString("PART_ID") +" AND SC_ID = '"+ resultSet.getString("SC_ID") + "'");
					System.out.println( "\n After first upadte");

					if(resultSet.getString("SOURCE_TYPE").equals("ACME")) {
						System.out.print ( "\nInside if to check for acme inv: ");
						tuples= statement.executeUpdate("UPDATE ACME_INVENTORY SET CURRENT_QUANTITY = CURRENT_QUANTITY - "+ resultSet.getString("PART_QUANTITY") +" WHERE PART_ID = "+ resultSet.getString("PART_ID") +" AND SC_ID = '"+ resultSet.getString("SOURCE_ID") + "'");
					}
				}
				System.out.print ( "\nAfter while loop : ");


			}catch (SQLException e) {
				System.out.println( "Cannot Access Orders. " + e );
				e.printStackTrace();
			}

			System.out.print ( "\nAfter the update of inventory : ");

			try {
				 tuples= statement.executeUpdate("UPDATE PURCHASE_ORDER SET ORDER_STATUS = 'DELIVERED' WHERE ORDER_ID IN (" + temp + ") AND ORDER_STATUS != 'DELIVERED' AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "'");
				 System.out.println(tuples + " Purchase orders Updated. ");
			}catch (SQLException e) {
				System.out.println( "System Query Error : Cannot Update orders. " + e );
				e.printStackTrace();
			}
			*/
		}
	
		//TODO change status of pending orders to delayed check details and notify manager
		System.out.println("CHANGING PENDING TO DELAYED & CREATE MANAGER NOTIFICATION");
		System.out.println("CHANGING NOTIFICATION TABLE SHOW TO FALSE FOR DELIVERED DELIVERIES");

		
		try {
			//set arrived order notification show to 1
			resultSet = statement.executeQuery("SELECT * FROM PURCHASE_ORDER PO INNER JOIN NOTIFICATION N ON N.ORDER_ID = PO.ORDER_ID WHERE PO.ORDER_STATUS = 'DELIVERED' AND N.SHOW = 1 AND PO.SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "'");	
			ArrayList<Integer> notificationList = new ArrayList<Integer>();
			while(resultSet.next()) {
				notificationList.add(Integer.parseInt(resultSet.getString("NOTIFICATION_ID")));
			}
			for (int index = 0; index < notificationList.size(); index++) {
				tuples = statement.executeUpdate("UPDATE NOTIFICATION SET SHOW = 1 WHERE NOTIFICATION_ID = '" + notificationList.get(index));	
			}

			
			// set delayed deliveries as DELAYED
			resultSet = statement.executeQuery("(SELECT SI.DELIVERY_WINDOW, PO.ORDER_STATUS, PO.ORDER_ID, PO.ORDER_DATE, P.PART_NAME, SC.SC_NAME AS PURCHASER_NAME, SI.UNIT_COST, PO.PART_QUANTITY, SI.SUPPLIER_NAME AS SUPPLIER_NAME FROM PURCHASE_ORDER PO INNER JOIN SERVICE_CENTER SC ON SC.SC_ID = PO.SC_ID INNER JOIN PARTS P ON PO.PART_ID = P.PART_ID INNER JOIN SUPPLIER_INVENTORY SI ON SI.SUPPLIER_ID = PO.SOURCE_ID WHERE PO.SOURCE_TYPE = 'SUPPLIER'AND PO.SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "' AND ORDER_STATUS != 'DELIVERED') UNION (SELECT AI.DELIVERY_WINDOW, PO.ORDER_STATUS, PO.ORDER_ID, PO.ORDER_DATE, P.PART_NAME, SC.SC_NAME AS PURCHASER_NAME, AI.UNIT_COST, PO.PART_QUANTITY, SC2.SC_NAME AS SUPPLIER_NAME FROM PURCHASE_ORDER PO INNER JOIN SERVICE_CENTER SC ON SC.SC_ID = PO.SC_ID INNER JOIN PARTS P ON PO.PART_ID = P.PART_ID INNER JOIN ACME_INVENTORY AI ON AI.SC_ID = PO.SOURCE_ID INNER JOIN SERVICE_CENTER SC2 ON SC2.SC_ID = AI.SC_ID WHERE PO.SOURCE_TYPE = 'ACME' AND AI.PART_ID = PO.PART_ID AND PO.SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "' AND ORDER_STATUS != 'DELIVERED')");	
			ArrayList<NotificationDetail> notification = new ArrayList<NotificationDetail>();
			
			Date currDate = new Date();
		    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			while(resultSet.next()) {
				NotificationDetail order = null;
				order = new NotificationDetail();
				String orderDate="";
				
				order.setOrderID(Integer.parseInt(resultSet.getString("ORDER_ID")));
				orderDate=resultSet.getString("ORDER_DATE");
				order.setOrderDate(formatter.parse(orderDate));
				order.setDeliveryWindow(Integer.parseInt(resultSet.getString("DELIVERY_WINDOW")));
				notification.add(order);
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(order.getOrderDate());
				calendar.add(Calendar.DAY_OF_YEAR, order.getDeliveryWindow());
				Date deliveryDate= calendar.getTime();
				order.setOrderDate(deliveryDate);
				
						
				for (int index = 0; index < notification.size(); index++) {
					if(order.getOrderDate().compareTo(currDate)>0) {
						tuples= statement.executeUpdate("UPDATE PURCHASE_ORDER SET ORDER_STATUS = 'DELAYED' WHERE ORDER_STATUS != 'DELIVERED' AND ORDER_ID = '" + notification.get(index).getOrderID() + "'");
					}
				}
				
				for (int index = 0; index < notification.size(); index++) {
					if(true) {
						sequenceResult = statement.executeQuery( "SELECT NOTIFICATION_SEQ.nextVal FROM dual");

						int notificationIndex = 0;
						if (order.getOrderDate().compareTo(currDate)>0) {
							notificationIndex = sequenceResult.getInt( "NEXTVAL" );
						}

						tuples = statement.executeUpdate( "INSERT INTO NOTIFICATION VALUES (" + notificationIndex + ", '" + java.time.LocalDate.now() + "',"+ notification.get(index).getOrderID() + ", '"+ ApplicationController.employee.getServiceCenterId() +"', 1 , '" + java.time.LocalTime.now() + "'" );
					}
				}

			}
		}catch (SQLException e) {
			System.out.println( "System Query Error : Cannot Update orders. " + e );
			e.printStackTrace();
		}
		
		
		
	}
}
