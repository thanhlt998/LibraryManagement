package com.thanh.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.thanh.dao.LibrarianDao;

public class LibrarianLogin extends JFrame {
	private JPanel contentPane;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private static Font font = new Font("Tahoma", Font.PLAIN, 18);

	public LibrarianLogin(JFrame parent) {
		contentPane = new JPanel();
		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		usernameField = new JTextField(10);
		passwordField = new JPasswordField(10);
		loginButton = new JButton("Login");

		usernameLabel.setFont(font);
		usernameField.setFont(font);
		passwordLabel.setFont(font);
		passwordField.setFont(font);
		loginButton.setFont(font);

		setPreferredSize(new Dimension(350, 250));
		pack();
		setLocationRelativeTo(null);
		createContentPaneLayout();
		parent.setVisible(false);
		setVisible(true);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());

				boolean isValid = LibrarianDao.isValidLibrarian(username, password);

				if (isValid) {
					LibrarianSection librarianSection = new LibrarianSection(LibrarianLogin.this);
				} else {
					JOptionPane.showMessageDialog(parent, "Username or password is not correct, please try again!",
							"Cannot login", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				parent.setVisible(true);
				super.windowClosing(e);
			}

			@Override
			public void windowActivated(WindowEvent e) {
				usernameField.setText("");
				passwordField.setText("");
				super.windowActivated(e);
			}
			
			
		});
	}

	private void createContentPaneLayout() {
		setContentPane(contentPane);

		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 10, 0, 0);
		gc.weighty = 0.5;

		contentPane.add(usernameLabel, gc);
		gc.gridx++;
		contentPane.add(usernameField, gc);

		gc.gridx = 0;
		gc.gridy++;
		gc.weighty = 0.6;
		contentPane.add(passwordLabel, gc);

		gc.gridx++;
		contentPane.add(passwordField, gc);

		gc.gridx = 0;
		gc.gridy++;
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(loginButton, gc);
	}
}
