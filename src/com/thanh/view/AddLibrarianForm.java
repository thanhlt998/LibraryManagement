package com.thanh.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.thanh.dao.LibrarianDao;
import com.thanh.model.Librarian;

public class AddLibrarianForm extends JFrame {
	private JPanel contentPane;
	private JLabel addLibrarianFormLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel emailLabel;
	private JLabel addressLabel;
	private JLabel cityLabel;
	private JLabel mobileLabel;

	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField mobileField;

	private JButton addButton;
	private JButton backButton;

	private static Font font = new Font("Tahoma", Font.PLAIN, 18);

	public AddLibrarianForm(JFrame parent) {
		super("Add Librarian Form");

		contentPane = new JPanel();
		addLibrarianFormLabel = new JLabel("Add Librarian Form");
		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		emailLabel = new JLabel("Email");
		addressLabel = new JLabel("Address");
		cityLabel = new JLabel("City");
		mobileLabel = new JLabel("Mobile");

		usernameField = new JTextField(10);
		passwordField = new JPasswordField(10);
		emailField = new JTextField(10);
		addressField = new JTextField(10);
		cityField = new JTextField(10);
		mobileField = new JTextField(10);

		addButton = new JButton("Add");
		backButton = new JButton("Back");

		addLibrarianFormLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		usernameLabel.setFont(font);
		passwordLabel.setFont(font);
		emailLabel.setFont(font);
		addressLabel.setFont(font);
		cityLabel.setFont(font);
		mobileLabel.setFont(font);

		usernameField.setFont(font);
		passwordField.setFont(font);
		emailField.setFont(font);
		addressField.setFont(font);
		cityField.setFont(font);
		mobileField.setFont(font);

		addButton.setFont(font);
		backButton.setFont(font);
		
		addButton.setFocusable(false);
		backButton.setFocusable(false);

		createContentPaneLayout();
		setPreferredSize(new Dimension(450, 450));
		setContentPane(contentPane);
		pack();
		setLocationRelativeTo(null);
		parent.setVisible(false);
		setVisible(true);

		setListeners(parent);
	}

	private void createContentPaneLayout() {
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		// First Row

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.7;
		gc.weighty = 0.7;

		gc.anchor = GridBagConstraints.PAGE_START;
		gc.gridwidth = 2;
		contentPane.add(addLibrarianFormLabel, gc);

		// Next Row
		gc.insets = new Insets(0, 30, 0, 0);
		gc.gridy++;
		gc.weighty = 0.6;
		gc.gridwidth = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(usernameLabel, gc);

		gc.gridx++;
		contentPane.add(usernameField, gc);

		// Next Row
		gc.gridy++;
		gc.gridx = 0;
		contentPane.add(passwordLabel, gc);

		gc.gridx++;
		contentPane.add(passwordField, gc);

		// Next Row
		gc.gridy++;
		gc.gridx = 0;
		contentPane.add(emailLabel, gc);

		gc.gridx++;
		contentPane.add(emailField, gc);

		// Next Row
		gc.gridy++;
		gc.gridx = 0;
		contentPane.add(addressLabel, gc);

		gc.gridx++;
		contentPane.add(addressField, gc);

		// Next Row
		gc.gridy++;
		gc.gridx = 0;
		contentPane.add(cityLabel, gc);

		gc.gridx++;
		contentPane.add(cityField, gc);

		// Next Row
		gc.gridy++;
		gc.gridx = 0;
		gc.weighty = 0.8;
		contentPane.add(mobileLabel, gc);

		gc.gridx++;
		contentPane.add(mobileField, gc);

		// Next Row
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(addButton, gc);

		gc.gridx++;
		contentPane.add(backButton, gc);

	}

	private void setListeners(JFrame parent) {
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pattern emailPattern = Pattern.compile(".+@.+\\.com");

				String email = emailField.getText();
				Matcher matcher = emailPattern.matcher(email);
				if (matcher.matches()) {
					String username = usernameField.getText();
					String password = new String(passwordField.getPassword());
					String address = addressField.getText();
					String city = cityField.getText();
					String mobile = mobileField.getText();

					Librarian librarian = new Librarian(username, password, email, address, city, mobile);

					boolean flag = LibrarianDao.addLibrarian(librarian);

					if (flag) {
						usernameField.setText("");
						passwordField.setText("");
						emailField.setText("");
						addressField.setText("");
						cityField.setText("");
						mobileField.setText("");
						
						JOptionPane.showMessageDialog(AddLibrarianForm.this, "Add a librarian successfully!",
								"Successfully", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(AddLibrarianForm.this, "Failed to add a librarian. Please try again!", "Failed",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(AddLibrarianForm.this, "Email formatter is invalid, please input again!", "Input invalid",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				parent.setVisible(true);
			}
		});
	}
}
