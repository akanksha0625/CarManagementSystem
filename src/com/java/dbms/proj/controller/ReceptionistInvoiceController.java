package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
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
			
			/* Find Customer */
			resultSet = statement.executeQuery( "SELECT * FROM CUSTOMER WHERE EMAIL = '" + userInput + "'" );
			if ( resultSet.next() ) {
				service = new Service();

				/* Find Customer Appointment */
				int customerID = resultSet.getInt("CID");
				resultSet = statement.executeQuery( "SELECT * FROM APPOINTMENT WHERE CUSTOMER_ID = '" + customerID + "'" );
				if ( resultSet.next() ) {

					service.setServiceID( resultSet.getString( "APPOINTMENT_ID" ) );
					service.setStartDate( resultSet.getString( "APPOINTMENT_DATE" ) );
					service.setServiceType( resultSet.getString( "SERVICE_TYPE" ) );			
					service.setLicense( resultSet.getString( "VEHICLE_LICENSE" ) );

					/* Find Time Slot of Appointment */
					resultSet = statement.executeQuery( "SELECT * FROM TIME_SLOT WHERE APPOINTMENT_ID = '" + service.getServiceID() + "'" );
					if(resultSet.next()) {
						service.setStartTime( resultSet.getString( "START_TIME" ) );
						service.setEndTime( resultSet.getString( "END_TIME" ) );
						service.setMechanic( resultSet.getString( "MECHANIC" ) );
						
						if(service.getServiceType().equalsIgnoreCase("repair")) {
							/* Get Repair Details */
							resultSet = statement.executeQuery( "SELECT REPAIR_ID FROM REPAIR WHERE APPOINTMENT_ID = '" + service.getServiceID() + "'" );
							if(resultSet.next()) {
								resultSet = statement.executeQuery("SELECT * FROM REPAIR_DETAILS INNER JOIN REPAIR " + 
														 "ON REPAIR_DETAILS.REPAIR_TYPE = REPAIR.REPAIR_TYPE");
								if(resultSet.next()) {
									service.setServiceDescription(resultSet.getString("REPAIR_NAME"));
									service.setDiagnosis(resultSet.getString("DIAGNOSIS"));
									service.setServiceAbrev(resultSet.getString("REPAIR_TYPE"));
									service.setCostPerHour(resultSet.getDouble("HOURLY_RATE"));
								}
								//TODO parts????
							} else {
								System.out.println("There are no repair details associated with this Appointment : " + service.getServiceID() );
							}
						} else {
							/* Get Maintenance Details */
							resultSet = statement.executeQuery( "SELECT * FROM VEHICLE INNER JOIN REPAIR_DETAILS " + 
									 						    "ON REPAIR_DETAILS.MAKE = VEHICLE.MAKE && REPAIR_DETAILS.MODEL = VEHICLE.MODEL" );
								if(resultSet.next()) {
									service.setServiceDescription(resultSet.getString(service.getServiceType()));
									//service.setCostPerHour(resultSet.getDouble("HOURLY_RATE"));
								} else {
								System.out.println("There are no maintenance details associated with this Appointment : " + service.getServiceID() );
							}
						}
						
						
						String[] splitStart1 = service.getStartTime().split( ":", 2 );
						String[] splitStart2 = splitStart1[1].split( " ", 2 );
						int hourStart = Integer.parseInt(splitStart1[ 0 ]);
						int minStart = Integer.parseInt(splitStart2[ 0 ]);
						String xmStart = splitStart2[ 1 ];
						
						String[] splitEnd1 = service.getEndTime().split( ":", 2 );
						String[] splitEnd2 = splitStart1[1].split( " ", 2 );
						int hourEnd = Integer.parseInt(splitEnd1[ 0 ]);
						int minEnd = Integer.parseInt(splitEnd2[ 0 ]);
						String xmEnd = splitEnd2[ 1 ];
						
						int totalMins = (minEnd - minEnd) / 60;
						int totalHours = (minEnd + minStart) % 60 + (hourEnd - hourStart) ;
						
						service.setTotalLaborHours(totalHours + ":" + totalMins);
						
						//TODO cost per hour
						//TODO cost total
					} else {
						System.out.println ("There are no Times associated with this Appointment : " + service.getServiceID() );
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
