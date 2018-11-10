package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;

public class EmployeeViewProfileController {
	
	public static void viewProfile( Scanner input )  throws ClassNotFoundException, SQLException{
		
		com.java.dbms.proj.views.EmployeeView.displayViewProfile(); //Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		
		try {
			/* Find userName and userPassword match from 'LOGIN' table */
			resultSet = statement.executeQuery("SELECT E.EID, SC.SC_NAME, E.FIRSTNAME, E.LASTNAME, EA.STREET, EA.CITY, EA.STATE, E.EMAIL, E.PHONE, E.ROLE, E.START_DATE FROM SERVICE_CENTER SC INNER JOIN EMPLOYEE E ON E.SC_ID = SC.SC_ID "
					+ "															LEFT JOIN EMPLOYEE_ADDRESS EA ON EA.EID = E.EID");
			
			/* If query returned a value */
			if (resultSet.next()) {
					System.out.println("Employee ID : "+ resultSet.getString("EID"));
					System.out.println("Address : "+ resultSet.getString("STREET") + ", "+ resultSet.getString("CITY") + ", "+ resultSet.getString("STATE"));
					System.out.println("Name : "+ resultSet.getString("FIRSTNAME") + " "+ resultSet.getString("LASTNAME"));
					System.out.println("Email : "+ resultSet.getString("EMAIL"));
					System.out.println("Phone Number : "+ resultSet.getString("PHONE"));
					System.out.println("Service Center : "+ resultSet.getString("SC_NAME"));
					System.out.println("Role : "+ resultSet.getString("ROLE"));
					System.out.println("Start Date : "+ resultSet.getString("START_DATE"));
					System.out.println();
					System.out.println();
					

				}
			}  catch (SQLException e) {
				System.out.println("Could'nt get the Employee details. " + e);
				e.printStackTrace();
			}
		
		//TODO call the controller to drop employee info into this view
		System.out.println("INSERT EMPLOYEE PROFILE DETAILS\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back." );

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}

}
