package com.thanh.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

import javafx.scene.input.Mnemonic;

public class AdminLogin extends JFrame {
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel adminLoginLabel;
	private JButton adminLoginButton;
	private static Font font = new Font("Tahoma", Font.PLAIN, 18);

	public AdminLogin(JFrame parent) {
		super("Admin Login");

		contentPane = new JPanel();
		usernameField = new JTextField(10);
		passwordField = new JPasswordField(10);
		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		adminLoginLabel = new JLabel("Admin Login");
		adminLoginButton = new JButton("Login");
		setContentPane(contentPane);

		usernameField.setFont(font);
		passwordField.setFont(font);
		usernameLabel.setFont(font);
		passwordLabel.setFont(font);
		adminLoginButton.setFont(font);
		adminLoginLabel.setFont(new Font("Tahoma", Font.BOLD, 25));

		adminLoginButton.setFocusable(false);
		adminLoginButton.setPreferredSize(new Dimension(80, 40));

		createContentPaneLayout();
		setPreferredSize(new Dimension(450, 300));
		pack();
		setLocationRelativeTo(null);
		parent.setVisible(false);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				parent.setVisible(true);
				dispose();
			}
		});

		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				
				if (username.equals("admin") && password.equals("admin123")) {
					AdminSection adminSection = new AdminSection(AdminLogin.this);
				} else {
					JOptionPane.showMessageDialog(AdminLogin.this,
							"Username or password is not correct, please try again.", "Login fail",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		adminLoginButton.setMnemonic(KeyEvent.VK_ENTER);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				usernameField.setText("");
				passwordField.setText("");
				super.windowActivated(e);
			}
		});
	}

	public void createContentPaneLayout() {
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.1;
		gc.weighty = 0.7;
		gc.anchor = GridBagConstraints.CENTER;

		gc.gridwidth = 2;
		contentPane.add(adminLoginLabel, gc);

		gc.gridwidth = 1;
		gc.gridy++;
		gc.weighty = 0.6;
		gc.insets = new Insets(0, 30, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(usernameLabel, gc);

		gc.gridx++;
		contentPane.add(usernameField, gc);

		gc.gridy++;
		gc.gridx = 0;
		contentPane.add(passwordLabel, gc);

		gc.gridx++;
		contentPane.add(passwordField, gc);

		gc.gridwidth = 2;
		gc.gridy++;
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(adminLoginButton, gc);
	}
}
