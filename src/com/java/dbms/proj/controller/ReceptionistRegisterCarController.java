package com.java.dbms.proj.controller;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.java.dbms.proj.common.DBFacade;

public class ReceptionistRegisterCarController {
	public static void registerCar(Scanner input) throws SQLException {
		com.java.dbms.proj.views.ReceptionistView.displayRegisterCar(); // Display page header
		ResultSet resultSet;
		Statement statement = DBFacade.getConnection().createStatement();

		int cid = 0;
		String licence = (null);
		String purchaseDate = (null);
		String make;
		String model;
		String year = (null);
		String currentMileage = (null);
		String lastServiceDate = "";
		int vid = 0;
		System.out.print("Please enter Customer email address :");
		String email = "";
		email = input.nextLine();
		System.out.println();

		try {

			resultSet = statement.executeQuery("SELECT CID FROM CUSTOMER WHERE EMAIL = '" + email + "' AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "'");
			if (resultSet.next()) {
				cid = resultSet.getInt("CID");
				System.out.print("Please enter Licence plate : ");
				licence = input.nextLine();
				System.out.print("\nPlease enter Purchase Date : ");
				purchaseDate = input.nextLine();
				System.out.print("\nPlease enter Make : ");
				make = input.nextLine();
				System.out.print("\nPlease enter Model : ");
				model = input.nextLine();

				try {
					resultSet = statement.executeQuery(
							"SELECT VID FROM VEHICLE_TYPE WHERE MAKE = '" + make + "' and MODEL = '" + model + "'");
					if (resultSet.next()) {
						vid = resultSet.getInt("VID");
					} else {
						System.out.println("\nSorry, we are unable to accommodate this vehicle type : " + make + ", "
								+ model + " at this time.");
						return;
					}
				} catch (SQLException e) {
					System.out.println("\nInvalid Vehicle Type : " + e.getMessage());
					return;
				}

				System.out.print("\nPlease enter Year : ");
				year = input.nextLine();
				System.out.print("\nPlease enter Current Mileage : ");
				currentMileage = input.nextLine();
				System.out.print("\nPlease enter Last service date : ");
				lastServiceDate = input.nextLine();

			} else {
				System.out.println("The customer email \"" + email + "\" is not recognized for this service center.");
				return;
			}

		} catch (SQLException e) {
			System.out.println("\nUnable to access the Customer Address table : " + e.getMessage());
			return;
		}

		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Register");
		System.out.println("\tEnter '2' to Cancel");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		} while (!userInput.equals("1") && !userInput.equals("2"));

		if (userInput.equals("1")) {
			try {
				statement.executeUpdate("INSERT INTO VEHICLE VALUES ('" + licence + "', '" + purchaseDate + "', '"
						+ currentMileage + "','" + lastServiceDate + "', '(((null)))', '" + vid + "', '" + year + "','"
						+ cid + "', '((null))', '((null))', '((null))', '((null))')");

			} catch (SQLException e) {
				System.out.println("Service for this Car type is not available ");
				return;
			}

		}
	}

}
