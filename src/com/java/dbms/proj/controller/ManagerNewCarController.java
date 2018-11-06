package com.java.dbms.proj.controller;

import java.util.Scanner;

import com.java.dbms.proj.views.ManagerView;

public class ManagerNewCarController {
	public static void newCar(Scanner input) {
		ManagerView.displayNewCarModel(); //Display page header
		//TODO ask for car model details
		System.out.println("ASK FOR CAR MODEL DETAILS\n");
		

		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Add Car" );
		System.out.println( "\tEnter '2' to Go Back" );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) );
		
		if( userInput.equals( "1" ) ) {
			//TODO call addCar controller
			System.out.println( "ADD CONTROLLER TO ADD NEW CAR" );
		}
	}
}
