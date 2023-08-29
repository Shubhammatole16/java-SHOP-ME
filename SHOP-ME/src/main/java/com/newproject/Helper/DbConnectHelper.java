package com.newproject.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectHelper {
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/shopme";
		String name = "root";
		String pass = "Shubham@1631";
		return DriverManager.getConnection(url, name, pass);
	}
}
