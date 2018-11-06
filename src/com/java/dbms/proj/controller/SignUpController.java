package com.java.dbms.proj.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Address;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.UserLogin;

public class SignUpController {
	UserLogin userlogin=new UserLogin();
	
	public static String signUp(Scanner input) throws ClassNotFoundException, SQLException {
		Statement statement = DBFacade.createConnection().createStatement();
		ResultSet resultSet;
		Customer customer=new Customer();
		String userState = "";
		String userName = "";
		Address custAddress=new Address();
		String userPassword;
		String confirmPassword;
		boolean passwordMatch=true;
		
		com.java.dbms.proj.views.CustomerView.displaySignUp(); //Display page header
		
		/* Request a valid user response. */
		System.out.println("Please provide some information so that we can get you set up in the system.");
		
		System.out.print( "User Email : ");
		customer.setEmail(input.nextLine());
		
		System.out.print( "User First Name : ");
		customer.setFirst(input.nextLine());
		
		System.out.print( "User Last Name : ");
		customer.setLast(input.nextLine());
		
		System.out.print( "User City : ");
		custAddress.setCity(input.nextLine());
		
		do {
			System.out.print( "User State Abbreviation (ex: NC) : ");
			userState=input.nextLine();
		}while(userState.length() > 2 || userState.isEmpty() );
		custAddress.setState(userState);
		
		System.out.print( "User Street Address : ");
		custAddress.setStreet(input.nextLine());
		
		customer.setAddress(custAddress);
		
		System.out.println("\nThank you for your account information.\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Sign Up.");
		System.out.println("\tEnter '2' to Go Back." );
	
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
			
		if(userInput.equals("2"))
			return "2";
		
		do {
			/* Assign a unique userName */
			System.out.print("Please enter a preferred user name: " );
			userName = input.nextLine();
			try {
				resultSet = statement.executeQuery( "SELECT USERNAME " +
							    					"FROM Login " +
							    					"WHERE username = '" + userName + "'" );
				if( resultSet.next() )
					System.out.println("Sorry, that user name already exists.");
			} catch (SQLException e) {
				System.out.println( "System Query Error : " + e );
				e.printStackTrace();
			}
		}while( userName.equals("") );
		customer.setUsername(userName);
		
		do {
			/* Assign user password */
			System.out.print("Please enter a login password: ");
			userPassword = input.nextLine();
			System.out.print("Please confirm your password: ");
			confirmPassword = input.nextLine();
			if(!userPassword.equals(confirmPassword)){
				System.out.print("Password does not match");
				passwordMatch=false;
			}
		}while(passwordMatch==false);
			
		//TODO Create customer tuple in LOGIN
		System.out.println( "Simulate: Successfully Created New " + customer.getUsername() + " tuple in LOGIN.");
		//TODO Create customer tuple in CUSTOMER
		System.out.println( "Simulate: Successfully Created New " + customer.getUsername() + " tuple in CUSTOMER.");
		return "1";
	}
}
