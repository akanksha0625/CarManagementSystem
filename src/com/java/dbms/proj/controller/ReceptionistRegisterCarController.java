package com.java.dbms.proj.controller;

import java.util.Scanner;

public class ReceptionistRegisterCarController {
	public static void registerCar(Scanner input) {
		com.java.dbms.proj.views.ReceptionistView.displayRegisterCar(); //Display page header
		
		//TODO ask for car details for registration
		System.out.println("ASK FOR DETAILS FOR CAR REGISTRATION");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Register");
		System.out.println("\tEnter '2' to Cancel");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			//TODO register car
			System.out.println("REGISTER CAR");
		}
	}

}
