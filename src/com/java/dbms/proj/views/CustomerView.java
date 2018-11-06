package com.java.dbms.proj.views;

import java.util.Scanner;

public class CustomerView {
	public static String displayLanding(Scanner input) {
		System.out.println("******************************************************************************************************************************************************");
		System.out.println("| 888       888          888                                               .d8888b.                    888                                           |");                                       
		System.out.println("| 888   o   888          888                                              d88P  Y88b                   888                                           |");                                   
		System.out.println("| 888  d8b  888          888                                              888    888                   888                                           |");                              
		System.out.println("| 888 d888b 888  .d88b.  888  .d8888b .d88b.  88888b.d88b.   .d88b.       888        888  888 .d8888b  888888 .d88b.  88888b.d88b.   .d88b.  888d888 |");
		System.out.println("| 888d88888b888 d8P  Y8b 888 d88P\"   d88\"\"88b 888 \"888 \"88b d8P  Y8b      888        888  888 88K      888   d88\"\"88b 888 \"888 \"88b d8P  Y8b 888P\"   |");
		System.out.println("| 88888P Y88888 88888888 888 888     888  888 888  888  888 88888888      888    888 888  888 \"Y8888b. 888   888  888 888  888  888 88888888 888     |");
		System.out.println("| 8888P   Y8888 Y8b.     888 Y88b.   Y88..88P 888  888  888 Y8b.          Y88b  d88P Y88b 888      X88 Y88b. Y88..88P 888  888  888 Y8b.     888     |");    
		System.out.println("| 888P     Y888  \"Y8888  888  \"Y8888P \"Y88P\"  888  888  888  \"Y8888        \"Y8888P\"   \"Y88888  88888P'  \"Y888 \"Y88P\"  888  888  888  \"Y8888  888     |"); 
		System.out.println("******************************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Profile");
		System.out.println("\tEnter '2' to  Register Car");
		System.out.println("\tEnter '3' to  Services");
		System.out.println("\tEnter '4' to	Invoices");
		System.out.println("\tEnter '5' to  Logout");

		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
				!userInput.equals("4") && !userInput.equals("5"));
		
		return userInput;
	}
	
	public static void displaySignUp() {
		System.out.println("*****************************************************************************");
		System.out.println("|         .d8888b.  d8b                        888     888                  |");
		System.out.println("|        d88P  Y88b Y8P                        888     888                  |");
		System.out.println("|        Y88b.                                 888     888                  |");
		System.out.println("|         \"Y888b.   888  .d88b.  88888b.       888     888 88888b.          |");
		System.out.println("|            \"Y88b. 888 d88P\"88b 888 \"88b      888     888 888 \"88b         |");
		System.out.println("|              \"888 888 888  888 888  888      888     888 888  888         |");
		System.out.println("|        Y88b  d88P 888 Y88b 888 888  888      Y88b. .d88P 888 d88P         |");
		System.out.println("|         \"Y8888P\"  888  \"Y88888 888  888       \"Y88888P\"  88888P\"          |");
		System.out.println("|                            888                           888              |");
		System.out.println("|                       Y8b d88P                           888              |");
		System.out.println("|                        \"Y88P\"                            888              |");
		System.out.println("*****************************************************************************\n");
	}
	
	public static String displayProfile(Scanner input) {
		System.out.println("************************************************************************************************************************");
		System.out.println("        d8888                                            888         8888888b.                   .d888 d8b 888          |");        
		System.out.println("       d88888                                            888         888   Y88b                 d88P\"  Y8P 888          |");      
		System.out.println("      d88P888                                            888         888    888                 888        888          |");      
		System.out.println("     d88P 888  .d8888b .d8888b .d88b.  888  888 88888b.  888888      888   d88P 888d888 .d88b.  888888 888 888  .d88b.  |");
		System.out.println("    d88P  888 d88P\"   d88P\"   d88\"\"88b 888  888 888 \"88b 888         8888888P\"  888P\"  d88\"\"88b 888    888 888 d8P  Y8b |");
		System.out.println("   d88P   888 888     888     888  888 888  888 888  888 888         888        888    888  888 888    888 888 88888888 |");
		System.out.println("  d8888888888 Y88b.   Y88b.   Y88..88P Y88b 888 888  888 Y88b.       888        888    Y88..88P 888    888 888 Y8b.     |");   
		System.out.println(" d88P     888  \"Y8888P \"Y8888P \"Y88P\"   \"Y88888 888  888  \"Y888      888        888     \"Y88P\"  888    888 888  \"Y8888  |");                                                 
		System.out.println("************************************************************************************************************************\n"); 
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to View Profile.");
		System.out.println("\tEnter '2' to Update Profile." );
		System.out.println("\tEnter '3' to Go Back." );
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
				!userInput.equals("4") && !userInput.equals("5"));
		
		return userInput;
	}
	
	public static String displayInvoice(Scanner input) {
		System.out.println("*******************************************************************************************************************************************");
		System.out.println("|  .d8888b.                    888                                                8888888                            d8b                  |"); 
		System.out.println("| d88P  Y88b                   888                                                  888                              Y8P                  |"); 
		System.out.println("| 888    888                   888                                                  888                                                   |"); 
		System.out.println("| 888        888  888 .d8888b  888888 .d88b.  88888b.d88b.   .d88b.  888d888        888   88888b.  888  888  .d88b.  888  .d8888b .d88b.  |"); 
		System.out.println("| 888        888  888 88K      888   d88\"\"88b 888 \"888 \"88b d8P  Y8b 888P\"          888   888 \"88b 888  888 d88\"\"88b 888 d88P\"   d8P   8b |"); 
		System.out.println("| 888    888 888  888 \"Y8888b. 888   888  888 888  888  888 88888888 888            888   888  888 Y88  88P 888  888 888 888     88888888 |"); 
		System.out.println("| Y88b  d88P Y88b 888      X88 Y88b. Y88..88P 888  888  888 Y8b.     888            888   888  888  Y8bd8P  Y88..88P 888 Y88b.   Y8b.     |"); 
		System.out.println("|  \"Y8888P\"   \"Y88888  88888P'  \"Y888 \"Y88P\"  888  888  888  \"Y8888  888          8888888 888  888   Y88P    \"Y88P\"  888  \"Y8888P \"Y8888  |"); 
		System.out.println("*******************************************************************************************************************************************\n"); 
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  View Invoice details");
		System.out.println("\tEnter '2' to Go back");

		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayInvoiceDetails(Scanner input) {
		System.out.println("*********************************************************************************************************************");
		System.out.println("| 8888888                            d8b                       8888888b.           888             d8b 888          |"); 
		System.out.println("|   888                              Y8P                       888  \"Y88b          888             Y8P 888          |"); 
		System.out.println("|   888                                                        888    888          888                 888          |"); 
		System.out.println("|   888   88888b.  888  888  .d88b.  888  .d8888b .d88b.       888    888  .d88b.  888888  8888b.  888 888 .d8888b  |"); 
		System.out.println("|   888   888 \"88b 888  888 d88\"\"88b 888 d88P\"   d8P  Y8b      888    888 d8P  Y8b 888        \"88b 888 888 88K      |"); 
		System.out.println("|   888   888  888 Y88  88P 888  888 888 888     88888888      888    888 88888888 888    .d888888 888 888 \"Y8888b. |"); 
		System.out.println("|   888   888  888  Y8bd8P  Y88..88P 888 Y88b.   Y8b.          888  .d88P Y8b.     Y88b.  888  888 888 888      X88 |"); 
		System.out.println("| 8888888 888  888   Y88P    \"Y88P\"  888  \"Y8888P \"Y8888       8888888P\"   \"Y8888   \"Y888 \"Y888888 888 888  88888P' |"); 
		System.out.println("*********************************************************************************************************************\n");

		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		
		return userInput;
	}
	
	public static String displayCarRegistration(Scanner input) {
		System.out.println("*************************************************************************************************************************************");
		System.out.println("    .d8888b.                        8888888b.                   d8b          888                    888    d8b                      |");           
		System.out.println("   d88P  Y88b                       888   Y88b                  Y8P          888                    888    Y8P                      |");               
		System.out.println("   888    888                       888    888                               888                    888                             |");                    
		System.out.println("   888         8888b.  888d888      888   d88P .d88b.   .d88b.  888 .d8888b  888888 888d888 8888b.  888888 888  .d88b.  88888b.     |"); 
		System.out.println("   888            \"88b 888P\"        8888888P\" d8P  Y8b d88P\"88b 888 88K      888    888P\"      \"88b 888    888 d88\"\"88b 888 \"88b    |");
		System.out.println("   888    888 .d888888 888          888 T88b  88888888 888  888 888 \"Y8888b. 888    888    .d888888 888    888 888  888 888  888    |");
		System.out.println("   Y88b  d88P 888  888 888          888  T88b Y8b.     Y88b 888 888      X88 Y88b.  888    888  888 Y88b.  888 Y88..88P 888  888    |"); 
		System.out.println("    \"Y8888P\"  \"Y888888 888          888   T88b \"Y8888   \"Y88888 888  88888P'  \"Y888 888    \"Y888888  \"Y888 888  \"Y88P\"  888  888    |"); 
		System.out.println("                                                            888                                                                     |");                                              
		System.out.println("                                                       Y8b d88P                                                                     |");                                                       
		System.out.println("                                                        \"Y88P\"                                                                      |"); 
		System.out.println("*************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Register");
		System.out.println("\tEnter '2' to Cancel");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayReschedule1(Scanner input) {
		System.out.println("********************************************************************************************************************************************************");
		System.out.println("| 8888888b.                            888                    888          888                .d8888b.                            d8b                  |");
		System.out.println("| 888   Y88b                           888                    888          888               d88P  Y88b                           Y8P                  |");
		System.out.println("| 888    888                           888                    888          888               Y88b.                                                     |");
		System.out.println("| 888   d88P .d88b.  .d8888b   .d8888b 88888b.   .d88b.   .d88888 888  888 888  .d88b.        \"Y888b.    .d88b.  888d888 888  888 888  .d8888b .d88b.  |");
		System.out.println("| 8888888P\" d8P  Y8b 88K      d88P\"    888 \"88b d8P  Y8b d88\" 888 888  888 888 d8P  Y8b          \"Y88b. d8P  Y8b 888P\"   888  888 888 d88P\"   d8P  Y8b |");
		System.out.println("| 888 T88b  88888888 \"Y8888b. 888      888  888 88888888 888  888 888  888 888 88888888            \"888 88888888 888     Y88  88P 888 888     88888888 |");
		System.out.println("| 888  T88b Y8b.          X88 Y88b.    888  888 Y8b.     Y88b 888 Y88b 888 888 Y8b.          Y88b  d88P Y8b.     888      Y8bd8P  888 Y88b.   Y8b.     |");
		System.out.println("| 888   T88b \"Y8888   88888P'  \"Y8888P 888  888  \"Y8888   \"Y88888  \"Y88888 888  \"Y8888        \"Y8888P\"   \"Y8888  888       Y88P   888  \"Y8888P \"Y8888  |");
		System.out.println("********************************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Pick a service");
		System.out.println("\tEnter '2' to	Go back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	public static String displayReschedule2(Scanner input) {
		System.out.println("********************************************************************************************************************************************************");
		System.out.println("| 8888888b.                            888                    888          888                .d8888b.                            d8b                  |");
		System.out.println("| 888   Y88b                           888                    888          888               d88P  Y88b                           Y8P                  |");
		System.out.println("| 888    888                           888                    888          888               Y88b.                                                     |");
		System.out.println("| 888   d88P .d88b.  .d8888b   .d8888b 88888b.   .d88b.   .d88888 888  888 888  .d88b.        \"Y888b.    .d88b.  888d888 888  888 888  .d8888b .d88b.  |");
		System.out.println("| 8888888P\" d8P  Y8b 88K      d88P\"    888 \"88b d8P  Y8b d88\" 888 888  888 888 d8P  Y8b          \"Y88b. d8P  Y8b 888P\"   888  888 888 d88P\"   d8P  Y8b |");
		System.out.println("| 888 T88b  88888888 \"Y8888b. 888      888  888 88888888 888  888 888  888 888 88888888            \"888 88888888 888     Y88  88P 888 888     88888888 |");
		System.out.println("| 888  T88b Y8b.          X88 Y88b.    888  888 Y8b.     Y88b 888 Y88b 888 888 Y8b.          Y88b  d88P Y8b.     888      Y8bd8P  888 Y88b.   Y8b.     |");
		System.out.println("| 888   T88b \"Y8888   88888P'  \"Y8888P 888  888  \"Y8888   \"Y88888  \"Y88888 888  \"Y8888        \"Y8888P\"   \"Y8888  888       Y88P   888  \"Y8888P \"Y8888  |");
		System.out.println("********************************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Reschedule date");
		System.out.println("\tEnter '2' to	Go back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayScheduleMaintenance1(Scanner input) {
		System.out.println("*****************************************************************************************************************************************************************************");
		System.out.println("|   .d8888b.           888                    888          888               888b     d888          d8b          888                                                        |");
		System.out.println("|  d88P  Y88b          888                    888          888               8888b   d8888          Y8P          888                                                        |");
		System.out.println("|  Y88b.               888                    888          888               88888b.d88888                       888                                                        |");
		System.out.println("|   \"Y888b.    .d8888b 88888b.   .d88b.   .d88888 888  888 888  .d88b.       888Y88888P888  8888b.  888 88888b.  888888 .d88b.  88888b.   8888b.  88888b.   .d8888b .d88b.  |");
		System.out.println("|      \"Y88b. d88P\"    888 \"88b d8P  Y8b d88\" 888 888  888 888 d8P  Y8b      888 Y888P 888     \"88b 888 888 \"88b 888   d8P  Y8b 888 \"88b     \"88b 888 \"88b d88P\"   d8P  Y8b |");
		System.out.println("|         888 888      888  888 88888888 888  888 888  888 888 88888888      888  Y8P  888 .d888888 888 888  888 888   88888888 888  888 .d888888 888  888 888     88888888 |");
		System.out.println("|  Y88b  d88P Y88b.    888  888 Y8b.     Y88b 888 Y88b 888 888 Y8b.          888   \"   888 888  888 888 888  888 Y88b. Y8b.     888  888 888  888 888  888 Y88b.   Y8b.     |");
		System.out.println("|   \"Y8888P\"   \"Y8888P 888  888  \"Y8888   \"Y88888  \"Y88888 888  \"Y8888       888       888 \"Y888888 888 888  888  \"Y888 \"Y8888  888  888 \"Y888888 888  888  \"Y8888P \"Y8888  |");
		System.out.println("*****************************************************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Schedule Maintenance");
		System.out.println("\tEnter '2' to	Schedule Repair");
		System.out.println("\tEnter '3' to	Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
		
		return userInput;
	}
		
	public static String displayScheduleMaintenance2(Scanner input) {
		System.out.println("*****************************************************************************************************************************************************************************");
		System.out.println("|   .d8888b.           888                    888          888               888b     d888          d8b          888                                                        |");
		System.out.println("|  d88P  Y88b          888                    888          888               8888b   d8888          Y8P          888                                                        |");
		System.out.println("|  Y88b.               888                    888          888               88888b.d88888                       888                                                        |");
		System.out.println("|   \"Y888b.    .d8888b 88888b.   .d88b.   .d88888 888  888 888  .d88b.       888Y88888P888  8888b.  888 88888b.  888888 .d88b.  88888b.   8888b.  88888b.   .d8888b .d88b.  |");
		System.out.println("|      \"Y88b. d88P\"    888 \"88b d8P  Y8b d88\" 888 888  888 888 d8P  Y8b      888 Y888P 888     \"88b 888 888 \"88b 888   d8P  Y8b 888 \"88b     \"88b 888 \"88b d88P\"   d8P  Y8b |");
		System.out.println("|         888 888      888  888 88888888 888  888 888  888 888 88888888      888  Y8P  888 .d888888 888 888  888 888   88888888 888  888 .d888888 888  888 888     88888888 |");
		System.out.println("|  Y88b  d88P Y88b.    888  888 Y8b.     Y88b 888 Y88b 888 888 Y8b.          888   \"   888 888  888 888 888  888 Y88b. Y8b.     888  888 888  888 888  888 Y88b.   Y8b.     |");
		System.out.println("|   \"Y8888P\"   \"Y8888P 888  888  \"Y8888   \"Y88888  \"Y88888 888  \"Y8888       888       888 \"Y888888 888 888  888  \"Y888 \"Y8888  888  888 \"Y888888 888  888  \"Y8888P \"Y8888  |");
		System.out.println("*****************************************************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Schedule on Date");
		System.out.println("\tEnter '2' to	Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
		
	public static String displayScheduleRepair1(Scanner input) {
		System.out.println("******************************************************************************************************************************");
		System.out.println("|  .d8888b.           888                    888          888               8888888b.                            d8b         |"); 
		System.out.println("| d88P  Y88b          888                    888          888               888   Y88b                           Y8P         |");  
		System.out.println("| Y88b.               888                    888          888               888    888                                       |");  
		System.out.println("|  \"Y888b.    .d8888b 88888b.   .d88b.   .d88888 888  888 888  .d88b.       888   d88P .d88b.  88888b.   8888b.  888 888d888 |");  
		System.out.println("|     \"Y88b. d88P\"    888 \"88b d8P  Y8b d88\" 888 888  888 888 d8P  Y8b      8888888P\" d8P  Y8b 888 \"88b     \"88b 888 888P\"   |"); 
		System.out.println("|       \"888 888      888  888 88888888 888  888 888  888 888 88888888      888 T88b  88888888 888  888 .d888888 888 888     |");  
		System.out.println("| Y88b  d88P Y88b.    888  888 Y8b.     Y88b 888 Y88b 888 888 Y8b.          888  T88b Y8b.     888 d88P 888  888 888 888     |"); 
		System.out.println("|  \"Y8888P\"   \"Y8888P 888  888  \"Y8888   \"Y88888  \"Y88888 888  \"Y8888       888   T88b \"Y8888  88888P\"  \"Y888888 888 888     |"); 
		System.out.println("|                                                                                              888                           |");  
		System.out.println("|                                                                                              888                           |"); 
		System.out.println("|                                                                                              888                           |"); 
		System.out.println("******************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to select \"Engine knock\"");
		System.out.println("\tEnter '2' to select \"Car drifts in a particular direction\"");
		System.out.println("\tEnter '3' to select \"Battery does not hold charge\"");
		System.out.println("\tEnter '4' to select \"Black/unclean exhaust\"");
		System.out.println("\tEnter '5' to select \"A/C or Heater not working\"");
		System.out.println("\tEnter '6' to select \"Head-lamps or Tail-lamps not working\"");
		System.out.println("\tEnter '7' to select \"Check engine light\"");
		System.out.println("\tEnter '8' to Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
				!userInput.equals("4") && !userInput.equals("5") && !userInput.equals("6") && !userInput.equals("7") && !userInput.equals("8"));
		
		return userInput;
	}
		public static String displayScheduleRepair2(Scanner input) {
			System.out.println("******************************************************************************************************************************");
			System.out.println("|  .d8888b.           888                    888          888               8888888b.                            d8b         |"); 
			System.out.println("| d88P  Y88b          888                    888          888               888   Y88b                           Y8P         |");  
			System.out.println("| Y88b.               888                    888          888               888    888                                       |");  
			System.out.println("|  \"Y888b.    .d8888b 88888b.   .d88b.   .d88888 888  888 888  .d88b.       888   d88P .d88b.  88888b.   8888b.  888 888d888 |");  
			System.out.println("|     \"Y88b. d88P\"    888 \"88b d8P  Y8b d88\" 888 888  888 888 d8P  Y8b      8888888P\" d8P  Y8b 888 \"88b     \"88b 888 888P\"   |"); 
			System.out.println("|       \"888 888      888  888 88888888 888  888 888  888 888 88888888      888 T88b  88888888 888  888 .d888888 888 888     |");  
			System.out.println("| Y88b  d88P Y88b.    888  888 Y8b.     Y88b 888 Y88b 888 888 Y8b.          888  T88b Y8b.     888 d88P 888  888 888 888     |"); 
			System.out.println("|  \"Y8888P\"   \"Y8888P 888  888  \"Y8888   \"Y88888  \"Y88888 888  \"Y8888       888   T88b \"Y8888  88888P\"  \"Y888888 888 888     |"); 
			System.out.println("|                                                                                              888                           |");  
			System.out.println("|                                                                                              888                           |"); 
			System.out.println("|                                                                                              888                           |"); 
			System.out.println("******************************************************************************************************************************\n");
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to schedule your date for Repair");
			System.out.println("\tEnter '2' Go Back");
			
			String userInput = "";
			System.out.print("\nOption Selection : ");
			do {
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));
			
			return userInput;
		}
			
		public static String displayScheduleService(Scanner input) {
			System.out.println("*****************************************************************************************************************************************");
			System.out.println("|   .d8888b.           888                    888          888                .d8888b.                            d8b                   |");
			System.out.println("|  d88P  Y88b          888                    888          888               d88P  Y88b                           Y8P                   |");
			System.out.println("|  Y88b.               888                    888          888               Y88b.                                                      |");
			System.out.println("|     888b.    .d8888b 88888b.   .d88b.   .d88888 888  888 888  .d88b.        \"Y888b.    .d88b.  888d888 888  888 888  .d8888b .d88b.   |");
			System.out.println("|      \"Y88b. d88P\"    888 \"88b d8P  Y8b d88\" 888 888  888 888 d8P  Y8b          \"Y88b. d8P  Y8b 888P\"   888  888 888 d88P\"   d8P  Y8b  |");
			System.out.println("|         888 888      888  888 88888888 888  888 888  888 888 88888888            \"888 88888888 888     Y88  88P 888 888     88888888  |");
			System.out.println("|  Y88b  d88P Y88b.    888  888 Y8b.     Y88b 888 Y88b 888 888 Y8b.          Y88b  d88P Y8b.     888      Y8bd8P  888 Y88b.   Y8b.      |");
			System.out.println("|   \"Y8888P\"   \"Y8888P 888  888  \"Y8888   \"Y88888  \"Y88888 888  \"Y8888        \"Y8888P\"   \"Y8888  888       Y88P   888  \"Y8888P \"Y8888   |");
			System.out.println("*****************************************************************************************************************************************\n");
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to  Schedule Maintenance");
			System.out.println("\tEnter '2' to	Schedule Repair");
			System.out.println("\tEnter '3' to	Go Back");
			
			String userInput = "";
			System.out.print("\nOption Selection : ");
			do {
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
			
			return userInput;
		}
			
		public static String displayService(Scanner input) {
			System.out.println("************************************************************************************************************");
			System.out.println("|                            .d8888b.                            d8b                                       |");                  
			System.out.println("|                           d88P  Y88b                           Y8P                                       |");                
			System.out.println("|                          Y88b.                                                                           |");  
			System.out.println("|                           \"Y888b.    .d88b.  888d888 888  888 888  .d8888b .d88b.                        |");
			System.out.println("|                              \"Y88b. d8P  Y8b 888P\"   888  888 888 d88P\"   d8P  Y8b                       |");
			System.out.println("|                                \"888 88888888 888     Y88  88P 888 888     88888888                       |");
			System.out.println("|                          Y88b  d88P Y8b.     888      Y8bd8P  888 Y88b.   Y8b.                           |");   
			System.out.println("|                           \"Y8888P\"   \"Y8888  888       Y88P   888  \"Y8888P \"Y8888                        |");
			System.out.println("***********************************************************************************************************\n");
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to  View Service History");
			System.out.println("\tEnter '2' to	Schedule Services");
			System.out.println("\tEnter '3' to	Reshchedule Services");
			
			String userInput = "";
			System.out.print("\nOption Selection : ");
			do {
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
			
			return userInput;
		}
		
		public static String displayServiceHistory(Scanner input) {
			System.out.println("**************************************************************************************************************************");
			System.out.println("|  .d8888b.                            d8b                       888    888 d8b          888                             |");
			System.out.println("| d88P  Y88b                           Y8P                       888    888 Y8P          888                             |");
			System.out.println("| Y88b.                                                          888    888              888                             |");
			System.out.println("|  \"Y888b.    .d88b.  888d888 888  888 888  .d8888b .d88b.       8888888888 888 .d8888b  888888 .d88b.  888d888 888  888 |");
			System.out.println("|     \"Y88b. d8P  Y8b 888P\"   888  888 888 d88P\"   d8P  Y8b      888    888 888 88K      888   d88\"\"88b 888P\"   888  888 |"); 
			System.out.println("|       \"888 88888888 888     Y88  88P 888 888     88888888      888    888 888 \"Y8888b. 888   888  888 888     888  888 |");
			System.out.println("| Y88b  d88P Y8b.     888      Y8bd8P  888 Y88b.   Y8b.          888    888 888      X88 Y88b. Y88..88P 888     Y88b 888 |");
			System.out.println("|  \"Y8888P\"   \"Y8888  888       Y88P   888  \"Y8888P \"Y8888       888    888 888  88888P'  \"Y888 \"Y88P\"  888      \"Y88888 |");
			System.out.println("|                                                                                                                    888 |"); 
			System.out.println("|                                                                                                               Y8b d88P |");
			System.out.println("|                                                                                                                \"Y88P\"  |");
			System.out.println("**************************************************************************************************************************\n");
			
			//TODO Call controller to display customer's service history
			System.out.println("CALLING CONTROLLER TO DISPLAY CUSTOMER SERVICE HISTORY\n");
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to  Go Back");
			
			String userInput = "";
			System.out.print("\nOption Selection : ");
			do {
				userInput = input.nextLine();
			}while(!userInput.equals("1"));
			
			return userInput;
		}
			
		public static String displayUpdateProfile(Scanner input) {
			System.out.println("*************************************************************************************************************************************");
			System.out.println("  .d8888b.                    888                                                8888888b.                   .d888 d8b 888          |");
			System.out.println(" d88P  Y88b                   888                                                888   Y88b                 d88P\"  Y8P 888          |"); 
			System.out.println(" 888    888                   888                                                888    888                 888        888          |"); 
			System.out.println(" 888        888  888 .d8888b  888888 .d88b.  88888b.d88b.   .d88b.  888d888      888   d88P 888d888 .d88b.  888888 888 888  .d88b.  |"); 
			System.out.println(" 888        888  888 88K      888   d88\"\"88b 888 \"888 \"88b d8P  Y8b 888P\"        8888888P\"  888P\"  d88\"\"88b 888    888 888 d8P  Y8b |"); 
			System.out.println(" 888    888 888  888 \"Y8888b. 888   888  888 888  888  888 88888888 888          888        888    888  888 888    888 888 88888888 |"); 
			System.out.println(" Y88b  d88P Y88b 888      X88 Y88b. Y88..88P 888  888  888 Y8b.     888          888        888    Y88..88P 888    888 888 Y8b.     |"); 
			System.out.println("   Y8888P\"   \"Y88888  88888P'  \"Y888 \"Y88P\"  888  888  888  \"Y8888  888          888        888     \"Y88P\"  888    888 888  \"Y8888  |");                                            
			System.out.println("*************************************************************************************************************************************\n"); 
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Update your First Name." );
			System.out.println("\tEnter '2' to Update your Last Name." );
			System.out.println("\tEnter '3' to Update your Address.");
			System.out.println("\tEnter '4' to Update your Phone Number." );
			System.out.println("\tEnter '5' to Update your Email." );
			System.out.println("\tEnter '6' to Update your Password." );
			
			String userInput = "";
			System.out.print("\nOption Selection : ");
			do {
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
					!userInput.equals("4") && !userInput.equals("5") && !userInput.equals("6"));
			
			return userInput;
		}
			
		public static String displayViewProfile(Scanner input) {
			System.out.println("*************************************************************************************************************************************");
			System.out.println("  .d8888b.                    888                                                8888888b.                   .d888 d8b 888          |");
			System.out.println(" d88P  Y88b                   888                                                888   Y88b                 d88P\"  Y8P 888          |"); 
			System.out.println(" 888    888                   888                                                888    888                 888        888          |"); 
			System.out.println(" 888        888  888 .d8888b  888888 .d88b.  88888b.d88b.   .d88b.  888d888      888   d88P 888d888 .d88b.  888888 888 888  .d88b.  |"); 
			System.out.println(" 888        888  888 88K      888   d88\"\"88b 888 \"888 \"88b d8P  Y8b 888P\"        8888888P\"  888P\"  d88\"\"88b 888    888 888 d8P  Y8b |"); 
			System.out.println(" 888    888 888  888 \"Y8888b. 888   888  888 888  888  888 88888888 888          888        888    888  888 888    888 888 88888888 |"); 
			System.out.println(" Y88b  d88P Y88b 888      X88 Y88b. Y88..88P 888  888  888 Y8b.     888          888        888    Y88..88P 888    888 888 Y8b.     |"); 
			System.out.println("   Y8888P\"   \"Y88888  88888P'  \"Y888 \"Y88P\"  888  888  888  \"Y8888  888          888        888     \"Y88P\"  888    888 888  \"Y8888  |");                                            
			System.out.println("*************************************************************************************************************************************\n"); 
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Go Back." );
			
			String userInput = "";
			System.out.print("\nOption Selection : ");
			do {
				userInput = input.nextLine();
			}while(!userInput.equals("1"));
			
			return userInput;
		}
}
