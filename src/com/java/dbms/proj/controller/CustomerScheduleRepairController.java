package com.java.dbms.proj.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.java.dbms.proj.common.ApplicationConstants;
import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.common.HelperFunctions;
import com.java.dbms.proj.entities.Schedule;
import com.java.dbms.proj.common.SchedulerHelper;
import com.java.dbms.proj.entities.Appointment;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.Repair;
import com.java.dbms.proj.entities.TimeSlot;

public class CustomerScheduleRepairController {
	static Statement statement;
	static ResultSet  resultSet;

	public static void scheduleRepair(Scanner input) throws SQLException, ParseException {
		statement = DBFacade.getConnection().createStatement();
		Customer customer = ApplicationController.customer;
		Appointment appointment = CustomerScheduleServiceController.appointment;
		Boolean isValidVehicle=false;
		if(appointment!=null && appointment.getVehicle()!=null) {
			isValidVehicle = HelperFunctions.validateCarDetails(customer,appointment.getVehicle().getLicense());
		}
		if(isValidVehicle) {
		com.java.dbms.proj.views.CustomerView.displayScheduleRepair1(); //Display page header
		
		System.out.println("Please select from the following user options:");
		System.out.println("\tEnter '1' to select \"Engine knock\"");
		System.out.println("\tEnter '2' to select \"Car drifts in a particular direction\"");
		System.out.println("\tEnter '3' to select \"Battery does not hold charge\"");
		System.out.println("\tEnter '4' to select \"Black/unclean exhaust\"");
		System.out.println("\tEnter '5' to select \"A/C or Heater not working\"");
		System.out.println("\tEnter '6' to select \"Head-lamps or Tail-lamps not working\"");
		System.out.println("\tEnter '7' to select \"Check engine light\"");
		System.out.println("\tEnter '8' to Go Back");
		
		String userInput = "";
		do {
			System.out.print("\nOption Selection : ");
			userInput = input.nextLine();
		}while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") &&
				!userInput.equals("4") && !userInput.equals("5") && !userInput.equals("6") && 
				!userInput.equals("7") && !userInput.equals("8"));
		
		if(!userInput.equals("8")) {
		
			Repair repairService =new Repair();
			repairService.setRepairID(userInput);
			
			resultSet = statement.executeQuery("SELECT * FROM REPAIR where RID = '" + userInput + "'");
			if (resultSet.next()) {
				
				repairService.setDiagnosis(resultSet.getString("DIAGNOSTIC"));
				repairService.setDiagnosisFee(Double.parseDouble(resultSet.getString("DIAGNOSTIC_FEE")));
			}
			
			repairService.setSubServices(HelperFunctions.getChildRepairNameList(repairService.getRepairID()));
			repairService.setPartsList(HelperFunctions.getRepairParts(repairService.getRepairID()));
			
			
			boolean partsavailability = HelperFunctions.checkPartAvailability(ApplicationConstants.REPAIR,repairService.getRepairID(),"");
			System.out.println("Parts availability" +partsavailability );
			if(partsavailability == true) {
			float duration= HelperFunctions.calculateServiceDuration(ApplicationConstants.REPAIR, repairService.getRepairID(), "");
			System.out.println("DISPLAY SERVICE DATES duration" + duration);
			int numOfSlots = (int) Math.ceil((duration*60/30)); 
			System.out.println("Number Of slots"+numOfSlots);
			ArrayList<Schedule> scheduleList=new ArrayList<Schedule>();
			Date nextDate = new Date();
			scheduleList = SchedulerHelper.getTimeSlot(appointment.getRequestedMechanicFirstName(),appointment.getRequestedMechanicLastName(),numOfSlots,customer.getServiceCenterId(),nextDate);
			com.java.dbms.proj.views.CustomerView.displayScheduleRepair2(); //Display second page header
			
			//TODO display report and service dates
			System.out.println("\t\t*************DIAGNOSTIC REPORT*************\t\t");			
			System.out.println("\t\tDiagnostic:\t"+repairService.getDiagnosis());
			System.out.println("\t\tDiagnostic Fee:\t"+repairService.getDiagnosisFee());
			System.out.print("\t\tServices Required:\t");
			for(int i=0;i<repairService.getSubServices().size();i++)
			{
				System.out.print("\t|"+repairService.getSubServices().get(i)+"|");
			}
			System.out.println();
			System.out.print("\t\tParts Required:\t");
			for(int i=0;i<repairService.getPartsList().size();i++)
			{
				System.out.print("\t\t|" + repairService.getPartsList().get(i).getPartName()+"|");
			}
			System.out.println();
			System.out.println("\t\t*********************************************\t\t");	
			System.out.println("\n\t\t***********Available Time Slots Details***********");
			for(int i=0;i<scheduleList.size();i++)
			{		int index = i+1;	
				Schedule schedule=scheduleList.get(i);
				TimeSlot t=schedule.getAvailableTimeSlot();
				String mechanicName = SchedulerHelper.getEmployeeName(schedule.getMechanicId()); 
				Date date = schedule.getDate();
				
				System.out.println("\t\t " + SchedulerHelper.datetoString(date) + " : " + t.getStartTime() + "\tMechanic Name: " +  mechanicName);
			}
			System.out.println("\t\t**************************************************\t\t");
			System.out.println("\nPlease select from the following user options:");
			System.out.println("\tEnter '1' to schedule your date for Repair");
			System.out.println("\tEnter '2' Go Back");
			
			userInput = "";
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
									 SchedulerHelper.datetoString(scheduleList.get(counter).getDate()) + "', '" + mechanicName + "', '"+ ApplicationConstants.REPAIR + "', '" + ApplicationConstants.PENDING +"' , '" + repairService.getRepairID() + "' , '"  + scheduleList.get(counter).getMechanicId()+  "')");					
			
			
			resultSet = statement.executeQuery( "SELECT TIME_SLOT_SEQ.nextval from dual" );
			
			int index=0;
			
			if ( resultSet.next() ) {
				index = resultSet.getInt( "NEXTVAL" );
			}
			
			String startTime = scheduleList.get(counter).getAvailableTimeSlot().getStartTime() ;
			System.out.println("Num of slots:"+numOfSlots);
			String endTime  = SchedulerHelper.searchEndSlot(startTime,numOfSlots);
			System.out.println("End time is "+ endTime);
			
			int res = statement.executeUpdate( "INSERT INTO TIME_SLOT VALUES ('" + index +"', '" + appindex + "', '" + scheduleList.get(counter).getMechanicId() + "', '" + 
					startTime + "', '" + endTime + "')");		
			
			if(res > 0 )
			{
				System.out.println("\t Thank you your appointment has been scheduled. \n-------------------------------------------------------------------------------------------------------------------------------------");
				
			}
			}
		}
			else {
				System.out.println("\t The parts required for the service are currently not availabile. Please try scheduling after " + partsavailability + " of days.\t\n Sorry for inconvenience. \n-------------------------------------------------------------------------------------------------------------------------------------");
				
			}
		}
		}
			else {
				System.out.println("\t\t******The entered car details could not be found. Please re-enter the car details registered with ACME.******\n\n");
				
			}
			
			
	}

}
