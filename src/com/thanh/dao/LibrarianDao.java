package com.thanh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.thanh.model.Librarian;

public class LibrarianDao {
	private static Connection connection = DBConnection.getConnection();
	
	public static boolean addLibrarian(Librarian librarian) {
		String sql = "insert into librarian (name, password, email, address, city, mobile) values "
				+ "(?, ?, ?, ?, ?, ?)";
		
		int rowsAffected = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, librarian.getName());
			statement.setString(2, librarian.getPassword());
			statement.setString(3, librarian.getEmail());
			statement.setString(4, librarian.getAddress());
			statement.setString(5, librarian.getCity());
			statement.setString(6, librarian.getMobile());
			
			rowsAffected = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAffected != 0;
	}
	
	public static ArrayList<Librarian> getAllLibrarians(){
		ArrayList<Librarian> librarians = new ArrayList<>();
		
		String sql = "select * from librarian";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				librarians.add(new Librarian(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return librarians;
	}
	
	public static boolean deleteLibrarianById(int id) {
		String sql = "delete from librarian where librarianId = " + id;
		int rowsAffected = 0;
		
		try {
			Statement statement = connection.createStatement();
			rowsAffected = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsAffected != 0;
	}
	
	public static boolean isValidLibrarian(String username, String password) {
		String sql = "select * from librarian where name like '" + username + "' and password like '" + password + "'";
		boolean isValid = false;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				isValid = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isValid;
	}
}
