package com.java.dbms.proj.controller;

import java.util.Scanner;

public class ReceptionistTaskUpdateInventoryController {
	public static void updateInventory(Scanner input) {
		
		//TODO update inventory and to display some type of success message
		System.out.println("UPDATE INVENTORY & DISPLAY MESSAGE");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to	Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}
}
