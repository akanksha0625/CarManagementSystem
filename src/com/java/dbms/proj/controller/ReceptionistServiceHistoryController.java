package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.dbms.proj.common.ApplicationConstants;
import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.Service;

public class ReceptionistServiceHistoryController {
	public static void serviceHistory(Scanner input) {
		/* Necessary Variables for SQL Transactions */
		Statement statement = null;
		ResultSet resultSet;
		boolean matchFound = false;
		String userInput = "";

		Customer customer = new Customer();

		try {

			statement = DBFacade.getConnection().createStatement();

			System.out.print("\nEnter the email of the customer that you would like to search : ");
			userInput = input.nextLine();
			System.out.println("");

			try {

				resultSet = statement.executeQuery("SELECT * FROM CUSTOMER WHERE EMAIL = '" + userInput
						+ "' AND SC_ID = '" + ApplicationController.employee.getServiceCenterId() + "'");

				if (!resultSet.next()) {
					System.out.println(
							"\n\tCustomer email \"" + userInput + "\" is not associated with this service center.\n");
					return;
				}
			} catch (SQLException e) {
				System.out.println(
						"\nUnable to access the Customer Table : " + e.getMessage() + " : Aborting Transaction.\n");
				return;
			}
		} catch (SQLException e) {
			System.out.println(
					"\nUnable to get a Database connection : " + e.getMessage() + " : Aborting Transaction.\n");
			return;
		}

		try {
			resultSet = statement.executeQuery("SELECT * FROM CUSTOMER " + "WHERE EMAIL = '" + userInput + "'");
			if (resultSet.next()) {
				customer.setUsername("USERNAME");
				if (resultSet.getString("CID") != null && resultSet.getString("CID") != "")
					customer.setCustomerId(resultSet.getInt("CID"));
				if (resultSet.getString("FIRSTNAME") != null && resultSet.getString("FIRSTNAME") != "")
					customer.setFirstName(resultSet.getString("FIRSTNAME"));
				if (resultSet.getString("LASTNAME") != null && resultSet.getString("LASTNAME") != "")
					customer.setLastName(resultSet.getString("LASTNAME"));
				if (resultSet.getString("PHONE") != null && resultSet.getString("PHONE") != "")
					customer.setPhoneNumber(resultSet.getString("PHONE"));
				if (resultSet.getString("EMAIL") != null && resultSet.getString("EMAIL") != "")
					customer.setEmail(resultSet.getString("EMAIL"));
				if (resultSet.getString("SC_ID") != null && resultSet.getString("SC_ID") != "")
					customer.setServiceCenterId(resultSet.getString("SC_ID"));
			}
		} catch (SQLException e) {
			System.out.println(
					"Unable able to Access the Customer Table : " + e.getMessage() + " : Aborting Transaction.");
			return;
		}
		try {
			displayServiceHistory(customer);
		} catch (SQLException e) {
			System.out.println("\nUnable to display Service History for this customer\n");
		}

		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to  Go Back");

		userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		} while (!userInput.equals("1"));
	}
	
	public static ArrayList<Service> getServiceHistory(Customer customer) throws SQLException {
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet = null;
		ArrayList<Service> serviceList = new ArrayList<Service>();
		try {

		resultSet = statement.executeQuery( "SELECT * FROM APPOINTMENT WHERE CUSTOMER_ID = '" + customer.getCustomerId() + "'" );
		
		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}

		while (resultSet.next()) {

			Service service = new Service();
			service.setAppointmentID(resultSet.getString("APPOINTMENT_ID"));
			service.setAppointmentDate(resultSet.getString("APPOINTMENT_DATE"));
			service.setServiceType(resultSet.getString("SERVICE_TYPE"));
			service.setVehicleLicense(resultSet.getString("VEHICLE_LICENSE"));
			service.setServiceStatus(resultSet.getString("STATE"));
			serviceList.add(service);
		}
		
		for(int i = 0; i < serviceList.size(); i++) {

			/* Find Time Slot of Appointment */
			resultSet = statement.executeQuery(
					"SELECT * FROM TIME_SLOT WHERE APPOINTMENT_ID = '" + serviceList.get(i).getAppointmentID() + "'");
			if (resultSet.next()) {
				serviceList.get(i).createTimeSlot(resultSet.getInt("SLOT_ID"), resultSet.getString("START_TIME"),
						resultSet.getString("END_TIME"));
				serviceList.get(i).setMechanicID(resultSet.getInt("MECHANIC_ID"));
			}
		}
		for(int i = 0; i < serviceList.size(); i++) {	
			resultSet = statement.executeQuery(
					"SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE EID = '" + serviceList.get(i).getMechanicID() + "'");
			if (resultSet.next()) {
				serviceList.get(i).setMechanicFullName(resultSet.getString("FIRSTNAME") + " " + resultSet.getString("LASTNAME"));
			}
		}
		return serviceList;
	}

	public static void displayServiceHistory(Customer customer) throws SQLException {

		ArrayList<Service> serviceList = getServiceHistory(customer);

		if (serviceList.size() == 0) {
			System.out.println("\tThere is no service history available for " + customer.getFirstName() + " "
					+ customer.getLastName() + ".");
			System.out.println("\t-------------------------------\n");

		}else {
			System.out.println("\n\tCUSTOMER SERVICE HISTORY");
			System.out.println("\t-------------------------------\n");

			for (int index = 0; index < serviceList.size(); index++) {
				Service service = serviceList.get(index);
	
				System.out.println("\tService ID                :\t" + service.getAppointmentID());
				System.out.println("\tCustomer Name             :\t" + customer.getFirstName() + " " + customer.getLastName());
				System.out.println("\tLicense Plate             :\t" + service.getVehicleLicense());
				System.out.println("\tService Type              :\t" + service.getServiceType());
				System.out.println("\tMechanic Name             :\t" + service.getMechanicFullName());
				System.out.println("\tService Start Date|Time   :\t" + service.getAppointmentDate() + " | " + service.getTimeSlot().getStartTime());
				System.out.println("\tService End Date|Time     :\t" + service.getAppointmentDate() + " | " + service.getTimeSlot().getEndTime());
				System.out.println("\tService Status            :\t" + service.getServiceStatus() + "\n\t-------------------------------\n");
			}
		}
	}

}
