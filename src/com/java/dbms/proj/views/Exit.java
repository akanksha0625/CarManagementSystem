package com.java.dbms.proj.views;
import java.sql.SQLException;

import com.java.dbms.proj.common.DBFacade;

public class Exit {
	 
    public static void goodbye() throws SQLException {
    	System.out.println("*********************************************************************************************************************************************************************");
    	System.out.println("|                                                                                                                                                                   |");
    	System.out.println("|88888888888 888                        888                     .d888                       .d8888b.  888                                 d8b                       |");
    	System.out.println("|    888     888                        888                    d88P\"                       d88P  Y88b 888                                 Y8P                       |");
    	System.out.println("|    888     888                        888                    888                         888    888 888                                                           |");
    	System.out.println("|    888     88888b.   8888b.  88888b.  888  888 .d8888b       888888 .d88b.  888d888      888        88888b.   .d88b.   .d88b.  .d8888b  888 88888b.   .d88b.      |");
    	System.out.println("|    888     888 \"88b     \"88b 888 \"88b 888 .88P 88K           888   d88\"\"88b 888P\"        888        888 \"88b d88\"\"88b d88\"\"88b 88K      888 888 \"88b d88P\"88b     |");
    	System.out.println("|    888     888  888 .d888888 888  888 888888K  \"Y8888b.      888   888  888 888          888    888 888  888 888  888 888  888 \"Y8888b. 888 888  888 888  888     |");
    	System.out.println("|    888     888  888 888  888 888  888 888 \"88b      X88      888   Y88..88P 888          Y88b  d88P 888  888 Y88..88P Y88..88P      X88 888 888  888 Y88b 888     |");
    	System.out.println("|    888     888  888 \"Y888888 888  888 888  888  88888P'      888    \"Y88P\"  888           \"Y8888P\"  888  888  \"Y88P\"   \"Y88P\"   88888P' 888 888  888  \"Y88888     |");
    	System.out.println("|                                                                                                                                                           888     |");
    	System.out.println("|                                                                                                                                                      Y8b d88P     |");
    	System.out.println("|                                                                                                                                                       \"Y88P\"      |");
    	System.out.println("|                                                       d8888  .d8888b.  888b     d888 8888888888                                                                   |");
    	System.out.println("|                                                      d88888 d88P  Y88b 8888b   d8888 888                                                                          |");
    	System.out.println("|                                                     d88P888 888    888 88888b.d88888 888                                                                          |");
    	System.out.println("|                                                    d88P 888 888        888Y88888P888 8888888                                                                      |");
    	System.out.println("|                                                   d88P  888 888        888 Y888P 888 888                                                                          |");
    	System.out.println("|                                                  d88P   888 888    888 888  Y8P  888 888                                                                          |");
    	System.out.println("|                                                 d8888888888 Y88b  d88P 888   \"   888 888                                                                          |");
    	System.out.println("|                                                d88P     888  \"Y8888P\"  888       888 8888888888                                                                   |");
    	System.out.println("*********************************************************************************************************************************************************************\n");
        DBFacade.closeConnection();
    }
    
}
