package com.java.dbms.proj.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.java.dbms.proj.common.SchedulerHelper;
import com.java.dbms.proj.views.ReceptionistView;

public class ReceptionistScheduleMaintenanceController {
	public static void scheduleMaintenance(Scanner input) throws SQLException, ParseException {
		ReceptionistView.displayScheduleMaintenance1(); //Display page header
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Find Service Date");
		System.out.println("\tEnter '2' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
			 //Display next page header
			
			SchedulerHelper.scheduleMaintenance(ReceptionistScheduleServiceController.customer, ReceptionistScheduleServiceController.appointment, input);
		}
	}

}
