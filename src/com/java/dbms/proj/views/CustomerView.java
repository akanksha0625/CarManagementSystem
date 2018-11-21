package com.java.dbms.proj.views;

import java.util.Scanner;

import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.common.ClearConsole;


public class CustomerView {
	public static String displayLanding(Scanner input) {
		ClearConsole.clearConsole();
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
		System.out.println("\tEnter '1' to Profile");
		System.out.println("\tEnter '2' to Register Car");
		System.out.println("\tEnter '3' to Services");
		System.out.println("\tEnter '4' to Invoices");
		System.out.println("\tEnter '5' to Logout");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
				!userInput.equals("4") && !userInput.equals("5"));
		
		return userInput;
	}
	
	public static void displaySignUp() {
		ClearConsole.clearConsole();
		System.out.println("***************************************************************************************");
		System.out.println("|              .d8888b.  d8b                        888     888                       |");
		System.out.println("|             d88P  Y88b Y8P                        888     888                       |");
		System.out.println("|             Y88b.                                 888     888                       |");
		System.out.println("|              \"Y888b.   888  .d88b.  88888b.       888     888 88888b.               |");
		System.out.println("|                 \"Y88b. 888 d88P\"88b 888 \"88b      888     888 888 \"88b              |");
		System.out.println("|                   \"888 888 888  888 888  888      888     888 888  888              |");
		System.out.println("|             Y88b  d88P 888 Y88b 888 888  888      Y88b. .d88P 888 d88P              |");
		System.out.println("|              \"Y8888P\"  888  \"Y88888 888  888       \"Y88888P\"  88888P\"               |");
		System.out.println("|                                 888                           888                   |");
		System.out.println("|                            Y8b d88P                           888                   |");
		System.out.println("|                             \"Y88P\"                            888                   |");
		System.out.println("***************************************************************************************\n");
	}
	
	public static void displayProfile() {
		ClearConsole.clearConsole();
		System.out.println("************************************************************************************************************************");
		System.out.println("|        d8888                                            888         8888888b.                   .d888 d8b 888          |");        
		System.out.println("|       d88888                                            888         888   Y88b                 d88P\"  Y8P 888          |");      
		System.out.println("|      d88P888                                            888         888    888                 888        888          |");      
		System.out.println("|     d88P 888  .d8888b .d8888b .d88b.  888  888 88888b.  888888      888   d88P 888d888 .d88b.  888888 888 888  .d88b.  |");
		System.out.println("|    d88P  888 d88P\"   d88P\"   d88\"\"88b 888  888 888 \"88b 888         8888888P\"  888P\"  d88\"\"88b 888    888 888 d8P  Y8b |");
		System.out.println("|   d88P   888 888     888     888  888 888  888 888  888 888         888        888    888  888 888    888 888 88888888 |");
		System.out.println("|  d8888888888 Y88b.   Y88b.   Y88..88P Y88b 888 888  888 Y88b.       888        888    Y88..88P 888    888 888 Y8b.     |");   
		System.out.println("| d88P     888  \"Y8888P \"Y8888P \"Y88P\"   \"Y88888 888  888  \"Y888      888        888     \"Y88P\"  888    888 888  \"Y8888  |");                                                 
		System.out.println("************************************************************************************************************************\n"); 
	}
	
	public static void displayInvoice() {
		ClearConsole.clearConsole();
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
	}
	
	public static void displayInvoiceDetails() {
		ClearConsole.clearConsole();
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
	}
	
	public static void displayCarRegistration() {
		ClearConsole.clearConsole();
		System.out.println("*************************************************************************************************************************************");
		System.out.println("|    .d8888b.                        8888888b.                   d8b          888                    888    d8b                      |");           
		System.out.println("|   d88P  Y88b                       888   Y88b                  Y8P          888                    888    Y8P                      |");               
		System.out.println("|   888    888                       888    888                               888                    888                             |");                    
		System.out.println("|   888         8888b.  888d888      888   d88P .d88b.   .d88b.  888 .d8888b  888888 888d888 8888b.  888888 888  .d88b.  88888b.     |"); 
		System.out.println("|   888            \"88b 888P\"        8888888P\" d8P  Y8b d88P\"88b 888 88K      888    888P\"      \"88b 888    888 d88\"\"88b 888 \"88b    |");
		System.out.println("|   888    888 .d888888 888          888 T88b  88888888 888  888 888 \"Y8888b. 888    888    .d888888 888    888 888  888 888  888    |");
		System.out.println("|   Y88b  d88P 888  888 888          888  T88b Y8b.     Y88b 888 888      X88 Y88b.  888    888  888 Y88b.  888 Y88..88P 888  888    |"); 
		System.out.println("|    \"Y8888P\"  \"Y888888 888          888   T88b \"Y8888   \"Y88888 888  88888P'  \"Y888 888    \"Y888888  \"Y888 888  \"Y88P\"  888  888    |"); 
		System.out.println("|                                                            888                                                                     |");                                              
		System.out.println("|                                                       Y8b d88P                                                                     |");                                                       
		System.out.println("|                                                        \"Y88P\"                                                                      |"); 
		System.out.println("*************************************************************************************************************************************\n");
	}
	
	public static void displayReschedule1() {
		ClearConsole.clearConsole();
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
	}
	public static void displayReschedule2() {
		ClearConsole.clearConsole();
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
	}
	
	public static void displayScheduleMaintenance1() {
		ClearConsole.clearConsole();
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
	}
		
	public static void displayScheduleMaintenance2() {
		ClearConsole.clearConsole();
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
	}
		
	public static void displayScheduleRepair1() {
		ClearConsole.clearConsole();
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
	}
		public static void displayScheduleRepair2() {
			ClearConsole.clearConsole();
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
		}
			
		public static void displayScheduleService() {
			ClearConsole.clearConsole();
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
		}
			
		public static void displayService() {
			ClearConsole.clearConsole();
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
		}
		
		public static void displayServiceHistory() {
			ClearConsole.clearConsole();
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
		}
			
		public static void displayUpdateProfile() {
			ClearConsole.clearConsole();
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
		}
			
		public static void displayViewProfile( ) {
			ClearConsole.clearConsole();
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
		}
}
