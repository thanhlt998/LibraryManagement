package com.thanh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.thanh.model.Book;

public class BookDao {
	private static Connection connection = DBConnection.getConnection();
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static boolean addBooks(Book book) {
		String sql = "insert into books(callNo, name, author, publisher, quantity, issued, addedDateTime)"
				+ " values (?, ?, ?, ?, ?, 0, ?)";
		int rowsAffected = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, book.getCallNo());
			statement.setString(2, book.getName());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getPublisher());
			statement.setInt(5, book.getQuantity());
			statement.setString(6, dateFormat.format(book.getAddedDateTime()));

			rowsAffected = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAffected != 0;
	}

	public static ArrayList<Book> getAllBooks() {
		ArrayList<Book> books = new ArrayList<>();
		String sql = "select * from books";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				books.add(new Book(resultSet));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
}
