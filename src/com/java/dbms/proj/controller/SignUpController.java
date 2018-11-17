package com.java.dbms.proj.controller;
import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import com.java.dbms.proj.common.DBFacade;

public class SignUpController {
	
	public static String signUp( Scanner input ) {
		ResultSet resultSet;
		Statement statement;
		
		try {
			statement = DBFacade.getConnection().createStatement();
		} catch (SQLException e) {
			System.out.println("Unable to acquire a database connection : " + e.getMessage() );
			return "2";
		}
		
		String customerID = "";
		String userName = "";
		String userPassword = "";
		String userInput = "";
		
		int serviceCenterSelection = 0;
		boolean isNum = false;
		boolean passwordMatch = true;

		ArrayList<String> serviceCenters = new ArrayList<String>();
		
		com.java.dbms.proj.views.CustomerView.displaySignUp(); // Display header for this page.
		
		/* Gather Customer details */
		System.out.println ("Please provide some information so that we can get you set up in the system.\n");
		
		String email = "";
		do {
			/* Assign a unique userName */
			System.out.print ( "Please enter a user email : " );
			email = input.nextLine();
			try {
				resultSet = statement.executeQuery( "SELECT EMAIL FROM CUSTOMER WHERE EMAIL = '" + email + "'" );
				if ( resultSet.next() ) {
					System.out.println ( "\nSorry, the email \"" + email +"\" already exists.\n" );
					email = "";
				}
			} catch ( SQLException e ) { 
				System.out.println( "Unable to access Customer Table : " + e.getMessage() ); 
			}	
		} while ( email.equals("") );
		
		System.out.print ( "\nUser Phone Contact : ");
		String phone = input.nextLine();
		
		System.out.print ( "\nUser First Name : ");

		String first = input.nextLine();
		
		System.out.print ( "\nUser Last Name : ");
		String last = input.nextLine();
		
		System.out.print( "\nUser Street Address : ");
		String address = input.nextLine();

		System.out.print ( "\nUser City : ");
		String city = input.nextLine();
		
		String state = "";
		do {
			System.out.print ( "\nUser State Abbreviation (ex: NC) : ");
			state = input.nextLine();
		} while ( state.length() > 2 || state.isEmpty() );
				
		System.out.print( "\nUser Zip Code : ");
		String zip =  input.nextLine();
		
		System.out.println ( "\nSelect the Service Center service center would you like to be registered with?" );
		
		/* Display possible service centers to select from */
		try {
			resultSet = statement.executeQuery( "SELECT * FROM SERVICE_CENTER" );
			int choice = 1; // display default numbering
			while( resultSet.next() ) {
				/* Display service centers to chose from */
				System.out.println( "\t" + choice++ + ". " + resultSet.getString( "SC_NAME" ) );
				serviceCenters.add( resultSet.getString( "SC_ID" ) );
			}
			
			do {
				System.out.print ( "\nOption Selection : ");
				userInput = input.nextLine();
				try { 
		            serviceCenterSelection = Integer.parseInt( userInput ); 
		            isNum = true; 
		        } catch ( NumberFormatException e ){ /*intentionally left blank*/ } 
			} while ( !isNum || ( serviceCenterSelection < 1 ) || ( serviceCenterSelection > ( choice - 1 ) ) );
		} catch (SQLException e) {
			System.out.println( "Unable to access Service Center table : " + e.getMessage() );
		}
		
		do {
			/* Assign a unique userName */
			System.out.print ( "\nPlease enter a preferred user name: " );
			userName = input.nextLine();
			try {
				resultSet = statement.executeQuery( "SELECT USERNAME FROM Login WHERE username = '" + userName + "'" );
				if ( resultSet.next() ) {
					System.out.println ( "\nSorry, that username \"" + userName + "\" already exists." );
					userName = "";
				}
			} catch ( SQLException e ) { 
				System.out.println( "Unable to access User Login Table : " + e.getMessage() ); 
			}	
		} while ( userName.equals("") );
		
		do {
			/* Assign user password */
			System.out.print ( "\nPlease enter a login password: " );
			userPassword = input.nextLine();
			System.out.print ( "\nPlease confirm your password: " );
			userInput = input.nextLine();
			if ( !userPassword.equals( userInput ) ) {
				System.out.println( "\n***************************" );
				System.out.println( "| Password does not match |" );
				System.out.println( "***************************" );
				passwordMatch = false;
			} else {
				passwordMatch = true;
			}
		} while ( !passwordMatch );
		
		/* Ask if customer would like to sign up or go back to the home page. */
		/* Customer has entered all necessary details */
		System.out.println ( "\nThank you for your account information.\n" );
		System.out.println ( "Please select from the following user options:" );
		System.out.println ( "\tEnter '1' to Sign Up." );
		System.out.println ( "\tEnter '2' to Go Back." );
	
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		} while ( !userInput.equals( "1" ) && !userInput.equals( "2" ) );
			
		if( userInput.equals( "2" ) )
			return "2"; // Go Back to the previous page
		
		/* Insert user into the login table */
		try {
			statement.executeUpdate( "INSERT INTO LOGIN VALUES ('" + userName + "', '" + userPassword + "', 'CUSTOMER', 'ACTIVE')" );
			
			/* Insert into Customer Table */
			try {
				resultSet = statement.executeQuery( "SELECT customers_seq.nextval from dual" );
				int index = 0;
				if ( resultSet.next() ) {
					index = resultSet.getInt( "NEXTVAL" );
				}
				
				statement.executeUpdate( "INSERT INTO CUSTOMER VALUES ('" + index +"', '" + first + "', '" + last + "', '" + 
										 phone + "', '" + email + "', '" + serviceCenters.get(serviceCenterSelection - 1) + 
										 "', '" + userName + "')");
					
					/* Get customer id for address insertion */
					try {
						resultSet = statement.executeQuery( "SELECT CID FROM CUSTOMER WHERE username = '" + userName + "'" );
						if( resultSet.next() )
							customerID = resultSet.getString( "CID" );
						
						statement.executeUpdate( "INSERT INTO CUSTOMER_ADDRESS VALUES ('" + address + "', '" +
															     	  city + "', '" + state + "', '" + customerID + "', '" + zip + "')");
					} catch ( SQLException e ) {
						System.out.println( "Unable to access the Customer Address table : " + e.getMessage() );
					}
			} catch ( SQLException e ) {
				System.out.println( "Unable to access Customer table : " + e.getMessage() );
			}
		} catch ( SQLException e ) {
			System.out.println( "Unable to access User Login Table : " + e.getMessage() );
		}

		return "1"; // Customer Registered.
	}
}
