package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.PayCheck;
import com.java.dbms.proj.views.ManagerView;

public class ManagerPayrollController {
	public static void payroll(Scanner input) {
		ManagerView.displayPayroll(); //Display page header
		
		System.out.print("Please enter a valid Employee ID : ");
		String employeeID = input.nextLine();
		String serviceCenterID = ApplicationController.employee.getServiceCenterId();
		PayCheck payCheck = null;
		double yearToDate = 0;
		
		ResultSet resultSet;
		Statement statement;
		
		try {
			statement = DBFacade.getConnection().createStatement();
		} catch (SQLException e) {
			System.out.println("Unable to acquire a database connection : " + e.getMessage() );
			return;
		}
		
		try {
			resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE EID = '" + employeeID + "' AND SC_ID = '" + serviceCenterID + "' ");
			if(resultSet.next()) {
				payCheck = new PayCheck();
				payCheck.setEmployeeID(employeeID);
				payCheck.setEmployeeName(resultSet.getString("FIRSTNAME") + " " + resultSet.getString("LASTNAME"));
				payCheck.setRole(resultSet.getString("ROLE"));
				payCheck.setStartDate(resultSet.getString("START_DATE"));
			
			}else {
				System.out.println("This employee does not exist for Service Center : " + serviceCenterID + "\n");
				return;
			}
		}catch(SQLException e) {
			System.out.println("Unable to access the Employee Table : " + e.getMessage() + " : Aborting Transaction\n");
			return;
		}
		
		
		if(payCheck.getRole().equalsIgnoreCase("Mechanic")) {
			/*Generate Hourly PayCheck*/
			payCheck.setFrequency("Hourly");
			try {
				resultSet = statement.executeQuery("SELECT HOURLY_RATE FROM HOURLY_EMPLOYEE WHERE EID = '" + employeeID +"' ");
				if(resultSet.next()) {
					payCheck.setCompensation(resultSet.getDouble("HOURLY_RATE"));
				} else {
					System.out.println("There is no wage rate associated with this employee : " + employeeID + "\n");
				}
			} catch (SQLException e) {
				System.out.println("Unable to access Hourly_Employee Table : " + e.getMessage() + " : Aborting Transaction \n ");
				return;
			}
			

			
		} else {
			/*Generate Monthly PayCheck*/
			payCheck.setFrequency("Monthly");
			try {
				resultSet = statement.executeQuery("SELECT MONTHLY_RATE FROM MONTHLY_EMPLOYEE WHERE EID = '" + employeeID +"' ");
				if(resultSet.next()) {
					payCheck.setCompensation(resultSet.getDouble("MONTHLY_RATE"));
				} else {
					System.out.println("There is no wage rate associated with this employee : " + employeeID + "\n");
				}
			} catch (SQLException e) {
				System.out.println("Unable to access Monthly_Employee Table : " + e.getMessage() + " : Aborting Transaction \n ");
				return;
			}
			
			
			// Print first PayCheck
			int businessDays = HelperFunctions.calculateDuration(payCheck, HelperFunctions.translateDate(payCheck.getStartDate()));
			payCheck.setCurrentEarnings(payCheck.getCompensation());
			yearToDate += payCheck.getCompensation();
			payCheck.setUnits(businessDays);
			payCheck.setYearToDateEarnings(yearToDate);
			System.out.println("\n\tNOTE : First PayCheck | days reflect starting date of " + payCheck.getStartDate());
			System.out.println(payCheck.toString());
			
			//Print Checks
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateInString =  HelperFunctions.translateDate(payCheck.getStartDate());
			Date startDate = null;
			try {
				startDate = sdf.parse(dateInString);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
			}
			Calendar startCal = Calendar.getInstance();
			startCal.setTime(startDate);
			startCal.add(Calendar.MONTH,2);
			
			Calendar current = Calendar.getInstance();
			
			/*Print Middle Checks*/
			while( (startCal.compareTo(current) == -1) && (startCal.get(Calendar.YEAR) != current.get(Calendar.YEAR))) {
				payCheck.setCurrentEarnings(payCheck.getCompensation());
				yearToDate += payCheck.getCompensation();
				businessDays = HelperFunctions.calculateDuration(payCheck, "1-" + (startCal.get(Calendar.MONTH)) + "-" + (startCal.get(Calendar.YEAR)));
				int month = startCal.get(Calendar.MONTH);
				payCheck.setYearToDateEarnings(yearToDate);
				payCheck.setUnits(businessDays);
				startCal.add(Calendar.DAY_OF_MONTH, startCal.getActualMaximum(Calendar.DAY_OF_MONTH) + 1 );
				System.out.println(payCheck.toString());
				if(month + 1 >= 12) {
					yearToDate = 0;
				}
			}
			
			/*Print Current Year Checks*/
			while( (startCal.compareTo(current) == -1) && (startCal.get(Calendar.MONTH) != current.get(Calendar.MONTH))) {
				payCheck.setCurrentEarnings(payCheck.getCompensation());
				businessDays = HelperFunctions.calculateDuration(payCheck, (startCal.get(Calendar.DAY_OF_MONTH)) + "-" + (startCal.get(Calendar.MONTH)) + "-" + (startCal.get(Calendar.YEAR)));
				startCal.add(Calendar.DAY_OF_MONTH, startCal.getActualMaximum(Calendar.DAY_OF_MONTH) + 1 );
				yearToDate += payCheck.getCompensation();
				payCheck.setUnits(businessDays);
				payCheck.setYearToDateEarnings(yearToDate);
				System.out.println(payCheck.toString());
				if(startCal.get(Calendar.MONTH) >= 12) {
					yearToDate = 0;
				}				
			}
			
			/* Print Current Month PayCheck */
			businessDays = HelperFunctions.calculateDuration(payCheck, "01-" + (current.get(Calendar.MONTH)) + "-" + (current.get(Calendar.YEAR)));
			payCheck.setCurrentEarnings(payCheck.getCompensation());
			yearToDate += payCheck.getCompensation();
			payCheck.setUnits(businessDays);
			payCheck.setYearToDateEarnings(current.get(Calendar.MONTH) * payCheck.getCompensation());
			System.out.println(payCheck.toString());
		}
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' Go Back" );

		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
