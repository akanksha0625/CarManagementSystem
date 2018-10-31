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
	public void signUp() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	Statement statement = DBFacade.createConnection().createStatement();
	ResultSet resultSet;
	Customer customer=new Customer();
	Scanner userInput = new Scanner( System.in );
	String userState = "";
	String userName = "";
	Address custAddress=new Address();
	String userPassword;
	String confirmPassword;
	boolean passwordMatch=true;
	/* Request a valid user response. */
	System.out.println("\nWelcome New User!");
	System.out.println("Please provide some information so that we can get you set up in the system.");
	
	System.out.print( "User Email : ");
	customer.setEmail(userInput.nextLine());
	
	System.out.print( "User First Name : ");
	customer.setFirst(userInput.nextLine());
	
	System.out.print( "User Last Name : ");
	customer.setLast(userInput.nextLine());
	
	System.out.print( "User City : ");
	custAddress.setCity(userInput.nextLine());
	
	do {
		System.out.print( "User State Abbreviation (ex: NC) : ");
		userState=userInput.nextLine();
	}while(userState.length() > 2 || userState.isEmpty() );
	custAddress.setState(userState);
	
	System.out.print( "User Street Address : ");
	custAddress.setStreet(userInput.nextLine());
	
	customer.setAddress(custAddress);
	
	System.out.println("\nThank you for your account information.\n");
	
	do {
		/* Assign a unique userName */
		System.out.print("Please enter a preferred user name: " );
		userName = userInput.nextLine();
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
	System.out.print("Please enter a login password: ");
	userPassword = userInput.nextLine();
	System.out.print("Please confirm your password: ");
	confirmPassword = userInput.nextLine();
	if(userPassword!=confirmPassword){
		System.out.print("Password does not match");
		passwordMatch=false;
	}
	}while(passwordMatch==false);
		
	userInput.close();

	System.out.println( "Simulate: Successfully Created New " + customer.getUsername() + " tuple in LOGIN.");
//TODO Create customer tuple in CUSTOMER
	System.out.println( "Simulate: Successfully Created New " + customer.getUsername() + " tuple in CUSTOMER.");
}
}
