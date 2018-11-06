package com.java.dbms.proj.controller;

import java.util.Scanner;

public class CustomerRegisterCarController {
	public static void registerCar(Scanner input) {
		com.java.dbms.proj.views.CustomerView.displayCarRegistration(); //Display page header
		
		//TODO gather user information about car
		System.out.println("GATHER USER INFORMATION ABOUT CAR");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Register");
		System.out.println("\tEnter '2' to Cancel");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			//TODO register car
			System.out.println("REGISTER CAR");
		}
	}

}
