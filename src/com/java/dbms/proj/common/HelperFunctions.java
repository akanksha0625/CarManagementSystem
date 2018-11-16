package com.java.dbms.proj.common;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.java.dbms.proj.entities.Appointment;
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
			car.setDatePurchased(resultSet.getString("DATE_PURCHASED"));
			car.setCurrentMileage(resultSet.getInt("CURRENT_MILEAGE"));
			car.setLastServiceDate(resultSet.getString("LAST_SERVICE_DATE"));
			car.setLastServiceType(resultSet.getString("LAST_SERVICE_TYPE"));
			car.setLastServiceName(resultSet.getString("LAST_MAINTENANCE_TYPE"));
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
		try {
			carList = HelperFunctions.getCustomerCars(customer.getCustomerId());
		} catch (SQLException e) {
			System.out.println("Issue Occured while trying to access Customer Cars : " + e.getMessage());
		}
		for(int i = 0; i < carList.size(); i++) {
			System.out.print(carList.get(i).toString());
		}
	}
	
	public static boolean checkDate(String date) {
		 try {
	            new SimpleDateFormat(ApplicationConstants.DATE_FORMAT).parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	
	public static ArrayList<Service> getServiceHistory(Customer customer) throws SQLException {
		statement = DBFacade.getConnection().createStatement();
		ArrayList<Service> serviceList=new ArrayList<Service>();	
		try {
		resultSet = statement.executeQuery( "SELECT * FROM APPOINTMENT WHERE CUSTOMER_ID = '" + customer.getCustomerId() + "' and STATE ='" + ApplicationConstants.COMPLETE + "'" );
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		while ( resultSet.next() ) {
			
			Service service = new Service();
			service.setAppointmentID( resultSet.getString( "APPOINTMENT_ID" ) );
			service.setAppointmentDate( resultSet.getString( "APPOINTMENT_DATE" ) );
			service.setServiceType( resultSet.getString( "SERVICE_TYPE" ) );			
			service.setVehicleLicense( resultSet.getString( "VEHICLE_LICENSE" ) );
			service.setServiceStatus( resultSet.getString( "STATE" ) );
			
			/* Find Time Slot of Appointment */
			resultSet = statement.executeQuery( "SELECT * FROM TIME_SLOT WHERE APPOINTMENT_ID = '" + service.getAppointmentID() + "'" );
			if(resultSet.next()) {
				service.createTimeSlot(resultSet.getInt( "SLOT_ID") , resultSet.getString( "START_TIME") , resultSet.getString( "END_TIME" ));
				service.setActualMechanic( resultSet.getString( "MECHANIC" ) );
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
	
			System.out.println("\tService ID		:\t" + service.getAppointmentID());
			System.out.println("\tLicense Plate		:\t" + service.getVehicleLicense());
			System.out.println("\tService Type		:\t" + service.getServiceType());
			System.out.println("\tMechanic Name		:\t" + service.getActualMechanic());
			System.out.println("\tService Start Date/Time	:\t" + service.getAppointmentDate() + " | " + service.getTimeSlot().getStartTime());
			System.out.println("\tService End Date/Time	:\t" + service.getAppointmentDate() + " | " + service.getTimeSlot().getEndTime());
			System.out.println("\tService Status		:\t" + service.getServiceStatus());
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
	
	
	public static String getServiceToBeScheduled(String vehicleLicenseNumber, int mileage) throws SQLException {
		String lastServiceName="";
		String lastServiceType="";
		String serviceTobeScheduled="";
		//int mileage=0;
		statement = DBFacade.getConnection().createStatement();
		
		try {
			resultSet = statement.executeQuery( "SELECT CURRENT_MILEAGE,LAST_SERVICE_TYPE,LAST_MAINTENANCE_TYPE FROM VEHICLE WHERE  LICENSE = '" + vehicleLicenseNumber + "'" );	
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if ( resultSet.next() ) {	
			lastServiceName = resultSet.getString("LAST_MAINTENANCE_TYPE");
			//mileage = resultSet.getInt("CURRENT_MILEAGE");
		}
		
		if(lastServiceName == null || lastServiceName.equals("") ) {
			if( mileage < 10000)
				serviceTobeScheduled = ApplicationConstants.SERVICEA;
			else if( mileage < 250000)
				serviceTobeScheduled = ApplicationConstants.SERVICEB;
			else
				serviceTobeScheduled = ApplicationConstants.SERVICEC;
		}
		else {
			
			if(lastServiceName.equals(ApplicationConstants.SERVICEA))
				serviceTobeScheduled = ApplicationConstants.SERVICEB;
			else if(lastServiceName.equals(ApplicationConstants.SERVICEB))
				serviceTobeScheduled = ApplicationConstants.SERVICEC;
			else
				serviceTobeScheduled = ApplicationConstants.SERVICEA;
		}
		
		return serviceTobeScheduled;	
	}
	
	public static int getVechileID(String vehicleLicenseNumber) {
		int vid = 0;
		try {
			resultSet = statement.executeQuery( "SELECT VID FROM VEHICLE WHERE LICENSE = '" + vehicleLicenseNumber + "'" );
			if ( resultSet.next() ) {
				/* Find Customer Appointment */
				 vid = resultSet.getInt("VID");
			} else {
				System.out.println ( "There is no vehicle associated with the given car scheduled for appointment : " + vehicleLicenseNumber );
			}
		} catch (SQLException e) {
			System.out.println("Unable to access the Vehicle Table : " + e.getMessage() );
		}
		return vid;
	}
	
	public static ArrayList<Integer> getChildServiceList(String serviceName, String serviceType, String licenseNumber) throws SQLException {
		int vechicleId=0;
		vechicleId = getVechileID(licenseNumber);
		ArrayList<Integer> childServiceList = new ArrayList<Integer>();
		if(vechicleId != 0) {
			int maintenanceId = 0;
			if(serviceName == ApplicationConstants.MAINTENANCE)
				resultSet = statement.executeQuery( "SELECT MAINTENANCE_ID FROM MAINTENANCE WHERE MAINTENANCE_NAME = '" + serviceType + "' and VID='" + vechicleId + "'");
		
			if(resultSet.next())
			{
				maintenanceId = resultSet.getInt("MAINTENANCE_ID");
			}
			
			if(maintenanceId !=0 )
			{
				resultSet = statement.executeQuery( "SELECT SERVICE_ID FROM MAINTENANCE_SERVICE_MAPPING WHERE M_ID = '" + maintenanceId + "'" );
				
				while(resultSet.next())
				{
					int childServiceId=0;
					childServiceId = resultSet.getInt("SERVICE_ID");
					childServiceList.add(childServiceId);
				}	
			}	
			
		}
		return childServiceList;
	}

	
	public static float calculateServiceDuration(String serviceName, String serviceType, String licenseNumber) throws SQLException{
		float timeDuration=0;
		ArrayList<Integer> childServiceList =getChildServiceList(serviceName, serviceType, licenseNumber);
		for(int i=0;i<childServiceList.size(); i++) {
			resultSet = statement.executeQuery( "SELECT TIME_REQUIRED,PART_ID FROM SERVICE_DETAILS WHERE SERVICE_ID = '" + childServiceList.get(i) + "'" );
			
			while(resultSet.next())
			{
				float childServiceTime=0;
				childServiceTime = Float.parseFloat(resultSet.getString("TIME_REQUIRED"));
				timeDuration = timeDuration +  childServiceTime;
			}
		}
		return timeDuration;
	}
	

  public static boolean compareDatesTimes( String currentDate, String currentTime, String possibleDate, String possibleTime) {
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy, h:mm a");
		
		try {
			Date current = formatter1.parse( currentDate + ", " + currentTime );
			System.out.println("CURRENT : " + current);
			Date possible = formatter1.parse( possibleDate + ", " + possibleTime );
			System.out.println("POSSIBLE : " + possible);
			
	        if (current.compareTo(possible) > 0) {
	           System.out.println("CURRENT is after POSSIBLE");
	        	return false;
	        } else if (current.compareTo(possible) < 0) {
	           System.out.println("CURRENT is before POSSIBLE");
	        	return true;
	        } else if (current.compareTo(possible) == 0) {
	           System.out.println("CURRENT is equal to POSSIBLE");
            }
		} catch (ParseException e) {
			System.out.println("Unable to Parse Date");
		}		
		return false;
	}
  
  
  
  public static String addTime( String startTime,  double laborHours) {
	  String[] startSplit = startTime.split(":");
	  int startHour = Integer.parseInt(startSplit[0]);
	  int startMin = Integer.parseInt(startSplit[1].split(" ")[0]);
	  String ampm =startSplit[1].split(" ")[1];
	  
	  int endHour = startHour + (int)(laborHours / 1);
	  int endMin = startMin + (int)((laborHours % 1) * 60);
		
	  if(ampm.equalsIgnoreCase("pm"))
		return endHour + ":" + endMin + " " + ampm;
	  else {
		  if(endHour >= 12)
			  return endHour + ":" + endMin + " pm";
		  else
			  return endHour + ":" + endMin + " am";
	  }
	}

	
	public static HashMap<Integer,Integer> getPartList(String serviceName, String serviceType, String licenseNumber) throws SQLException{
		ArrayList<Integer> partIDList = new ArrayList<Integer>();
		ArrayList<Integer> childServiceList = getChildServiceList(serviceName, serviceType, licenseNumber);
		HashMap<Integer,Integer> requiredPartList = new HashMap<Integer,Integer>();
		for(int i=0;i<childServiceList.size(); i++) {
			resultSet = statement.executeQuery( "SELECT PART_ID FROM SERVICE_DETAILS WHERE SERVICE_ID = '" + childServiceList.get(i) + "'" );
			System.out.println("Inside childServiceList");
			while(resultSet.next())
			{
				int partID=0;
				partID = Integer.parseInt(resultSet.getString("PART_ID"));
				System.out.println("Required Part id:"+ partID);
				partIDList.add(partID);
			}	
		}
		
		for(int index=0; index<partIDList.size(); index++) {
			resultSet = statement.executeQuery( "SELECT QUANTITY FROM PARTS_QUANTITY WHERE PART_ID = '" + partIDList.get(index) + "'" );
			System.out.println("Inside Calculate parts quantity");
			
			while(resultSet.next())
			{
				int quantity= Integer.parseInt(resultSet.getString("QUANTITY"));
				requiredPartList.put(partIDList.get(index), quantity);
				System.out.println("Part id:"+ partIDList.get(index)+":"+quantity);
			}
			
		}
		
		return requiredPartList;
	}
	
	//Needs to be changed based on order placement
	public static boolean checkPartAvailability(String serviceName, String serviceType, String licenseNumber) throws NumberFormatException, SQLException {
		int numberOfDays=0;
		boolean partsAvailable = true;
		HashMap<Integer,Integer> requiredPartList =getPartList(serviceName, serviceType, licenseNumber);
		for(int index : requiredPartList.keySet()) {
			
			resultSet = statement.executeQuery( "SELECT CURRENT_QUANTITY FROM ACME_INVENTORY WHERE PART_ID = '" + index + "'" );
			
			while(resultSet.next())
			{
				int quantity= Integer.parseInt(resultSet.getString("CURRENT_QUANTITY"));
				if(quantity < requiredPartList.get(index) ) {
					System.out.println("Inside Parts not available");
					partsAvailable=false;
				}
			}
			
		}
		return partsAvailable;
	}
	
	public static ArrayList<String> getTimeSlot(String mechanicFirstName, String mechanicLastName, Float duration) throws SQLException {
		int empId=0;
		ArrayList<String> timeSlot = new ArrayList<String>();
		
		if(mechanicFirstName!=null && mechanicFirstName!="" && mechanicLastName!=null && mechanicLastName!="")
			resultSet = statement.executeQuery( "SELECT EID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName + "' and LASTNAME = '" + mechanicLastName + "'" );
		else if(mechanicFirstName!=null && mechanicFirstName!="" && (mechanicLastName==null || mechanicLastName==""))
			resultSet = statement.executeQuery( "SELECT EID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName + "'");
		if(resultSet.next())
		{
			empId = Integer.parseInt(resultSet.getString("EID"));
		}
		//Fetch employee based on only last name information
		
		if(empId != 0)
		{
			String startTime="";
			String endTime="";
			HashMap<String,String> mechanicTimeSlot = new HashMap<String,String>();
			resultSet = statement.executeQuery( "SELECT START_TIME,END_TIME FROM TIME_SLOT WHERE MECHANIC_ID = '" + empId + "'");
			if(resultSet.next())
			{
				startTime = resultSet.getString("START_TIME");
				startTime = resultSet.getString("END_TIME");
				mechanicTimeSlot.put(startTime, endTime);
			}
		}
		
		
		
		return timeSlot;
		
	}
	

}
 

