package com.thanh.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.thanh.model.Book;

public class BooksTableModel extends AbstractTableModel {
	private ArrayList<Book> books;
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private String[] columnNames = { "ID", "CallNo", "Name", "Author", "Publisher", "Quantity", "Issued",
			"Added Date Time" };

	public BooksTableModel(ArrayList<Book> books) {
		this.books = books;
	}

	@Override
	public int getRowCount() {
		return books.size();
	}

	@Override
	public int getColumnCount() {
		return 8;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Book book = books.get(rowIndex);

		if (book != null) {
			switch (columnIndex) {
			case 0:
				return book.getBookId();
			case 1:
				return book.getCallNo();
			case 2:
				return book.getName();
			case 3:
				return book.getAuthor();
			case 4:
				return book.getPublisher();
			case 5:
				return book.getQuantity();
			case 6:
				return book.getIssued();
			case 7:
				return dateFormat.format(book.getAddedDateTime());
			}
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
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
			return Integer.class;
		case 6:
			return Integer.class;
		case 7:
			return String.class;
		}
		return null;
	}

}
