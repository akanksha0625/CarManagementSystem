package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.ClearConsole;
import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.UserLogin;
import com.java.dbms.proj.views.Login;

public class LoginController {
	Login login = new Login();
	static UserLogin userLogin = new UserLogin();

	public static String userLogin(Scanner input) throws ClassNotFoundException, SQLException {
		ClearConsole.clearConsole();
		Login.displayLogin(); // Call page header

		int attempts = 0;
		int back = 0;
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		boolean success = false;

		/*
		 * Prompt user for userName and password until successful match is discovered.
		 */
		while (!success) {
			attempts++;
			System.out.print("\tPlease enter username : ");
			userLogin.setUserName(input.nextLine());
			System.out.print("\n\tPlease enter password : ");
			userLogin.setPassword(input.nextLine());
			System.out.println(); // Spacing on console.
			System.out.println("\tPlease select from the following user options:");
			System.out.println("\t\tEnter '1' to Login.");
			System.out.println("\t\tEnter '2' to Go Back.");

			String userInput = "";

			do {
				System.out.print("\n\tOption Selection : ");
				userInput = input.nextLine();
			} while (!userInput.equals("1") && !userInput.equals("2"));

			if (userInput.equals("1")) {
				try {
					/* Find userName and userPassword match from 'LOGIN' table */
					resultSet = statement
							.executeQuery("SELECT USERNAME, PASSWORD, ROLE " + "FROM LOGIN " + "WHERE username = '"
									+ userLogin.getUserName() + "' AND password = '" + userLogin.getPassword() + "'");

					/* If query returned a value */
					if (resultSet.next()) {
	
						if (resultSet.getString("role") != null && resultSet.getString("role") != "") {
							userLogin.setRole(resultSet.getString("role"));
						}
	
						System.out.println("\n\t************************");
						System.out.println("\t  - Login Successful -  ");
						System.out.println("\t************************\n");
						success = true;
						return userLogin.getRole();
					} else {
						System.out.println("\n\t*********************************");
						System.out.println("\t     - Login Unsuccessful -");
						System.out.println("\t---------------------------------");
	
						/* Check if userName in the system. */
						resultSet = statement.executeQuery(
								"SELECT USERNAME " + "FROM Login " + "WHERE username = '" + userLogin.getUserName() + "'");
	
						if (!resultSet.next()) {
							System.out.println("\t User Name '" + userLogin.getUserName()
									+ "' \n\tdoes not exist in the Acme Service System.");
						} else {
							System.out.println("\t Incorrect Password --> Please try again.");
						}
						System.out.println("\t*********************************\n");
						String response = "";
						if (attempts >= 2) {
							System.out.println("\tHaving Trouble?");
							do {
								System.out.println("\t\t Enter 1 to Exit Login");
								System.out.println("\t\t Enter 2 to Attempt Another Login");
								System.out.print("\n\tOption Selection : ");
								response = input.nextLine();
							} while (!response.equals("1") && !response.equals("2"));
						}
						if(response.equals("1")) {
							break;
						}
					}
				} catch (SQLException e) {
					System.out.println("\tLogin Unsuccessful due to database error : " + e);
					e.printStackTrace();
					break;
				}
			} else {
				break;
			}
		}
		return "fail";
	}
}
