package com.thanh.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thanh.dao.IssueBookDao;

public class ReturnBookForm extends JFrame {
	private JPanel contentPane;
	private JLabel returnBookFormLabel;
	private JLabel callNoLabel;
	private JTextField callNoField;
	private JLabel studentIdLabel;
	private JTextField studentIdField;
	private JButton returnButton;
	private JButton backButton;

	private static Font font = new Font("Tahoma", Font.PLAIN, 20);

	public ReturnBookForm(JFrame parent) {
		contentPane = new JPanel();
		returnBookFormLabel = new JLabel("Return Book Form");
		callNoLabel = new JLabel("CallNo");
		callNoField = new JTextField(10);
		studentIdLabel = new JLabel("Student Id");
		studentIdField = new JTextField(10);
		returnButton = new JButton("Return");
		backButton = new JButton("Back");

		returnBookFormLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		callNoLabel.setFont(font);
		callNoField.setFont(font);
		studentIdLabel.setFont(font);
		studentIdField.setFont(font);
		returnButton.setFont(font);
		backButton.setFont(font);
		
		returnBookFormLabel.setForeground(Color.GRAY);
		createContentPaneLayout();
		setPreferredSize(new Dimension(400, 300));
		pack();
		setLocationRelativeTo(null);
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
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.CENTER;

		// First Row
		contentPane.add(returnBookFormLabel, gc);

		// Next row
		gc.weighty = 0.4;
		gc.gridy++;
		gc.gridwidth = 1;
		gc.insets = new Insets(0, 20, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(callNoLabel, gc);

		gc.gridx++;
		gc.insets.left = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(callNoField, gc);

		// next row
		gc.gridx = 0;
		gc.gridy++;
		gc.insets.left = 20;
		gc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(studentIdLabel, gc);

		gc.gridx++;
		gc.insets.left = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(studentIdField, gc);

		// next row
		gc.gridx = 0;
		gc.gridy++;
		contentPane.add(returnButton, gc);

		gc.gridx++;
		contentPane.add(backButton, gc);
	}

	private void setListeners(JFrame parent) {
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String callNo = callNoField.getText();
				String studentId = studentIdField.getText();

				if (callNo.isEmpty() || studentId.isEmpty()) {
					JOptionPane.showMessageDialog(ReturnBookForm.this, "Please don't leave blank fields", "Blank Field",
							JOptionPane.WARNING_MESSAGE);
				} else {
					boolean flag = IssueBookDao.returnBook(callNo, studentId);
					if (flag) {
						JOptionPane.showMessageDialog(ReturnBookForm.this, "Returned a book successfully",
								"Return success", JOptionPane.OK_OPTION);
						callNoField.setText("");
						studentIdField.setText("");
					} else {
						JOptionPane.showMessageDialog(ReturnBookForm.this, "Failed to return a book", "Return Failure",
								JOptionPane.ERROR_MESSAGE);
					}
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
