package com.thanh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.thanh.model.IssueBook;

public class IssueBookDao {
	private static Connection connection = DBConnection.getConnection();
	
	public static boolean issueBook(IssueBook issueBook) {
		String sql = "select issueBook(?, ?, ?, ?) as result";
		boolean flag = false;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, issueBook.getCallNo());
			statement.setString(2, issueBook.getStudentId());
			statement.setString(3, issueBook.getStudentName());
			statement.setString(4, issueBook.getStudentMobile());
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				flag = resultSet.getBoolean("result");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public static ArrayList<IssueBook> getAllIssuedBooks(){
		ArrayList<IssueBook> issueBooks = new ArrayList<>();
		
		String sql = "select * from issueBooks";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				issueBooks.add(new IssueBook(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return issueBooks;
	}
	
	public static boolean returnBook(String callNo, String studentId) {
		String sql = "select returnBook(?, ?) as result";
		boolean flag = false;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, callNo);
			statement.setString(2, studentId);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				flag = resultSet.getBoolean("result");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
}
