package com.thanh.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminSection extends JFrame {
	JPanel contentPane;
	JLabel adminSectionLabel;
	JButton addLibrarianButton;
	JButton viewLibrarianButton;
	JButton deleteLibrarianButton;
	JButton logoutButton;
	private static Font font = new Font("Tahoma", Font.PLAIN, 18);

	public AdminSection(JFrame parent) {
		super("Admin Section");
		
		parent.setVisible(false);
		setPreferredSize(new Dimension(400, 500));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		contentPane = new JPanel(new GridBagLayout());
		adminSectionLabel = new JLabel("Admin Section");
		addLibrarianButton = new JButton("Add Librarian");
		viewLibrarianButton = new JButton("View Librarian");
		deleteLibrarianButton = new JButton("Delete Librarian");
		logoutButton = new JButton("Logout");

		adminSectionLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		addLibrarianButton.setFont(font);
		viewLibrarianButton.setFont(font);
		deleteLibrarianButton.setFont(font);
		logoutButton.setFont(font);
		adminSectionLabel.setForeground(Color.GRAY);

		addLibrarianButton.setFocusable(false);
		viewLibrarianButton.setFocusable(false);
		deleteLibrarianButton.setFocusable(false);
		logoutButton.setFocusable(false);

		Dimension size = deleteLibrarianButton.getPreferredSize();
		size.setSize(size.getWidth(), 50);

		addLibrarianButton.setPreferredSize(size);
		viewLibrarianButton.setPreferredSize(size);
		deleteLibrarianButton.setPreferredSize(size);
		logoutButton.setPreferredSize(size);

		adminSectionLabel.setForeground(Color.gray);

		setLayout();
		setListeners(parent);
	}

	public void setLayout() {
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.weighty = 0.1;

		contentPane.add(adminSectionLabel, gc);

		gc.gridy++;
		contentPane.add(addLibrarianButton, gc);

		gc.gridy++;
		contentPane.add(viewLibrarianButton, gc);

		gc.gridy++;
		contentPane.add(deleteLibrarianButton, gc);

		gc.gridy++;
		contentPane.add(logoutButton, gc);
	}

	public void setListeners(JFrame parent) {
		addLibrarianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLibrarianForm addLibrarianForm = new AddLibrarianForm(AdminSection.this);
			}
		});

		viewLibrarianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLibrarians viewLibrarians = new ViewLibrarians(AdminSection.this);
			}
		});
		
		deleteLibrarianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteLibrarianForm deleteLibrarianForm = new DeleteLibrarianForm(AdminSection.this);
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
