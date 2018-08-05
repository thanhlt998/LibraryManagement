package com.thanh.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LibrarianSection extends JFrame{
	private JPanel contentPane;
	private JLabel librarianSectionLabel;
	private JButton addBooksButton;
	private JButton viewBooksButton;
	private JButton issueBookButton;
	private JButton viewIssuedBooksButton;
	private JButton returnBookButton;
	private JButton logoutButton;
	
	private static Font font = new Font("Tahoma", Font.PLAIN, 18);
	
	public LibrarianSection(JFrame parent) {
		contentPane = new JPanel();
		librarianSectionLabel = new JLabel("Librarian Section");
		addBooksButton = new JButton("Add Books");
		viewBooksButton = new JButton("View Books");
		issueBookButton = new JButton("Issue Books");
		viewIssuedBooksButton = new JButton("View Issued Books");
		returnBookButton = new JButton("Return Book");
		logoutButton = new JButton("Logout");
		
		librarianSectionLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		addBooksButton.setFont(font);
		viewBooksButton.setFont(font);
		issueBookButton.setFont(font);
		viewIssuedBooksButton.setFont(font);
		returnBookButton.setFont(font);
		logoutButton.setFont(font);
		
		librarianSectionLabel.setForeground(Color.GRAY);
		
		Dimension size = viewIssuedBooksButton.getPreferredSize();
		size.height = 50;
		
		addBooksButton.setPreferredSize(size);
		viewBooksButton.setPreferredSize(size);
		issueBookButton.setPreferredSize(size);
		viewIssuedBooksButton.setPreferredSize(size);
		returnBookButton.setPreferredSize(size);
		logoutButton.setPreferredSize(size);
		
		addBooksButton.setFocusable(false);
		viewBooksButton.setFocusable(false);
		issueBookButton.setFocusable(false);
		viewIssuedBooksButton.setFocusable(false);
		returnBookButton.setFocusable(false);
		logoutButton.setFocusable(false);
		
		setPreferredSize(new Dimension(400, 600));
		pack();
		setLocationRelativeTo(null);
		
		createContentPaneLayout();
		
		parent.setVisible(false);
		setVisible(true);
		
		setListeners(parent);
	}
	
	private void createContentPaneLayout() {
		setContentPane(contentPane);
		
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.PAGE_START;
		
		contentPane.add(librarianSectionLabel, gc);
		
		gc.gridy++;
		gc.weighty = 0.4;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(addBooksButton, gc);
		
		gc.gridy++;
		contentPane.add(viewBooksButton, gc);
		
		gc.gridy++;
		contentPane.add(issueBookButton, gc);
		
		gc.gridy++;
		contentPane.add(viewIssuedBooksButton, gc);
		
		gc.gridy++;
		contentPane.add(returnBookButton, gc);
		
		gc.gridy++;
		gc.weighty = 0.6;
		contentPane.add(logoutButton, gc);
		
	}
	
	private void setListeners(JFrame parent) {
		addBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBooksForm addBooksForm = new AddBooksForm(LibrarianSection.this);
			}
		});
		
		viewBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooks viewBooks = new ViewBooks(LibrarianSection.this);
			}
		});
		
		issueBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBookForm issueBookForm = new IssueBookForm(LibrarianSection.this);
			}
		});
		
		viewIssuedBooksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssuedBooks viewIssuedBooks = new ViewIssuedBooks(LibrarianSection.this);
			}
		});
		
		returnBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBookForm returnBookForm = new ReturnBookForm(LibrarianSection.this);
			}
		});
		
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				parent.setVisible(true);
			}
		});
	}
	
}
