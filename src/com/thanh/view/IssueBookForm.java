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
import com.thanh.model.IssueBook;

public class IssueBookForm extends JFrame {
	private JPanel contentPane;
	private JLabel issueBookFormLabel;
	private JLabel callNoLabel;
	private JTextField callNoField;
	private JLabel studentIdLabel;
	private JTextField studentIdField;
	private JLabel studentNameLabel;
	private JTextField studentNameField;
	private JLabel studentMobileLabel;
	private JTextField studentMobileField;
	private JButton issueBookButton;
	private JButton backButton;

	private static Font font = new Font("Tahoma", Font.PLAIN, 18);

	public IssueBookForm(JFrame parent) {
		super("Issue Book Form");
		contentPane = new JPanel();
		issueBookFormLabel = new JLabel("Issue Book Form");
		callNoLabel = new JLabel("CallNo");
		callNoField = new JTextField(15);
		studentIdLabel = new JLabel("Student ID");
		studentIdField = new JTextField(15);
		studentNameLabel = new JLabel("Student Name");
		studentNameField = new JTextField(15);
		studentMobileLabel = new JLabel("Student Mobile");
		studentMobileField = new JTextField(15);
		issueBookButton = new JButton("Issue Book");
		backButton = new JButton("Back");

		issueBookFormLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		callNoLabel.setFont(font);
		callNoField.setFont(font);
		studentIdLabel.setFont(font);
		studentIdField.setFont(font);
		studentNameLabel.setFont(font);
		studentNameField.setFont(font);
		studentMobileLabel.setFont(font);
		studentMobileField.setFont(font);
		issueBookButton.setFont(font);
		backButton.setFont(font);

		issueBookFormLabel.setForeground(Color.GRAY);

		setPreferredSize(new Dimension(500, 400));
		createContentPaneLayout();
		pack();
		setLocationRelativeTo(null);
		parent.setVisible(false);
		setVisible(true);

		setListeners(parent);
	}

	private void createContentPaneLayout() {
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 2;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.PAGE_START;

		// first row
		contentPane.add(issueBookFormLabel, gc);

		// next row
		gc.gridwidth = 1;
		gc.weighty = 0.4;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 20, 0, 0);
		contentPane.add(callNoLabel, gc);

		gc.gridx++;
		gc.insets.left = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(callNoField, gc);

		// next row
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets.left = 20;
		contentPane.add(studentIdLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets.left = 0;
		contentPane.add(studentIdField, gc);

		// next row
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets.left = 20;
		contentPane.add(studentNameLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets.left = 0;
		contentPane.add(studentNameField, gc);

		// next row
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets.left = 20;
		contentPane.add(studentMobileLabel, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets.left = 0;
		contentPane.add(studentMobileField, gc);

		// next row
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(issueBookButton, gc);

		gc.gridx++;
		gc.insets.left = 0;
		contentPane.add(backButton, gc);
	}

	private void setListeners(JFrame parent) {
		issueBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String callNo = callNoField.getText();
				String studentId = studentIdField.getText();
				String studentName = studentNameField.getText();
				String studentMobile = studentMobileField.getText();

				if (callNo.isEmpty() || studentId.isEmpty() || studentName.isEmpty() || studentMobile.isEmpty()) {
					JOptionPane.showMessageDialog(IssueBookForm.this, "Please don't leave blank field", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					IssueBook issueBook = new IssueBook(callNo, studentId, studentName, studentMobile);
					boolean flag = IssueBookDao.issueBook(issueBook);

					if (flag) {
						JOptionPane.showMessageDialog(IssueBookForm.this,
								"Issue a book with CallNo (" + callNo + ") successfully", "Issue successfully",
								JOptionPane.OK_OPTION);
						callNoField.setText("");
						studentIdField.setText("");
						studentNameField.setText("");
						studentMobileField.setText("");
					} else {
						JOptionPane.showMessageDialog(IssueBookForm.this,
								"Cannot issue a book with CallNo (" + callNo + ")", "Issue Failure",
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
