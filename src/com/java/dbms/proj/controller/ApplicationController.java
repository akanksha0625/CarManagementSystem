package com.java.dbms.proj.controller;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.dbms.proj.views.*;
 
public class ApplicationController {
	/* Response string and Scanner to process user option selections. */
	static String response = "";
	static Scanner input = new Scanner(System.in);
//---------------------------------------------------------------------------------------------Home		
	/*Flow association with the homepage. --> entry point of application flow*/
	public static void home() {
		response = Home.displayHome(input);
		if(response.equals("1")) {
			/*direct to login page*/
			login();
		}else if(response.equals("2")) {
			/*direct to signup page*/
			signUp();
		}else {
			/*Exit system*/
			try {
				Exit.displaypage();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
//---------------------------------------------------------------------------------------------Login	
	/*Flow associated with the login page --> second step of application flow, determines which flow to pick up*/
	private static void login() {
		response = Login.displayLogin(input);
		if(response.equals("1")) {
			/*Login the user*/
			//TODO call login controller
			//TODO login controller should return the role of the user to determine next redirect
			//String role = signInController()
			
			String role = "receptionist"; // string just for testing redirect --> remove later
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
		}else {
			/*Return home*/
			home();
		}
	}
//---------------------------------------------------------------------------------------------Manager	
	/*Flow associated with the manager*/
	private static void manager() {
		response = ManagerView.displayLanding(input);
		if(response.equals("1")) {
			/*Redirect to display manager profile page*/
			employeeProfile();
			manager();
		} else if(response.equals("2")) {
			/*Redirect to display customer profile page.*/
			searchCustomer();
			manager();
		}else if(response.equals("3")){
			/*Redirect to add Employee page.*/
			addEmployee();
			manager();
		}else if(response.equals("4")){
			/*Redirect to display payroll page*/
			payroll();
			manager();
		}else if(response.equals("5")){
			/*Redirect to display inventory page*/
			//inventory controller is called from view
			response = ManagerView.displayInventory(input);
			manager(); //go back
		}else if(response.equals("6")){
			viewOrders();
			manager();
		}else if(response.equals("7")){
			/*Redirect to the notifications page*/
			notifications();
			manager();//go back
		}else if(response.equals("8")){
			/*Redirect to the new car model page*/
			newCar();
			manager();//go back
		}else if(response.equals("9")){
			/*Redirect to car service details page*/
			// controller called from view
			response = ManagerView.displayCarServiceDetails(input);
			manager();
		}else if(response.equals("10")){
			/*Redirect to service history page*/
			//controller called from view
			response = ManagerView.displayServiceHistory(input);
			manager();
		}else if(response.equals("11")){
			/*Redirect to display invoices page*/
			//controller called from view
			response = ManagerView.displayInvoices(input);
			manager();
		}else {
			Logout.logout();
			//TODO set a timer
			home();
		}			
	}

private static void payroll() {
	do{
		response = ManagerView.displayPayroll(input);
		if(response.equals("1")) {
			//TODO call controller to display employee payroll details
			System.out.println("ADD CONTROLLER TO GET EMPLOYEE PAYROLL");
		}
	}while(response.equals("1"));
		
}
//---------------------------------------------------------------------------------------------Employee	
	private static void mechanic() {
		response = EmployeeView.displayProfile(input);
		employeeProfile();
	} 
//---------------------------------------------------------------------------------------------Receptionist
	private static void receptionist() {
		response = ReceptionistView.displayLanding(input);
		if(response.equals("1")) {
			/*Redirect to display manager profile page*/
			employeeProfile();
			receptionist();
		} else if(response.equals("2")) {
			/*Redirect to display customer profile page.*/
			searchCustomer();
			receptionist();
		}else if(response.equals("3")){
			/*Redirect to add Register Car.*/
			registerCar();
			receptionist();
		}else if(response.equals("4")){
			/*Redirect to service history page*/
			//controller called from view
			response = ManagerView.displayServiceHistory(input);
			receptionist();
		}else if(response.equals("5")){
			/*Redirect to display Schedule Service*/
			scheduleService();
			receptionist(); //go back
		}else if(response.equals("6")){
			/*Redirect to display Reschedule Service*/
			rescheduleService();
			receptionist();
		}else if(response.equals("7")){
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
private static void scheduleService() {
	do {
		response = ReceptionistView.displayScheduleService(input);
		if(response.equals("1")) {
			scheduleMaintenance();
		}else if(response.equals("2")) {
			scheduleRepair();
		}
		System.out.println("Stuck?????");
	}while(!response.equals("1") && !response.equals("2") && !response.equals("3"));
	System.out.println("GO BACK?");
	receptionist();
}
private static void scheduleRepair() {
	response = ReceptionistView.displayScheduleRepair1(input);
	if(response.equals("8")) {
		//TODO call controller to have create diagnostic report
		System.out.println("CALL CONTROLLER TO CREATE DIAGNOSTIC REPORT");
		response = ReceptionistView.displayScheduleRepair2(input);
		if(!response.equals("1")) {
			//TODO call controller to have customer choose from the two dates
			System.out.println("CALL CONTROLLER TO HAVE CUSTOMER SELECT THE DATE");
		}
		//go back
	}
	scheduleService();
}
private static void scheduleMaintenance() {
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
	scheduleService();
}
private static void registerCar() {
	do {
		response = ReceptionistView.displayRegisterCar(input);
		if(response.equals("1")) {
			//TODO call controller to handle registering a car
			System.out.println("CALL CONTROLLER TO HANDLE CAR REGISTRATION");
		}
	}while(response.equals("1"));
}
//---------------------------------------------------------------------------------------------Customer	
	private static void customer() {
		response = CustomerView.displayLanding(input);
		//TODO like manager
	}
//---------------------------------------------------------------------------------------------Helper Methods
	private static void searchCustomer() {
		do{
			response = EmployeeView.displayCustomerProfile(input);
			if(response.equals("1")) {
				//TODO call controller to process customer email selection and display of customer profile details
				System.out.println("CALL CONTROLLER TO HANDLE SEARCHING CUSTOMER");
			}
		}while(response.equals("1"));
	}

	private static void notifications() {
		do {
			response = ManagerView.displayNotifications(input);
			if(response.equals("1")) {
				System.out.println("What Order ID would you like to view? : ");
				response = input.nextLine();
				//TODO add logic to check for correct order ID
				//call controller to display the information about this order ID notification with the details view
				System.out.println("SEND RESPONSE TO THE CONTROLLER TO GET NOTIFICATION DETAILS");
				response = "1";
			}
		} while(response.equals("1"));
	}

	private static void newCar() {
		do {
			response = ManagerView.displayNewCarModel(input);
			if(response.equals("1")) {
				//TODO call addCar controller
				System.out.println("ADD CONTROLLER TO ADD NEW CAR");
			}
		}while(response.equals("1"));
	}

	private static void employeeProfile() {
		response = EmployeeView.displayProfile(input);
				
		if(response.equals("1")) {
			/*Redirect to employee view profile*/
			// view profile controller is called from view.
			response = EmployeeView.displayViewProfile(input);
			employeeProfile(); // only option is to go back to the profile
		} else if(response.equals("2")) {
			updateProfile();
		}		
	}

	private static void updateProfile() {
		do {
			response = EmployeeView.displayProfileUpdate(input);
			//TODO call controller with (response) to determine what to update
			System.out.println("CALL CONTROLLER TO UPDATE PROFILE DETAIL");
		}while(!response.equals("7"));
		employeeProfile(); //done editing profile, send back to profile landing page.
	}

	private static void viewOrders() {
		do{
			response = ManagerView.displayOrders(input);
	
			if(response.equals("1")) {
				/*Redirect to view order history page*/
				//controller called from view
				ManagerView.displayOrderHistory(input);
				viewOrders();//go back
			} else if(response.equals("2")){
				/*Redirect to new order page*/
				response = ManagerView.displayNewOrder(input);
				System.out.println("RESPONSE = "+response);
				if(response.equals("1")) {
					//TODO call place order controller
					System.out.println("ADD CONTROLLER TO CREATE NEW ORDER");
				} else {
					viewOrders(); //go back
				}
			}
		}while(!response.equals("3"));
	}
	/*Flow association with the signUp page. */
	private static void signUp() {
		response = CustomerView.displaySignUp(input);
		if(response.equals("1")) {
			/*Sign up the customer*/
			//TODO call the signUp controller;
			System.out.println("CALL CONTROLLER TO SIGN UP THE CUSTOMER");
		}
		/*Return home*/
		home();
	}
	
	private static void addEmployee() {
		do{
			response = ManagerView.dsiplayAddEmployee(input);
			if(response.equals("1")) {
				//TODO call addEmployee controller
				System.out.println("ADD CONTROLLER TO ADD EMPLOYEE");
			}
		}while(response.equals("1"));
	}
}
