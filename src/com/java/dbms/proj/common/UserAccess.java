package com.java.dbms.proj.common;
import java.sql.*;

import java.util.Scanner;

/**
 * Class logs in a user from the command line.
 * Login is based on a successful 'userName' and
 * 'password' match in the database table 'LOGIN'.
 * 
 * Note: only 'INACTIVE' user can be logged in to the system.
 * 	     state will reflect 'ACTIVE' upon a successful login,
 * 		 and 'INACTIVE' upon a successful logout.
 */
public class UserAccess {
	public static String userName;
	private static String userPassword;
	public static String userRole;
	
	/*
	 * Logs a user into the system.
	 * @param statement
	 * 		Statement connection with the database.
	 * @param resultSet
	 * 		result variable for querying the database.
	 */
	
	
	public boolean userLogout( Statement statement, ResultSet resultSet ) {
		try {
			userRole = null;
			
			/* Update user 'STATE' */
			statement.executeUpdate( "UPDATE LOGIN " +
									"SET STATE = 'INACTIVE' " + 
									"WHERE username = '" + userName +
									"' AND password = '" + userPassword + "'");
				    				//"' AND state = 'ACTIVE';" );
		} catch (SQLException e) {
			System.out.println( "System Update Error : " + e );
			e.printStackTrace();
			return false;
		}
		
		System.out.println( "************************" );
		System.out.println( "  - Logout Successful -  " );
		System.out.println( "************************\n" );
		
		return true;
	}

	public void signUp() {
		// TODO Auto-generated method stub
		
}
}
