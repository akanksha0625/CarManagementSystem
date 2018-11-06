package com.java.dbms.proj.views;

import java.util.Scanner;

public class EmployeeView {
	/*Displays the Employee Profile Landing Page*/
	public static String displayProfileLanding(Scanner input) {
		System.out.println( "*************************************************************************************************************************************" );
		System.out.println( "| 8888888888                        888                                          8888888b.                   .d888 d8b 888          |" ); 
		System.out.println( "| 888                               888                                          888   Y88b                 d88P\"  Y8P 888          |" ); 
		System.out.println( "| 888                               888                                          888    888                 888        888          |" );
		System.out.println( "| 8888888    88888b.d88b.  88888b.  888  .d88b.  888  888  .d88b.   .d88b.       888   d88P 888d888 .d88b.  888888 888 888  .d88b.  |" );
		System.out.println( "| 888        888 \"888 \"88b 888 \"88b 888 d88\"\"88b 888  888 d8P  Y8b d8P  Y8b      8888888P\"  888P\"  d88\"\"88b 888    888 888 d8P  Y8b |" );
		System.out.println( "| 888        888  888  888 888  888 888 888  888 888  888 88888888 88888888      888        888    888  888 888    888 888 88888888 |" );
		System.out.println( "| 888        888  888  888 888 d88P 888 Y88..88P Y88b 888 Y8b.     Y8b.          888        888    Y88..88P 888    888 888 Y8b.     |" );
		System.out.println( "| 8888888888 888  888  888 88888P\"  888  \"Y88P\"   \"Y88888  \"Y8888   \"Y8888       888        888     \"Y88P\"  888    888 888  \"Y8888  |" );
		System.out.println( "|                          888                        888                                                                           |" );
		System.out.println( "|                          888                   Y8b d88P                                                                           |" ); 
		System.out.println( "|                          888                    \"Y88P\"                                                                            |" );
		System.out.println( "*************************************************************************************************************************************\n" ); 
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to View Profile." );
		System.out.println( "\tEnter '2' to Update Profile." );
		System.out.println( "\tEnter '3' to Go Back." );
		
		String userInput = "";
		System.out.print( "\nOption Selection : " );
		do {
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) && !userInput.equals( "3" ) );
		
		return userInput;
	}
	
	public static String displayProfileUpdate(Scanner input) {
		System.out.println( "*************************************************************************************************************************************");
		System.out.println( "| 8888888888                        888                                          8888888b.                   .d888 d8b 888          |"); 
		System.out.println( "| 888                               888                                          888   Y88b                 d88P\"  Y8P 888          |"); 
		System.out.println( "| 888                               888                                          888    888                 888        888          |");
		System.out.println( "| 8888888    88888b.d88b.  88888b.  888  .d88b.  888  888  .d88b.   .d88b.       888   d88P 888d888 .d88b.  888888 888 888  .d88b.  |");
		System.out.println( "| 888        888 \"888 \"88b 888 \"88b 888 d88\"\"88b 888  888 d8P  Y8b d8P  Y8b      8888888P\"  888P\"  d88\"\"88b 888    888 888 d8P  Y8b |");
		System.out.println( "| 888        888  888  888 888  888 888 888  888 888  888 88888888 88888888      888        888    888  888 888    888 888 88888888 |");
		System.out.println( "| 888        888  888  888 888 d88P 888 Y88..88P Y88b 888 Y8b.     Y8b.          888        888    Y88..88P 888    888 888 Y8b.     |");
		System.out.println( "| 8888888888 888  888  888 88888P\"  888  \"Y88P\"   \"Y88888  \"Y8888   \"Y8888       888        888     \"Y88P\"  888    888 888  \"Y8888  |");
		System.out.println( "|                          888                        888                                                                           |");
		System.out.println( "|                          888                   Y8b d88P                                                                           |"); 
		System.out.println( "|                          888                    \"Y88P\"                                                                            |");
		System.out.println( "*************************************************************************************************************************************n"); 
		
		System.out.println( "Please select from the following user options:");
		System.out.println( "\tEnter '1' to Update your First Name." );
		System.out.println( "\tEnter '2' to Update your Last Name." );
		System.out.println( "\tEnter '3' to Update your Address.");
		System.out.println( "\tEnter '4' to Update your Phone Number." );
		System.out.println( "\tEnter '5' to Update your Email." );
		System.out.println( "\tEnter '6' to Update your Password." );
		System.out.println( "\tEnter '7' when Finished Updating." );
		
		String userInput = "";
		System.out.print( "\nOption Selection : " );
		do {
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) && !userInput.equals( "3" ) && 
				!userInput.equals( "4" ) && !userInput.equals( "5" ) && !userInput.equals( "6" ) &&
				!userInput.equals( "7" ) );
		
		return userInput;
	}
	/* Displays the view for an employee to search for a customer's profile*/
	public static void displayCustomerProfile() {
		System.out.println( "******************************************************************************************************************************" );
		System.out.println( "|   888     888 d8b                              .d8888b.                    888                                             |" );
		System.out.println( "|   888     888 Y8P                             d88P  Y88b                   888                                             |" );
		System.out.println( "|   888     888                                 888    888                   888                                             |" ); 
		System.out.println( "|   Y88b   d88P 888  .d88b.  888  888  888      888        888  888 .d8888b  888888 .d88b.  88888b.d88b.   .d88b.  888d888   |" );
		System.out.println( "|    Y88b d88P  888 d8P  Y8b 888  888  888      888        888  888 88K      888   d88\"\"88b 888 \"888 \"88b d8P  Y8b 888P\"     |" );
		System.out.println( "|     Y88o88P   888 88888888 888  888  888      888    888 888  888 \"Y8888b. 888   888  888 888  888  888 88888888 888       |" ); 
		System.out.println( "|      Y888P    888 Y8b.     Y88b 888 d88P      Y88b  d88P Y88b 888      X88 Y88b. Y88..88P 888  888  888 Y8b.     888       |" );
		System.out.println( "|       Y8P     888  \"Y8888   \"Y8888888P\"        \"Y8888P\"   \"Y88888  88888P'  \"Y888 \"Y88P\"  888  888  888  \"Y8888  888       |" );
		System.out.println( "|                                                                                                                            |" );
		System.out.println( "|                                        8888888b.                   .d888 d8b 888                                           |" );
		System.out.println( "|                                        888   Y88b                 d88P\"  Y8P 888                                           |" );
		System.out.println( "|                                        888    888                 888        888                                           |" );
		System.out.println( "|                                        888   d88P 888d888 .d88b.  888888 888 888  .d88b.                                   |" );
		System.out.println( "|                                        8888888P\"  888P\"  d88\"\"88b 888    888 888 d8P  Y8b                                  |" );
		System.out.println( "|                                        888        888    888  888 888    888 888 88888888                                  |" );
		System.out.println( "|                                        888        888    Y88..88P 888    888 888 Y8b.                                      |" );
		System.out.println( "|                                        888        888     \"Y88P\"  888    888 888  \"Y8888                                   |" );
		System.out.println( "|                                                                                                                            |" );                                                                                                                        
		System.out.println( "******************************************************************************************************************************\n" ); 

	}
	
	public static void displayViewProfile() {
		System.out.println("*************************************************************************************************************************************");
		System.out.println("| 8888888888                        888                                          8888888b.                   .d888 d8b 888          |"); 
		System.out.println("| 888                               888                                          888   Y88b                 d88P\"  Y8P 888          |"); 
		System.out.println("| 888                               888                                          888    888                 888        888          |");
		System.out.println("| 8888888    88888b.d88b.  88888b.  888  .d88b.  888  888  .d88b.   .d88b.       888   d88P 888d888 .d88b.  888888 888 888  .d88b.  |");
		System.out.println("| 888        888 \"888 \"88b 888 \"88b 888 d88\"\"88b 888  888 d8P  Y8b d8P  Y8b      8888888P\"  888P\"  d88\"\"88b 888    888 888 d8P  Y8b |");
		System.out.println("| 888        888  888  888 888  888 888 888  888 888  888 88888888 88888888      888        888    888  888 888    888 888 88888888 |");
		System.out.println("| 888        888  888  888 888 d88P 888 Y88..88P Y88b 888 Y8b.     Y8b.          888        888    Y88..88P 888    888 888 Y8b.     |");
		System.out.println("| 8888888888 888  888  888 88888P\"  888  \"Y88P\"   \"Y88888  \"Y8888   \"Y8888       888        888     \"Y88P\"  888    888 888  \"Y8888  |");
		System.out.println("|                          888                        888                                                                           |");
		System.out.println("|                          888                   Y8b d88P                                                                           |"); 
		System.out.println("|                          888                    \"Y88P\"                                                                            |");
		System.out.println("*************************************************************************************************************************************n"); 

	}
}
