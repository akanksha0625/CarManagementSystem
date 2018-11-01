package com.java.dbms.proj.main;
import java.sql.*;
import java.util.Scanner;

import com.java.dbms.proj.common.UserAccess;
import com.java.dbms.proj.controller.ApplicationController;
import com.java.dbms.proj.views.*;
public class Main {
/*
 * CSC 540 - Database Project 1
 * 
 * Team Name 	:	VASC
 * Team Members : 
 * 					Vishnu Radhakrishnan Nair (vradhak)
 * 					Akanksha Mohan (amohan7)
 * 					Srinivas Nethra Padala (spadala)
 * 					Carmen Aiken Bentley (cnaiken)
 * 
 */		
	/*
	 * Main entry point of execution for project.
	 * 
	 * @param args
	 * 		Commandline arguments
	 * @return status of exit.
	 */
    public static void main( String[] args ) {
//		/* Print welcome screen for the user. */
//    	Home.displaypage();
//       	try {
//       	ApplicationController applicationController=new ApplicationController();
//	       	 	
//     	} catch( Exception e ) {
//			/* Error occurred while creating a connection with the database. */
//     		System.out.println( "Sorry for the inconvenience. Our System is out of service. Please try after some time." + e.getMessage() );
//		}
    	
    	com.java.dbms.proj.controller.SampleFlow.home();
	}
}



