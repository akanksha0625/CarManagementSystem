package com.java.dbms.proj.controller;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.views.*;
 
public class ApplicationController {
	/* Response string and Scanner to process user option selections. */
	static String response = "";
	static Scanner input = new Scanner( System.in );
	
	/*Flow association with the homepage. --> entry point of application flow*/
	public static void home() {
		response = Home.displayHome( input );
		if( response.equals( "1" ) ) {
			/*Redirect to login page*/
			login();
		}else if( response.equals( "2" ) ) {
			/*Redirect to Customer SignUp page*/
			try {
				response = SignUpController.signUp(input);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			if(response.equals("1")) {
				login();
			} else {
				home();
			}
		}else {
			/*Exit system*/
			try {
				Exit.displaypage();
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
		}
	}
		
	/*Flow associated with the login page --> second step of application, determines which user flow to pick up*/
	private static void login() {
		String role = "";
		try {
			role = LoginController.userLogin(input);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		if( role.equalsIgnoreCase("manager")){
			/*Redirect to manager landing page*/
			manager();
		}else if(role.equalsIgnoreCase("receptionist")){
			/*Redirect to receptionist landing page*/
			receptionist();
		}else if(role.equalsIgnoreCase("mechanic")){
			/*Redirect to the employee profile page*/
			mechanic();
		}else{
			/*Redirect to the customer landing page*/
			customer();
		}
	}
	
//---------------------------------------------------------------------------------------------Manager	
	/*Flow associated with the manager*/
	private static void manager() {
		response = ManagerView.displayLanding( input );
		if( response.equals( "1" ) ) {
			/*Redirect to manager profile*/
			employeeProfile();
			manager();
		} else if( response.equals( "2" ) ) {
			/*Redirect to display customer profile page.*/
			EmployeeSearchCustomerController.searchCustomer(input);
			manager();
		}else if( response.equals( "3" ) ){
			/*Redirect to add Employee page.*/
			ManagerAddEmployeeController.addEmployee(input);
			manager();
		}else if( response.equals( "4" ) ){
			/*Redirect to display payroll page*/
			ManagerPayrollController.payroll(input);
			manager();
		}else if( response.equals( "5" ) ){
			/*Redirect to display inventory page*/
			ManagerInventoryController.displayInventory(input);
			manager();
		}else if( response.equals( "6" ) ){
			ManagerViewOrdersController.orderLanding(input);
			manager();
		}else if( response.equals( "7" ) ){
			/*Redirect to the notifications page*/
			ManagerNotificationsController.notifications(input);
			manager();
		}else if( response.equals( "8" ) ){
			/*Redirect to the new car model page*/
			ManagerNewCarController.newCar(input);
			manager();
		}else if( response.equals( "9" ) ){
			/*Redirect to car service details page*/
			ManagerCarServiceDetailsController.carServicDetails(input);
			manager();
		}else if( response.equals( "10" ) ){
			/*Redirect to service history page*/
			ManagerServiceHistoryController.serviceHistory(input);
			manager();
		}else if( response.equals( "11" ) ){
			/*Redirect to display invoices page*/
			ManagerInvoicesController.invoices(input);
			manager();
		}else {
			Logout.logout();
			for(int i = 0; i < 1000000; i++) {} //simulate timer to return to homepage
			home();
		}			
	}

//---------------------------------------------------------------------------------------------Employee	
	/*Handles the flow of the mechanic*/
	private static void mechanic() {
		response = EmployeeView.displayProfileLanding( input );
		employeeProfile();
	} 
	
//---------------------------------------------------------------------------------------------Receptionist
	/*Handles the flow of the receptionist*/
	private static void receptionist() {
		response = ReceptionistView.displayLanding(input);
		if(response.equals("1")) {
			/*Redirect to display manager profile page*/
			employeeProfile();
			receptionist();
		} else if(response.equals("2")) {
			/*Redirect to display customer profile page.*/
			EmployeeSearchCustomerController.searchCustomer(input);
			receptionist();
		}else if(response.equals("3")){
			/*Redirect to add Register Car.*/
			receptionistRegisterCar();
			receptionist();
		}else if(response.equals("4")){
			/*Redirect to service history page*/
			//controller called from view
			ManagerServiceHistoryController.serviceHistory(input);
			receptionist();
		}else if(response.equals("5")){
			/*Redirect to display Schedule Service*/
			receptionistScheduleService();
			receptionist(); //go back
		}else if(response.equals("6")){
			/*Redirect to display Reschedule Service*/
			rescheduleService();
			receptionist();
		}else if( response.equals("7")){
			/*Redirect to display invoices page*/
			//controller called from view
			response = ReceptionistView.displayInvoice(input);
			receptionist();
		}else if(response.equals("8")){
			/*Redirect to the Task Update page*/
			response = ReceptionistView.displayTaskUpdateInventory(input);
			receptionist();//go back
		}else if(response.equals("9")){
			/*Redirect to the Task Record Deliveries*/
			response = ReceptionistView.displayTaskUpdateDeliveries(input);
			if(response.equals("1")) {
				//TODO call controller to process delivery updates.
				System.out.println("CALL CONTROLLER TO HANDLE DELIVER UPDATES");
			}
			receptionist();
		}else {
			Logout.logout();
			//TODO set a timer
			home();
		}	
	}

//---------------------------------------------------------------------------------------------Customer	
	/*Handles the flow of the customer*/
	private static void customer() {
		response = CustomerView.displayLanding(input);
		if(response.equals("1")) {
			/*Redirect to display customer profile page*/
			customerProfile();
			customer();
		} else if(response.equals("2")) {
			/*Redirect to display register car profile page.*/
			receptionistRegisterCar();
			customer();
		}else if(response.equals("3")){
			/*Redirect to Service page.*/
			customerService();
			customer();
		}else if(response.equals("4")){
			/*Redirect to service invoice page*/
			CustomerView.displayInvoice(input);
			customer();
		}else {
			Logout.logout();
			//TODO set a timer
			home();
		}	
	}
	
	//--------------------------------------------------------------------------------------------- Helper Methods
	/*Handles the flow of the employee profile page.*/
	private static void employeeProfile() {
		response = EmployeeView.displayProfileLanding( input );
		if( response.equals( "1" ) ) {
			/*Redirect to Employee View Profile*/
			EmployeeViewProfileController.viewProfile( input );
			employeeProfile();
		} else if( response.equals( "2" ) ) {
			/*Redirect to Employee Update Profile*/
			EmployeeUpdateProfileController.updateProfile(input);
			employeeProfile();
		}	
	}
	
	
	//---------------------------------------------------------------------------------------------Receptionist Helper Methods
	private static void rescheduleService() {
		do {
			response = ReceptionistView.displayRescheduleService1(input);
			if(response.equals("1")) {
				System.out.println("Enter the Service ID of the service you would like to reschedule : ");
				response = input.nextLine();
				//TODO add controller to verify service ID and select two dates for service
				response = ReceptionistView.displayRescheduleService2(input);
				if(response.equals("1")) {
					//TODO call controller to have customer choose from the two dates
					System.out.println("CALL CONTROLLER TO HAVE CUSTOMER SELECT THE DATE");
				}
				response = "1";
			}
		}while(response.equals("1"));
	}
	private static void receptionistScheduleService() {
		do {
			response = ReceptionistView.displayScheduleService(input);
			if(response.equals("1")) {
				receptionistScheduleMaintenance();
			}else if(response.equals("2")) {
				receptionistScheduleRepair();
			}
			System.out.println("Stuck?????");
		}while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
		System.out.println("GO BACK?");
		receptionist();
	}
	private static void receptionistScheduleRepair() {
		response = ReceptionistView.displayScheduleRepair1(input);
		if(!response.equals("8")) {
			//TODO call controller to have create diagnostic report
			System.out.println("CALL CONTROLLER TO CREATE DIAGNOSTIC REPORT");
			response = ReceptionistView.displayScheduleRepair2(input);
			if(!response.equals("1")) {
				//TODO call controller to have customer choose from the two dates
				System.out.println("CALL CONTROLLER TO HAVE CUSTOMER SELECT THE DATE");
			}
			//go back
		}
		receptionistScheduleService();
	}
	private static void receptionistScheduleMaintenance() {
		do {
			response = ReceptionistView.displayScheduleMaintenance1(input);
			if(response.equals("1")) {
				response = ReceptionistView.displayScheduleMaintenance2(input);
				if(response.equals("1")) {
					//TODO call controller to have customer choose from the two dates
					System.out.println("CALL CONTROLLER TO HAVE CUSTOMER SELECT THE DATE");
				}
				//go back
			}
		}while(response.equals("1"));
		receptionistScheduleService();
	}
	private static void receptionistRegisterCar() {
		do {
			response = ReceptionistView.displayRegisterCar(input);
			if(response.equals("1")) {
				//TODO call controller to handle registering a car
				System.out.println("CALL CONTROLLER TO HANDLE CAR REGISTRATION");
			}
		}while(response.equals("1"));
	}
	//---------------------------------------------------------------------------------------------Customer Helper Methods
	private static void customerService() {
		response = CustomerView.displayService(input);
		if(response.equals("1")){
			/*Redirect to Customer Service History page*/
			response = CustomerView.displayServiceHistory(input);
			customerService(); //Go Back
		}else if(response.equals("2")){
			/*Redirect to display Schedule Service*/
			receptionistScheduleService();
			customerService(); //go back
		}else if(response.equals("3")){
			/*Redirect to display Reschedule Service*/
			rescheduleService();
			customerService();
		}else {
			customer(); //Go Back
		}
	}
	private static void customerProfile() {
		response = CustomerView.displayProfile(input);
		
		if(response.equals("1")) {
			/*Redirect to customer view profile*/
			response = CustomerView.displayViewProfile(input);
			customerProfile(); // only option is to go back to the profile
		} else if(response.equals("2")) {
			updateCustomerProfile();
		}
		
	}
	private static void updateCustomerProfile() {
		do {
			response = CustomerView.displayUpdateProfile(input);
			//TODO call controller with (response) to determine what to update
			System.out.println("CALL CONTROLLER TO UPDATE PROFILE DETAIL");
		}while(!response.equals("7"));
		customerProfile(); //done editing profile, send back to profile landing page.
	}
	private static void customerScheduleService() {
		do {
			response = CustomerView.displayScheduleService(input);
			if(response.equals("1")) {
				customerScheduleMaintenance();
			}else if(response.equals("2")) {
				customerScheduleRepair();
			}
		}while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
		customerService();
	}
	private static void customerScheduleRepair() {
		response = CustomerView.displayScheduleRepair1(input);
		if(!response.equals("8")) {
			//TODO call controller to have create diagnostic report
			System.out.println("CALL CONTROLLER TO CREATE DIAGNOSTIC REPORT");
			response = CustomerView.displayScheduleRepair2(input);
			if(!response.equals("1")) {
				//TODO call controller to have customer choose from the two dates
				System.out.println("CALL CONTROLLER TO HAVE CUSTOMER SELECT THE DATE");
			}
			//go back
		}
		customerScheduleService();
		
	}
	private static void customerScheduleMaintenance() {
		// TODO Auto-generated method stub
		
	}

}
