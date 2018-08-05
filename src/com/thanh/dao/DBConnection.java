package com.thanh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection = null;
	
	private static void connectToDatabase(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Registered Driver successfully!!");
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find the Driver.");
		};
		
		String url = "jdbc:mysql://localhost:3306/";
		String DBName = "library";
		String user = "root";
		String password = "tuanthanh98";
		
		try {
			connection = DriverManager.getConnection(url + DBName, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			connectToDatabase();
		}
		return connection;
	}
	
	public static void closeConnection() {
		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
