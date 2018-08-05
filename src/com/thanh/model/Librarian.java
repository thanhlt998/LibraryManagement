package com.thanh.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Librarian {
	private int librarianId;
	private String name;
	private String password;
	private String email;
	private String address;
	private String city;
	private String mobile;

	public Librarian(String name, String password, String email, String address, String city, String mobile) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.city = city;
		this.mobile = mobile;
	}
	
	public Librarian(ResultSet resultSet) throws SQLException {
		this.librarianId = resultSet.getInt("librarianId");
		this.name = resultSet.getString("name");
		this.password = resultSet.getString("password");
		this.email = resultSet.getString("email");
		this.address = resultSet.getString("address");
		this.city = resultSet.getString("city");
		this.mobile = resultSet.getString("mobile");
	}

	public int getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(int librarianId) {
		this.librarianId = librarianId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
