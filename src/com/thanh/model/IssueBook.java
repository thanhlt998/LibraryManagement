package com.thanh.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class IssueBook {
	private int issuedBookId;
	private String callNo;
	private String studentId;
	private String studentName;
	private String studentMobile;
	private Date issuedDateTime;
	private String returnStatus;

	public IssueBook(String callNo, String studentId, String studentName, String studentMobile, Date issuedDateTime,
			String returnStatus) {
		super();
		this.callNo = callNo;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMobile = studentMobile;
		this.issuedDateTime = issuedDateTime;
		this.returnStatus = returnStatus;
	}
	
	public IssueBook(ResultSet resultSet) throws SQLException {
		this.issuedBookId = resultSet.getInt("issuedBookId");
		this.callNo = resultSet.getString("callNo");
		this.studentId = resultSet.getString("studentId");
		this.studentName = resultSet.getString("studentName");
		this.studentMobile = resultSet.getString("studentMobile");
		this.issuedDateTime = new Date(resultSet.getTimestamp("issuedDateTime").getTime());
		this.returnStatus = resultSet.getString("returnStatus");
	}
	
	public IssueBook(String callNo, String studentId, String studentName, String studentMobile) {
		this.callNo = callNo;
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMobile = studentMobile;
	}

	public int getIssuedBookId() {
		return issuedBookId;
	}

	public void setIssuedBookId(int issuedBookId) {
		this.issuedBookId = issuedBookId;
	}

	public String getCallNo() {
		return callNo;
	}

	public void setCallNo(String callNo) {
		this.callNo = callNo;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Date getIssuedDateTime() {
		return issuedDateTime;
	}

	public void setIssuedDateTime(Date issuedDateTime) {
		this.issuedDateTime = issuedDateTime;
	}

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

}
