package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;

public class ManagerInvoicesController {
	public static void invoices(Scanner input)   throws ClassNotFoundException, SQLException{
		com.java.dbms.proj.views.ManagerView.displayInvoices(); //Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		
		try {
			/* Find userName and userPassword match from 'LOGIN' table */
			resultSet = statement.executeQuery("SELECT * APPOINTMENT A INNER JOIN CUSTOMER C ON C.CID = A.CID INNER JOIN INVOICE I ON I.APPOINTMENT_ID = A.APPOINTMENT_ID INNER JOIN TIMESLOT T ON T.SLOT_ID = A.SLOT_ID");
			
			/* If query returned a value */
			if (resultSet.next()) {
					System.out.println("Service ID : "+ resultSet.getString("SERVICE_ID"));
					System.out.println("Customer Name : "+ resultSet.getString("FIRSTNAME") + " "+ resultSet.getString("LASTNAME"));
					System.out.println("Start Time : "+ resultSet.getString("START_TIME"));
					System.out.println("End Time : "+ resultSet.getString("END_TIME"));
					System.out.println("Service Type : "+ resultSet.getString("SERVICE_TYPE"));
					System.out.println("License Plate : "+ resultSet.getString("VEHICLE_LICENSE"));
					System.out.println("Mechanic Name : "+ resultSet.getString("MECHANIC"));
					System.out.println("Service Center : "+ resultSet.getString("ITEMIZED_COST"));
			//TODO  System.out.println("Total labour hours : "+ resultSet.getString("START_DATE"));
			//		System.out.println("Labour wages per hour : "+ resultSet.getString("START_DATE"));
					System.out.println("Role : "+ resultSet.getString("TOTAL_COST"));
					System.out.println();
					System.out.println();
					

				}
			}  catch (SQLException e) {
				System.out.println("Could'nt get the Employee details. " + e);
				e.printStackTrace();
			}
		//TODO dump in details
		System.out.println("GET INVOICE DETAILS\n");
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Go Back" );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
