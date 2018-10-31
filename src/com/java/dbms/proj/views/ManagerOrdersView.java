package com.java.dbms.proj.views;

public class ManagerOrdersView {

	public static void displayOrdersMenu() {
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to	Order History");
		System.out.println("\tEnter '2' to	New Order");
		System.out.println("\tEnter '3' to	Go Back");
	}
	
	public static void displayOrdersHistory() {
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to	Go Back");
	}
	
	public static void displayNewOrder() {
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '2' to	Place Orders");
		System.out.println("\tEnter '1' to	Go Back");

	}
}
