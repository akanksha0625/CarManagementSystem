package com.java.dbms.proj.controller;
import java.sql.ResultSet;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import com.java.dbms.proj.common.DBFacade;

public class SignUpController {
	
	public static String signUp( Scanner input ) throws ClassNotFoundException, SQLException {
		/* Necessary Variables for SQL Transactions */
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		
		/* Necessary Variables for Customer Tuple Creation */
		String customerID = "";
		String userName = "";
		String userPassword = "";
		String userInput = "";
		int serviceCenterSelection = 0;
		
		/* Variables for loop checking. */
		boolean isNum = false;
		boolean passwordMatch = true;
		
		ArrayList<String> serviceCenters = serviceCenters = new ArrayList<String>();
		
		/* Display page header */
		com.java.dbms.proj.views.CustomerView.displaySignUp();
		
		/* Request a valid user response. */
		System.out.println("Please provide some information so that we can get you set up in the system.");
		
		System.out.print( "User Email : ");
		String email = input.nextLine();
		
		System.out.print( "User Phone Contact : ");
		String phone = input.nextLine();
		
		System.out.print( "User First Name : ");
		String first = input.nextLine();
		
		System.out.print( "User Last Name : ");
		String last = input.nextLine();
		
		System.out.print( "User City : ");
		String city = input.nextLine();
		
		String state = "";
		/* Check restriction of State Abreviation */
		do {
			System.out.print( "User State Abbreviation (ex: NC) : ");
			state = input.nextLine();
		}while( state.length() > 2 || state.isEmpty() );
		
		System.out.print( "User Street Address : ");
		String address = input.nextLine();
				
		System.out.print( "User Zip Code : ");
		String zip =  input.nextLine();
		
		/* Have customer select his/her preferred service center */
		System.out.println("Select the Service Center service center would you like to be registered with?");
		
		try {
			resultSet = statement.executeQuery( "SELECT * FROM SERVICE_CENTER" );
			
			int choice = 1; // display default numbering
			while( resultSet.next() ) {
				/* Display service centers to chose from */
				System.out.println( "\t" + choice++ + ". " + resultSet.getString("SC_NAME") );
				serviceCenters.add(resultSet.getString("SC_ID"));
			}
			
			do {
				System.out.print("Option Selection : ");
				userInput = input.next();
				try { 
		            serviceCenterSelection = Integer.parseInt(userInput); 
		            isNum = true; 
		        } catch ( NumberFormatException e ){ /*intentionally left blank*/ } 
			}while( !isNum || ( serviceCenterSelection < 1 ) || ( serviceCenterSelection > ( choice - 1 ) ) );
		} catch (SQLException e) {
			System.out.println( "System Query Error : " + e );
			e.printStackTrace();
		}
		
		/* Customer has entered all necessary details */
		System.out.println("\nThank you for your account information.\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Sign Up.");
		System.out.println("\tEnter '2' to Go Back.");
		
		input.nextLine(); // flusht the input stream
	
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) );
			
		if( userInput.equals( "2" ) )
			return "2"; // Go Back to the previous page
		
		do {
			/* Assign a unique userName */
			System.out.print("Please enter a preferred user name: " );
			userName = input.nextLine();
			try {
				resultSet = statement.executeQuery( "SELECT USERNAME " +
							    					"FROM Login " +
							    					"WHERE username = '" + userName + "'" );
				if( resultSet.next() ) {
					System.out.println( "Sorry, that user name already exists." );
					userName = "";
				}
			} catch ( SQLException e ) { System.out.println( "System Query Error : " + e ); }	
		}while( userName.equals("") );
		
		do {
			/* Assign user password */
			System.out.print("Please enter a login password: ");
			userPassword = input.nextLine();
			System.out.print("Please confirm your password: ");
			userInput = input.nextLine();
			if(!userPassword.equals(userInput)){
				System.out.println("\n***************************");
				System.out.println("| Password does not match |");
				System.out.println("***************************\n");
				passwordMatch = false;
			} else {
				passwordMatch = true;
			}
		}while(passwordMatch==false);
		
		/* Insert Tuple into Login Table */
		try {
			int tuples = statement.executeUpdate( "INSERT INTO LOGIN " +
						    					"VALUES ('" + userName + "', '" +
													          userPassword + "', 'CUSTOMER', 'ACTIVE')");
			if( tuples != 1 )
				System.out.println("Unable to load user into the Login Table.");
		} catch (SQLException e) {
			System.out.println( "System Query Error : " + e );
			e.printStackTrace();
		}

		/* Insert into Customer Table */
		try {
			resultSet = statement.executeQuery("SELECT customers_seq.nextval from dual");
			int index = 0;
			if (resultSet.next()) {
				index = resultSet.getInt("NEXTVAL");
			}
			int tuples = statement.executeUpdate( "INSERT INTO CUSTOMER " +
						    					"VALUES ('" + index +"', '" + first + "', '" +
													     	  last + "', '" +
						    					              phone + "', '" +
													     	  email + "', '" +
													     	 serviceCenters.get(serviceCenterSelection - 1) + "', '" + 
													     	  userName + "')");
			if( tuples != 1 )
				System.out.println("Unable to load user into the Login Table.");
		} catch (SQLException e) {
			System.out.println( "System Query Error : " + e );
			e.printStackTrace();
		}
		
		/* Get the Customer ID to be inserted into the Customer Address Table */
		try {
			resultSet = statement.executeQuery( "SELECT CID " +
						    					"FROM CUSTOMER " +
						    					"WHERE username = '" + userName + "'" );
			resultSet.next();
			customerID = resultSet.getString("CID");
		} catch (SQLException e) {
			System.out.println( "System Query Error : " + e );
			e.printStackTrace();
		}
		
		/* Insert into the Customer Address Table */
		try {
			//TODO fix auto increment
			int tuples = statement.executeUpdate( "INSERT INTO CUSTOMER_ADDRESS " +
						    					"VALUES ('0', '" + address + "', '" +
													     	  city + "', '" +
						    					              state + "', '" +
													     	  customerID + "', '" +
						    					              zip + "')");
			if( tuples != 1 )
				System.out.println("Unable to load user into the Login Table.");
		} catch (SQLException e) {
			System.out.println( "System Query Error : " + e );
			e.printStackTrace();
		}
		
		return "1"; // Customer Registered.
	}
}
