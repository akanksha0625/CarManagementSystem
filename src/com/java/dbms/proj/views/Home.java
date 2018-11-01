package com.java.dbms.proj.views;

import java.util.Scanner;

public class Home {
	public static String displayHome() {
    	System.out.println("************************************************************************************************************************");
    	System.out.println("|                                                                                                                      |");
    	System.out.println("|            d8888                                      .d8888b.                            d8b                        |");
    	System.out.println("|           d88888                                     d88P  Y88b                           Y8P                        |");
    	System.out.println("|          d88P888                                     Y88b.                                                           |");
    	System.out.println("|         d88P 888 88888b.d88b.   .d8888b .d88b.        \"Y888b.    .d88b.  888d888 888  888 888  .d8888b .d88b.        |");
    	System.out.println("|        d88P  888 888 \"888 \"88b d88P\"   d8P  Y8b          \"Y88b. d8P  Y8b 888P\"   888  888 888 d88P\"   d8P  Y8b       |");
    	System.out.println("|       d88P   888 888  888  888 888     88888888            \"888 88888888 888     Y88  88P 888 888     88888888       |");
    	System.out.println("|      d8888888888 888  888  888 Y88b.   Y8b.          Y88b  d88P Y8b.     888      Y8bd8P  888 Y88b.   Y8b.           |");
    	System.out.println("|     d88P     888 888  888  888  \"Y8888P \"Y8888        \"Y8888P\"   \"Y8888  888       Y88P   888  \"Y8888P \"Y8888        |");
    	System.out.println("|                                                                                                                      |");
    	System.out.println("|                                    .d8888b.                    888                                                   |");
    	System.out.println("|                                   d88P  Y88b                   888                                                   |");
    	System.out.println("|                                   888    888                   888                                                   |");
    	System.out.println("|                                   888         .d88b.  88888b.  888888 .d88b.  888d888                                |");
    	System.out.println("|                                   888        d8P  Y8b 888 \"88b 888   d8P  Y8b 888P\"                                  |");
    	System.out.println("|                                   888    888 88888888 888  888 888   88888888 888                                    |");
    	System.out.println("|                                   Y88b  d88P Y8b.     888  888 Y88b. Y8b.     888                                    |");
    	System.out.println("|                                   \"Y8888P\"   \"Y8888\"  888  888  \"Y888 \"Y8888  888                                    |");
    	System.out.println("|                                                                                                                      |");
    	System.out.println("************************************************************************************************************************\n");

		System.out.println("Please select from the following user options:\n");
		System.out.println( "\tEnter \"1\" to Login"); 
		System.out.println( "\tEnter \"2\" to Sign Up");
		System.out.println( "\tEnter \"3\" to Exit");
		
		Scanner input = new Scanner(System.in);
		String userInput = "";
		System.out.print("\nOption Selection : ");
		do {
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
		input.close();
		return userInput;
	}
}
