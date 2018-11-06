package com.java.dbms.proj.controller;

import java.util.Scanner;

import com.java.dbms.proj.views.EmployeeView;

public class EmployeeUpdateProfileController {
	
	public static void updateProfile(Scanner input) {
		String response = "";
		do {
			/*Redirect to the employee update profile page*/
			response = EmployeeView.displayProfileUpdate(input);
			//TODO call controller with (response) to determine what to update
			System.out.println( "CALL CONTROLLER(response) TO UPDATE PROFILE DETAIL" );
		}while( !response.equals( "7" ) );
	}

}
