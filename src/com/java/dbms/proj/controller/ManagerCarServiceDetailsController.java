package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;

public class ManagerCarServiceDetailsController {
	public static void carServicDetails(Scanner input)  throws ClassNotFoundException, SQLException {
		com.java.dbms.proj.views.ManagerView.displayCarServiceDetails(); //Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		
		try {
			/* Find userName and userPassword match from 'LOGIN' table */
			resultSet = statement.executeQuery("SELECT * FROM VEHICLE_TYPE VT INNER JOIN MAINTENANCE M ON M.VID = VT.VID INNER JOIN SERVICE_TYPE_PARTS_MAPPING SPM ON SPM.TYPE_ID = M.TYPE_ID"
					+ "															LEFT JOIN EMPLOYEE_ADDRESS EA ON EA.EID = E.EID");
			
			/* If query returned a value */
			if (resultSet.next()) {
					// SHOULD GROUP BY AND CONCAT PARTS
					System.out.println();
					System.out.println();
					

				}
			}  catch (SQLException e) {
				System.out.println("Could'nt get the Employee details. " + e);
				e.printStackTrace();
			}
		//TODO dump the details in
		System.out.println("GET SERVICE DETAILS\n");
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Go Back");
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
