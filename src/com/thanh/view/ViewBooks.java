package com.thanh.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.thanh.dao.BookDao;

public class ViewBooks extends JFrame{
	private JPanel contentPane;
	private JTable booksTable;
	private BooksTableModel booksTableModel;
	
	public ViewBooks(JFrame parent) {
		super("View Books");
		contentPane = new JPanel();
		booksTableModel = new BooksTableModel(BookDao.getAllBooks());
		booksTable = new JTable(booksTableModel);
		
		booksTable.setRowHeight(30);
		booksTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		contentPane.add(new JScrollPane(booksTable), BorderLayout.CENTER);
		
		setPreferredSize(new Dimension(1200, 600));
		pack();
		setLocationRelativeTo(null);
		parent.setVisible(false);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				parent.setVisible(true);
			}
			
		});
	}
}
