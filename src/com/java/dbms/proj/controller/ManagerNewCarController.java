package com.java.dbms.proj.controller;

import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.views.ManagerView;



public class ManagerNewCarController {
	public static void newCar(Scanner input) throws SQLException {
		ManagerView.displayNewCarModel(); //Display page header
		//TODO ask for car model details
		System.out.println("Please enter the following details of the new Car Model.\n");
		
		ResultSet resultSet;
		Statement statement = DBFacade.getConnection().createStatement();

		String make;
		String model;
		String year;
		int amiles = 0,bmiles = 0,cmiles =0;
		int amonths = 0,bmonths = 0,cmonths = 0;
		String servicelista, servicelistb, servicelistc;
		
		int vid = 0, sid = 0, i = 0;
		int mid=0;
		
	
		System.out.print("\tPlease enter Make:");
		make=input.nextLine();
		
		while(make.isEmpty()==true){
			System.out.println("\n Please enter a valid Make:");
			make = input.nextLine();
		}
		
		System.out.print("\n\tPlease enter Model:");
		model=input.nextLine();
		
		while(model.isEmpty()==true){
			System.out.println("\n Please enter a valid Make:");
			model = input.nextLine();
		}
		
		System.out.print("\n\tPlease enter Year:");
		year=input.nextLine();
		
		while(year.isEmpty()==true){
			System.out.println("\n Please enter a valid year:");
			year = input.nextLine();
		}
		
		
		try {
			resultSet = statement.executeQuery(
					"SELECT VID FROM VEHICLE_TYPE WHERE MAKE = '" + make + "' AND MODEL = '" + model + "'");
			if (resultSet.next()) {
				vid = resultSet.getInt("VID");
				resultSet = statement.executeQuery(
						"SELECT * FROM MAINTENANCE WHERE VID ='" + vid + "'");
				if (resultSet.next()) {
							System.out.println("\nSorry, this vehicle already exists in the system.");
							return;
					}
				}
			/* else {
				System.out.println("\nSorry, we are unable to accommodate this vehicle type : " + make + ", "
						+ model + " at this time.");
				return;
			 	}*/
		} catch (SQLException e) {
			System.out.println("\nInvalid Vehicle Type : " + e.getMessage());
			return;
		}
	
		System.out.print("\n\tPlease enter number of miles for Service A:");
		amiles=input.nextInt();
		System.out.print("\n\tPlease enter number of months for Service A:");
		amonths=input.nextInt();
		System.out.print("\n\tPlease enter list of basic services for Service A seperated with a comma:");
		servicelista=input.nextLine();
		servicelista=input.nextLine();
		
		String[] valuesa = servicelista.split(",");
		ArrayList<Integer> serviceIda = new ArrayList<Integer>();
		ArrayList<Integer> serviceIdb = new ArrayList<Integer>();
		
		
		System.out.print("\n\tPlease enter number of miles for Service B:");
		bmiles=input.nextInt();
		
		
		System.out.print("\n\tPlease enter number of months for Service B:");
		bmonths=input.nextInt();

		System.out.println("Please enter additional list of services for Service B seperated with a comma:");

		servicelistb=input.nextLine();
		servicelistb=input.nextLine();	
		
		while(servicelistb.isEmpty()==true){
			System.out.println("\n Please enter a valid list of services for Service B:");
			year = input.nextLine();
		}
		
		String[] valuesb = servicelistb.split(",");
		
		System.out.print("\n\tPlease enter number of miles for Service C:");
		cmiles=input.nextInt();
		System.out.print("\n\tPlease enter number of months for Service C:");
		cmonths=input.nextInt();

		System.out.println("Please enter additional list of services for Service C seperated with a comma:");

		servicelistc=input.nextLine();	
		servicelistc=input.nextLine();	
		
		while(servicelistc.isEmpty()==true){
			System.out.println("\n Please enter a valid list of services for Service B:");
			year = input.nextLine();
		}
		
		String[] valuesc = servicelistc.split(",");
	
				
		System.out.println( "\nPlease select from the following user options:" );
		System.out.println( "\tEnter '1' to Add Car" );		
		System.out.println( "\tEnter '2' to Go Back" );
		
		String userInput = "";
		do {
			System.out.print( "\nOption Selection : " );
			userInput = input.nextLine();
		}while( !userInput.equals( "1" ) && !userInput.equals( "2" ) );
		
		if( userInput.equals( "1" ) ) {			
			 
			try {
				
				resultSet = statement.executeQuery( "SELECT maintenance_seq.nextval from dual" );
				if ( resultSet.next() ) {
					mid = resultSet.getInt( "NEXTVAL" );
				}
				
				resultSet = statement.executeQuery( "SELECT VEHICLE_TYPE_SEQ.nextval from dual" );
				if ( resultSet.next() ) {
					vid = resultSet.getInt( "NEXTVAL" );
				}
				try {
				statement.executeUpdate( "INSERT INTO VEHICLE_TYPE VALUES ('" + vid + "', '" + make + "', '" + model + "')" );	
				statement.executeUpdate( "INSERT INTO MAINTENANCE VALUES ('" + vid + "', '" + amiles + "', '" + amonths + "', '" + mid + "', 'A')" );
				}
				catch ( SQLException e ) {
					System.out.println( "Unable to insert into the MAINTENANCE Table for Service A : " + e.getMessage() );
				
			    }
				
				while(i <= valuesa.length-1) {
					try {
					resultSet = statement.executeQuery( "SELECT SERVICE_ID FROM SERVICE_DETAILS WHERE SERVICE_NAME = '"+valuesa[i]+"'");
					}
					catch(SQLException e) {
						System.out.println( "Service entered is invalid or not available");
					}
				
				if (resultSet.next())
				{
					sid=resultSet.getInt("SERVICE_ID");
					serviceIda.add(sid);
					
				}
				try {
				statement.executeUpdate( "INSERT INTO MAINTENANCE_SERVICE_MAPPING VALUES ('" + mid + "', '" + sid + "')" );
				}
				catch ( SQLException e ) {
					System.out.println( "Unable to insert into the MAINTENANCE_SERVICE_MAPPING Table for Service A : " + e.getMessage() );
				
			    }
				i+=1;
				}
			}
			catch ( SQLException e ) {
				System.out.println( "Unable to access the MAINTENANCE Table for Service A : " + e.getMessage() );
			
		    }
			try {
				
			resultSet = statement.executeQuery( "SELECT maintenance_seq.nextval from dual" );
			if ( resultSet.next() ) {
				mid = resultSet.getInt( "NEXTVAL" );
			}
			
			statement.executeUpdate( "INSERT INTO MAINTENANCE VALUES ('" + vid + "', '" + bmiles + "', '" + bmonths + "','" + mid + "', '" + "B" + "')" );
			i=0;
			while(i<=valuesb.length-1) {
				try {
				resultSet = statement.executeQuery( "SELECT SERVICE_ID FROM SERVICE_DETAILS WHERE SERVICE_NAME = '"+valuesb[i]+"'");
				}
				catch(SQLException e) {
					System.out.println( "Service entered is invalid or not available");
				}
			
			if (resultSet.next())
			{
				sid=resultSet.getInt("SERVICE_ID");
				serviceIdb.add(sid);
				
			}
			
			statement.executeUpdate( "INSERT INTO MAINTENANCE_SERVICE_MAPPING VALUES ('" + mid + "', '" + sid + "')" );
			i=i+1;
			}
			
			i=0;
			for(i=0;i<serviceIda.size();i++) {
				statement.executeUpdate( "INSERT INTO MAINTENANCE_SERVICE_MAPPING VALUES ('" + mid + "', '" + serviceIda.get(i) + "')" );
			}
			
			}
			catch ( SQLException e ) {
				System.out.println( "Unable to access the MAINTENANCE Table for Service B : " + e.getMessage() );
			
		}
			i=0;
			try {
				
				
			resultSet = statement.executeQuery( "SELECT maintenance_seq.nextval from dual" );
			if ( resultSet.next() ) {
				mid = resultSet.getInt( "NEXTVAL" );
			}
			
			statement.executeUpdate( "INSERT INTO MAINTENANCE VALUES ('" + vid + "', '" + cmiles + "', '" + cmonths + "','" + mid + "', '" + "C" + "')" );
			i=0;
			while(i<=valuesc.length-1) {
				try {
				resultSet = statement.executeQuery( "SELECT SERVICE_ID FROM SERVICE_DETAILS WHERE SERVICE_NAME = '"+valuesc[i]+"'");
				}
				catch(SQLException e) {
					System.out.println( "Service entered is invalid or not available");
				}
			
			if (resultSet.next())
			{
				sid=resultSet.getInt("SERVICE_ID");
			}
			
			statement.executeUpdate( "INSERT INTO MAINTENANCE_SERVICE_MAPPING VALUES ('" + mid + "', '" + sid + "')" );
			i=i+1;
			}
			
			for(i=0;i<serviceIda.size();i++) {
				statement.executeUpdate( "INSERT INTO MAINTENANCE_SERVICE_MAPPING VALUES ('" + mid + "', '" + serviceIda.get(i) + "')" );
			}
			
			for(i=0;i<serviceIdb.size();i++) {
				statement.executeUpdate( "INSERT INTO MAINTENANCE_SERVICE_MAPPING VALUES ('" + mid + "', '" + serviceIdb.get(i) + "')" );
			}
			
			
			System.out.println( "New Car added." );
		}
			catch ( SQLException e ) {
				System.out.println( "Unable to access the MAINTENANCE Table for Service C : " + e.getMessage() );
			
		}
	}
	}
}
