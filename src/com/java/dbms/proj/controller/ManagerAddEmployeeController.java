package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class ManagerAddEmployeeController {
	
	public static void addEmployee( Scanner input )  throws ClassNotFoundException, SQLException{
		com.java.dbms.proj.views.ManagerView.dsiplayAddEmployee(); //Display page header
		
		//TODO take in the details of the new employee
		System.out.println("HANDLE TAKING IN NEW EMPLOYEE DETAILS\n");
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Add" );
		System.out.println( "\tEnter '2' to Go Back" );

		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) );
				
		if( userInput.equals("1")) {
			//TODO add employee to database
		}
	}

}
