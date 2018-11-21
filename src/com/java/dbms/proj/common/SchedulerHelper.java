package com.java.dbms.proj.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.DailyTimeSlot;
import com.java.dbms.proj.entities.HourlyEmployee;
import com.java.dbms.proj.entities.TimeSlot;
import com.java.dbms.proj.entities.Vehicle;
import com.java.dbms.proj.views.ReceptionistView;
import com.java.dbms.proj.entities.Schedule;
public class SchedulerHelper {
	
		/* Necessary Variables for SQL Transactions */
		static ArrayList<Vehicle> carList = new ArrayList<Vehicle>();
		static ArrayList<String> cars = new ArrayList<String>();
		static Statement statement;
		static ResultSet resultSet;
		
		public static String getEmployeeName(int employeeId) throws SQLException {
			String empFirstName="";
			String empLastName="";
			statement = DBFacade.getConnection().createStatement();
		resultSet = statement.executeQuery("SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE WHERE EID = '" + employeeId + "'");
		
		if(resultSet.next())
		{
			empFirstName=resultSet.getString("FIRSTNAME");
			empLastName=resultSet.getString("LASTNAME");
		}
		return empFirstName + " " + empLastName;
		}
		
		public static String datetoString(Date date) {
			int month = date.getMonth() + 1;
			int year = date.getYear() + 1900;
			String dateFormatted = date.getDate()+"-"+ month +"-" + year;
			dateFormatted = HelperFunctions.translateBack(dateFormatted);
			return dateFormatted;
		}
		
		public static ArrayList<Schedule> getPreferredMechanicTimeSlot(int empId, int slotsRequired, String serviceCenterId, Date nextDate) throws SQLException, ParseException {
			statement = DBFacade.getConnection().createStatement();
			ArrayList<Schedule>  result = new ArrayList<Schedule>();
			if (empId != 0) {
				String startTime = "";
				String endTime = "";

				final Calendar calendar = Calendar.getInstance();
				SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
				
				while(result.size()<2) {
					//Incrementing a day
					calendar.setTime(nextDate);
					calendar.add(Calendar.DAY_OF_YEAR, 1);
					nextDate = calendar.getTime();
					int month = nextDate.getMonth() + 1;
					int year = nextDate.getYear() + 1900;
					String dateFormatted = nextDate.getDate() + "-" + month + "-" + year;			
					resultSet = statement.executeQuery(
							"SELECT APPOINTMENT_DATE FROM APPOINTMENT WHERE STATE='PENDING' AND MECHANIC_ID = '"
									+ empId + "' and APPOINTMENT_DATE = '" + HelperFunctions.translateBack(dateFormatted)+"'");
					//If appointment is present on the next day
				if(resultSet.next()) {
					
					resultSet = statement.executeQuery(
							"SELECT APPOINTMENT_DATE,START_TIME,END_TIME FROM TIME_SLOT T, APPOINTMENT A WHERE T.APPOINTMENT_ID=A.APPOINTMENT_ID AND STATE='PENDING' AND A.MECHANIC_ID = '"
									+ empId + "' and APPOINTMENT_DATE = '" + HelperFunctions.translateBack(dateFormatted) + "'");

					DailyTimeSlot dailyTimeSlotObj = new DailyTimeSlot();
					ArrayList<TimeSlot> bookedTimeSlotList  = dailyTimeSlotObj.getTimeslotList();
					dailyTimeSlotObj.setDate(nextDate);

					while (resultSet.next()) {
						boolean activeSlots = false;
						startTime = resultSet.getString("START_TIME");
						endTime = resultSet.getString("END_TIME");
						for (int i = 0; i < ApplicationConstants.TIMESLOTS; i++) {
							if (startTime.equalsIgnoreCase(bookedTimeSlotList.get(i).getStartTime())) {
								activeSlots = true;
							}
							if (endTime.equalsIgnoreCase(bookedTimeSlotList.get(i).getEndTime())) {
								bookedTimeSlotList.get(i).setIsbooked(true);
								activeSlots = false;
								break;
							}
							if (activeSlots == true)
								bookedTimeSlotList.get(i).setIsbooked(true);

						}

						// search for free time slots

					}
					int countFreeSlots = 0;
					int firstIndex = -1;
					for (int i = 0; i < ApplicationConstants.TIMESLOTS; i++) {
						if (bookedTimeSlotList.get(i).isIsbooked() == false) {
							if (countFreeSlots == 0)
								firstIndex = i;

							countFreeSlots++;

							if (countFreeSlots == slotsRequired)
								break;
						} else {
							countFreeSlots = 0;
							firstIndex = -1;
						}
					}
					if (firstIndex != -1) {
						Schedule schedule =new Schedule();
						schedule.setAvailableTimeSlot(bookedTimeSlotList.get(firstIndex));
						schedule.setDate(nextDate);
						schedule.setMechanicId(empId);
						result.add(schedule);
					}
					
				}
				
				else {
					
					DailyTimeSlot dailyTimeSlotObj1 = new DailyTimeSlot();
					ArrayList<TimeSlot> firstTimeSlotList = dailyTimeSlotObj1.getTimeslotList();
					Schedule schedule =new Schedule();
					schedule.setAvailableTimeSlot(firstTimeSlotList.get(0));
					schedule.setDate(nextDate);
					schedule.setMechanicId(empId);
					result.add(schedule);
				}
					
				}
			}
			
			
			return result;
		}
		
		public static boolean checkValidMechanic(String mechanicFirstName,String mechanicLastName,String serviceCenter) throws SQLException {
			boolean isMechanicValid=false;
			statement = DBFacade.getConnection().createStatement();
			if (mechanicFirstName != null && mechanicFirstName != "" && mechanicLastName != null && mechanicLastName != "")
				resultSet = statement.executeQuery("SELECT SC_ID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName
						+ "' and LASTNAME = '" + mechanicLastName + "'");
		
			else if (mechanicFirstName != null && mechanicFirstName != ""
					&& (mechanicLastName == null || mechanicLastName == "")) 
				resultSet = statement.executeQuery("SELECT SC_ID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName + "'");
		
			if (resultSet!=null && resultSet.next()&& serviceCenter!=null &&!serviceCenter.isEmpty()) {
				isMechanicValid =serviceCenter.equalsIgnoreCase(resultSet.getString("SC_ID"));
				//System.out.println("isMechanicValid"+isMechanicValid+"resultset"+resultSet.getString("SC_ID"));
			}
			return isMechanicValid;
		}
		
		public static ArrayList<Schedule> getTimeSlot(String mechanicFirstName, String mechanicLastName,
				int slotsRequired, String serviceCenterId, Date nextDate) throws SQLException, ParseException {
			// add service center id logic to check only mechanics with same customer id as
			// customer			
		//	System.out.println("mechanicFirstName" + mechanicFirstName+"mechanicLastName"+mechanicLastName);
			int empId = 0;
			statement = DBFacade.getConnection().createStatement();
			ArrayList<Schedule>  result = new ArrayList<Schedule>();
			//HourlyEmployee mechanic = new HourlyEmployee();
			Date currDate=nextDate;
			if (mechanicFirstName != null && mechanicFirstName != "" && mechanicLastName != null && mechanicLastName != "")
				try {
				resultSet = statement.executeQuery("SELECT EID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName
						+ "' and LASTNAME = '" + mechanicLastName + "'");
				}
			catch (Exception e) {
				System.out.println("Unable to get the employee");
			}
			else if (mechanicFirstName != null && mechanicFirstName != ""
					&& (mechanicLastName == null || mechanicLastName == "")) {
				resultSet = statement.executeQuery("SELECT EID FROM EMPLOYEE WHERE FIRSTNAME = '" + mechanicFirstName + "'");
			
			if (resultSet.next()) {

				empId = Integer.parseInt(resultSet.getString("EID"));
			}
			}
			// Fetch employee based on only last name information
			
			if(empId!=0) {
			//	System.out.println("empId is enetered cond "+empId);
				return getPreferredMechanicTimeSlot(empId,slotsRequired,serviceCenterId,nextDate);
			}
			else if(empId==0) {
				
				ArrayList<Integer> mechanicList = new ArrayList<Integer>();
				if(serviceCenterId.isEmpty())
					resultSet = statement.executeQuery("SELECT EID FROM EMPLOYEE WHERE ROLE = 'MECHANIC'");
				else
				resultSet = statement.executeQuery("SELECT EID FROM EMPLOYEE WHERE ROLE = 'MECHANIC' and SC_ID = '"+ serviceCenterId+"'");

				while(resultSet.next()) {
					int mechanicId=resultSet.getInt("EID");
					mechanicList.add(mechanicId);
					
				}			
				
				final Calendar calendar = Calendar.getInstance();				
				while(result.size()<2) {
					//Incrementing a day
					calendar.setTime(nextDate);
					calendar.add(Calendar.DAY_OF_YEAR, 1);
					nextDate = calendar.getTime();
					int month = nextDate.getMonth() + 1;
					int year = nextDate.getYear() + 1900;

					String dateFormatted = nextDate.getDate() + "-" + month + "-" + year;			
					resultSet = statement.executeQuery(
							"SELECT APPOINTMENT_DATE FROM APPOINTMENT WHERE STATE='PENDING' AND APPOINTMENT_DATE = '" + HelperFunctions.translateBack(dateFormatted)+"'");
					
					
					//If appointment is present on the next day
				if(resultSet!=null && resultSet.next()) {
				
					ArrayList<Schedule>  mechanicScheduleList = new ArrayList<Schedule>();
					//book mechanic who does not have any appointments
					//return getPreferredMechanicTimeSlot(mechanicList.get(0),slotsRequired,serviceCenterId,nextDate);
					Date date;
					if(result.size()==0)
						date=currDate;
					else {
						calendar.setTime(currDate);
						calendar.add(Calendar.DAY_OF_YEAR, 1);
						date = calendar.getTime();
					}
					for( int i=0; i<mechanicList.size();i++ ) {
						mechanicScheduleList.addAll(getPreferredMechanicTimeSlot(mechanicList.get(i),slotsRequired,serviceCenterId,date));
				}
		
					Collections.sort(mechanicScheduleList);
					result.add(mechanicScheduleList.get(0));
					
					//Sort the timeslots of mechanics to do
					}
				
				else {
					
					DailyTimeSlot dailyTimeSlotObj1 = new DailyTimeSlot();
					ArrayList<TimeSlot> firstTimeSlotList = dailyTimeSlotObj1.getTimeslotList();
					Schedule schedule =new Schedule();
					schedule.setAvailableTimeSlot(firstTimeSlotList.get(0));
					schedule.setDate(nextDate);
					schedule.setMechanicId(mechanicList.get(0));
					result.add(schedule);
				}
				}
				}
							
			return result;

		}

		public static String searchEndSlot(String startTime, int numOfSlots) {
			String endTime="";
			DailyTimeSlot dailyTimeSlotObj1 = new DailyTimeSlot();
			ArrayList<TimeSlot> timeSlotList = dailyTimeSlotObj1.getTimeslotList();
			boolean matchFound=false;
			for(int i=0,j=0;i<timeSlotList.size()&& j<=numOfSlots ;i++){
			
				if(timeSlotList.get(i).getStartTime().equalsIgnoreCase(startTime)){
					matchFound=true;
				}
				if(matchFound==true)
				{
					j++;
				}
				if(j==numOfSlots)
				{
					endTime = timeSlotList.get(i).getEndTime();
					break;
				}
			}
			
			return endTime;
		}
	public static void scheduleMaintenance(Customer customer,Appointment appointment, Scanner input) throws SQLException, ParseException {
		String userInput="";
		String licensePlateNumber = "";
		int mileage=0;
		int numOfSlots=0;
		if(appointment!=null && appointment.getVehicle()!=null) {
			licensePlateNumber = appointment.getVehicle().getLicense();
			mileage = appointment.getVehicle().getCurrentMileage();
		}
		statement = DBFacade.getConnection().createStatement();
		boolean isValidVehicle = HelperFunctions.validateCarDetails(customer,licensePlateNumber);
		boolean isValidMechanic = SchedulerHelper.checkValidMechanic(appointment.getRequestedMechanicFirstName(),appointment.getRequestedMechanicLastName(),customer.getServiceCenterId());
		if(isValidMechanic==false && !appointment.getRequestedMechanicFirstName().isEmpty())
		{
			appointment.setRequestedMechanicFirstName("");
			appointment.setRequestedMechanicLastName("");
			System.out.println("\n\t\tThe entered mechanic is not associated with this service center. \n\t\t We would schedule you with the mechanics working only at this service center.\n");
		}
		if(isValidVehicle) {
			ReceptionistView.displayScheduleMaintenance2();
		String serviceTobeScheduled = HelperFunctions.getServiceToBeScheduled(licensePlateNumber, mileage);   
		int vehicleID = HelperFunctions.getVechileID(licensePlateNumber); 						
		int partsavailability = HelperFunctions.checkPartAvailability(ApplicationConstants.MAINTENANCE, serviceTobeScheduled, licensePlateNumber,customer.getServiceCenterId());
		if(partsavailability == 0) {
		float duration= HelperFunctions.calculateServiceDuration(ApplicationConstants.MAINTENANCE, serviceTobeScheduled, licensePlateNumber);
		numOfSlots = (int) Math.ceil((duration*60/30)); 
		ArrayList<Schedule> scheduleList=new ArrayList<Schedule>();
		Date nextDate = new Date();
		scheduleList = SchedulerHelper.getTimeSlot(appointment.getRequestedMechanicFirstName(),appointment.getRequestedMechanicLastName(),numOfSlots,customer.getServiceCenterId(),nextDate);
		
		System.out.println("\n\t\t***********Available Time Slots Details***********");
		for(int i=0;i<scheduleList.size();i++)
		{		int index = i+1;	
			Schedule schedule=scheduleList.get(i);
			TimeSlot t=schedule.getAvailableTimeSlot();
			String mechanicName = SchedulerHelper.getEmployeeName(schedule.getMechanicId()); 
			Date date = schedule.getDate();
			System.out.println("\t\t " + SchedulerHelper.datetoString(date) + " : " + t.getStartTime() + "|\t\tMechanic Name: " +  mechanicName);
		}
		System.out.println("\t\t**************************************************\t\t");
		System.out.println("\nPlease select from the following user options:");
		System.out.println("\tEnter '1' to Schedule on Date");
		System.out.println("\tEnter '2' to Go Back");
		
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2"));
		
		if(userInput.equals("1")) {
				System.out.println("Please select from the following user options:");
			
				for(int i=0;i<scheduleList.size();i++)
				{			
					int index = i+1;
					Schedule schedule=scheduleList.get(i);
					String mechanicName = SchedulerHelper.getEmployeeName(schedule.getMechanicId());
					TimeSlot t=schedule.getAvailableTimeSlot();
					Date date = schedule.getDate();
					System.out.println("\tEnter "+ index +" to Schedule on : " + SchedulerHelper.datetoString(date) + " : " + t.getStartTime() + "\tMechanic Name: " +  mechanicName);
				}
		
			do {
				System.out.print("\nOption Selection : ");
				userInput = input.nextLine();
			}while(!userInput.equals("1") && !userInput.equals("2"));	
			
			int counter=0;
			if(userInput.equals("1"))
			{
				counter = 0;
			}
			else
				counter = 1;
			
			resultSet = statement.executeQuery( "SELECT APPOINTMENT_SEQ.nextval from dual" );
			int appindex = 0;
			if ( resultSet.next() ) {
				appindex = resultSet.getInt( "NEXTVAL" );
			}
			String mechanicName = SchedulerHelper.getEmployeeName(scheduleList.get(counter).getMechanicId());
			statement.executeUpdate( "INSERT INTO APPOINTMENT VALUES ('" + appindex +"', '" + customer.getCustomerId() + "', '" + appointment.getVehicle().getLicense() + "', '" + 
									 SchedulerHelper.datetoString(scheduleList.get(counter).getDate()) + "', '" + mechanicName + "', '"+ ApplicationConstants.MAINTENANCE +"', '"+ ApplicationConstants.PENDING + "' , '" + serviceTobeScheduled + "' , '"  + scheduleList.get(counter).getMechanicId()+  "')");					
			
			
			resultSet = statement.executeQuery( "SELECT TIME_SLOT_SEQ.nextval from dual" );
			
			int index=0;
			
			if ( resultSet.next() ) {
				index = resultSet.getInt( "NEXTVAL" );
			}
			
			String startTime = scheduleList.get(counter).getAvailableTimeSlot().getStartTime() ;
			
			String endTime  = SchedulerHelper.searchEndSlot(startTime,numOfSlots);
			
			
			int res = statement.executeUpdate( "INSERT INTO TIME_SLOT VALUES ('" + index +"', '" + appindex + "', '" + scheduleList.get(counter).getMechanicId() + "', '" + 
					startTime + "', '" + endTime + "')");		
			
			if(res > 0 )
			{
				System.out.println("\t Thank you your appointment has been scheduled. \n-------------------------------------------------------------------------------------------------------------------------------------");
				
			}
		
		}
		}
		
		else {
			System.out.println("\t The parts required for the service are currently not availabile. Please try scheduling after " + partsavailability + " days.\t\n Sorry for inconvenience. \n-------------------------------------------------------------------------------------------------------------------------------------");
			
		}
		}
		else {
			System.out.println("\t\t******The entered car details could not be found registered in your name. Please re-enter your car details registered with ACME.******\n\n");
			
		}
	}
}
