package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.views.ManagerView;
import com.java.dbms.proj.views.Notification;

public class ManagerNotificationsController {
	public static void notifications(Scanner input) throws ClassNotFoundException, SQLException {
		ManagerView.displayNotifications(); // Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet, resultSet1;
		float totalPrice;
		int orderId;

		try {
			/* Display all the notifications for the manager */
			resultSet = statement.executeQuery("SELECT * FROM NOTIFICATION WHERE SC_ID = '"
					+ ApplicationController.employee.getServiceCenterId() + "' AND SHOW = 1");

			/* If query returned a value */
			if (resultSet.next()) {

				System.out.println();
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Couldn't get the Notification details. " + e);
			e.printStackTrace();
			return;
		}

		System.out.println(
				"\tCurrent Notifications for Service Center : " + ApplicationController.employee.getServiceCenterId()
						+ "\n\tManaged by \"" + ApplicationController.employee.getFirstName() + "  "
						+ ApplicationController.employee.getLastName() + "");
		System.out.println("\t---------------------------------------------------------------\n");
		resultSet = statement.executeQuery(
				"SELECT * FROM NOTIFICATION,PURCHASE_ORDER WHERE NOTIFICATION.ORDER_ID = PURCHASE_ORDER.ORDER_ID AND NOTIFICATION.SC_ID = '"
						+ ApplicationController.employee.getServiceCenterId() + "'");
		
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		while(resultSet.next()) {
			Notification notification = new Notification();
			String dateCreated = resultSet.getString("DATE_CREATED");
			String year = dateCreated.split("-")[0];
			String month = dateCreated.split("-")[1];
			String day = dateCreated.split("-")[2];
			
			String timeCreated = resultSet.getString("TIME_CREATED");
			int hour = Integer.parseInt(timeCreated.split(":")[0]);
			int min = Integer.parseInt(timeCreated.split(":")[1]);
			String amPM = "";
			if(hour > 11) {
				amPM = "pm";
			}else {
				amPM = "am";
			}
			
			notification.setNotificationID(resultSet.getString("NOTIFICATION_ID"));
			notification.setNotificationDate(HelperFunctions.translateBack(day + "-" + month + "-" + year));
			notification.setOrderID(resultSet.getString("ORDER_ID"));
			notification.setNotificationTime(hour + ":" + min + " " + amPM);
			notification.setSupplierID(resultSet.getString("SOURCE_ID"));
			notification.setSupplierType(resultSet.getString("SOURCE_TYPE"));
			notifications.add(notification);
		}
		
		for(int i = 0; i < notifications.size(); i++) {
			if(notifications.get(i).getSupplierType().equalsIgnoreCase("supplier")) {
				resultSet = statement.executeQuery("SELECT SUPPLIER_NAME FROM SUPPLIER_INVENTORY WHERE SUPPLIER_ID = '" + notifications.get(i).getSupplierID() + "'");
				if(resultSet.next())
					notifications.get(i).setSupplierName(resultSet.getString("SUPPLIER_NAME"));
			} else {
				resultSet = statement.executeQuery("SELECT SC_NAME FROM SERVICE_CENTER WHERE SC_ID = '" + notifications.get(i).getSupplierID() + "'");
				if(resultSet.next())
					notifications.get(i).setSupplierName(resultSet.getString("SC_NAME"));
			}
		}
		
		for(int i = 0; i < notifications.size(); i++) {
			System.out.println(notifications.get(i).toString());
		}

		System.out.println("\nPlease select from the following user options:");
		System.out.println("\tEnter '1' to	Order ID");
		System.out.println("\tEnter '2' to	Go Back");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		} while (!userInput.equals("1") && !userInput.equals("2"));

		if (userInput.equals("1")) {
			System.out.print("\nWhat Order ID would you like to view? : ");
			String response = input.nextLine();
			System.out.println();

			orderId = Integer.parseInt(response);
			DecimalFormat df = new DecimalFormat("#.00");
			try {
				/* Get all order details */
				resultSet = statement.executeQuery(
						"(SELECT PO.ORDER_STATUS, PO.ORDER_ID, PO.ORDER_DATE, P.PART_NAME, SC.SC_NAME AS PURCHASER_NAME, SI.UNIT_COST, PO.PART_QUANTITY, SI.SUPPLIER_NAME AS SUPPLIER_NAME FROM PURCHASE_ORDER PO INNER JOIN SERVICE_CENTER SC ON SC.SC_ID = PO.SC_ID INNER JOIN PARTS P ON PO.PART_ID = P.PART_ID INNER JOIN SUPPLIER_INVENTORY SI ON SI.SUPPLIER_ID = PO.SOURCE_ID WHERE PO.SOURCE_TYPE = 'SUPPLIER' AND SI.PART_ID = PO.PART_ID AND PO.ORDER_ID = "
								+ orderId
								+ " ) UNION (SELECT PO.ORDER_STATUS, PO.ORDER_ID, PO.ORDER_DATE, P.PART_NAME, SC.SC_NAME AS PURCHASER_NAME, AI.UNIT_COST, PO.PART_QUANTITY, SC2.SC_NAME AS SUPPLIER_NAME FROM PURCHASE_ORDER PO INNER JOIN SERVICE_CENTER SC ON SC.SC_ID = PO.SC_ID INNER JOIN PARTS P ON PO.PART_ID = P.PART_ID INNER JOIN ACME_INVENTORY AI ON AI.SC_ID = PO.SOURCE_ID INNER JOIN SERVICE_CENTER SC2 ON SC2.SC_ID = AI.SC_ID WHERE PO.SOURCE_TYPE = 'ACME' AND AI.PART_ID = PO.PART_ID AND PO.ORDER_ID = "
								+ orderId + ")");
				/* If query returned a value */
				while (resultSet.next()) {
					String[] date = resultSet.getDate("ORDER_DATE").toString().split(" ");
					String year = date[0].split("-")[0];
					String month = date[0].split("-")[1];
					String day = date[0].split("-")[2];

					totalPrice = Float.parseFloat(resultSet.getString("PART_QUANTITY"))
							* Float.parseFloat(resultSet.getString("UNIT_COST"));
					System.out.println("\t-----------------------------------------------------");
					System.out.println("\tOrder_Id      : " + resultSet.getString("ORDER_ID"));
					System.out.println("\t-----------------------------------------------------");
					System.out.println(
							"\tDate          : " + HelperFunctions.translateBack(day + "-" + month + "-" + year));
					System.out.println("\tPart Name     : " + resultSet.getString("PART_NAME"));
					System.out.println("\tSupplier Name : " + resultSet.getString("SUPPLIER_NAME"));
					System.out.println("\tPurchase Name : " + resultSet.getString("PURCHASER_NAME"));
					System.out.println("\tQuantity      : " + df.format(resultSet.getDouble("PART_QUANTITY")));
					System.out.println("\tUnit Price    : $" + df.format(resultSet.getDouble("UNIT_COST")));
					System.out.println("\tTotal Cost    : $" + df.format(totalPrice));
					System.out.println("\tOrder Status  : " + resultSet.getString("ORDER_STATUS"));
					System.out.println();
					System.out.println();
				}
			} catch (SQLException e) {
				System.out.println("Could'nt get the Order details. " + e);
				e.printStackTrace();
			}

			ManagerView.displayNotificationsDetail(); // Display new page header

			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to	Go Back");

			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			} while (!userInput.equals("1"));

		}
	}
}
