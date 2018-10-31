package com.java.dbms.proj.common;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFacade {
	
	// Specify JDBC URL
	private static final String JDBC_URL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
	    
	// Specify database login details (you must have an Oracle account setup already. Contact csc_help@ncsu.edu if you need assistance)
	private static String connectionUserName = "amohan7"; // Provide your unity ID
    private static String connectionPassword = "200261198"; // Provide your password
    private static Connection connection;
    			
    	/* Try and connect to the database. */
    	
    	static {

    		try {
    			createConnection();
    		            
    		} catch (SQLException e) {
    			e.printStackTrace();
    			System.out.println( "Connection to Database Unsuccessful : " + e.getMessage());
    			
    		}
    		catch (ClassNotFoundException e) {
    			e.printStackTrace();
    			System.out.println( "Connection to Database Unsuccessful : " + e.getMessage());
    			
    		}
    		catch (Exception e) {
    			e.printStackTrace();
    			System.out.println( "Connection to Database Unsuccessful : " + e.getMessage());
    			
    		}

    	}
    


public static Connection createConnection() throws SQLException, ClassNotFoundException {
	Class.forName( "oracle.jdbc.driver.OracleDriver" );
    return connection = DriverManager.getConnection( JDBC_URL, connectionUserName, connectionPassword );
}

public static void closeConnection() throws SQLException{
	connection.close();
}

public static Connection getConnection() {
	return connection;
}


}

