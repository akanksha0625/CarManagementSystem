package com.java.dbms.proj.controller;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Vehicle;

public class ManagerCarServiceDetailsController {
	public static void carServicDetails(Scanner input)  throws ClassNotFoundException, SQLException {
		com.java.dbms.proj.views.ManagerView.displayCarServiceDetails(); //Display page header
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet,resultSet2,resultSet3;
		String make,model;
		
		try {
			resultSet = statement.executeQuery("SELECT VID FROM MAINTENANCE");
			while(resultSet.next()) {
				Vehicle car = new Vehicle();
				
				car.setVid(resultSet.getInt("VID"));
				
				try {
					
					resultSet2 = statement.executeQuery( "SELECT VEHICLE_TYPE.MAKE, VEHICLE_TYPE.MODEL,VEHICLE.YEAR FROM VEHICLE_TYPE INNER JOIN VEHICLE ON VEHICLE.VID=VEHICLE_TYPE.VID WHERE VEHICLE.VID = '" + car.getVid() + "'" );
					while (resultSet2.next())
					{
						car.setMake(resultSet2.getString("MAKE"));
						car.setModel(resultSet2.getString("MODEL"));
						car.setYear(resultSet2.getInt("YEAR"));
						System.out.println("MAKE: " + car.getMake());
						System.out.println("MODEL: " + car.getModel());
						System.out.println("YEAR: "+ car.getYear());
						System.out.println("Service A:");
						resultSet3 = statement.executeQuery( "select MAINTENANCE.miles,SERVICE_DETAILS.service_name from maintenance inner join maintenance_service_mapping on maintenance.maintenance_id=maintenance_service_mapping.m_id inner join service_details on maintenance_service_mapping.service_id=service_details.service_id where maintenance.vid='" + car.getVid() + "' and maintenance.maintenance_name='A'" );
						if(resultSet3.next()) {
							System.out.println("Miles:" + resultSet3.getString("miles"));
						}
						while(resultSet3.next()) {
							System.out.println("List of basic services: \n" + resultSet3.getString("service_name"));
						}
						
						System.out.println("Service B:");
						resultSet3 = statement.executeQuery( "select MAINTENANCE.miles,SERVICE_DETAILS.service_name from maintenance inner join maintenance_service_mapping on maintenance.maintenance_id=maintenance_service_mapping.m_id inner join service_details on maintenance_service_mapping.service_id=service_details.service_id where maintenance.vid='" + car.getVid() + "' and maintenance.maintenance_name='B'" );
						if(resultSet3.next()) {
							System.out.println("Miles:" + resultSet3.getString("miles"));
						}
						while(resultSet3.next()) {
							System.out.println("List of basic services: \n" + resultSet3.getString("service_name"));
						}
						
						System.out.println("Service C:");
						resultSet3 = statement.executeQuery( "select MAINTENANCE.miles,SERVICE_DETAILS.service_name from maintenance inner join maintenance_service_mapping on maintenance.maintenance_id=maintenance_service_mapping.m_id inner join service_details on maintenance_service_mapping.service_id=service_details.service_id where maintenance.vid='" + car.getVid() + "' and maintenance.maintenance_name='C'" );
						if(resultSet3.next()) {
							System.out.println("Miles:" + resultSet3.getString("miles"));
						}
						while(resultSet3.next()) {
							System.out.println("List of basic services: \n" + resultSet3.getString("service_name"));
						}
							
											
												
					}					
					
				}
				catch ( SQLException e ) {
					System.out.println( "Invalid Vehicle Type : " + e.getMessage() );
				}
				
				
			}
				
						
				
			/*
			whileMake
			B. Model
			C. Year
			D. Service A:
			a. Miles
			b. List of Basic
			Services
			(Service ID)
			E. Service B
			a. Miles
			b. List of Basic
			Services
			(Service ID)
			F. Service C
			a. Miles
			b. List of Basic
			Services
			(Service ID)
		*/
			
			}  catch (SQLException e) {
				System.out.println("Could'nt get the Employee details. " + e);
				e.printStackTrace();
			}
		//TODO dump the details in
		System.out.println("GET SERVICE DETAILS\n");
		
		System.out.println( "Please select from the following user options:" );
		System.out.println( "\tEnter '1' to Go Back");
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) );
	}

}
