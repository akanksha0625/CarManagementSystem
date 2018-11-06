package com.java.dbms.proj.controller;
import com.java.dbms.proj.views.Exit;
import java.sql.SQLException;

public class LogoutController {
	static Exit exit=new Exit();
	public static void Logout() throws SQLException {
		Exit.displaypage();
	}
}
