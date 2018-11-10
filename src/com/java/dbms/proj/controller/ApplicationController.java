package com.java.dbms.proj.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.java.dbms.proj.common.DBFacade;
import com.java.dbms.proj.entities.Address;
import com.java.dbms.proj.entities.Customer;
import com.java.dbms.proj.entities.Employee;
import com.java.dbms.proj.views.*;
 
public class ApplicationController {
	/* Response string and Scanner to process user option selections. */
	static String response = "";
	static Scanner input = new Scanner( System.in );
	static Customer customer = new Customer();
	static Employee employee = new Employee();
	
	static Statement statement=null;
	static ResultSet resultSet;
	
	/*Flow association with the homepage. --> entry point of application flow*/

	public static void home() throws ClassNotFoundException, SQLException  {
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

	private static void login() throws ClassNotFoundException, SQLException {
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
		}else if(role.equalsIgnoreCase("customer")){
			/*Redirect to the customer landing page*/
			customer();
		} else {
			home();
		}
	}
	
//---------------------------------------------------------------------------------------------Manager	
	/*Flow associated with the manager*/

	private static void manager()  throws ClassNotFoundException, SQLException{
		response = ManagerView.displayLanding( input );
		if( response.equals( "1" ) ) {
			/*Redirect to manager profile*/
			EmployeeProfileController.profileLanding(input);
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
	private static void mechanic() throws ClassNotFoundException, SQLException {
		EmployeeProfileController.profileLanding(input);
	} 
	
//---------------------------------------------------------------------------------------------Receptionist
	/*Handles the flow of the receptionist*/

	private static void receptionist() throws ClassNotFoundException, SQLException  {

		response = ReceptionistView.displayLanding(input);
		if(response.equals("1")) {
			/*Redirect to display employee profile page*/
			EmployeeProfileController.profileLanding(input);
			receptionist();
		} else if(response.equals("2")) {
			/*Redirect to display customer profile page.*/
			EmployeeSearchCustomerController.searchCustomer(input);
			receptionist();
		}else if(response.equals("3")){
			/*Redirect to add Register Car.*/
			ReceptionistRegisterCarController.registerCar(input);
			receptionist();
		}else if(response.equals("4")){
			/*Redirect to service history page*/
			ReceptionistServiceHistoryController.serviceHistory(input);
			receptionist();
		}else if(response.equals("5")){
			/*Redirect to display Schedule Service*/
			ReceptionistScheduleServiceController.scheduleServiceLanding(input);
			receptionist(); //go back
		}else if(response.equals("6")){
			/*Redirect to display Reschedule Service*/
			ReceptionistRescheduleServiceController.rescheduleService(input);
			receptionist();
		}else if( response.equals("7")){
			/*Redirect to display invoices page*/
			ReceptionistInvoiceController.invoice(input);
			receptionist();
		}else if(response.equals("8")){
			/*Redirect to the Task Update page*/
			ReceptionistTaskUpdateInventoryController.updateInventory(input);
			receptionist();//go back
		}else if(response.equals("9")){
			/*Redirect to the Task Record Deliveries*/
			ReceptionistTaskRecordDeliveriesController.recordDeliveries(input);
			receptionist();
		}else {
			Logout.logout();
			for(int i = 0; i < 1000000; i++) {} //simulate timer to return to homepage
			home();
		}	
	}

	private static void setCustomerDetails() throws SQLException {
		statement = DBFacade.getConnection().createStatement();
		
		resultSet = statement.executeQuery("SELECT CID, FIRSTNAME, LASTNAME, PHONE, EMAIL, SC_ID FROM CUSTOMER " 
		+ "WHERE username = '" + LoginController.userLogin.getUserName() + "'");
		
		if (resultSet.next()) {
			
			if (resultSet.getString("CID") != null && resultSet.getString("CID") !="" )
				customer.setCustomerId(resultSet.getString("CID"));
			
			if (resultSet.getString("FIRSTNAME") != null && resultSet.getString("FIRSTNAME") != "")
				customer.setFirstName(resultSet.getString("FIRSTNAME"));
			
			if (resultSet.getString("LASTNAME") != null && resultSet.getString("LASTNAME") != "")
				customer.setLastName(resultSet.getString("LASTNAME"));
			
			if (resultSet.getString("PHONE") != null && resultSet.getString("PHONE") != "")
				customer.setPhoneNumber(resultSet.getString("PHONE"));
			
			if (resultSet.getString("EMAIL") != null && resultSet.getString("EMAIL") != "")
				customer.setEmail(resultSet.getString("EMAIL"));
			
			if (resultSet.getString("SC_ID") != null && resultSet.getString("SC_ID") != "")
				customer.setServiceCenterId(resultSet.getString("SC_ID"));
			
			}

		Address customerAddress=new Address();
		resultSet = statement.executeQuery("SELECT * FROM CUSTOMER_ADDRESS" 
				+ "WHERE username = '" + LoginController.userLogin.getUserName() + "'");
		
		if(resultSet.next()) {
			if (resultSet.getString("ADD_ID") != null && resultSet.getString("ADD_ID") != "")
				customer.setServiceCenterId(resultSet.getString("ADD_ID"));
			
			if (resultSet.getString("Street") != null && resultSet.getString("Street") != "")
				customer.setServiceCenterId(resultSet.getString("Street"));
			
			if (resultSet.getString("City") != null && resultSet.getString("City") != "")
				customer.setServiceCenterId(resultSet.getString("City"));
			
			if (resultSet.getString("STATE") != null && resultSet.getString("STATE") != "")
				customer.setServiceCenterId(resultSet.getString("STATE"));
			
			if (resultSet.getString("ZIP") != null && resultSet.getString("ZIP") != "")
				customer.setServiceCenterId(resultSet.getString("ZIP"));
		}
		
		customer.setAddress(customerAddress);
	}
	
	//---------------------------------------------------------------------------------------------Customer	
	/*Handles the flow of the customer*/
	private static void customer() throws ClassNotFoundException, SQLException {

		
		setCustomerDetails();

		response = CustomerView.displayLanding(input);
		if(response.equals("1")) {
			/*Redirect to display customer profile page*/
			CustomerProfileController.profileLanding(input);
			customer();
		} else if(response.equals("2")) {
			/*Redirect to display register car profile page.*/
			CustomerRegisterCarController.registerCar(input);
			customer();
		}else if(response.equals("3")){
			/*Redirect to Service page.*/
			CustomerServiceController.serviceLanding(input);
			customer();
		}else if(response.equals("4")){
			/*Redirect to service invoice page*/
			CustomerInvoiceController.invoice(input);
			customer();
		}else {
			Logout.logout();
			for(int i = 0; i < 1000000; i++) {} //simulate timer to return to homepage
			home();
		}	
	}

}
