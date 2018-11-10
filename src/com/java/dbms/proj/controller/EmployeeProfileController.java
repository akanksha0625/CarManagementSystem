package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.views.EmployeeView;

public class EmployeeProfileController {
	public static void employeeProfile(String response, Scanner input) throws ClassNotFoundException, SQLException {
		if( response.equals( "1" ) ) {
			/*Redirect to Employee View Profile*/
			EmployeeViewProfileController.viewProfile( input );
			profileLanding(input);
		} else if( response.equals( "2" ) ) {
			/*Redirect to Employee Update Profile*/
			EmployeeUpdateProfileController.updateProfile(input);
			profileLanding(input);
		}	
	}
	
	public static void profileLanding(Scanner input) throws ClassNotFoundException, SQLException {
		EmployeeView.displayProfileLanding();
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to View Profile." );
		System.out.println( "\tEnter '2' to Update Profile." );
		System.out.println( "\tEnter '3' to Go Back." );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) && !userInput.equals( "3" ) );
		
		if(!userInput.equals("3")) {
			employeeProfile(userInput, input);
		}
	}

}
