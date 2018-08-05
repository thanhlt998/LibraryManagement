package com.thanh.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.thanh.model.IssueBook;

public class IssuedBooksTableModel extends AbstractTableModel {
	private ArrayList<IssueBook> issueBooks;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private String[] columnNames = { "ID", "CallNo", "Student ID", "Student Name", "Student Mobile", "Issued Date Time",
			"Return Status" };

	public IssuedBooksTableModel(ArrayList<IssueBook> issueBooks) {
		this.issueBooks = issueBooks;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		return issueBooks.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		IssueBook issueBook = issueBooks.get(rowIndex);
		if (issueBook != null) {
			switch (columnIndex) {
			case 0:
				return issueBook.getIssuedBookId();
			case 1:
				return issueBook.getCallNo();
			case 2:
				return issueBook.getStudentId();
			case 3:
				return issueBook.getStudentName();
			case 4:
				return issueBook.getStudentMobile();
			case 5:
				return dateFormat.format(issueBook.getIssuedDateTime());
			case 6:
				return issueBook.getReturnStatus();
			}
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		case 6:
			return String.class;
		}
		return null;
	}

}
