package com.thanh.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LibraryManagement extends JFrame{
	
	public static Font font = new Font("Tahoma", Font.PLAIN, 18);
	private JPanel contentPane;
	
	public LibraryManagement() {
		super("Library Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(450, 300));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel libraryManagementLabel = new JLabel("Library Management");
		libraryManagementLabel.setFont(font);
		libraryManagementLabel.setForeground(Color.GRAY);
		
		JButton adminLoginButton = new JButton("Admin Login");
		adminLoginButton.setFont(font);
		adminLoginButton.setForeground(Color.BLACK);
		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminLogin(LibraryManagement.this);
			}
		});
		
		JButton librarianLoginButton = new JButton("Librarian Login");
		librarianLoginButton.setFont(font);
		librarianLoginButton.setForeground(Color.BLACK);
		librarianLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LibrarianLogin(LibraryManagement.this);
			}
		});
		
		adminLoginButton.setPreferredSize(new Dimension(150, 50));
		librarianLoginButton.setPreferredSize(new Dimension(150, 50));
		adminLoginButton.setFocusable(false);
		librarianLoginButton.setFocusable(false);
		
/*		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		
		contentPaneLayout.setHorizontalGroup(contentPaneLayout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(contentPaneLayout.createSequentialGroup()
						.addGroup(contentPaneLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(contentPaneLayout.createSequentialGroup()
										.addGap(64)
										.addComponent(libraryManagementLabel))
								.addGroup(contentPaneLayout.createSequentialGroup()
										.addGap(140)
										.addGroup(contentPaneLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(adminLoginButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(librarianLoginButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
						.addContainerGap(95, Short.MAX_VALUE))
				);
		
		contentPaneLayout.setVerticalGroup(contentPaneLayout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(contentPaneLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(libraryManagementLabel)
						.addGap(32)
						.addComponent(adminLoginButton, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(librarianLoginButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(70, Short.MAX_VALUE))
				);
		contentPane.setLayout(contentPaneLayout);*/
		
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.CENTER;
		
		contentPane.add(libraryManagementLabel, gc);
		
		gc.gridy++;
		gc.weighty = 0.05;
		gc.anchor = GridBagConstraints.PAGE_START;
		contentPane.add(adminLoginButton, gc);
		
		gc.gridy++;
		contentPane.add(librarianLoginButton, gc);
	}
	
}
