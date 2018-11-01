package com.java.dbms.proj.controller;
import java.sql.SQLException;

import com.java.dbms.proj.views.*;
 
public class SampleFlow {
	static String response = "";
	public static void home() {
		response = Home.displayHome();
		if(response.equals("1")) {
			login();
		}else if(response.equals("2")) {
			signUp();
		}else {
			try {
				Exit.displaypage();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void signUp() {
		response = CustomerView.displaySignUp();
		if(response.equals("1")) {
			//TODO call the signUp controller;
		}
		// If other option send home.
		// After user signs up, send home.
		home();
	}
	
	private static void login() {
		response = Login.displayLogin();
		if(response.equals("1")) {
			//TODO call sign-in controller
			//TODO sign-in controller should return the role of the user to determine next display page
			//String role = signInController()
			//if( role.equalsIgnoreCase("manager"){
			//		manager();
			//}else if(role.equalsIgnoreCase("receptionist"){
			//		receptionist();
			//}else if(role.equalsIgnoreCase("mechanic"){
			//		mechanic();
			//}else{
			//		customer();
			//}
		}else {
			home();
		}
		// TODO Auto-generated method stub
	}
	
	private static void manager() {
		ManagerView.displayLanding();
	}
	
	private static void receptionist() {
		ReceptionistView.displayLanding();
	}
	
	private static void mechanic() {
		EmployeeView.displayPage();
	}
	
	private static void customer() {
		CustomerView.displayLanding();
	}
}
