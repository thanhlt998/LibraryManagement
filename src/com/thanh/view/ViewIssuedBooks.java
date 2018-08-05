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

import com.thanh.dao.IssueBookDao;

public class ViewIssuedBooks extends JFrame{
	private JPanel contentPane;
	private JTable viewIssuedBookTable;
	private IssuedBooksTableModel issuedBooksTableModel;
	
	public ViewIssuedBooks(JFrame parent) {
		contentPane = new JPanel();
		issuedBooksTableModel = new IssuedBooksTableModel(IssueBookDao.getAllIssuedBooks());
		viewIssuedBookTable = new JTable(issuedBooksTableModel);
		
		viewIssuedBookTable.setRowHeight(30);
		viewIssuedBookTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(new JScrollPane(viewIssuedBookTable), BorderLayout.CENTER);
		
		setContentPane(contentPane);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				parent.setVisible(true);
				super.windowClosing(e);
			}
		});
		
		setPreferredSize(new Dimension(1200, 600));
		pack();
		setLocationRelativeTo(null);
		parent.setVisible(false);
		setVisible(true);
	}
}
