package com.java.dbms.proj.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import com.java.dbms.proj.controller.ApplicationController;
import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.PayCheck;
import com.java.dbms.proj.entities.Service;
import com.java.dbms.proj.entities.Vehicle;

public class HelperFunctions {
	/* Necessary Variables for SQL Transactions */
	static ArrayList<Vehicle> carList = new ArrayList<Vehicle>();
	static ArrayList<String> cars = new ArrayList<String>();
	static Statement statement;
	static ResultSet resultSet;

	public static void updatePassword(String userName) throws SQLException {
		String userPassword = "";
		String userInput = "";
		boolean passwordMatch = true;
		Scanner input = new Scanner(System.in);
		statement = DBFacade.getConnection().createStatement();
		do {
			/* Assign user password */
			System.out.print("\nPlease enter a login password: ");
			userPassword = input.nextLine();
			System.out.print("Please confirm your password: ");
			userInput = input.nextLine();
			if (!userPassword.equals(userInput)) {
				System.out.println("\n***************************");
				System.out.println("| Password does not match |");
				System.out.println("***************************\n");
				passwordMatch = false;
			} else {
				passwordMatch = true;
			}
		} while (!passwordMatch);

		try {
			int tuples = statement.executeUpdate(
					"UPDATE LOGIN SET PASSWORD = '" + userPassword + "' where USERNAME = '" + userName + "'");
			if (tuples != 1)
				System.out.println("Unable to load user into the Login Table.");
		} catch (SQLException e) {
			System.out.println("Unable to access User Login Table : " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static ArrayList<Vehicle> getCustomerCars(int customerID) throws SQLException {
		statement = DBFacade.getConnection().createStatement();
		boolean matchFound = false;

		resultSet = statement.executeQuery("SELECT * FROM VEHICLE WHERE CID = '" + customerID + "'");
		while (resultSet.next()) {
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
		if (!matchFound) {
			cars.add("\t\tThere are currently no cars registerd for this customer.\n");
		}
		return carList;
	}

	public static void displayCustomerProfile(Customer customer) {
		System.out.println("\n\tCUSTOMER PROFILE DETAILS");
		System.out.println("\t------------------------\n");

		System.out.println("\tCustomer ID           :\t" + customer.getCustomerId());
		System.out.println("\tCustomer Name         :\t" + customer.getFirstName() + " " + customer.getLastName());
		System.out.println("\tCustomer Address      :\t" + customer.getAddress().addressToString());
		System.out.println("\tCustomer Phone Number :\t" + customer.getPhoneNumber());
		System.out.println("\tCustomer Email        :\t" + customer.getEmail());
		System.out.println("\tCustomer Username     :\t" + customer.getUsername());

		System.out.println("\n\tCUSTOMER REGISTERED CARS & DETAILS");
		System.out.println("\t----------------------------------");
		try {
			carList = HelperFunctions.getCustomerCars(customer.getCustomerId());
		} catch (SQLException e) {
			System.out.println("Issue Occured while trying to access Customer Cars : " + e.getMessage());
		}
		if (carList.isEmpty()) {
			System.out.println("\tThere are not cars currently associated with " + customer.getFirstName() + " "
					+ customer.getLastName() + "\n");
		} else {
			for (int i = 0; i < carList.size(); i++) {
				System.out.print(carList.get(i).toString());
			}
		}
	}

	public static boolean checkDate(String date) {

		try {
			new SimpleDateFormat(ApplicationConstants.DATE_FORMAT).parse(date);
			String month = date.split("-")[1];
			if (!month.equals("JAN") && !month.equals("FEB") && !month.equals("MAR") & !month.equals("APR")
					&& !month.equals("MAY") && !month.equals("JUN") && !month.equals("JUL") && !month.equals("AUG")
					&& !month.equals("SEP") && !month.equals("OCT") && !month.equals("NOV") && !month.equals("DEC")) {
				return false;
			}
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static String translateDate(String date) {
		String split[] = date.split("-");
		if (split[1].equalsIgnoreCase("jan")) {
			return split[0] + "-" + 1 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("feb")) {
			return split[0] + "-" + 2 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("mar")) {
			return split[0] + "-" + 3 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("apr")) {
			return split[0] + "-" + 4 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("may")) {
			return split[0] + "-" + 5 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("jun")) {
			return split[0] + "-" + 6 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("jul")) {
			return split[0] + "-" + 7 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("aug")) {
			return split[0] + "-" + 8 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("sep")) {
			return split[0] + "-" + 9 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("oct")) {
			return split[0] + "-" + 10 + "-" + split[2];
		} else if (split[1].equalsIgnoreCase("nov")) {
			return split[0] + "-" + 11 + "-" + split[2];
		}
		return split[0] + "-" + 12 + "-" + split[2];
	}

	public static String translateBack(String date) {
		String split[] = date.split("-");
		if (split[1].equalsIgnoreCase("1")) {
			return split[0] + "-JAN-" + split[2];
		} else if (split[1].equalsIgnoreCase("2")) {
			return split[0] + "-FEB-" + split[2];
		} else if (split[1].equalsIgnoreCase("3")) {
			return split[0] + "-MAR-" + split[2];
		} else if (split[1].equalsIgnoreCase("4")) {
			return split[0] + "-APR-" + split[2];
		} else if (split[1].equalsIgnoreCase("5")) {
			return split[0] + "-MAY-" + split[2];
		} else if (split[1].equalsIgnoreCase("6")) {
			return split[0] + "-JUN-" + split[2];
		} else if (split[1].equalsIgnoreCase("7")) {
			return split[0] + "-JUL-" + split[2];
		} else if (split[1].equalsIgnoreCase("8")) {
			return split[0] + "-AUG-" + split[2];
		} else if (split[1].equalsIgnoreCase("9")) {
			return split[0] + "-SEP-" + split[2];
		} else if (split[1].equalsIgnoreCase("10")) {
			return split[0] + "-OCT-" + split[2];
		} else if (split[1].equalsIgnoreCase("11")) {
			return split[0] + "-NOV-" + split[2];
		}
		return split[0] + "-DEC-" + split[2];

	}

	public static ArrayList<Service> getServiceHistory(Customer customer) throws SQLException {
		statement = DBFacade.getConnection().createStatement();
		ArrayList<Service> serviceList = new ArrayList<Service>();
		try {

			resultSet = statement.executeQuery("SELECT * FROM APPOINTMENT WHERE CUSTOMER_ID = '"
					+ customer.getCustomerId() + "' and STATE ='" + ApplicationConstants.COMPLETE + "'");

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

		for (int i = 0; i < serviceList.size(); i++) {

			/* Find Time Slot of Appointment */
			resultSet = statement.executeQuery(
					"SELECT * FROM TIME_SLOT WHERE APPOINTMENT_ID = '" + serviceList.get(i).getAppointmentID() + "'");
			if (resultSet.next()) {
				serviceList.get(i).createTimeSlot(resultSet.getInt("SLOT_ID"), resultSet.getString("START_TIME"),
						resultSet.getString("END_TIME"));
				serviceList.get(i).setMechanicID(resultSet.getInt("MECHANIC_ID"));
			}
		}
		for (int i = 0; i < serviceList.size(); i++) {
			resultSet = statement.executeQuery("SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE EID = '"
					+ serviceList.get(i).getMechanicID() + "'");
			if (resultSet.next()) {
				serviceList.get(i)
						.setMechanicFullName(resultSet.getString("FIRSTNAME") + " " + resultSet.getString("LASTNAME"));
			}
		}
		return serviceList;
	}

	public static void displayServiceHistory(Customer customer) throws SQLException {

		ArrayList<Service> serviceList = getServiceHistory(customer);

		if (serviceList.size() == 0)
			System.out.println("There is no service history available for " + customer.getFirstName() + " "
					+ customer.getLastName() + ".");

		else {
			System.out.println("\n\tDISPLAY CUSTOMER SERVICE HISTORY");
			System.out.println("\t-------------------------------\n");

			for (int index = 0; index < serviceList.size(); index++) {
				Service service = serviceList.get(index);

				System.out.println("\tService ID                :\t" + service.getAppointmentID());
				System.out.println("\tLicense Plate             :\t" + service.getVehicleLicense());
				System.out.println("\tService Type              :\t" + service.getServiceType());
				System.out.println("\tMechanic Name             :\t" + service.getMechanicFullName());
				System.out.println("\tService Start Date|Time   :\t" + service.getAppointmentDate() + " | "
						+ service.getTimeSlot().getStartTime());
				;
				System.out.println("\tService End Date|Time     :\t" + service.getAppointmentDate() + " | "
						+ service.getTimeSlot().getEndTime());
				System.out.println("\tService Status            :\t" + service.getServiceStatus()
						+ "\n\t-------------------------------\n");
			}
		}
	}

	public static boolean validateCarDetails(Customer customer, String licensePlateNumber) throws SQLException {
		ArrayList<Vehicle> vehicleList = getCustomerCars(customer.getCustomerId());
		for (int index = 0; index < vehicleList.size(); index++) {
			if (vehicleList.get(index).getLicense().equals(licensePlateNumber)) {
				return true;
			}
		}
		return false;
	}

	public static String getServiceToBeScheduled(String vehicleLicenseNumber, int mileage) throws SQLException {
		String lastServiceName = "";
		String lastServiceType = "";
		String serviceTobeScheduled = "";
		// int mileage=0;

		statement = DBFacade.getConnection().createStatement();

		try {

			resultSet = statement.executeQuery(
					"SELECT CURRENT_MILEAGE,LAST_SERVICE_TYPE,LAST_MAINTENANCE_TYPE FROM VEHICLE WHERE  LICENSE = '"
							+ vehicleLicenseNumber + "'");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		if (resultSet.next()) {
			lastServiceName = resultSet.getString("LAST_MAINTENANCE_TYPE");
			// mileage = resultSet.getInt("CURRENT_MILEAGE");
		}

		if (lastServiceName == null || lastServiceName.equals("")) {
			if (mileage < 10000)
				serviceTobeScheduled = ApplicationConstants.SERVICEA;
			else if (mileage < 250000)
				serviceTobeScheduled = ApplicationConstants.SERVICEB;
			else
				serviceTobeScheduled = ApplicationConstants.SERVICEC;
		} else {

			if (lastServiceName.equals(ApplicationConstants.SERVICEA))
				serviceTobeScheduled = ApplicationConstants.SERVICEB;
			else if (lastServiceName.equals(ApplicationConstants.SERVICEB))
				serviceTobeScheduled = ApplicationConstants.SERVICEC;
			else
				serviceTobeScheduled = ApplicationConstants.SERVICEA;
		}

		return serviceTobeScheduled;
	}

	public static int getVechileID(String vehicleLicenseNumber) {
		int vid = 0;
		try {
			resultSet = statement
					.executeQuery("SELECT VID FROM VEHICLE WHERE LICENSE = '" + vehicleLicenseNumber + "'");
			if (resultSet.next()) {
				/* Find Customer Appointment */
				vid = resultSet.getInt("VID");
			} else {
				System.out.println("There is no vehicle associated with the given car scheduled for appointment : "
						+ vehicleLicenseNumber);
			}
		} catch (SQLException e) {
			System.out.println("Unable to access the Vehicle Table : " + e.getMessage());
		}
		return vid;
	}

	public static ArrayList<Integer> getChildServiceList(String serviceName, String serviceType, String licenseNumber)
			throws SQLException {
		int vechicleId = 0;
		vechicleId = getVechileID(licenseNumber);
		ArrayList<Integer> childServiceList = new ArrayList<Integer>();
		if (vechicleId != 0) {
			int maintenanceId = 0;
			if (serviceName == ApplicationConstants.MAINTENANCE)
				resultSet = statement.executeQuery("SELECT MAINTENANCE_ID FROM MAINTENANCE WHERE MAINTENANCE_NAME = '"
						+ serviceType + "' and VID='" + vechicleId + "'");

			if (resultSet.next()) {
				maintenanceId = resultSet.getInt("MAINTENANCE_ID");
			}

			if (maintenanceId != 0) {
				resultSet = statement.executeQuery(
						"SELECT SERVICE_ID FROM MAINTENANCE_SERVICE_MAPPING WHERE M_ID = '" + maintenanceId + "'");

				while (resultSet.next()) {
					int childServiceId = 0;
					childServiceId = resultSet.getInt("SERVICE_ID");
					childServiceList.add(childServiceId);
				}
			}

		}
		return childServiceList;
	}

	public static float calculateServiceDuration(String serviceName, String serviceType, String licenseNumber)
			throws SQLException {
		float timeDuration = 0;
		ArrayList<Integer> childServiceList = getChildServiceList(serviceName, serviceType, licenseNumber);
		for (int i = 0; i < childServiceList.size(); i++) {
			resultSet = statement.executeQuery("SELECT TIME_REQUIRED,PART_ID FROM SERVICE_DETAILS WHERE SERVICE_ID = '"
					+ childServiceList.get(i) + "'");

			while (resultSet.next()) {
				float childServiceTime = 0;
				childServiceTime = Float.parseFloat(resultSet.getString("TIME_REQUIRED"));
				timeDuration = timeDuration + childServiceTime;
			}
		}
		return timeDuration;
	}

	public static boolean compareDatesTimes(String currentDate, String currentTime, String possibleDate,
			String possibleTime) {

		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy, h:mm a");

		try {
			Date current = formatter1.parse(currentDate + ", " + currentTime);
			System.out.println("CURRENT : " + current);
			Date possible = formatter1.parse(possibleDate + ", " + possibleTime);
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

	public static String addTime(String startTime, double laborHours) {
		String[] startSplit = startTime.split(":");
		int startHour = Integer.parseInt(startSplit[0]);
		int startMin = Integer.parseInt(startSplit[1].split(" ")[0]);
		String ampm = startSplit[1].split(" ")[1];

		int endHour = startHour + (int) (laborHours / 1);
		int endMin = startMin + (int) ((laborHours % 1) * 60);

		if (ampm.equalsIgnoreCase("pm"))
			return endHour + ":" + endMin + " " + ampm;
		else {
			if (endHour >= 12)
				return endHour + ":" + endMin + " pm";
			else
				return endHour + ":" + endMin + " am";
		}
	}

	public static int calculateDuration(PayCheck payCheck, String start) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString = start;
		Date startDate = null;
		int day = Integer.parseInt(start.split("-")[0]);

		if (Integer.parseInt(java.time.LocalTime.now().toString().split(":")[0]) >= 17)
			day++;

		try {
			startDate = sdf.parse(dateInString);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
		}

		Date endDate = null;
		try {
			endDate = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		Calendar current = Calendar.getInstance();

		if ((startCal.get(Calendar.MONTH) == endCal.get(Calendar.MONTH) + 1)
				&& (startCal.get(Calendar.YEAR) == endCal.get(Calendar.YEAR))) {
			System.out.println("CURRENT MONTH CHECK");
			endCal.add(Calendar.DAY_OF_MONTH, current.get(Calendar.DAY_OF_MONTH) - 1);
		} else {
			endCal.add(Calendar.DAY_OF_MONTH, (endCal.getActualMaximum(Calendar.DAY_OF_MONTH) + 1) - day);
		}

		String beginning = "1-" + (startCal.get(Calendar.MONTH) + 1) + "-" + startCal.get(Calendar.YEAR);
		String end = (endCal.getActualMaximum(Calendar.DAY_OF_MONTH)) + "-" + (endCal.get(Calendar.MONTH) + 1) + "-"
				+ endCal.get(Calendar.YEAR);

		payCheck.setPayPeriod(HelperFunctions.translateBack(beginning) + " to " + HelperFunctions.translateBack(end));

		if ((endCal.get(Calendar.MONTH) + 1) != 12) {

			payCheck.setDate(HelperFunctions
					.translateBack("1-" + (endCal.get(Calendar.MONTH) + 2) + "-" + endCal.get(Calendar.YEAR)));
		} else {
			payCheck.setDate("01-JAN-" + (endCal.get(Calendar.YEAR) + 1));
		}

		int workDays = 0;

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()) {
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {

				workDays++;
			}

			startCal.add(Calendar.DAY_OF_MONTH, 1);
		}

		return workDays;
	}

	public static HashMap<Integer, Integer> getPartList(String serviceName, String serviceType, String licenseNumber)
			throws SQLException {
		ArrayList<Integer> partIDList = new ArrayList<Integer>();
		ArrayList<Integer> childServiceList = getChildServiceList(serviceName, serviceType, licenseNumber);
		HashMap<Integer, Integer> requiredPartList = new HashMap<Integer, Integer>();
		for (int i = 0; i < childServiceList.size(); i++) {
			resultSet = statement.executeQuery(
					"SELECT PART_ID FROM SERVICE_DETAILS WHERE SERVICE_ID = '" + childServiceList.get(i) + "'");
			System.out.println("Inside childServiceList");
			while (resultSet.next()) {
				int partID = 0;
				partID = Integer.parseInt(resultSet.getString("PART_ID"));
				System.out.println("Required Part id:" + partID);
				partIDList.add(partID);
			}
		}

		for (int index = 0; index < partIDList.size(); index++) {
			resultSet = statement.executeQuery(
					"SELECT QUANTITY FROM PARTS_QUANTITY WHERE PART_ID = '" + partIDList.get(index) + "'");
			System.out.println("Inside Calculate parts quantity");

			while (resultSet.next()) {
				int quantity = Integer.parseInt(resultSet.getString("QUANTITY"));
				requiredPartList.put(partIDList.get(index), quantity);
				System.out.println("Part id:" + partIDList.get(index) + ":" + quantity);
			}

		}

		return requiredPartList;
	}

	// Needs to be changed based on order placement
	public static boolean checkPartAvailability(String serviceName, String serviceType, String licenseNumber)
			throws NumberFormatException, SQLException {
		int numberOfDays = 0;
		boolean partsAvailable = true;
		HashMap<Integer, Integer> requiredPartList = getPartList(serviceName, serviceType, licenseNumber);
		for (int index : requiredPartList.keySet()) {

			resultSet = statement
					.executeQuery("SELECT CURRENT_QUANTITY FROM ACME_INVENTORY WHERE PART_ID = '" + index + "'");

			while (resultSet.next()) {
				int quantity = Integer.parseInt(resultSet.getString("CURRENT_QUANTITY"));
				if (quantity < requiredPartList.get(index)) {
					System.out.println("Inside Parts not available");
					partsAvailable = false;
				}
			}

		}
		return partsAvailable;
	}

	public static ArrayList<String> getTimeSlot(String mechanicFirstName, String mechanicLastName, Float duration)
			throws SQLException {
		int empId = 0;
		ArrayList<String> timeSlot = new ArrayList<String>();

		if (mechanicFirstName != null && mechanicFirstName != "" && mechanicLastName != null && mechanicLastName != "")
			resultSet = statement.executeQuery("SELECT EID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName
					+ "' and LASTNAME = '" + mechanicLastName + "'");
		else if (mechanicFirstName != null && mechanicFirstName != ""
				&& (mechanicLastName == null || mechanicLastName == ""))
			resultSet = statement
					.executeQuery("SELECT EID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName + "'");
		if (resultSet.next()) {
			empId = Integer.parseInt(resultSet.getString("EID"));
		}
		// Fetch employee based on only last name information

		if (empId != 0) {
			String startTime = "";
			String endTime = "";
			HashMap<String, String> mechanicTimeSlot = new HashMap<String, String>();
			resultSet = statement
					.executeQuery("SELECT START_TIME,END_TIME FROM TIME_SLOT WHERE MECHANIC_ID = '" + empId + "'");

			if (resultSet.next()) {
				startTime = resultSet.getString("START_TIME");
				startTime = resultSet.getString("END_TIME");
				mechanicTimeSlot.put(startTime, endTime);
			}
		}

		return timeSlot;

	}
	
	public static int calculateDeliveryWindowForParts() throws SQLException {
		int partIds[] = {1,2};
		String scId = "S0001";
		
		Statement statement = DBFacade.getConnection().createStatement();
		ResultSet inventoryResult;

		int minOrderThreshold =0;
		int maxDeliveryInDays = 0, deliveryWindow=0;
		
		String csv = "" + partIds[0]; 
		for (int i=1; i< partIds.length;i++) {
			csv = csv+","+partIds[i];
		}
		try {
			resultSet = statement.executeQuery("SELECT * FROM ACME_INVENTORY WHERE PART_ID IN (" + csv + ") AND SC_ID = '" + scId + "'" );

			while (resultSet.next()) {
				minOrderThreshold = Integer.parseInt(resultSet.getString("MIN_ORDER_THRESHOLD"));
				try {
					inventoryResult = statement.executeQuery( "SELECT * FROM ACME_INVENTORY WHERE PART_ID = " + Integer.parseInt(resultSet.getString("PART_ID")) + " AND SC_ID <> '" + scId + "' AND MIN_QUANTITY >= (CURRENT_QUANTITY - "+ minOrderThreshold+" ) ORDER BY (CURRENT_QUANTITY - MIN_QUANTITY) DESC" );
					if(inventoryResult.next()) {
						deliveryWindow = Integer.parseInt(inventoryResult.getString("MIN_ORDER_THRESHOLD"));
					} else {
						try {
							inventoryResult = statement.executeQuery( "SELECT * FROM SUPPLIER_INVENTORY WHERE PART_ID = " + Integer.parseInt(resultSet.getString("PART_ID")) + " ORDER BY DELIVERY_WINDOW ASC ");
							deliveryWindow = Integer.parseInt(inventoryResult.getString("DELIVERY_WINDOW"));
						}catch ( SQLException e ) {
							System.out.println( "Unable to access Supplier Inventory table : " + e.getMessage() );
							e.printStackTrace();
						}
					}
					
					if(deliveryWindow > maxDeliveryInDays) {
						maxDeliveryInDays = deliveryWindow;
					}
				}catch ( SQLException e ) {
					System.out.println( "Unable to access Acme Inventory table for other Service centers : " + e.getMessage() );
					e.printStackTrace();
				}
				
			}
		} catch ( SQLException e ) {
			System.out.println( "Unabel to access Acme Inventory table : " + e.getMessage() );
			e.printStackTrace();
		}
		return maxDeliveryInDays;
	}

}
