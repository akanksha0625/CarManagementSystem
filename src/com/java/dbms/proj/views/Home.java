package com.java.dbms.proj.views;

import java.util.Scanner;

public class Home {
	public static String displayHome(Scanner input) {
		System.out.println("|---------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("|        d8888  .d8888b.  888b     d888 8888888888       .d8888b.  8888888888 8888888b.  888     888 8888888 .d8888b.  8888888888 |");
		System.out.println("|       d88888 d88P  Y88b 8888b   d8888 888             d88P  Y88b 888        888   Y88b 888     888   888  d88P  Y88b 888        |");
		System.out.println("|      d88P888 888    888 88888b.d88888 888             Y88b.      888        888    888 888     888   888  888    888 888        |");
		System.out.println("|     d88P 888 888        888Y88888P888 8888888          \"Y888b.   8888888    888   d88P Y88b   d88P   888  888        8888888    |");
		System.out.println("|    d88P  888 888        888 Y888P 888 888                 \"Y88b. 888        8888888P\"   Y88b d88P    888  888        888        |");
		System.out.println("|   d88P   888 888    888 888  Y8P  888 888                   \"888 888        888 T88b     Y88o88P     888  888    888 888        |");
		System.out.println("|  d8888888888 Y88b  d88P 888   \"   888 888             Y88b  d88P 888        888  T88b     Y888P      888  Y88b  d88P 888        |");
		System.out.println("| d88P     888  \"Y8888P\"  888       888 8888888888       \"Y8888P\"  8888888888 888   T88b     Y8P     8888888 \"Y8888P\"  8888888888 |");
		System.out.println("|                                                                                                                                 |");
		System.out.println("|                            .d8888b.  8888888888 888b    888 88888888888 8888888888 8888888b.                                    |");
		System.out.println("|                           d88P  Y88b 888        8888b   888     888     888        888   Y88b                                   |");
		System.out.println("|                           888    888 888        88888b  888     888     888        888    888                                   |");
		System.out.println("|                           888        8888888    888Y88b 888     888     8888888    888   d88P                                   |");
		System.out.println("|                           888        888        888 Y88b888     888     888        8888888P\"                                    |");
		System.out.println("|                           888    888 888        888  Y88888     888     888        888 T88b                                     |");
		System.out.println("|                           Y88b  d88P 888        888   Y8888     888     888        888  T88b                                    |");
		System.out.println("|                            \"Y8888P\"  8888888888 888    Y888     888     8888888888 888   T88b                                   |");
		System.out.println("|---------------------------------------------------------------------------------------------------------------------------------|");

		System.out.println("Please select from the following user options:\n");
		System.out.println( "\tEnter \"1\" to Login"); 
		System.out.println( "\tEnter \"2\" to Sign Up");
		System.out.println( "\tEnter \"3\" to Exit");
		
		String userInput = "";
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3"));
		return userInput;
	}
}
