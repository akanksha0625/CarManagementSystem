package com.java.dbms.proj.views;

import java.util.Scanner;

public class ReceptionistView {
	public static String displayTaskUpdateInventory(Scanner input) {
		System.out.println("******************************************************************************************************************************************");
		System.out.println("| 888     888               888          888                 8888888                                     888                             |");
		System.out.println("| 888     888               888          888                   888                                       888                             |");
		System.out.println("| 888     888               888          888                   888                                       888                             |");
		System.out.println("| 888     888 88888b.   .d88888  8888b.  888888 .d88b.         888   88888b.  888  888  .d88b.  88888b.  888888 .d88b.  888d888 888  888 |");
		System.out.println("| 888     888 888 \"88b d88\" 888     \"88b 888   d8P  Y8b        888   888 \"88b 888  888 d8P  Y8b 888 \"88b 888   d88\"\"88b 888P\"   888  888 |");
		System.out.println("| 888     888 888  888 888  888 .d888888 888   88888888        888   888  888 Y88  88P 88888888 888  888 888   888  888 888     888  888 |");
		System.out.println("| Y88b. .d88P 888 d88P Y88b 888 888  888 Y88b. Y8b.            888   888  888  Y8bd8P  Y8b.     888  888 Y88b. Y88..88P 888     Y88b 888 |");
		System.out.println("|  \"Y88888P\"  88888P\"   \"Y88888 \"Y888888  \"Y888 \"Y8888       8888888 888  888   Y88P    \"Y8888  888  888  \"Y888 \"Y88P\"  888      \"Y88888 |");
		System.out.println("|             888                                                                                                                    888 |");
		System.out.println("|             888                                                                                                               Y8b d88P |");
		System.out.println("|             888                                                                                                                \"Y88P\"  |");
		System.out.println("******************************************************************************************************************************************\n");
		
		//TODO call controller to update inventory and to display some type of success message
		System.out.println("CALL CONTROLLER TO UPDATE INVENTORY");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to	Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		
		return userInput;
	}
	
	
	public static String displayTaskUpdateDeliveries(Scanner input) {
		System.out.println("******************************************************************************************************************************************");
		System.out.println("|  8888888b.                                       888      8888888b.           888 d8b                           d8b                    |");
		System.out.println("|  888   Y88b                                      888      888  \"Y88b          888 Y8P                           Y8P                    |");
		System.out.println("|  888    888                                      888      888    888          888                                                      |");
		System.out.println("|  888   d88P .d88b.   .d8888b .d88b.  888d888 .d88888      888    888  .d88b.  888 888 888  888  .d88b.  888d888 888  .d88b.  .d8888b   |");
		System.out.println("|  8888888P\" d8P  Y8b d88P\"   d88\"\"88b 888P\"  d88\" 888      888    888 d8P  Y8b 888 888 888  888 d8P  Y8b 888P\"   888 d8P  Y8b 88K       |");
		System.out.println("|  888 T88b  88888888 888     888  888 888    888  888      888    888 88888888 888 888 Y88  88P 88888888 888     888 88888888 \"Y8888b.  |");
		System.out.println("|  888  T88b Y8b.     Y88b.   Y88..88P 888    Y88b 888      888  .d88P Y8b.     888 888  Y8bd8P  Y8b.     888     888 Y8b.          X88  |");
		System.out.println("|  888   T88b \"Y8888   \"Y8888P \"Y88P\"  888     \"Y88888      8888888P\"   \"Y8888  888 888   Y88P    \"Y8888  888     888  \"Y8888   88888P'  |");
		System.out.println("******************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Enter Order ID");
		System.out.println("\tEnter '2' to	Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
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
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		
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
		System.out.println("\tEnter '1' to  Engine Knock");
		System.out.println("\tEnter '2' to	Car drifts in a particular direction");
		System.out.println("\tEnter '3' to  Battery does not hold charge");
		System.out.println("\tEnter '4' to	Black/Unclean exhaust");
		System.out.println("\tEnter '5' to  A/C-Heater not working");
		System.out.println("\tEnter '6' to	Headlamps/Taillamps not working");
		System.out.println("\tEnter '7' to  Check engine light");
		System.out.println("\tEnter '8' to	Go Back");
		
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
		
		//TODO call controller to find service date
		System.out.println("CALL CONTROLLER TO OFFER SERVICE DATES");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Repair on date");
		System.out.println("\tEnter '2' to	Go Back");
		
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
		System.out.println("\tEnter '1' to  Find Service Date");
		System.out.println("\tEnter '2' to	Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
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
		
		//TODO call controller to find service date
		System.out.println("CALL CONTROLLER TO OFFER SERVICE DATES");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Schedule On Date");
		System.out.println("\tEnter '2' to	Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayRescheduleService1(Scanner input) {
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
		
		//TODO add controller to ask for and display service history for that customer
		System.out.println("CONTROLLER TO GET USER EMAIL AND OUTPUT PAST SERVICES");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Pick a Service");
		System.out.println("\tEnter '2' to	Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayRescheduleService2(Scanner input) {
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
		
		//TODO call controller to find service date
		System.out.println("CALL CONTROLLER TO OFFER SERVICE DATES");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Reschedule Date");
		System.out.println("\tEnter '2' to	Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayRegisterCar(Scanner input) {
		System.out.println("***********************************************************************************************************************");
		System.out.println("|       8888888b.                   d8b          888                          .d8888b.                                |");
		System.out.println("|       888   Y88b                  Y8P          888                         d88P  Y88b                               |");
		System.out.println("|       888    888                               888                         888    888                               |");
		System.out.println("|       888   d88P .d88b.   .d88b.  888 .d8888b  888888 .d88b.  888d888      888         8888b.  888d888              |");
		System.out.println("|       8888888P\" d8P  Y8b d88P\"88b 888 88K      888   d8P  Y8b 888P\"        888            \"88b 888P\"                |");
		System.out.println("|       888 T88b  88888888 888  888 888 \"Y8888b. 888   88888888 888          888    888 .d888888 888                  |");
		System.out.println("|       888  T88b Y8b.     Y88b 888 888      X88 Y88b. Y8b.     888          Y88b  d88P 888  888 888                  |");
		System.out.println("|       888   T88b \"Y8888   \"Y88888 888  88888P'  \"Y888 \"Y8888  888           \"Y8888P\"  \"Y888888 888                  |");
		System.out.println("|                               888                                                                                   |");
		System.out.println("|                          Y8b d88P                                                                                   |");
		System.out.println("|                           \"Y88P\"                                                                                    |");
		System.out.println("***********************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Register");
		System.out.println("\tEnter '2' to	Cancel");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayLanding(Scanner input) {
		System.out.println("*************************************************************************************************************************************************************************");
		System.out.println("| 888       888          888                                              8888888b.                                    888    d8b                   d8b          888    |");
		System.out.println("| 888   o   888          888                                              888   Y88b                                   888    Y8P                   Y8P          888    |");
		System.out.println("| 888  d8b  888          888                                              888    888                                   888                                       888    |");
		System.out.println("| 888 d888b 888  .d88b.  888  .d8888b .d88b.  88888b.d88b.   .d88b.       888   d88P .d88b.   .d8888b .d88b.  88888b.  888888 888  .d88b.  88888b.  888 .d8888b  888888 |");
		System.out.println("| 888d88888b888 d8P  Y8b 888 d88P\"   d88\"\"88b 888 \"888 \"88b d8P  Y8b      8888888P\" d8P  Y8b d88P\"   d8P  Y8b 888 \"88b 888    888 d88\"\"88b 888 \"88b 888 88K      888    |");
		System.out.println("| 88888P Y88888 88888888 888 888     888  888 888  888  888 88888888      888 T88b  88888888 888     88888888 888  888 888    888 888  888 888  888 888 \"Y8888b. 888    |");
		System.out.println("| 8888P   Y8888 Y8b.     888 Y88b.   Y88..88P 888  888  888 Y8b.          888  T88b Y8b.     Y88b.   Y8b.     888 d88P Y88b.  888 Y88..88P 888  888 888      X88 Y88b.  |");
		System.out.println("| 888P     Y888  \"Y8888  888  \"Y8888P \"Y88P\"  888  888  888  \"Y8888       888   T88b \"Y8888   \"Y8888P \"Y8888  88888P\"   \"Y888 888  \"Y88P\"  888  888 888  88888P'  \"Y888 |");
		System.out.println("|                                                                                                             888                                                       |");
		System.out.println("|                                                                                                             888                                                       |");
		System.out.println("|                                                                                                             888                                                       |");
		System.out.println("*************************************************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Profile");
		System.out.println("\tEnter '2' to	View Customer Profile");
		System.out.println("\tEnter '3' to  Register Car");
		System.out.println("\tEnter '4' to	Service History");
		System.out.println("\tEnter '5' to  Schedule Service");
		System.out.println("\tEnter '6' to	Reschedule Service");
		System.out.println("\tEnter '7' to  Invoices");
		System.out.println("\tEnter '8' to	Daily task: Update Inventory");
		System.out.println("\tEnter '9' to  Daily task: Record Deliveries");
		System.out.println("\tEnter '10' to	Logout");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
				!userInput.equals("4") && !userInput.equals("5") && !userInput.equals("6") && 
				!userInput.equals("7") && !userInput.equals("8") && !userInput.equals("9") && !userInput.equals("10"));
		
		return userInput;
	}
	
	public static String displayInvoice(Scanner input) {
		System.out.println("***************************************************************************************");
		System.out.println("|           8888888                            d8b                                    |");
		System.out.println("|             888                              Y8P                                    |");
		System.out.println("|             888                                                                     |");
		System.out.println("|             888   88888b.  888  888  .d88b.  888  .d8888b .d88b.  .d8888b           |");
		System.out.println("|             888   888 \"88b 888  888 d88\"\"88b 888 d88P\"   d8P  Y8b 88K               |");
		System.out.println("|             888   888  888 Y88  88P 888  888 888 888     88888888 \"Y8888b.          |");
		System.out.println("|             888   888  888  Y8bd8P  Y88..88P 888 Y88b.   Y8b.          X88          |");
		System.out.println("|           8888888 888  888   Y88P    \"Y88P\"  888  \"Y8888P \"Y8888   88888P'          |");
		System.out.println("***************************************************************************************\n");
		
		//TODO call controller to dump in details
		System.out.println("CALL CONTROLLER TO GET INVOICE DETAILS\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back");
		
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		
		return userInput;
	}
}
