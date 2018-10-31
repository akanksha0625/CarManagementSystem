package com.java.dbms.proj.controller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.UserLogin;
import com.java.dbms.proj.views.Login;

public class LoginController{
		Login login=new Login();		
		UserLogin userLogin=new UserLogin();
		public String userLogin() throws ClassNotFoundException, SQLException {
		login.displaypage();
		Scanner userInput = new Scanner(System.in);
		int attempts = 0;
		Statement statement = DBFacade.createConnection().createStatement();
		ResultSet resultSet;
		
       
		System.out.println("Welcome User!");
		System.out.println("Please select from the following user options: \n");
		System.out.println("\tEnter 1 to Sign In.");
		System.out.println("\tEnter 2 to Go Back.");
		String userResponse = "";
		do {
			System.out.print("\nYour selection : ");
			userResponse = userInput.nextLine();
		}while (!userResponse.equals("1") && !userResponse.equals("2"));
		
		if( userResponse.equals("1") ) {
    	
			/* Prompt user for userName and password until successful match is discovered. */
			while( true ) {
				attempts++;
				System.out.print("Please enter username : ");
				userLogin.setUserName(userInput.nextLine()) ;
		        System.out.print("\nPlease enter password : ");
		        userLogin.setPassword(userInput.nextLine());		        
		        System.out.println(); // Spacing on console.
		        
		        try {
		        	
		        	/* Find userName and userPassword match from 'LOGIN' table */
					resultSet = statement.executeQuery( "SELECT USERNAME, PASSWORD, ROLE " +
													    "FROM LOGIN " +
													    "WHERE username = '" + userLogin.getUserName() +
													    "' AND password = '" + userLogin.getPassword() +
													    "' AND state = 'ACTIVE'" );
					/* If query returned a value */
					if( resultSet.next() ) {
					
							if(resultSet.getString( "role" )!=null && resultSet.getString( "role" )!="")
							userLogin.setRole(resultSet.getString( "role" ));
				
						System.out.println( "************************" );
						System.out.println( "  - Login Successful -  " );
						System.out.println( "************************\n" );
						
						userInput.close();
						return userLogin.getRole();
			        } else {
			        	System.out.println( "*********************************" );
						System.out.println( "     - Login Unsuccessful -" );
						System.out.println( "---------------------------------" );
						
						
						/* Check if userName in the system. */
						resultSet = statement.executeQuery( "SELECT USERNAME " +
							    "FROM Login " +
							    "WHERE username = '" + userLogin.getUserName() + "'" );
						
						if( !resultSet.next() ) {
							System.out.println( " User Name '" + userLogin.getUserName() + "' does not exist in the Acme Service System.");
						} else {
							System.out.println( " Incorrect Password --> Please try again." );
						}
						System.out.println( "*********************************\n" );
						
						if( attempts >= 2 ) {
							System.out.println( "Having Trouble?");
							String response = "";
							do {
								System.out.println( "\t Enter 1 to Exit Login" );
								System.out.println( "\t Enter 2 to Attempt Another Login" );
								response = userInput.nextLine();
							}while(!response.equals( "1" ) && !response.equals( "2" ) );
						}
			        }
				} catch (SQLException e) {
					System.out.println( "Login Unsuccessful due to database error : " + e );
					e.printStackTrace();
					break;
				}	
	    	}
		}
		/* Close Scanner on an unsuccessful login in. */
		userInput.close();
		return null;
	}
	
}
