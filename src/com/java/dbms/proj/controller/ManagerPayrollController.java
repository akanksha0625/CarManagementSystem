package com.java.dbms.proj.controller;

import java.util.Scanner;

import com.java.dbms.proj.views.ManagerView;

public class ManagerPayrollController {
	public static void payroll(Scanner input) {
		ManagerView.displayPayroll(); //Display page header
		
		//TODO ask for employee email and display payroll information
		System.out.println( "ASK FOR EMAIL AND GET EMPLOYEE PAYROLL" );
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' Go Back" );

		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
