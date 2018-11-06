package com.java.dbms.proj.controller;

import java.util.Scanner;
import com.java.dbms.proj.views.EmployeeView;

public class EmployeeUpdateProfileController {
	
	public static void updateProfile(Scanner input) {
		String userInput = "";
		do {
			EmployeeView.displayProfileUpdate(); //Display page header
			
			System.out.println( "Please select from the following user options:");
			System.out.println( "\tEnter '1' to Update your First Name." );
			System.out.println( "\tEnter '2' to Update your Last Name." );
			System.out.println( "\tEnter '3' to Update your Address.");
			System.out.println( "\tEnter '4' to Update your Phone Number." );
			System.out.println( "\tEnter '5' to Update your Email." );
			System.out.println( "\tEnter '6' to Update your Password." );
			System.out.println( "\tEnter '7' when Finished Updating." );
			
			do {
				System.out.print( "\nOption Selection : " );
				userInput = input.nextLine();
			}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) && !userInput.equals( "3" ) && 
					!userInput.equals( "4" ) && !userInput.equals( "5" ) && !userInput.equals( "6" ) &&
					!userInput.equals( "7" ) );
			
			if(!userInput.equals("7")) {
				//TODO call controller with (response) to determine what to update
				System.out.println( "CALL CONTROLLER(response) TO UPDATE PROFILE DETAIL" );
			}
		}while( !userInput.equals( "7" ) );
	}

}
