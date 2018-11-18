package com.java.dbms.proj.controller;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.java.dbms.proj.entities.HourlyEmployee;
import com.java.dbms.proj.entities.MonthlyEmployee;

public class EmployeeViewProfileController {

	public static void viewProfile(Scanner input) {

		com.java.dbms.proj.views.EmployeeView.displayViewProfile(); // Display page header
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("\n\tEMPLOYEE PROFILE DETAILS");
		System.out.println("\t------------------------\n");

		System.out.println("\tEmployee ID    :\t" + ApplicationController.employee.getEmpId());
		System.out.println("\tUsername       :\t" + ApplicationController.employee.getUserName());
		System.out.println("\tName           :\t" + ApplicationController.employee.getFirstName() + " "
				+ ApplicationController.employee.getLastName());
		System.out.println("\tAddress        :\t" + ApplicationController.employee.getAddress().addressToString());
		System.out.println("\tEmail          :\t" + ApplicationController.employee.getEmail());
		System.out.println("\tPhone Number   :\t" + ApplicationController.employee.getPhoneNumber());
		System.out.println("\tService Center :\t" + ApplicationController.employee.getServiceCenterName());
		System.out.println("\tRole           :\t" + ApplicationController.employee.getRole());
		System.out.println("\tStart Date     :\t" + ApplicationController.employee.getStartDate().toString());
		if (ApplicationController.employee.getRole().equalsIgnoreCase("mechanic")) {
			System.out.println("\tCompensation   :\t$"
					+ df.format(((HourlyEmployee) ApplicationController.employee).getHourlyRate()));
			System.out.println("\tPay Frequency  :\t Hourly");
		} else {
			System.out.println(
					"\tCompensation   :\t$" + ((MonthlyEmployee) ApplicationController.employee).getMonthlyRate());
			System.out.println("\tPay Frequency  :\tMonthly");
		}

		System.out.println("\nPlease select from the following user options:");
		System.out.println("\tEnter '1' to Go Back.");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		} while (!userInput.equals("1"));
	}
}
