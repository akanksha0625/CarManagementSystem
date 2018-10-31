package com.java.dbms.proj.views;

public class ReceptionistScheduleRepairView {
	public static void displayPage1() {
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Engine Knock");
		System.out.println("\tEnter '2' to	Car drifts in a particular direction");
		System.out.println("\tEnter '3' to  Battery does not hold charge");
		System.out.println("\tEnter '4' to	Black/Unclean exhaust");
		System.out.println("\tEnter '5' to  A/C-Heater not working");
		System.out.println("\tEnter '6' to	Headlamps/Taillamps not working");
		System.out.println("\tEnter '7' to  Check engine light");
		System.out.println("\tEnter '8' to	Go Back");

	}
	
	public static void displayPage2() {
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Repait on date");
		System.out.println("\tEnter '2' to	Go Back");
	}
}
