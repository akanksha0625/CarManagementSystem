package com.java.dbms.proj.common;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import com.java.dbms.proj.controller.LoginController;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.Service;
import com.java.dbms.proj.entities.Vehicle;

public class HelperFunctions {
	/* Necessary Variables for SQL Transactions */
	static ArrayList<Vehicle> carList = new ArrayList<Vehicle>(); 
	static ArrayList<String> cars = new ArrayList<String>();
	static Statement statement;
	static ResultSet resultSet;
	
	public static void updatePassword(String userName) throws SQLException{
		String userPassword = "";
		String userInput = "";
		boolean passwordMatch = true;
		Scanner input=new Scanner(System.in);
		statement = DBFacade.getConnection().createStatement();
		do {
			/* Assign user password */
			System.out.print ( "Please enter a login password: " );
			userPassword   = input.nextLine();
			System.out.print ( "Please confirm your password: " );
			userInput = input.nextLine();
			if ( !userPassword.equals( userInput ) ) {
				System.out.println( "\n***************************" );
				System.out.println( "| Password does not match |" );
				System.out.println( "***************************\n" );
				passwordMatch = false;
			} else {
				passwordMatch = true;
			}
		} while ( !passwordMatch );
		
		try {
			int tuples = statement.executeUpdate( "UPDATE LOGIN SET PASSWORD = '" +	userPassword + "' where USERNAME = '" + userName + "'") ;
	if ( tuples != 1 )
				System.out.println ( "Unable to load user into the Login Table." );
		} catch ( SQLException e ) {
			System.out.println( "Unable to access User Login Table : " + e.getMessage() );
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Vehicle> getCustomerCars( int customerID ) throws SQLException{
		statement = DBFacade.getConnection().createStatement();
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
			
			carList.add(car);
		}
		if(!matchFound) { 
			cars.add("\t\tThere are currently no cars registerd for this customer.\n");
		} 
		return carList;
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
			carList = HelperFunctions.getCustomerCars(customer.getCustomerId());
		} catch (SQLException e) {
			System.out.println("Issue Occured while trying to access Customer Cars : " + e.getMessage());
		}
		for(int i = 0; i < cars.size(); i++) {
			System.out.print(cars.get(i).toString());
		}
	}
	
	public static boolean checkDate(String date) {
		 try {
	            new SimpleDateFormat("dd-MMM-yyyy").parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	
	public static ArrayList<Service> getServiceHistory(Customer customer) throws SQLException {
		statement = DBFacade.getConnection().createStatement();
		ArrayList<Service> serviceList=new ArrayList<Service>();	
		try {
		resultSet = statement.executeQuery( "SELECT * FROM APPOINTMENT WHERE CUSTOMER_ID = '" + customer.getCustomerId() + "' and STATE ='Complete'" );
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if ( resultSet.next() ) {
			
			Service service = new Service();
			service.setServiceID( resultSet.getString( "APPOINTMENT_ID" ) );
			service.setStartDate( resultSet.getString( "APPOINTMENT_DATE" ) );
			service.setServiceType( resultSet.getString( "SERVICE_TYPE" ) );			
			service.setLicense( resultSet.getString( "VEHICLE_LICENSE" ) );
			service.setStatus( resultSet.getString( "STATE" ) );
			
			/* Find Time Slot of Appointment */
			resultSet = statement.executeQuery( "SELECT * FROM TIME_SLOT WHERE APPOINTMENT_ID = '" + service.getServiceID() + "'" );
			if(resultSet.next()) {
				service.setStartTime( resultSet.getString( "START_TIME" ) );
				service.setEndTime( resultSet.getString( "END_TIME" ) );
				service.setMechanic( resultSet.getString( "MECHANIC" ) );
			}
			serviceList.add(service);
		}
		return serviceList;
	}
			
	public static void displayServiceHistory(Customer customer) throws SQLException {
		
		ArrayList<Service> serviceList = getServiceHistory(customer);
		
		if(serviceList.size() == 0)
			System.out.println("There is no service history available for " + customer.getFirstName() + " "+ customer.getLastName() + "." );
		
		else {
			System.out.println("\nDISPLAY CUSTOMER SERVICE HISTORY");
			System.out.println("\t-------------------------------\n");
			
			for(int index=0; index<serviceList.size();index++) {
				Service service = serviceList.get(index);
	
			System.out.println("\tService ID        		:\t" + service.getServiceID());
			System.out.println("\tLicense Plate     		:\t" + service.getLicense());
			System.out.println("\tService Type      		:\t" + service.getServiceType());
			System.out.println("\tMechanic Name 			:\t" + service.getMechanic());
			System.out.println("\tService Start Date/Time   :\t" + service.getStartDate());
			System.out.println("\tService End Date/Time     :\t" + service.getEndDate());
			System.out.println("\tService Status	        :\t" + service.getStatus());
			}
		}
	}
	
	
	public static boolean validateCarDetails(Customer customer, String licensePlateNumber) throws SQLException {
		ArrayList<Vehicle> vehicleList = getCustomerCars(customer.getCustomerId());
		for(int index=0; index<vehicleList.size(); index++) {
			if(vehicleList.get(index).getLicense().equals(licensePlateNumber)) {
				return true;
			}
		}
		return false;
	}
}
