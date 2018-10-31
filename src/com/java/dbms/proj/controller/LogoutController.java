package com.java.dbms.proj.controller;
import com.java.dbms.proj.views.Exit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogoutController {
	static Exit exit=new Exit();
	public static void Logout() throws SQLException {
		exit.displaypage();
	}
}
