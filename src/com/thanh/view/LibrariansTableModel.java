package com.thanh.view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.thanh.model.Librarian;

public class LibrariansTableModel extends AbstractTableModel {

	private ArrayList<Librarian> librarians;
	private String[] columnsName = { "ID", "Name", "Password", "Email", "Address", "City", "Contact" };

	public LibrariansTableModel(ArrayList<Librarian> librarians) {
		this.librarians = librarians;
	}

	@Override
	public String getColumnName(int column) {
		return columnsName[column];
	}

	@Override
	public int getRowCount() {
		return librarians.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Librarian librarian = librarians.get(rowIndex);

		if (librarian != null) {
			switch (columnIndex) {
			case 0:
				return librarian.getLibrarianId();
			case 1:
				return librarian.getName();
			case 2:
				return librarian.getPassword();
			case 3:
				return librarian.getEmail();
			case 4:
				return librarian.getAddress();
			case 5:
				return librarian.getCity();
			case 6:
				return librarian.getMobile();
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
