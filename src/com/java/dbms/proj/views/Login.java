package com.java.dbms.proj.views;

import java.util.Scanner;

public class Login {
	
	public static String displayLogin(Scanner input) {
		System.out.println("************************************************************************************************************************");
		System.out.println("|                                        888                       d8b                                                 |");          
		System.out.println("|                                        888                       Y8P                                                 |");      
		System.out.println("|                                        888                                                                           |");             
		System.out.println("|                                        888      .d88b.   .d88b.  888 88888b.                                         |");   
		System.out.println("|                                        888     d88\"\"88b d88P\"88b 888 888 \"88b                                        |"); 
		System.out.println("|                                        888     888  888 888  888 888 888  888                                        |");  
		System.out.println("|                                        888     Y88..88P Y88b 888 888 888  888                                        |"); 
		System.out.println("|                                        88888888 \"Y88P\"   \"Y88888 888 888  888                                        |"); 
		System.out.println("|                                                              888                                                     |");           
		System.out.println("|                                                         Y8b d88P                                                     |");             
		System.out.println("|                                                          \"Y88P\"                                                      |");
		System.out.println("************************************************************************************************************************\n"); 
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Login.");
		System.out.println("\tEnter '2' to Go Back." );
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
			System.out.println(userInput);
		}while(!userInput.equals("1") && !userInput.equals("2"));
		return userInput;
				
	}
}
