package com.java.dbms.proj.controller;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.entities.Address;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;

public class EmployeeSearchCustomerController {
	
	public static void searchCustomer( Scanner input ) {
		
		com.java.dbms.proj.views.EmployeeView.displayCustomerProfile(); //Display page header
		
		/* Necessary Variables for SQL Transactions */
		Statement statement = null;
		ResultSet resultSet;
		boolean matchFound = false;
		
		Customer customer = new Customer();
		
		try {
			
			statement = DBFacade.getConnection().createStatement();
			
			System.out.println ( "\nEnter the email of the customer that you would like to search : " );
			String userInput = input.nextLine();
			
			try {
				
				resultSet = statement.executeQuery( "SELECT * FROM CUSTOMER WHERE EMAIL = '" + userInput + "'" );
				
				while ( resultSet.next() ) {
					matchFound = true;
					
					customer.setCustomerId( resultSet.getInt( "CID" ) );
					customer.setFirstName(resultSet.getString( "FIRSTNAME" ) );
					customer.setLastName( resultSet.getString( "LASTNAME" ) );
					customer.setPhoneNumber( resultSet.getString( "PHONE" ) );
					customer.setEmail( resultSet.getString( "EMAIL" ) );
					customer.setUsername( resultSet.getString( "USERNAME" ) );
				}
				
				if ( matchFound ) { 
					
					resultSet = statement.executeQuery( "SELECT * FROM CUSTOMER_ADDRESS WHERE CID = '" + customer.getCustomerId() + "'" );
					
					while ( resultSet.next() ) {
						matchFound = true;
						Address address = new Address();
						address.setStreet( resultSet.getString( "STREET" ) );
						address.setCity( resultSet.getString( "CITY" ) );
						address.setState( resultSet.getString( "STATE" ) );
						address.setZipCode( resultSet.getString( "ZIP" ) );
						customer.setAddress( address );
					}
					
					HelperFunctions.displayCustomerProfile( customer );
					
				} else {
					System.out.println( "\tCustomer Does not exist in Database\n" );
				}
				
			} catch ( SQLException e2 ) { System.out.println( "System Query Error : " + e2.getMessage() ); }
			
			System.out.println( "\nPlease select from the following user options:" );
			System.out.println( "\tEnter '1' to Go Back." );
			
			do {
				
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
				
			} while ( !userInput.equals( "1" ) );
			
		} catch (SQLException e) { System.out.println( "Error in acquiring the database connection : " + e.getMessage() ); }
	}
}
