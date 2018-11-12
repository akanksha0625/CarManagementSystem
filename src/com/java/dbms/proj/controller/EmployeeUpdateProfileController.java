package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.views.EmployeeView;

public class EmployeeUpdateProfileController {
	
	public static void updateProfile ( Scanner input ) {
		String userInput = "";
		Statement statement = null;
		
		try {
			statement = DBFacade.getConnection().createStatement();
		} catch ( SQLException e ) { 
			System.out.println ( "Unable to acquire the database connection : " + e.getMessage() ); 
			return;
		}
		
		do {
			EmployeeView.displayProfileUpdate(); //Display page header
			
			System.out.println ( "Please select from the following user options:");
			System.out.println ( "\tEnter '1' to Update your Name." );
			System.out.println ( "\tEnter '2' to Update your Address.");
			System.out.println ( "\tEnter '3' to Update your Email." );
			System.out.println ( "\tEnter '4' to Update your Phone Number." );
			System.out.println ( "\tEnter '5' to Update your Password." );
			System.out.println ( "\tEnter '6' when Finished Updating." );
			
			do {
				System.out.print ( "\nOption Selection : " );
				userInput = input.nextLine();
			} while ( !userInput.equals( "1" ) && !userInput.equals( "2" ) && !userInput.equals( "3" ) && 
					!userInput.equals( "4" ) && !userInput.equals( "5" ) && !userInput.equals( "6" ) );
			
			if ( !userInput.equals( "6" ) ) {
		        switch ( userInput ) { 
			        case "1": 
			        	System.out.print ( "Enter your First Name : " );
			        	String firstName = input.nextLine();
			        	System.out.print ( "Enter your Last Name : " );
			        	String lastName = input.nextLine();
			            
			        	ApplicationController.employee.setFirstName( firstName );
			            ApplicationController.employee.setLastName( lastName );
			            
			            try {
							statement.executeUpdate( "UPDATE EMPLOYEE SET FIRSTNAME = '" + firstName +
													"' WHERE EID = '" + ApplicationController.employee.getEmpId() + "'" );
						} catch ( SQLException e ) {
							System.out.println ( "Unable to update the Employee First Name : " + e.getMessage() );
						}
			           
			            try {
							statement.executeUpdate( "UPDATE EMPLOYEE SET LASTNAME = '" + lastName +
									"' WHERE EID = '" + ApplicationController.employee.getEmpId() + "'" );
			            } catch ( SQLException e ) {
							System.out.println ( "Unable to update the Employee Last Name : " + e.getMessage() );
						}
			            break; 
			       
			        case "2": 
			        	System.out.print ( "Enter your Street : " );
			        	String street = input.nextLine();
			        	System.out.print ( "Enter your City : " );
			        	String city = input.nextLine();
			        	String state = "";
			    		do {
			    			System.out.print ( "Enter your State Abbreviation (ex: NC) : " );
			    			state = input.nextLine();
			    		} while ( state.length() > 2 || state.isEmpty() );
			    		
			    		System.out.print ( "Enter your Zip Code : " );
			        	String zip = input.nextLine();
			        	
			        	ApplicationController.employee.getAddress().setStreet(street);
			        	ApplicationController.employee.getAddress().setCity(city);
			        	ApplicationController.employee.getAddress().setState(state);
			        	ApplicationController.employee.getAddress().setZipCode(zip);
			            
			            try {
							statement.executeUpdate( "UPDATE EMPLOYEE_ADDRESS SET STREET = '" + street +
													"' WHERE EID = '" + ApplicationController.employee.getEmpId() + "'" );
			            } catch ( SQLException e ) {
							System.out.println ( "Unable to update the Employee Street : " + e.getMessage() );
						}
			           
			            try {
							statement.executeUpdate("UPDATE EMPLOYEE_ADDRESS SET CITY = '" + city +
									"' WHERE EID = '" + ApplicationController.employee.getEmpId() + "'" );
			            } catch ( SQLException e ) {
							System.out.println ( "Unable to update the Employee City : " + e.getMessage() );
						}
			            
			            try {
							statement.executeUpdate("UPDATE EMPLOYEE_ADDRESS SET STATE = '" + state +
									"' WHERE EID = '" + ApplicationController.employee.getEmpId() + "'" );
			            } catch ( SQLException e ) {
							System.out.println ( "Unable to update the Employee State : " + e.getMessage() );
						}
			            
			            try {
							statement.executeUpdate("UPDATE EMPLOYEE_ADDRESS SET ZIP = '" + zip +
									"' WHERE EID = '" + ApplicationController.employee.getEmpId() + "'" );
			            } catch ( SQLException e ) {
							System.out.println ( "Unable to update the Employee Zip Code : " + e.getMessage() );
						}
			            break; 
			        
			        case "3": 
			        	System.out.print( "Enter your Email Address : " );
			        	String email = input.nextLine();
			            
			        	ApplicationController.employee.setEmail( email );
			            
			            try {
							statement.executeUpdate( "UPDATE EMPLOYEE SET EMAIL = '" + email +
													"' WHERE EID = '" + ApplicationController.employee.getEmpId() + "'" );
			            } catch ( SQLException e ) {
							System.out.println ( "Unable to update the Employee Email : " + e.getMessage() );
						}
			            break; 
			        
			        case "4": 
			        	System.out.print( "Enter your Phone Number : " );
			        	String phone = input.nextLine();
			            
			        	ApplicationController.employee.setEmail( phone );
			            
			            try {
							statement.executeUpdate( "UPDATE EMPLOYEE SET PHONE = '" + phone +
													"' WHERE EID = '" + ApplicationController.employee.getEmpId() + "'" );
			            } catch ( SQLException e ) {
							System.out.println ( "Unable to update the Employee Phone Number : " + e.getMessage() );
						}
			            break; 
			        
			        case "5": 
			        	boolean passwordMatch = false;
			        	String password = "";
			    		do {
			    			/* Assign user password */
			    			System.out.print ( "Please enter a login password: " );
			    			password = input.nextLine();
			    			System.out.print ( "Please confirm your password: " );
			    			userInput = input.nextLine();
			    			if( !password.equals( userInput ) ){
			    				System.out.println( "\n***************************" );
			    				System.out.println( "| Password does not match |" );
			    				System.out.println( "***************************\n" );
			    				passwordMatch = false;
			    			} else {
			    				passwordMatch = true;
			    			}
			    		} while ( !passwordMatch );
			            
			        	ApplicationController.employee.setEmail( password );
			            
			            try {
							statement.executeUpdate( "UPDATE LOGIN SET PASSWORD = '" + password +
													"' WHERE USERNAME = '" + ApplicationController.employee.getUserName() + "'" );
							System.out.println("username : " + ApplicationController.employee.getUserName());
			            } catch ( SQLException e ) {
							System.out.println ( "Unable to update the Employee Password : " + e.getMessage() );
						}
			            break; 
			        
			        default: 
			            break; 
		        } 
			}
		} while ( !userInput.equals( "6" ) );
	}
}
