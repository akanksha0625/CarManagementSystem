package com.java.dbms.proj.main;
import java.sql.SQLException;
import java.text.ParseException;

import com.java.dbms.proj.common.*;
import com.java.dbms.proj.controller.*;
import com.java.dbms.proj.entities.DailyTimeSlot;
import com.java.dbms.proj.entities.TimeSlot;
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

    public static void main( String[] args ) throws SQLException, ClassNotFoundException, ParseException {
    	DBFacade.createConnection();
    	ApplicationController.home();
    
	}
    

}



