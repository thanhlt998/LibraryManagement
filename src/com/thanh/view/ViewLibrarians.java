package com.thanh.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.thanh.dao.LibrarianDao;
import com.thanh.model.Librarian;

public class ViewLibrarians extends JFrame{
	private JPanel contentPane;
	private JTable librariansTable;
	private LibrariansTableModel librariansTableModel;
	
	public ViewLibrarians(JFrame parent) {
		super("View Librarians");
		
		contentPane = new JPanel();
		librariansTableModel = new LibrariansTableModel(LibrarianDao.getAllLibrarians());
		librariansTable = new JTable(librariansTableModel);
		
		setPreferredSize(new Dimension(800, 600));
		pack();
		setLocationRelativeTo(null);
		
		createContentPaneLayout();
		parent.setVisible(false);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				ViewLibrarians.this.dispose();
				parent.setVisible(true);
			}
			
		});
	}
	
	private void createContentPaneLayout() {
		setContentPane(contentPane);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		contentPane.setLayout(new BorderLayout());
		
		librariansTable.setRowHeight(30);
		librariansTable.setAutoCreateColumnsFromModel(true);
		librariansTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		librariansTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(new JScrollPane(librariansTable), BorderLayout.CENTER);
	}
}
