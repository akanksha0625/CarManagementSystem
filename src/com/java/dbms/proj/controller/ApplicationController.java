package com.java.dbms.proj.controller;
import java.sql.SQLException;
import java.util.Scanner;
import com.java.dbms.proj.views.Exit;

public class ApplicationController {
	static Scanner input = new Scanner(System.in);
	static String userInput = "";
	static Exit exit=new Exit();
	static LoginController loginController=new LoginController();
	static SignUpController signUpController=new SignUpController();
	static String userRole="";
	
	public static void displayMainMenu() {
		System.out.println("Welcome to the Acme Service Center System!");
		System.out.println("Please select from the following user options:\n");
		System.out.println( "\tEnter \"1\" to Login"); 
		System.out.println( "\tEnter \"2\" to Sign Up");
		System.out.println( "\tEnter \"3\" to Exit");
		System.out.print("\nYour selection : ");
		userInput = input.nextLine();
		while( !userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"))
		{
			displayMainMenu();
		}
	}
	
	public static void applicationController() throws SQLException, ClassNotFoundException{
		displayMainMenu();
		if(userInput.equals("3"))
			exit.displaypage();
		else{
       	 		if(userInput.equals("2") ) {
       	 		/* Create a new customer account. */
       	 		signUpController.signUp();
       	 		displayMainMenu();
       	 		}
       	 		
       	 		else if(userInput.equals("1")) {
       	 		userRole=loginController.userLogin();
       	 		}
       	 			
   	 				/* Invite user to login into the system and determine what type of user for permissions based on role. */
   	 			
	   	 			if( userRole != null ) {
	   	 				/*User Successfully logged in. */
		   	 		   if( userRole.toLowerCase().equals( "manager" ) ) {
		   	 			   System.out.println( "Manager Application Options:\n TO DO" );
		   	 		   }else if( userRole.equalsIgnoreCase( "receptionist" ) ) {
		   	 			   System.out.println( "Receptionist Application Options:\n TO DO" );
		   	 		   }else if( userRole.equalsIgnoreCase( "mechanic" ) ) {
		   	 			   System.out.println( "Mechanic User Options:\n TO DO" );
		   	 		   }else if( userRole.equalsIgnoreCase( "customer" ) ) {
		   	 			   System.out.println( "Customer User Options:\n TO DO" );
		   	 		   }  	 		
//		   	 		   System.out.println("\t Enter \"L\" to LOGOUT");
//		   	 		   System.out.print( "User Selection : " );
//		   	 		   userInput = input.nextLine();
//		   	 		   if( userInput.equalsIgnoreCase("L") ) {
//		   	 			   session.userLogout(statement, resultSet);
//		   	 		   }
		       	 		
		       	 		//-----------------------------
		    	 		// TODO REMAINDER OF APP FLOW
		    	 		//-----------------------------
	   	 			}
       	 		}
	}
}
