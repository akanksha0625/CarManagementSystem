package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Maintenance;
import com.java.dbms.proj.entities.Part;
import com.java.dbms.proj.entities.Repair;
import com.java.dbms.proj.entities.Service;

public class ReceptionistInvoiceController {
	public static void invoice(Scanner input) {
		
		com.java.dbms.proj.views.ReceptionistView.displayInvoice(); //Display page header
		
		/* Necessary Variables for SQL Transactions */
		Statement statement = null;
		ResultSet resultSet;
		String userInput = "";
		int customerID = -1;
		String serviceCenterID;
		int vid = -1;
		
		try {
			statement = DBFacade.getConnection().createStatement();
			
			System.out.print( "\nEnter the email of the customer invoice that you would like to search : " );
			userInput = input.nextLine();
		} catch (SQLException e) { 
			System.out.println( "Error in acquiring the database connection : " + e.getMessage() ); 
			return;
		}
			
		/* Find Customer */
		try {
			resultSet = statement.executeQuery( "SELECT * FROM CUSTOMER WHERE EMAIL = '" + userInput + "'" );
			if ( resultSet.next() ) {
				/* Find Customer Appointment */
				customerID = resultSet.getInt("CID");
				serviceCenterID = resultSet.getString("SC_ID");
			} else {
				System.out.println ( "There is no Customer associated with the given email : " + userInput);
				return;
			}
		} catch (SQLException e) {
			System.out.println("Unable to access the Customer Table : " + e.getMessage() );
			return;
		}
					
		/* Find all Appointments that coorespond with this customer */
		try {
			resultSet = statement.executeQuery( "SELECT * FROM APPOINTMENT WHERE CUSTOMER_ID = '" + customerID + "'" );
			while ( resultSet.next() ) { //while there is an appointment tuple create the services
				Service service = null;
				String serviceType = resultSet.getString("SERVICE_TYPE");
				if(serviceType.equalsIgnoreCase("repair")) {
					service = new Repair();
				}else {
					service = new Maintenance();
				}
				service.setServiceType(serviceType);
				service.setAppointmentID(resultSet.getString("APPOINTMENT_ID"));
				service.setCustomerID(customerID);
				service.setVehicleLicense(resultSet.getString("VEHICLE_LICENSE"));
				service.setAppointmentDate(resultSet.getString("APPOINTMENT_DATE"));
				service.setRequestedMechanic(resultSet.getString("REQUESTED_MECHANIC"));
				service.setServiceStatus(resultSet.getString("STATE"));
				service.setServiceTypeID(resultSet.getString("SERVICE_TYPE_ID"));
				
				/* Find VID */
				try {
					resultSet = statement.executeQuery( "SELECT VID FROM VEHICLE WHERE LICENSE = '" + service.getVehicleLicense() + "'" );
					if ( resultSet.next() ) {
						/* Find Customer Appointment */
						vid = resultSet.getInt("VID");
					} else {
						System.out.println ( "There is no vehicle associated with the given car scheduled for appointment : " + service.getAppointmentID() );
						return;
					}
				} catch (SQLException e) {
					System.out.println("Unable to access the Vehicle Table : " + e.getMessage() );
					return;
				}
				
				if(serviceType.equalsIgnoreCase("repair")) {
					try {
						/* get repair details*/
						resultSet = statement.executeQuery("SELECT * FROM REPAIR WHERE RID = '" + service.getServiceTypeID() + "' ");
						if(resultSet.next()) {
							((Repair)service).setDiagnosis(resultSet.getString("DIAGNOSTIC"));
							((Repair)service).setDiagnosisFee(resultSet.getDouble("DIAGNOSTIC_FEE"));
							((Repair)service).setRepairID(resultSet.getString("RID"));
							((Repair)service).setRepairName(resultSet.getString("REPAIR_NAME"));
						} else {
							System.out.println("There is no repair service associated with this appointment.");
						}
					} catch (SQLException e) {
						System.out.println("Uable to access the Repair Table : " + e.getMessage());
						return;
					}	
					/*Get parts required*/
					try {
						resultSet = statement.executeQuery("SELECT DISTINCT SERVICE_NAME, PART_ID, TIME_REQUIRED, CHARGE_TYPE" +
														   " FROM REPAIR_SERVICE_MAPPING, SERVICE_DETAILS" +
														   " WHERE REPAIR_SERVICE_MAPPING.RID = SERVICE_DETAILS.SERVICE_ID" + 
														   " AND REPAIR_SERVICE_MAPPING.RID = '" + ((Repair)service).getRepairID() + "' ");
						while(resultSet.next()) {
								Part part = new Part();
								part.setRequiredFor(resultSet.getString("SERVICE_NAME"));
								part.setPartID(resultSet.getInt("PART_ID"));
								part.setInstallTime(resultSet.getString("TIME_REQUIRED"));
								part.setChargeType(resultSet.getString("CHARGE_TYPE"));
								((Repair)service).getPartsList().add(part);
						}
						
						for(int i = 0; i < ((Repair)service).getPartsList().size(); i++) {
								try {
								/*Get number of this part required*/
								resultSet = statement.executeQuery("SELECT QUANTITY FROM PARTS_QUANTITY WHERE VID = '" + vid + 
																   "' AND PART_ID = '" + ((Repair)service).getPartsList().get(i).getPartID() + "' ");
								if(resultSet.next()) {
									((Repair)service).getPartsList().get(i).setUnitsRequired(resultSet.getInt("QUANTITY"));
								} else {
									System.out.println("Unable to acquire the number of parts needed for this service.");
									return;
								}
							}catch(SQLException e) {
								System.out.println("Unable to access Quantity Table : " + e.getMessage());
								return;
							}
						}
						
						for(int i = 0; i < ((Repair)service).getPartsList().size(); i++) {				
							try {
								/*get low/high cost*/
								resultSet = statement.executeQuery("SELECT CHARGE_VALUE FROM SERVICE_CHARGE WHERE CHARGE_TYPE = '" + ((Repair)service).getPartsList().get(i).getChargeType() + "' ");
								if(resultSet.next()) {
									((Repair)service).getPartsList().get(i).setInstallCharge(resultSet.getDouble("CHARGE_VALUE"));
								}
							}catch(SQLException e) {
								System.out.println("Unable to access Charge Table : " + e.getMessage());
								return;
							}
						}
						
						for(int i = 0; i < ((Repair)service).getPartsList().size(); i++) {	
							try {
								resultSet = statement.executeQuery("SELECT * FROM ACME_INVENTORY WHERE SC_ID = '" + serviceCenterID + 
																   "' AND PART_ID = '" + ((Repair)service).getPartsList().get(i).getPartID() + "' ");
								if(resultSet.next()) {
									((Repair)service).getPartsList().get(i).setPartName(resultSet.getString("PART_NAME"));
									((Repair)service).getPartsList().get(i).setUnitCost(resultSet.getDouble("UNIT_PRICE"));
								} else {
									System.out.println("There is not unit cost associated with this part.");
								}
							} catch ( SQLException e) {
								System.out.println("Unable to access the Inventory Table : " + e.getMessage());
								return;
							}
						}
					} catch (SQLException e) {
						System.out.println("Uable to access the Repair Details : " + e.getMessage());
						return;
					}	
													
				}else {
					/*Maintenance*/
				}
						
				//get time slot details
				try {
					resultSet = statement.executeQuery("SELECT * FROM TIME_SLOT WHERE APPOINTMENT_ID = '" + service.getAppointmentID() + "' ");
					if(resultSet.next()) {
						service.createTimeSlot(resultSet.getInt("SLOT_ID"),resultSet.getString("START_TIME"), resultSet.getString("END_TIME"));
						
						
						service.setActualMechanic(resultSet.getString("MECHANIC"));
						resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE WHERE EID = '" + service.getActualMechanic() + "' ");
						if(resultSet.next()) {
							service.setActualMechanic(resultSet.getString("FIRSTNAME") + " " + resultSet.getString("LASTNAME"));
						}else {
							System.out.println("There is no mechanic associated with this appointment.");
							return;
						}
					}
				}catch (SQLException e) {
					System.out.println("Unable to access the TimeSlot table : " + e.getMessage());
					return;
				}

				System.out.println("\n-------------------------------------------------------");
				System.out.println("\nSERVICE DETAILS");
				System.out.println("-------------------------------------------------------");
				System.out.println(service.toString());
				System.out.println(((Repair)service).repairPartsToString());
				System.out.println("-------------------------------------------------------");
			}
		} catch (SQLException e) {
			System.out.println("Unable to access the Customer table : " + e.getMessage());
			return;
		}
		System.out.println("\nPlease select from the following user options:");
		System.out.println("\tEnter '1' to Go Back");
		
		userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1"));
	}
}
