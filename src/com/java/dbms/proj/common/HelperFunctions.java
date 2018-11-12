package com.java.dbms.proj.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.Vehicle;

public class HelperFunctions {
	/* Necessary Variables for SQL Transactions */
	
	static ArrayList<String> cars = new ArrayList<String>();
	
	public static ArrayList<String> getCustomerCars( int customerID ) throws SQLException{
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet resultSet;
		boolean matchFound = false;
		
		resultSet = statement.executeQuery( "SELECT * FROM VEHICLE WHERE CID = '" + customerID + "'" );
		while(resultSet.next()) {
			matchFound = true;
			Vehicle car = new Vehicle();
			
			car.setLicense(resultSet.getString("LICENSE"));
			car.setDatePurchased(resultSet.getDate("DATE_PURCHASED"));
			car.setCurrentMileage(resultSet.getInt("CURRENT_MILEAGE"));
			car.setLastServiceDate(resultSet.getDate("LAST_SERVICE_DATE"));
			car.setLastServiceType(resultSet.getString("LAST_SERVICE_TYPE"));
			car.setYear(resultSet.getInt("YEAR"));
			car.setVid(resultSet.getInt("VID"));
			
			cars.add(car.toString());
		}
		if(!matchFound) { 
			cars.add("\t\tThere are currently no cars registerd for this customer.\n");
		} 
		return cars;
	}
	
	public static void displayCustomerProfile(Customer customer) {
		System.out.println("\n\tCUSTOMER PROFILE DETAILS");
		System.out.println(  "\t------------------------\n");
		
		System.out.println("\tCustomer ID           :\t" + customer.getCustomerId());
		System.out.println("\tCustomer Name         :\t" + customer.getFirstName() + " " + customer.getLastName());
		System.out.println("\tCustomer Address      :\t" + customer.getAddress().addressToString());
		System.out.println("\tCustomer Phone Number :\t" + customer.getPhoneNumber());
		System.out.println("\tCustomer Email        :\t" + customer.getEmail());
		System.out.println("\tCustomer Username     :\t" + customer.getUsername());
		
		System.out.println("\n\tCUSTOMER REGISTERED CARS & DETAILS");
		System.out.println(  "\t----------------------------------");
		ArrayList<String> cars = null;
		try {
			cars = HelperFunctions.getCustomerCars(customer.getCustomerId());
		} catch (SQLException e) {
			System.out.println("Issue Occured while trying to access Customer Cars : " + e.getMessage());
		}
		for(int i = 0; i < cars.size(); i++) {
			System.out.print(cars.get(i));
		}
	}
}
