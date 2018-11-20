package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;

public class ManagerOrderHistoryController {
	public static void orderHistory(Scanner input) throws ClassNotFoundException, SQLException {
		com.java.dbms.proj.views.ManagerView.displayOrderHistory(); // Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		float totalPrice = 0;

		try {
			DecimalFormat df = new DecimalFormat("#.00");
			/* Get all order details */

			resultSet = statement.executeQuery("(SELECT PO.ORDER_STATUS, PO.ORDER_ID, PO.ORDER_DATE, P.PART_NAME, SC.SC_NAME AS PURCHASER_NAME, SI.UNIT_COST, PO.PART_QUANTITY, SI.SUPPLIER_NAME AS SUPPLIER_NAME FROM PURCHASE_ORDER PO INNER JOIN SERVICE_CENTER SC ON SC.SC_ID = PO.SC_ID INNER JOIN PARTS P ON PO.PART_ID = P.PART_ID INNER JOIN SUPPLIER_INVENTORY SI ON SI.SUPPLIER_ID = PO.SOURCE_ID WHERE PO.SOURCE_TYPE = 'SUPPLIER'AND PO.SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "') UNION (SELECT PO.ORDER_STATUS, PO.ORDER_ID, PO.ORDER_DATE, P.PART_NAME, SC.SC_NAME AS PURCHASER_NAME, AI.UNIT_COST, PO.PART_QUANTITY, SC2.SC_NAME AS SUPPLIER_NAME FROM PURCHASE_ORDER PO INNER JOIN SERVICE_CENTER SC ON SC.SC_ID = PO.SC_ID INNER JOIN PARTS P ON PO.PART_ID = P.PART_ID INNER JOIN ACME_INVENTORY AI ON AI.SC_ID = PO.SOURCE_ID INNER JOIN SERVICE_CENTER SC2 ON SC2.SC_ID = AI.SC_ID WHERE PO.SOURCE_TYPE = 'ACME' AND AI.PART_ID = PO.PART_ID AND PO.SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "')");	

			/* If query returned a value */
			while (resultSet.next()) {
				String[] date = resultSet.getDate("ORDER_DATE").toString().split(" ");
				String year = date[0].split("-")[0];
				String month = date[0].split("-")[1];
				String day = date[0].split("-")[2];
				totalPrice = Float.parseFloat(resultSet.getString("PART_QUANTITY"))
						* Float.parseFloat(resultSet.getString("UNIT_COST"));
				System.out.println("\t-----------------------------------------------------");
				System.out.println("\tOrder_Id : " + resultSet.getString("ORDER_ID"));
				System.out.println("\t-----------------------------------------------------");
				System.out
						.println("\tDate          : " + HelperFunctions.translateBack(day + "-" + month + "-" + year));
				System.out.println("\tPart Name     : " + resultSet.getString("PART_NAME"));
				System.out.println("\tSupplier Name : " + resultSet.getString("SUPPLIER_NAME"));
				System.out.println("\tPurchase Name : " + resultSet.getString("PURCHASER_NAME"));
				System.out.println("\tQuantity      : " + df.format(resultSet.getDouble("PART_QUANTITY")));
				System.out.println("\tUnit Price    : $" + df.format(resultSet.getDouble("UNIT_COST")));
				System.out.println("\tTotal Cost    : $" + df.format(totalPrice));
				System.out.println("\tOrder Status  : " + resultSet.getString("ORDER_STATUS"));
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Couldn't get the Order details. " + e);
			e.printStackTrace();
			return;
		}

		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		} while (!userInput.equals("1"));
	}

}
