package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;

public class ManagerAddEmployeeController {
	
	public static void addEmployee( Scanner input )  throws ClassNotFoundException, SQLException{
		com.java.dbms.proj.views.ManagerView.dsiplayAddEmployee(); //Display page header

		ResultSet resultSet;
		Statement statement;
		
		try {
			statement = DBFacade.getConnection().createStatement();
		} catch (SQLException e) {
			System.out.println("Unable to acquire a database connection : " + e.getMessage() );
			return;
		}
			
		String employeeID = "";
		String userName = "";
		String userPassword = "";
		String userInput = "";
		String manager_SC_ID = "";
		double compensation = 0;
		boolean attempt = false;
			
		/* Gather Employee details */
		System.out.println ("Please provide some information about your new employee so that we can get them set up in the system.\n");
			
		String email = "";
		do {
			/* Assign a unique userName */
			System.out.print ( "Please enter an Employee email : " );
			email = input.nextLine();
			try {
				resultSet = statement.executeQuery( "SELECT EMAIL FROM EMPLOYEE WHERE EMAIL = '" + email + "' " );
				if ( resultSet.next() ) {
					System.out.println ( "\nSorry, the email \"" + email +"\" already exists.\n" );
					email = "";
				}
			} catch ( SQLException e ) { 
				System.out.println( "Unable to access Employee Table : " + e.getMessage() ); 
			}	
		} while ( email.equals("") );
			
		System.out.print ( "\nEmployee Phone Contact : ");
		String phone = input.nextLine();
		
		System.out.print ( "\nEmployee First Name : ");

		String first = input.nextLine();
		
		System.out.print ( "\nEmployee Last Name : ");
		String last = input.nextLine();
		
		System.out.print( "\nEmployee Street Address : ");
		String address = input.nextLine();

		System.out.print ( "\nEmployee City : ");
		String city = input.nextLine();
		
		String state = "";
		do {
			System.out.print ( "\nEmployee State Abbreviation (ex: NC) : ");
			state = input.nextLine();
		} while ( state.length() > 2 || state.isEmpty() );
				
		System.out.print( "\nEmployee Zip Code : ");
		String zip =  input.nextLine();
		
	
		/* Assign Service Center ID*/
		try {
			resultSet = statement.executeQuery( "SELECT SC_ID FROM EMPLOYEE WHERE EMAIL = '" + ApplicationController.employee.getEmail() + "' " );
			
			if( resultSet.next() )
				manager_SC_ID = resultSet.getString("SC_ID");
				
		} catch (SQLException e) {
			System.out.println( "Unable to access Employee table : " + e.getMessage() );
		}
		
		do {
			/* Assign a unique userName */
			if( !attempt ) {
				userName = email.split("@")[0]; //try and assign the email as the username
			} else {
				System.out.print("\nPlease enter an employee username : ");
				userName = input.nextLine();
			}
			
			try {
				resultSet = statement.executeQuery( "SELECT USERNAME FROM Login WHERE username = '" + userName + "'" );
				if ( resultSet.next() ) {
					if(!attempt) {
						System.out.println("\nUnable to assign the email's local identifier \"" + userName + "\" as the Employee username.");
						System.out.println("This username already exists.");
						attempt = true;
						userName = "";
					} else {
						System.out.println ( "\nSorry, that username \"" + userName + "\" already exists." );
						userName = "";
					}
				}
			} catch ( SQLException e ) { 
				System.out.println( "Unable to access User Login Table : " + e.getMessage() ); 
			}	
		} while ( userName.equals("") );
		
		userPassword = "password123456"; //default employee password
		
		System.out.println ( "\nThank you the Employee information.\n" );
		System.out.println ( "Please select the type of employee you are registering:" );
		System.out.println ( "\tEnter '1' for Manager." );
		System.out.println ( "\tEnter '2' for Receptionist." );
		System.out.println ( "\tEnter '3' for Mechanic." );
	
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		} while ( !userInput.equals( "1" ) && !userInput.equals( "2" ) && !userInput.equals( "3" ) );
		
		String role = "";
		if(userInput.equals("1")) {
			role = "MANAGER";
		}else if(userInput.equals("2")) {
			role = "RECEPTIONIST";
		}else {
			role = "MECHANIC";
		}
		
		if(!userInput.equals("3")) {
			System.out.print("\nPlease enter the monthly compensation for this employee (i.e. 8000) : ");
			while(!input.hasNextDouble()) {
				System.out.println("Incorrect format");
				input.nextLine();
				System.out.print("\nPlease enter the monthly compensation for this employee (i.e. 8000) : ");
			}
			compensation = input.nextDouble();
		} else {
			System.out.print("\nPlease enter the hourly compensation for this employee (i.e. 8000) : ");
			while(!input.hasNextDouble()) {
				System.out.println("Incorrect format");
				input.nextLine();
				System.out.print("\nPlease enter the hourly compensation for this employee (i.e. 8000) : ");
			}
			compensation = input.nextDouble();
		}
		String startDate = "";
		input.nextLine();
		while (!startDate.matches("[0-1][0-9]-[0-3][0-9]-\\d\\d\\d\\d")) {
			System.out.print("\nPlease enter the Employee Start Date (i.e. mm-dd-yyyy) : ");
			startDate = input.nextLine();
		}
			
		/* Ask if manager would like to add or go back to the home page. */
		System.out.println ( "\nPlease select from the following user options:" );
		System.out.println ( "\tEnter '1' to Add." );
		System.out.println ( "\tEnter '2' to Go Back." );
	
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		} while ( !userInput.equals( "1" ) && !userInput.equals( "2" ) );
			
		if( userInput.equals( "2" ) )
			return; // Go Back to the previous page
		
		/* Insert user into the login table */
		try {
			statement.executeUpdate( "INSERT INTO LOGIN VALUES ('" + userName + "', '" + userPassword + "', '" + role + "', 'ACTIVE')" );
			
			/* Insert into Employee Table */
			try {
				//TODO need employee increment --> resultSet = statement.executeQuery( "SELECT customers_seq.nextval from dual" );
				//int index = 0;
				//if ( resultSet.next() ) {
				//	index = resultSet.getInt( "NEXTVAL" );
				//}
				
				statement.executeUpdate( "INSERT INTO EMPLOYEE VALUES ('25', '" + first + "', '" + last + "', '" + 
										 manager_SC_ID + "', '" + email + "', '" + phone + "', '" + role + "', '" + 
										 userName + "', '" + startDate + "')");
					
					/* Get employee id for address insertion */
					try {
						resultSet = statement.executeQuery( "SELECT EID FROM EMPLOYEE WHERE username = '" + userName + "'" );
						if( resultSet.next() )
							employeeID = resultSet.getString( "EID" );
						
						//TODO NEED resultSet = statement.executeQuery( "SELECT customerAddress_seq.nextval from dual" );
						//int increment = 0;
						//if ( resultSet.next() ) {
						//	index = resultSet.getInt( "NEXTVAL" );
						//}
						statement.executeUpdate( "INSERT INTO EMPLOYEE_ADDRESS VALUES ('25', '" + address + "', '" +
															     	  city + "', '" + state + "', '" + employeeID + "', '" + zip + "')");
						try {
							if(role.equals("MECHANIC")) {
								statement.executeUpdate( "INSERT INTO HOURLY_EMPLOYEE VALUES ('" + compensation + "', '" + employeeID + "')");
							} else {
								statement.executeUpdate( "INSERT INTO MONTHLY_EMPLOYEE VALUES ('" + compensation + "', '" + employeeID + "')");
							}
						} catch ( SQLException e ) {
							System.out.println( "Unable to access the Compensation table : " + e.getMessage() );
						}
					} catch ( SQLException e ) {
						System.out.println( "Unable to access the Employee Address table : " + e.getMessage() );
					}
			} catch ( SQLException e ) {
				System.out.println( "Unable to access Employee table : " + e.getMessage() );
			}
		} catch ( SQLException e ) {
			System.out.println( "Unable to access User Login Table : " + e.getMessage() );
		}
		System.out.println("Employee successfully created :\n\tUSERNAME - " + userName + "\n\tDEFAULT PASSWORD - " + userPassword);
		return; // Employee Registered.
	}
}
