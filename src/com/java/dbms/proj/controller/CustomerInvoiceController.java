package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.Maintenance;
import com.java.dbms.proj.entities.Part;
import com.java.dbms.proj.entities.Repair;
import com.java.dbms.proj.entities.Service;

public class CustomerInvoiceController {
	public static void invoice(Scanner input) {
		com.java.dbms.proj.views.CustomerView.displayInvoice(); // Display page header
		Statement statement = null;
		ResultSet resultSet;
		ArrayList<String> serviceIDsList = new ArrayList<String>();
		ArrayList<String> serviceDate = new ArrayList<String>();

		try {
			/* get a conection to the database */
			statement = DBFacade.getConnection().createStatement();
		} catch (SQLException e) {
			System.out.println("Error in acquiring the database connection : " + e.getMessage());
			return;
		}

		try {
			resultSet = statement.executeQuery(
					"SELECT * FROM APPOINTMENT WHERE APPOINTMENT.CUSTOMER_ID = '" + ApplicationController.customer.getCustomerId() + "' AND APPOINTMENT.STATE = 'COMPLETE' ");
			while (resultSet.next()) {
				serviceIDsList.add(resultSet.getString("APPOINTMENT_ID"));
				serviceDate.add(resultSet.getString("APPOINTMENT_DATE"));
			}
		} catch (SQLException e) {
			System.out.println("Unable to access the Appointment Table : " + e.getMessage() +  " : Aborting Transaction\n");
			return;
		}
		
		for(int i = 0; i < serviceIDsList.size(); i++) {
			try {
				resultSet = statement.executeQuery(
						"SELECT * FROM TIME_SLOT WHERE APPOINTMENT_ID = '" + serviceIDsList.get(i) + "'"); 
				if(resultSet.next())
				System.out
				.println("Service ID : " + serviceIDsList.get(i) + "  |  Service Date & Time : "
						+ serviceDate.get(i) + ", " + resultSet.getString("START_TIME"));
			}catch (SQLException e){
				System.out.println("Unable to access the TIME_SLOT Table : " + e.getMessage() +  " : Aborting Transaction\n");
				return;
			}
		}

		System.out.println("\nPlease select from the following user options:");
		System.out.println("\tEnter '1' to View Invoice details");
		System.out.println("\tEnter '2' to Go back");

		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		} while (!userInput.equals("1") && !userInput.equals("2"));

		if (userInput.equals("1")) {
			do {
				System.out.print("\nEnter a valid Service ID for which you would like Invoice Details : ");
				userInput = input.nextLine();
			}while(!serviceIDsList.contains(userInput));
			
			com.java.dbms.proj.views.CustomerView.displayInvoiceDetails(); // Display second page header
			Service service = null;
			String serviceType;

			try {
				resultSet = statement.executeQuery(
						"SELECT * FROM APPOINTMENT WHERE APPOINTMENT.APPOINTMENT_ID = '" + userInput + "' ");
				while (resultSet.next()) { // while there is an appointment tuple create the services

					serviceType = resultSet.getString("SERVICE_TYPE");

					/* Assign Service Type */
					if (serviceType.equalsIgnoreCase("repair")) {
						service = new Repair();
					} else {
						service = new Maintenance();
					}

					/* Assign Service Attributes from Appointment Table */
					service.setServiceType(serviceType);
					service.setAppointmentID(resultSet.getString("APPOINTMENT_ID"));
					service.setCustomerID(ApplicationController.customer.getCustomerId());
					service.setVehicleLicense(resultSet.getString("VEHICLE_LICENSE"));
					service.setAppointmentDate(resultSet.getString("APPOINTMENT_DATE"));
					service.setRequestedMechanic(resultSet.getString("REQUESTED_MECHANIC"));
					service.setServiceStatus(resultSet.getString("STATE"));
					service.setServiceTypeID(resultSet.getString("SERVICE_TYPE_ID"));
					service.setCustomerName(ApplicationController.customer.getFirstName() + " " + ApplicationController.customer.getLastName());
					service.setServiceCenterID(ApplicationController.customer.getServiceCenterId());
				}
			} catch (SQLException e) {
				System.out
						.println("Unable to access the Appointment Table : " + e.getMessage() + " : Transaction Aborted\n");
				return;
			}

			/* Get TimeSlot Details */
			try {
				resultSet = statement.executeQuery("SELECT * FROM TIME_SLOT WHERE APPOINTMENT_ID = '"
						+ service.getAppointmentID() + "' ");
				if (resultSet.next()) {
					service.createTimeSlot(resultSet.getInt("SLOT_ID"),
							resultSet.getString("START_TIME"), resultSet.getString("END_TIME"));
					service.setMechanicID(resultSet.getInt("MECHANIC_ID"));
				} else {
					System.out.println("There are no Times associated with this appointment : "
							+ service.getAppointmentID() + "\n");
					return;
				}
			} catch (SQLException e) {
				System.out.println("Unable to access Time Slot Table : " + e.getMessage() + " : Transaction Aborted\n");
				return;
			}

			try {
				resultSet = statement.executeQuery("SELECT * FROM HOURLY_EMPLOYEE,EMPLOYEE WHERE EMPLOYEE.EID = HOURLY_EMPLOYEE.EID AND EMPLOYEE.EID = '"
						+ service.getMechanicID() + "' ");
				if (resultSet.next()) {
					service.setMechanicCost(resultSet.getDouble("HOURLY_RATE"));
					service.setMechanicFullName(resultSet.getString("FIRSTNAME") + " " + resultSet.getString("LASTNAME"));
				} else {
					System.out.println("There is no mechanic associated with this appointment : "
							+ service.getAppointmentID() + "\n");
					return;
				}
			} catch (SQLException e) {
				System.out.println(
						"Unable to access Hourly Employee Table : " + e.getMessage() + " : Transaction Aborted\n");
				return;
			}

			/* Find Vehicle ID */
			try {
				resultSet = statement.executeQuery(
						"SELECT * FROM VEHICLE WHERE LICENSE = '" + service.getVehicleLicense() + "'");
				if (resultSet.next()) {
					service.setVid(resultSet.getInt("VID"));
					service.setFirstAID(resultSet.getString("FIRST_A_APPID"));
					service.setFirstBID(resultSet.getString("FIRST_B_APPID"));
					service.setFirstCID(resultSet.getString("FIRST_C_APPID"));
				} else {
					System.out.println("There is no vehicle associated with the given car scheduled for appointment : "
							+ service.getAppointmentID());
					return;
				}
			} catch (SQLException e) {
				System.out
						.println("Unable to access the Vehicle Table : " + e.getMessage() + " : Transaction Aborted\n");
				return;
			}

			if (service.getServiceType().equalsIgnoreCase("repair")) {
				try {
					/* get repair details */
					resultSet = statement.executeQuery(
							"SELECT * FROM REPAIR WHERE RID = '" + service.getServiceTypeID() + "' ");
					if (resultSet.next()) {
						((Repair) service).setDiagnosis(resultSet.getString("DIAGNOSTIC"));
						((Repair) service).setDiagnosisFee(resultSet.getDouble("DIAGNOSTIC_FEE"));
						((Repair) service).setRepairID(resultSet.getString("RID"));
						((Repair) service).setRepairName(resultSet.getString("REPAIR_NAME"));
					} else {
						System.out.println("There is no repair service associated with this appointment : "
								+ service.getAppointmentID() + "\n");
						return;
					}
				} catch (SQLException e) {
					System.out.println(
							"Uable to access the Repair Table : " + e.getMessage() + " : Transaction Aborted\n");
					return;
				}

				ArrayList<String> repairs = new ArrayList<String>();
				/* Get services required */
				try {
					resultSet = statement.executeQuery("SELECT REQUIRED_SERVICE_ID FROM REPAIR_SERVICE_MAPPING"
							+ " WHERE RID = '"
							+ ((Repair) service).getServiceTypeID() + "' ");
					while (resultSet.next()) {
						repairs.add(resultSet.getString("REQUIRED_SERVICE_ID"));
					}
				} catch (SQLException e) {
					System.out.println("Unable to access the Required Service Table : " + e.getMessage()
							+ " : Transaction Aborted\n");
					return;
				}
				for(int i = 0; i < repairs.size(); i++) {
					try {
						resultSet = statement
								.executeQuery("SELECT SERVICE_NAME, PART_ID, TIME_REQUIRED, CHARGE_TYPE"
										+ " FROM SERVICE_DETAILS"
										+ " WHERE SERVICE_ID = '" + repairs.get(i)+ "'");
						while (resultSet.next()) {
							Part part = new Part();
							part.setRequiredFor(resultSet.getString("SERVICE_NAME"));
							part.setPartID(resultSet.getInt("PART_ID"));
							part.setInstallTime(resultSet.getDouble("TIME_REQUIRED"));
							part.setChargeType(resultSet.getString("CHARGE_TYPE"));
	
							((Repair) service).getPartsList().add(part);
						}
					} catch (SQLException e) {
						System.out.println("Unable to access the Service Details Table : " + e.getMessage()
								+ " : Transaction Aborted\n");
						return;
					}
				}

				for (int i = 0; i < ((Repair) service).getPartsList().size(); i++) {
					try {
						/* Get number of this part required */
						resultSet = statement.executeQuery(
								"SELECT QUANTITY FROM PARTS_QUANTITY WHERE VID = '" + ((Repair) service).getVid() + "' AND PART_ID = '"
										+ ((Repair) service).getPartsList().get(i).getPartID() + "' ");
						if (resultSet.next()) {
							((Repair) service).getPartsList().get(i)
									.setUnitsRequired(resultSet.getInt("QUANTITY"));
						} else {
							System.out.println("Unable to acquire the number of parts needed for this appointment : "
									+ service.getAppointmentID() + "\n");
							break;
						}
					} catch (SQLException e) {
						System.out.println(
								"Unable to access Quantity Table : " + e.getMessage() + " : Aborting Transaction\n");
						return;
					}
				}

				for (int i = 0; i < ((Repair) service).getPartsList().size(); i++) {
					try {
						/* get low/high cost */
						resultSet = statement
								.executeQuery("SELECT CHARGE_VALUE FROM SERVICE_CHARGE WHERE CHARGE_TYPE = '"
										+ ((Repair) service).getPartsList().get(i).getChargeType()
										+ "' ");
						if (resultSet.next()) {
							((Repair) service).getPartsList().get(i)
									.setInstallCharge(resultSet.getDouble("CHARGE_VALUE"));
						} else {
							System.out.println("There is no value associated with this charge type.\n");
							break;
						}
					} catch (SQLException e) {
						System.out.println(
								"Unable to access Charge Table : " + e.getMessage() + " : Aborting Transaction\n");
						return;
					}
				}

				for (int i = 0; i < ((Repair) service).getPartsList().size(); i++) {
					try {
						resultSet = statement.executeQuery("SELECT * FROM ACME_INVENTORY WHERE SC_ID = '"
								+ ApplicationController.customer.getServiceCenterId() + "' AND PART_ID = '"
								+ ((Repair) service).getPartsList().get(i).getPartID() + "' ");
						if (resultSet.next()) {
							((Repair) service).getPartsList().get(i)
									.setPartName(resultSet.getString("PART_NAME"));
							((Repair) service).getPartsList().get(i)
									.setUnitCost(resultSet.getDouble("UNIT_COST"));
						} else {
							System.out.println("There is not unit cost associated with this part.\n");
						}
					} catch (SQLException e) {
						System.out.println("Unable to access the Inventory Table : " + e.getMessage()
								+ " : Aborting Transaction\n");
						return;
					}
				}

				/* Calculate Part Cost and Time */
				for (int j = 0; j < ((Repair) service).getPartsList().size(); j++) {
					double unitCost = ((Repair) service).getPartsList().get(j).getUnitCost();
					double unitsRequired = ((Repair) service).getPartsList().get(j).getUnitsRequired();

					service.addToPartsCost(unitCost * unitsRequired);
					service.addToInstallationCost(
							((Repair) service).getPartsList().get(j).getInstallCharge());
					service
							.addToTotalHours(((Repair) service).getPartsList().get(j).getInstallTime());
				}
			} else {
				try {
					/* get maintenance details */
					resultSet = statement.executeQuery("SELECT * FROM MAINTENANCE WHERE VID = '" + service.getVid() + "' ");
					if (resultSet.next()) {
						((Maintenance) service).setMiles(resultSet.getInt("MILES"));
						((Maintenance) service).setMonths(resultSet.getInt("MONTHS"));
						((Maintenance) service).setMaintenanceID(resultSet.getString("MAINTENANCE_ID"));
						((Maintenance) service)
								.setMaintenanceName(resultSet.getString("MAINTENANCE_NAME"));
					} else {
						System.out.println("There is no maintenance service associated with this appointment : "
								+ service.getAppointmentID() + "\n");
						return;
					}
				} catch (SQLException e) {
					System.out.println(
							"Uable to access the Maintenance Table : " + e.getMessage() + " : Aborting Transaction\n");
					return;
				}

				ArrayList<String> repairs = new ArrayList<String>();
				/* Get services required */
				try {
					resultSet = statement.executeQuery("SELECT SERVICE_ID FROM MAINTENANCE_SERVICE_MAPPING"
							+ " WHERE M_ID = '"
									+ ((Maintenance) service).getMaintenanceID() + "' ");
					while (resultSet.next()) {
						repairs.add(resultSet.getString("SERVICE_ID"));
					}
				} catch (SQLException e) {
					System.out.println("Unable to access the Required Maintenance Table : " + e.getMessage()
							+ " : Transaction Aborted\n");
					return;
				}
				for(int i = 0; i < repairs.size(); i++) {
					try {
						resultSet = statement
								.executeQuery("SELECT SERVICE_NAME, PART_ID, TIME_REQUIRED, CHARGE_TYPE"
										+ " FROM SERVICE_DETAILS"
										+ " WHERE SERVICE_ID = '" + repairs.get(i)+ "'");
						while (resultSet.next()) {
							Part part = new Part();
							part.setRequiredFor(resultSet.getString("SERVICE_NAME"));
							part.setPartID(resultSet.getInt("PART_ID"));
							part.setInstallTime(resultSet.getDouble("TIME_REQUIRED"));
							part.setChargeType(resultSet.getString("CHARGE_TYPE"));
	
							((Maintenance) service).getPartsList().add(part);
						}
					} catch (SQLException e) {
						System.out.println("Unable to access the Service Details Table : " + e.getMessage()
								+ " : Transaction Aborted\n");
						return;
					}
				}

				for (int i = 0; i < ((Maintenance) service).getPartsList().size(); i++) {
					try {
						/* Get number of this part required */
						resultSet = statement.executeQuery("SELECT QUANTITY FROM PARTS_QUANTITY WHERE VID = '" + ((Maintenance) service).getVid()
								+ "' AND PART_ID = '"
								+ ((Maintenance) service).getPartsList().get(i).getPartID() + "' ");
						if (resultSet.next()) {
							((Maintenance) service).getPartsList().get(i)
									.setUnitsRequired(resultSet.getInt("QUANTITY"));
						} else {
							System.out.println("Unable to acquire the number of parts needed for this : "
									+ service.getAppointmentID() + "\n");
							break;
						}
					} catch (SQLException e) {
						System.out.println(
								"Unable to access Quantity Table : " + e.getMessage() + " : Aborting Transaction\n");
						return;
					}
				}

				for (int i = 0; i < ((Maintenance) service).getPartsList().size(); i++) {
					try {
						/* get low/high cost */
						resultSet = statement
								.executeQuery("SELECT CHARGE_VALUE FROM SERVICE_CHARGE WHERE CHARGE_TYPE = '"
										+ ((Maintenance) service).getPartsList().get(i).getChargeType()
										+ "' ");
						if (resultSet.next()) {
							((Maintenance) service).getPartsList().get(i)
									.setInstallCharge(resultSet.getDouble("CHARGE_VALUE"));
						} else {
							System.out.println("There is no value associated with this charge type.\n");
							break;
						}
					} catch (SQLException e) {
						System.out.println(
								"Unable to access Charge Table : " + e.getMessage() + " : Aborting Transaction\n");
						return;
					}
				}

				for (int i = 0; i < ((Maintenance) service).getPartsList().size(); i++) {
					try {
						resultSet = statement.executeQuery("SELECT * FROM ACME_INVENTORY WHERE SC_ID = '"
								+ ApplicationController.customer.getServiceCenterId() + "' AND PART_ID = '"
								+ ((Maintenance) service).getPartsList().get(i).getPartID() + "' ");
						if (resultSet.next()) {
							((Maintenance) service).getPartsList().get(i)
									.setPartName(resultSet.getString("PART_NAME"));
							((Maintenance) service).getPartsList().get(i)
									.setUnitCost(resultSet.getDouble("UNIT_COST"));
						} else {
							System.out.println("There is not unit cost associated with this part.");
							break;
						}
					} catch (SQLException e) {
						System.out.println("Unable to access the Inventory Table : " + e.getMessage()
								+ " : Aborting Transaction\n");
						return;
					}
				}


				/* Calculate Part Cost and Time */
				for (int j = 0; j < ((Maintenance) service).getPartsList().size(); j++) {
					double unitCost = ((Maintenance) service).getPartsList().get(j).getUnitCost();
					double unitsRequired = ((Maintenance) service).getPartsList().get(j)
							.getUnitsRequired();

					service.addToPartsCost(unitCost * unitsRequired);
					service.addToInstallationCost(
							((Maintenance) service).getPartsList().get(j).getInstallCharge());
					service.addToTotalHours(
							((Maintenance) service).getPartsList().get(j).getInstallTime());
				}
			}

			System.out.println(
					"\n---------------------------------------------------------------------------------------");
			System.out.println("Service Center : " + service.getServiceCenterID() + " Invoice Details");
			System.out
					.println("---------------------------------------------------------------------------------------");
			System.out.println(service.toCustomerString());
			if (service.getServiceType().equalsIgnoreCase("repair"))
				System.out.println(((Repair) service).repairPartsToString());
			else
				System.out.println(((Maintenance) service).repairPartsToString());
			System.out.println(
					"\n***************************************************************************************");
		
			
			System.out.println("Please select from the following user options:");
			System.out.println("\tEnter '1' to Go back");
	
			userInput = "";
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			} while (!userInput.equals("1"));
		}
	}
}

