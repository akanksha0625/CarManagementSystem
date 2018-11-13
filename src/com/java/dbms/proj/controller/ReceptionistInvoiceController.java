package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Part;
import com.java.dbms.proj.entities.Service;

public class ReceptionistInvoiceController {
	public static void invoice(Scanner input) {
		
		com.java.dbms.proj.views.ReceptionistView.displayInvoice(); //Display page header
		
		/* Necessary Variables for SQL Transactions */
		Statement statement = null;
		ResultSet resultSet;
		String userInput = "";
		Service service = null;
		
		try {
			
			statement = DBFacade.getConnection().createStatement();
			
			System.out.println ( "\nEnter the email of the customer invoice that you would like to search : " );
			userInput = input.nextLine();
			
			resultSet = statement.executeQuery( "SELECT * FROM CUSTOMER WHERE EMAIL = '" + userInput + "'" );
			if ( resultSet.next() ) {
				service = new Service();

				int customerID = resultSet.getInt("CID");
				resultSet = statement.executeQuery( "SELECT * FROM APPOINTMENT WHERE CUSTOMER_ID = '" + customerID + "'" );
				if ( resultSet.next() ) {

					int appointmentID = resultSet.getInt( "APPOINTMENT_ID" );
					service.setServiceID( resultSet.getString( "SERVICE_ID" ) );
					service.setStartDate( resultSet.getString( "APPOINTMENT_DATE" ) );
					service.setServiceType( resultSet.getString( "SERVICE_TYPE" ) );			
					service.setLicense( resultSet.getString( "VEHICLE_LICENSE" ) );

					resultSet = statement.executeQuery( "SELECT * FROM TIME_SLOT WHERE APPOINTMENT_ID = '" + appointmentID + "'" );
					if(resultSet.next()) {
						service.setStartTime( resultSet.getString( "START_TIME" ) );
						service.setEndTime( resultSet.getString( "START_TIME" ) );
						service.setMechanic( resultSet.getString( "MECHANIC" ) );
						
						if(service.getServiceType().equalsIgnoreCase("repair")) {
							resultSet = statement.executeQuery( "SELECT REPAIR_ID FROM REPAIR WHERE APPOINTMENT_ID = '" + appointmentID + "'" );
							if(resultSet.next()) {
								resultSet = statement.executeQuery( "SELECT * FROM " + resultSet.getString( "REPAIR_ID" ) );
								while(resultSet.next()) {
									service.addPart(new Part(resultSet.getString("PART_NAME"), resultSet.getInt("PART_ID") ) );
								}
							} else {
								System.out.println("There are no parts associated with this Appointment : " + appointmentID );
							}
						} else {
							resultSet = statement.executeQuery( "SELECT TYPE_ID FROM MAINTENANCE WHERE VID = '" + service.getLicense() + "'" );
							if(resultSet.next()) {
								resultSet = statement.executeQuery( "SELECT * FROM " + resultSet.getString( "TYPE_ID" ) );
								while(resultSet.next()) {
									service.addPart(new Part(resultSet.getString("PART_NAME"), resultSet.getInt("PART_ID") ) );
								}
							} else {
								System.out.println("There are no parts associated with this Appointment : " + appointmentID );
							}
						}
						
						
						String[] splitStart1 = service.getStartTime().split( ":", 2 );
						String[] splitStart2 = splitStart1[1].split( " ", 2 );
						int hourStart = Integer.parseInt(splitStart1[ 0 ]);
						int minStart = Integer.parseInt(splitStart2[ 0 ]);
						int xmStart = Integer.parseInt(splitStart2[ 1 ]);
						
						String[] splitEnd1 = service.getEndTime().split( ":", 2 );
						String[] splitEnd2 = splitStart1[1].split( " ", 2 );
						int hourEnd = Integer.parseInt(splitEnd1[ 0 ]);
						int minEnd = Integer.parseInt(splitEnd2[ 0 ]);
						int xmEnd = Integer.parseInt(splitEnd2[ 1 ]);
						
						int totalMins = (minEnd - minEnd) / 60;
						int totalHours = (minEnd + minStart) % 60 + (hourEnd - hourStart) ;
						
						service.setTotalLaborHours(totalHours + ":" + totalMins);
						
						//TODO cost per hour
						//TODO cost total
					} else {
						System.out.println ("There are no Times associated with this Appointment : " + appointmentID );
					}
						
				} else {
					System.out.println ( "There are no appointments associated with the customer ID : " + customerID );
				}
			} else {
				System.out.println ( "There is no Customer associated with the given email." );
			}
		} catch (SQLException e) { System.out.println( "Error in acquiring the database connection : " + e.getMessage() ); }
			
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back");
		
		userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}
}
