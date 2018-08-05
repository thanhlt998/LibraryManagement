package com.thanh.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Book {
	private int bookId;
	private String callNo;
	private String name;
	private String author;
	private String publisher;
	private int quantity;
	private int issued;
	private Date addedDateTime;

	public Book(String callNo, String name, String author, String publisher, int quantity, int issued,
			Date addedDateTime) {
		super();
		this.callNo = callNo;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
		this.issued = issued;
		this.addedDateTime = addedDateTime;
	}
	
	public Book(ResultSet resultSet) throws SQLException {
		this.bookId = resultSet.getInt("bookId");
		this.callNo = resultSet.getString("callNo");
		this.name = resultSet.getString("name");
		this.author = resultSet.getString("author");
		this.publisher = resultSet.getString("publisher");
		this.quantity = resultSet.getInt("quantity");
		this.issued = resultSet.getInt("issued");
		this.addedDateTime = new Date(resultSet.getTimestamp("addedDateTime").getTime());
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getCallNo() {
		return callNo;
	}

	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIssued() {
		return issued;
	}

	public void setIssued(int issued) {
		this.issued = issued;
	}

	public Date getAddedDateTime() {
		return addedDateTime;
	}

	public void setAddedDateTime(Date addedDateTime) {
		this.addedDateTime = addedDateTime;
	}

}
