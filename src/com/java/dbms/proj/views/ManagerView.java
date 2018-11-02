package com.java.dbms.proj.views;
import java.util.Scanner;

public class ManagerView {
	public static String dsiplayAddEmployee(Scanner input) {
		System.out.println("*********************************************************************************************************************************************************");
		System.out.println("|        d8888      888      888      888b    888                             8888888888                        888                                      |");
		System.out.println("|       d88888      888      888      8888b   888                             888                               888                                      |");
		System.out.println("|      d88P888      888      888      88888b  888                             888                               888                                      |");
		System.out.println("|     d88P 888  .d88888  .d88888      888Y88b 888  .d88b.  888  888  888      8888888    88888b.d88b.  88888b.  888  .d88b.  888  888  .d88b.   .d88b.   |");
		System.out.println("|    d88P  888 d88\" 888 d88\" 888      888 Y88b888 d8P  Y8b 888  888  888      888        888 \"888 \"88b 888 \"88b 888 d88\"\"88b 888  888 d8P  Y8b d8P  Y8b  |");
		System.out.println("|   d88P   888 888  888 888  888      888  Y88888 88888888 888  888  888      888        888  888  888 888  888 888 888  888 888  888 88888888 88888888  |");
		System.out.println("|  d8888888888 Y88b 888 Y88b 888      888   Y8888 Y8b.     Y88b 888 d88P      888        888  888  888 888 d88P 888 Y88..88P Y88b 888 Y8b.     Y8b.      |");
		System.out.println("| d88P     888  \"Y88888  \"Y88888      888    Y888  \"Y8888   \"Y8888888P\"       8888888888 888  888  888 88888P\"  888  \"Y88P\"   \"Y88888  \"Y8888   \"Y8888   |");
		System.out.println("|                                                                                                      888                        888                    |");
		System.out.println("|                                                                                                      888                   Y8b d88P                    |");
		System.out.println("|                                                                                                      888                    \"Y88P\"                     |");
		System.out.println("**********************************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to	Add");
		System.out.println("\tEnter '2' to	Go Back");

		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayPayroll(Scanner input) {
		
		System.out.println("*****************************************************************************************************************************");
		System.out.println("|                               8888888b.                                   888 888                                         |");
		System.out.println("|                               888   Y88b                                  888 888                                         |");
		System.out.println("|                               888    888                                  888 888                                         |");
		System.out.println("|                               888   d88P 8888b.  888  888 888d888 .d88b.  888 888                                         |");
		System.out.println("|                               8888888P\"     \"88b 888  888 888P\"  d88\"\"88b 888 888                                         |");
		System.out.println("|                               888       .d888888 888  888 888    888  888 888 888                                         |");
		System.out.println("|                               888       888  888 Y88b 888 888    Y88..88P 888 888                                         |");
		System.out.println("|                               888       \"Y888888  \"Y88888 888     \"Y88P\"  888 888                                         |");
		System.out.println("|                                                       888                                                                 |");
		System.out.println("|                                                  Y8b d88P                                                                 |");
		System.out.println("|                                                   \"Y88P\"                                                                  |");
		System.out.println("*****************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Enter Employee ID");
		System.out.println("\tEnter '2' to Go Back");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayOrders(Scanner input) {
		System.out.println("*****************************************************************************************************************************");
		System.out.println("|                                    .d88888b.              888                                                             |");
		System.out.println("|                                   d88P\" \"Y88b             888                                                             |");
		System.out.println("|                                   888     888             888                                                             |");
		System.out.println("|                                   888     888 888d888 .d88888  .d88b.  888d888 .d8888b                                    |");
		System.out.println("|                                   888     888 888P\"  d88\" 888 d8P  Y8b 888P\"   88K                                        |");
		System.out.println("|                                   888     888 888    888  888 88888888 888     \"Y8888b.                                   |");
		System.out.println("|                                   Y88b. .d88P 888    Y88b 888 Y8b.     888          X88                                   |");
		System.out.println("|                                    \"Y88888P\"  888     \"Y88888  \"Y8888  888      88888P'                                   |");
		System.out.println("*****************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Order History");
		System.out.println("\tEnter '2' to New Order");
		System.out.println("\tEnter '3' to Go Back");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
		
		return userInput;
	}
	
	public static String displayOrderHistory(Scanner input) {
		System.out.println("***************************************************************************************************************************");
		System.out.println("|        .d88888b.              888                       888    888 d8b          888                                     |");
		System.out.println("|       d88P\" \"Y88b             888                       888    888 Y8P          888                                     |");
		System.out.println("|       888     888             888                       888    888              888                                     |");
		System.out.println("|       888     888 888d888 .d88888  .d88b.  888d888      8888888888 888 .d8888b  888888 .d88b.  888d888 888  888         |");
		System.out.println("|       888     888 888P\"  d88\" 888 d8P  Y8b 888P\"        888    888 888 88K      888   d88\"\"88b 888P\"   888  888         |");
		System.out.println("|       888     888 888    888  888 88888888 888          888    888 888 \"Y8888b. 888   888  888 888     888  888         |");
		System.out.println("|       Y88b. .d88P 888    Y88b 888 Y8b.     888          888    888 888      X88 Y88b. Y88..88P 888     Y88b 888         |");
		System.out.println("|        \"Y88888P\"  888     \"Y88888  \"Y8888  888          888    888 888  88888P'  \"Y888 \"Y88P\"  888      \"Y88888         |");
		System.out.println("|                                                                                                             888         |");
		System.out.println("|                                                                                                        Y8b d88P         |");
		System.out.println("|                                                                                                         \"Y88P\"          |");
		System.out.println("***************************************************************************************************************************\n");
		
		//TODO call controller that will dump order history details into view
		System.out.println("CALL CONTROLLER TO GET ORDER DETAILS\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		
		return userInput;
	}
	
	public static String displayNewOrder(Scanner input) {
		System.out.println("***************************************************************************************************************");
		System.out.println("|             888b    888                              .d88888b.              888                              |");
		System.out.println("|             8888b   888                             d88P\" \"Y88b             888                              |");
		System.out.println("|             88888b  888                             888     888             888                              |");
		System.out.println("|             888Y88b 888  .d88b.  888  888  888      888     888 888d888 .d88888  .d88b.  888d888             |");
		System.out.println("|             888 Y88b888 d8P  Y8b 888  888  888      888     888 888P\"  d88\" 888 d8P  Y8b 888P\"               |");
		System.out.println("|             888  Y88888 88888888 888  888  888      888     888 888    888  888 88888888 888                 |");
		System.out.println("|             888   Y8888 Y8b.     Y88b 888 d88P      Y88b. .d88P 888    Y88b 888 Y8b.     888                 |");
		System.out.println("|             888    Y888  \"Y8888   \"Y8888888P\"        \"Y88888P\"  888     \"Y88888  \"Y8888  888                 |");
		System.out.println("****************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Place Orders");
		System.out.println("\tEnter '2' to Go Back");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayNotifications(Scanner input) {		
		System.out.println("***************************************************************************************************************************");
		System.out.println("|        888b    888          888    d8b  .d888 d8b                   888    d8b                                          |");
		System.out.println("|        8888b   888          888    Y8P d88P\"  Y8P                   888    Y8P                                          |");
		System.out.println("|        88888b  888          888        888                          888                                                 |");
		System.out.println("|        888Y88b 888  .d88b.  888888 888 888888 888  .d8888b  8888b.  888888 888  .d88b.  88888b.  .d8888b                |");
		System.out.println("|        888 Y88b888 d88\"\"88b 888    888 888    888 d88P\"        \"88b 888    888 d88\"\"88b 888 \"88b 88K                    |");
		System.out.println("|        888  Y88888 888  888 888    888 888    888 888      .d888888 888    888 888  888 888  888 \"Y8888b.               |");
		System.out.println("|        888   Y8888 Y88..88P Y88b.  888 888    888 Y88b.    888  888 Y88b.  888 Y88..88P 888  888      X88               |");
		System.out.println("|        888    Y888  \"Y88P\"   \"Y888 888 888    888  \"Y8888P \"Y888888  \"Y888 888  \"Y88P\"  888  888  88888P'               |");
		System.out.println("***************************************************************************************************************************\n");
		
		//TODO call controller to dump notifications into view
		System.out.println("CALL CONTROLLER TO GET NOTIFICATION\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to	Order ID");
		System.out.println("\tEnter '2' to	Go Back");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
	
	public static String displayNotificationsDetail() {		
		System.out.println("*******************************************************************************************************************************************************");
		System.out.println("| 888b    888          888    d8b  .d888 d8b                   888    d8b                        8888888b.           888             d8b 888          |");
		System.out.println("| 8888b   888          888    Y8P d88P\"  Y8P                   888    Y8P                        888  \"Y88b          888             Y8P 888          |");
		System.out.println("| 88888b  888          888        888                          888                               888    888          888                 888          |");
		System.out.println("| 888Y88b 888  .d88b.  888888 888 888888 888  .d8888b  8888b.  888888 888  .d88b.  88888b.       888    888  .d88b.  888888  8888b.  888 888 .d8888b  |");
		System.out.println("| 888 Y88b888 d88\"\"88b 888    888 888    888 d88P\"        \"88b 888    888 d88\"\"88b 888 \"88b      888    888 d8P  Y8b 888        \"88b 888 888 88K      |");
		System.out.println("| 888  Y88888 888  888 888    888 888    888 888      .d888888 888    888 888  888 888  888      888    888 88888888 888    .d888888 888 888 \"Y8888b. |");
		System.out.println("| 888   Y8888 Y88..88P Y88b.  888 888    888 Y88b.    888  888 Y88b.  888 Y88..88P 888  888      888  .d88P Y8b.     Y88b.  888  888 888 888      X88 |");
		System.out.println("| 888    Y888  \"Y88P\"   \"Y888 888 888    888  \"Y8888P \"Y888888  \"Y888 888  \"Y88P\"  888  888      8888888P\"   \"Y8888   \"Y888 \"Y888888 888 888  88888P' |");
		System.out.println("*******************************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to	Go Back");
		
		Scanner input = new Scanner(System.in);
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		input.close();
		
		return userInput;
	}
	
	public static String displayLanding(Scanner input) {
		System.out.println("**********************************************************************************************************************************************");
		System.out.println("| 888       888          888                                              888b     d888                                                      |"); 
		System.out.println("| 888   o   888          888                                              8888b   d8888                                                      |"); 
		System.out.println("| 888  d8b  888          888                                              88888b.d88888                                                      |"); 
		System.out.println("| 888 d888b 888  .d88b.  888  .d8888b .d88b.  88888b.d88b.   .d88b.       888Y88888P888  8888b.  88888b.   8888b.   .d88b.   .d88b.  888d888 |"); 
		System.out.println("| 888d88888b888 d8P  Y8b 888 d88P\"   d88\"\"88b 888 \"888 \"88b d8P  Y8b      888 Y888P 888     \"88b 888 \"88b     \"88b d88P\"88b d8P  Y8b 888P\"   |"); 
		System.out.println("| 88888P Y88888 88888888 888 888     888  888 888  888  888 88888888      888  Y8P  888 .d888888 888  888 .d888888 888  888 88888888 888     |"); 
		System.out.println("| 8888P   Y8888 Y8b.     888 Y88b.   Y88..88P 888  888  888 Y8b.          888   \"   888 888  888 888  888 888  888 Y88b 888 Y8b.     888     |"); 
		System.out.println("| 888P     Y888  \"Y8888  888  \"Y8888P \"Y88P\"  888  888  888  \"Y8888       888       888 \"Y888888 888  888 \"Y888888  \"Y88888  \"Y8888  888     |"); 
		System.out.println("|                                                                                                                       888                  |"); 
		System.out.println("|                                                                                                                  Y8b d88P                  |"); 
		System.out.println("|                                                                                                                   \"Y88P\"                   |"); 
		System.out.println("**********************************************************************************************************************************************\n");
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1'  to Profile");
		System.out.println("\tEnter '2'  to	View Customer Profile");
		System.out.println("\tEnter '3'  to Add new Employee");
		System.out.println("\tEnter '4'  to	Payroll");
		System.out.println("\tEnter '5'  to Inventory");
		System.out.println("\tEnter '6'  to	Orders");
		System.out.println("\tEnter '7'  to Notifications");
		System.out.println("\tEnter '8'  to	New Car Model");
		System.out.println("\tEnter '9'  to Car Service Details");
		System.out.println("\tEnter '10' to	Service History");
		System.out.println("\tEnter '11' to	Invoices");
		System.out.println("\tEnter '12' to	Logout");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") && !userInput.equals("4") &&
				!userInput.equals("5") && !userInput.equals("6") && !userInput.equals("7") && !userInput.equals("8") &&
				!userInput.equals("9") && !userInput.equals("10") && !userInput.equals("11") && !userInput.equals("12"));

		return userInput;
	}
	
	public static String displayInvoices(Scanner input) {
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
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		
		return userInput;
	}
	
	public static String displayInventory(Scanner input) {
		System.out.println("*****************************************************************************************************************************");
		System.out.println("|                     8888888                                     888                                                       |");
		System.out.println("|                       888                                       888                                                       |");
		System.out.println("|                       888                                       888                                                       |");
		System.out.println("|                       888   88888b.  888  888  .d88b.  88888b.  888888 .d88b.  888d888 888  888                           |");
		System.out.println("|                       888   888 \"88b 888  888 d8P  Y8b 888 \"88b 888   d88\"\"88b 888P\"   888  888                           |");
		System.out.println("|                       888   888  888 Y88  88P 88888888 888  888 888   888  888 888     888  888                           |");
		System.out.println("|                       888   888  888  Y8bd8P  Y8b.     888  888 Y88b. Y88..88P 888     Y88b 888                           |");
		System.out.println("|                     8888888 888  888   Y88P    \"Y8888  888  888  \"Y888 \"Y88P\"  888      \"Y88888                           |");
		System.out.println("|                                                                                             888                           |");
		System.out.println("|                                                                                        Y8b d88P                           |");
		System.out.println("|                                                                                         \"Y88P\"                            |");
		System.out.println("*****************************************************************************************************************************\n");

		//TODO call inventory controller to dump the details in
		System.out.println("CALL CONTROLLER TO GET INVENTORY DETAILS\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		
		return userInput;
	}
	
	public static String displayCarServiceDetails(Scanner input) {
		System.out.println("********************************************************************************************************************************************************");
		System.out.println("|  .d8888b.                         .d8888b.                            d8b                       8888888b.           888             d8b 888          |");
		System.out.println("| d88P  Y88b                       d88P  Y88b                           Y8P                       888  \"Y88b          888             Y8P 888          |");
		System.out.println("| 888    888                       Y88b.                                                          888    888          888                 888          |");
		System.out.println("| 888         8888b.  888d888       \"Y888b.    .d88b.  888d888 888  888 888  .d8888b .d88b.       888    888  .d88b.  888888  8888b.  888 888 .d8888b  |");
		System.out.println("| 888            \"88b 888P\"            \"Y88b. d8P  Y8b 888P\"   888  888 888 d88P\"   d8P  Y8b      888    888 d8P  Y8b 888        \"88b 888 888 88K      |");
		System.out.println("| 888    888 .d888888 888                \"888 88888888 888     Y88  88P 888 888     88888888      888    888 88888888 888    .d888888 888 888 \"Y8888b. |");
		System.out.println("| Y88b  d88P 888  888 888          Y88b  d88P Y8b.     888      Y8bd8P  888 Y88b.   Y8b.          888  .d88P Y8b.     Y88b.  888  888 888 888      X88 |");
		System.out.println("|  \"Y8888P\"  \"Y888888 888           \"Y8888P\"   \"Y8888  888       Y88P   888  \"Y8888P \"Y8888       8888888P\"   \"Y8888   \"Y888 \"Y888888 888 888  88888P' |");
		System.out.println("********************************************************************************************************************************************************\n");
		
		//TODO call controller to dump the details in
		System.out.println("CALL CONTROLLER TO GET SERVICE DETAILS\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to	Go Back");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		
		return userInput;
	}
	
	public static String displayServiceHistory(Scanner input) {
		System.out.println("**************************************************************************************************************************");
		System.out.println("|  .d8888b.                            d8b                       888    888 d8b          888                             |");
		System.out.println("| d88P  Y88b                           Y8P                       888    888 Y8P          888                             |");
		System.out.println("| Y88b.                                                          888    888              888                             |");
		System.out.println("|  \"Y888b.    .d88b.  888d888 888  888 888  .d8888b .d88b.       8888888888 888 .d8888b  888888 .d88b.  888d888 888  888 |");
		System.out.println("|	  \"Y88b. d8P  Y8b 888P\"   888  888 888 d88P\"   d8P  Y8b      888    888 888 88K      888   d88\"\"88b 888P\"   888  888 |"); 
		System.out.println("|	    \"888 88888888 888     Y88  88P 888 888     88888888      888    888 888 \"Y8888b. 888   888  888 888     888  888 |");
		System.out.println("| Y88b  d88P Y8b.     888      Y8bd8P  888 Y88b.   Y8b.          888    888 888      X88 Y88b. Y88..88P 888     Y88b 888 |");
		System.out.println("|  \"Y8888P\"   \"Y8888  888       Y88P   888  \"Y8888P \"Y8888       888    888 888  88888P'  \"Y888 \"Y88P\"  888      \"Y88888 |");
		System.out.println("|	                                                                                                                 888 |"); 
		System.out.println("|	                                                                                                            Y8b d88P |");
		System.out.println("|	                                                                                                             \"Y88P\"  |");
		System.out.println("**************************************************************************************************************************\n");
		
		//TODO call controller to dump details in
		System.out.println("CALL CONTROLLER TO GET SERVICE HISTORY DETAILS\n");
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to	Go Back");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
		
		return userInput;
	}
	
	public static String displayNewCarModel(Scanner input) {
		System.out.println("*************************************************************************************************************************");
		System.out.println("| 888b    888                              .d8888b.                        888b     d888               888          888 |");
		System.out.println("| 8888b   888                             d88P  Y88b                       8888b   d8888               888          888 |");
		System.out.println("| 88888b  888                             888    888                       88888b.d88888               888          888 |");
		System.out.println("| 888Y88b 888  .d88b.  888  888  888      888         8888b.  888d888      888Y88888P888  .d88b.   .d88888  .d88b.  888 |");
		System.out.println("| 888 Y88b888 d8P  Y8b 888  888  888      888            \"88b 888P\"        888 Y888P 888 d88\"\"88b d88\" 888 d8P  Y8b 888 |");
		System.out.println("| 888  Y88888 88888888 888  888  888      888    888 .d888888 888          888  Y8P  888 888  888 888  888 88888888 888 |");
		System.out.println("| 888   Y8888 Y8b.     Y88b 888 d88P      Y88b  d88P 888  888 888          888   \"   888 Y88..88P Y88b 888 Y8b.     888 |");
		System.out.println("| 888    Y888  \"Y8888   \"Y8888888P\"        \"Y8888P\"  \"Y888888 888          888       888  \"Y88P\"   \"Y88888  \"Y8888  888 |");
		System.out.println("*************************************************************************************************************************\n");

		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Add Car");
		System.out.println("\tEnter '2' to Go Back");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		return userInput;
	}
}
