package com.java.dbms.proj.controller;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Part;
import com.java.dbms.proj.entities.ServiceDetails;
import com.java.dbms.proj.entities.Vehicle;

public class ManagerCarServiceDetailsController {
	public static void carServicDetails(Scanner input) throws ClassNotFoundException, SQLException {
		com.java.dbms.proj.views.ManagerView.displayCarServiceDetails(); // Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;

		ArrayList<ServiceDetails> serviceDetailsList = new ArrayList<ServiceDetails>();

		try {
			/* Get all the vechicles */
			resultSet = statement.executeQuery("SELECT * FROM VEHICLE_TYPE");
			while (resultSet.next()) {
				ServiceDetails details = new ServiceDetails();
				details.setVid(resultSet.getInt("VID"));
				details.setMake(resultSet.getString("MAKE"));
				details.setModel(resultSet.getString("MODEL"));
				serviceDetailsList.add(details);
			}
		} catch (SQLException e) {
			System.out.println("Unable to access the Vehicle Table : " + e.getMessage() + " : Aborting Transaction\n");
			return;
		}

		for (int i = 0; i < serviceDetailsList.size(); i++) {
			/* for each serviceDetail */
			try {
				/*Service A Details*/
				resultSet = statement.executeQuery("SELECT * FROM MAINTENANCE WHERE VID = '"
						+ serviceDetailsList.get(i).getVid() + "' AND MAINTENANCE_NAME = 'A'");
				if (resultSet.next()) {
					serviceDetailsList.get(i).setaMiles(resultSet.getInt("MILES"));
					serviceDetailsList.get(i).setaMonths(resultSet.getInt("MONTHS"));
					serviceDetailsList.get(i).setaMaintenanceID(resultSet.getInt("MAINTENANCE_ID"));
				}
				/*Service B Details*/
				resultSet = statement.executeQuery("SELECT * FROM MAINTENANCE WHERE VID = '"
						+ serviceDetailsList.get(i).getVid() + "' AND MAINTENANCE_NAME = 'B'");
				if (resultSet.next()) {
					serviceDetailsList.get(i).setbMiles(resultSet.getInt("MILES"));
					serviceDetailsList.get(i).setbMonths(resultSet.getInt("MONTHS"));
					serviceDetailsList.get(i).setbMaintenanceID(resultSet.getInt("MAINTENANCE_ID"));
				}
				/*Service C Details*/
				resultSet = statement.executeQuery("SELECT * FROM MAINTENANCE WHERE VID = '"
						+ serviceDetailsList.get(i).getVid() + "' AND MAINTENANCE_NAME = 'C'");
				if (resultSet.next()) {
					serviceDetailsList.get(i).setcMiles(resultSet.getInt("MILES"));
					serviceDetailsList.get(i).setcMonths(resultSet.getInt("MONTHS"));
					serviceDetailsList.get(i).setcMaintenanceID(resultSet.getInt("MAINTENANCE_ID"));
				}
			} catch (SQLException e) {
				System.out.println(
						"Unable to access the Maintenance Table : " + e.getMessage() + " : Aborting Transaction\n");
				return;
			}
		}

		for (int i = 0; i < serviceDetailsList.size(); i++) {
			try {
				resultSet = statement.executeQuery("SELECT * FROM MAINTENANCE_SERVICE_MAPPING WHERE M_ID = '"
						+ serviceDetailsList.get(i).getaMaintenanceID() + "'");
				while (resultSet.next()) {
					serviceDetailsList.get(i).getServiceAIDs().add(resultSet.getInt("SERVICE_ID"));
				}
				resultSet = statement.executeQuery("SELECT * FROM MAINTENANCE_SERVICE_MAPPING WHERE M_ID = '"
						+ serviceDetailsList.get(i).getbMaintenanceID() + "'");
				while (resultSet.next()) {
					serviceDetailsList.get(i).getServiceBIDs().add(resultSet.getInt("SERVICE_ID"));
				}
				resultSet = statement.executeQuery("SELECT * FROM MAINTENANCE_SERVICE_MAPPING WHERE M_ID = '"
						+ serviceDetailsList.get(i).getcMaintenanceID() + "'");
				while (resultSet.next()) {
					serviceDetailsList.get(i).getServiceCIDs().add(resultSet.getInt("SERVICE_ID"));
				}
			} catch (SQLException e) {
				System.out.println("Unable to access the Maintenance Mapping Table : " + e.getMessage()
						+ " : Aborting Transaction\n");
				return;
			}
		}

		for (int i = 0; i < serviceDetailsList.size(); i++) {
			try {
				for (int j = 0; j < serviceDetailsList.get(i).getServiceAIDs().size(); j++) {
					resultSet = statement.executeQuery("SELECT * FROM SERVICE_DETAILS WHERE SERVICE_ID = '"
							+ serviceDetailsList.get(i).getServiceAIDs().get(j) + "'");
					while (resultSet.next()) {
						Part part = new Part();
						part.setPartID(resultSet.getInt("PART_ID"));
						serviceDetailsList.get(i).getServiceAParts().add(part);
					}
				}
				for (int j = 0; j < serviceDetailsList.get(i).getServiceBIDs().size(); j++) {
					resultSet = statement.executeQuery("SELECT * FROM SERVICE_DETAILS WHERE SERVICE_ID = '"
							+ serviceDetailsList.get(i).getServiceBIDs().get(j) + "'");
					while (resultSet.next()) {
						Part part = new Part();
						part.setPartID(resultSet.getInt("PART_ID"));
						serviceDetailsList.get(i).getServiceBParts().add(part);
					}
				}
				for (int j = 0; j < serviceDetailsList.get(i).getServiceCIDs().size(); j++) {
					resultSet = statement.executeQuery("SELECT * FROM SERVICE_DETAILS WHERE SERVICE_ID = '"
							+ serviceDetailsList.get(i).getServiceCIDs().get(j) + "'");
					while (resultSet.next()) {
						Part part = new Part();
						part.setPartID(resultSet.getInt("PART_ID"));
						serviceDetailsList.get(i).getServiceCParts().add(part);
					}
				}
			} catch (SQLException e) {
				System.out.println(
						"Unable to access the Service Details Table : " + e.getMessage() + " : Aborting Transaction\n");
				return;
			}
		}

		for (int i = 0; i < serviceDetailsList.size(); i++) {
			try {
				for (int j = 0; j < serviceDetailsList.get(i).getServiceAParts().size(); j++) {
					resultSet = statement.executeQuery("SELECT * FROM PARTS, PARTS_QUANTITY WHERE PARTS.PART_ID = '"
							+ serviceDetailsList.get(i).getServiceAParts().get(j).getPartID()
							+ "' AND PARTS_QUANTITY.VID = '" + serviceDetailsList.get(i).getVid() + "'");
					while (resultSet.next()) {
						serviceDetailsList.get(i).getServiceAParts().get(j)
								.setPartName(resultSet.getString("PART_NAME"));
						serviceDetailsList.get(i).getServiceAParts().get(j)
								.setUnitsRequired(resultSet.getInt("QUANTITY"));
					}
				}
				for (int j = 0; j < serviceDetailsList.get(i).getServiceBParts().size(); j++) {
					resultSet = statement.executeQuery("SELECT * FROM PARTS, PARTS_QUANTITY WHERE PARTS.PART_ID = '"
							+ serviceDetailsList.get(i).getServiceBParts().get(j).getPartID()
							+ "' AND PARTS_QUANTITY.VID = '" + serviceDetailsList.get(i).getVid() + "'");
					while (resultSet.next()) {
						serviceDetailsList.get(i).getServiceBParts().get(j)
								.setPartName(resultSet.getString("PART_NAME"));
						serviceDetailsList.get(i).getServiceBParts().get(j)
								.setUnitsRequired(resultSet.getInt("QUANTITY"));
					}
				}
				for (int j = 0; j < serviceDetailsList.get(i).getServiceCParts().size(); j++) {
					resultSet = statement.executeQuery("SELECT * FROM PARTS, PARTS_QUANTITY WHERE PARTS.PART_ID = '"
							+ serviceDetailsList.get(i).getServiceCParts().get(j).getPartID()
							+ "' AND PARTS_QUANTITY.VID = '" + serviceDetailsList.get(i).getVid() + "'");
					while (resultSet.next()) {
						serviceDetailsList.get(i).getServiceCParts().get(j)
								.setPartName(resultSet.getString("PART_NAME"));
						serviceDetailsList.get(i).getServiceCParts().get(j)
								.setUnitsRequired(resultSet.getInt("QUANTITY"));
					}
				}
			} catch (SQLException e) {
				System.out.println(
						"Unable to access the Parts Details Table : " + e.getMessage() + " : Aborting Transaction\n");
				return;
			}
		}

		for (int i = 0; i < serviceDetailsList.size(); i++)
			System.out.println(serviceDetailsList.get(i).toString());

		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to Go Back");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		} while (!userInput.equals("1"));
	}

}