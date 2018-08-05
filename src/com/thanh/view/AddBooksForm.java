package com.thanh.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thanh.dao.BookDao;
import com.thanh.model.Book;

public class AddBooksForm extends JFrame {
	private JPanel contentPane;
	private JLabel addBooksformLabel;
	private JLabel callNoLabel;
	private JTextField callNoField;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel authorLabel;
	private JTextField authorField;
	private JLabel publisherLabel;
	private JTextField publisherField;
	private JLabel quantityLabel;
	private JTextField quantityField;

	private JButton addBookButton;
	private JButton backButton;

	private static Font font = new Font("Tahoma", Font.PLAIN, 18);

	public AddBooksForm(JFrame parent) {
		contentPane = new JPanel();
		addBooksformLabel = new JLabel("Add Books Form");
		callNoLabel = new JLabel("CallNo");
		callNoField = new JTextField(15);
		nameLabel = new JLabel("Name");
		nameField = new JTextField(15);
		authorLabel = new JLabel("Author");
		authorField = new JTextField(15);
		publisherLabel = new JLabel("Publisher");
		publisherField = new JTextField(15);
		quantityLabel = new JLabel("Quantity");
		quantityField = new JTextField(15);
		addBookButton = new JButton("Add Book");
		backButton = new JButton("Back");

		addBooksformLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addBooksformLabel.setForeground(Color.gray);

		callNoLabel.setFont(font);
		callNoField.setFont(font);
		nameLabel.setFont(font);
		nameField.setFont(font);
		authorLabel.setFont(font);
		authorField.setFont(font);
		publisherLabel.setFont(font);
		publisherField.setFont(font);
		quantityLabel.setFont(font);
		quantityField.setFont(font);
		addBookButton.setFont(font);
		backButton.setFont(font);

		addBookButton.setMnemonic(KeyEvent.VK_ENTER);

		setPreferredSize(new Dimension(500, 400));
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
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.PAGE_START;
		contentPane.add(addBooksformLabel, gc);

		gc.gridwidth = 1;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 40, 0, 0);
		contentPane.add(callNoLabel, gc);

		gc.gridx++;
		gc.insets.left = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(callNoField, gc);

		// Next Row
		gc.gridx = 0;
		gc.gridy++;
		gc.insets.left = 40;
		gc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(nameLabel, gc);

		gc.gridx++;
		gc.insets.left = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(nameField, gc);

		// Next Row
		gc.gridx = 0;
		gc.gridy++;
		gc.insets.left = 40;
		gc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(authorLabel, gc);

		gc.gridx++;
		gc.insets.left = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(authorField, gc);

		// Next Row
		gc.gridx = 0;
		gc.gridy++;
		gc.insets.left = 40;
		gc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(publisherLabel, gc);

		gc.gridx++;
		gc.insets.left = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(publisherField, gc);

		// Next Row
		gc.gridx = 0;
		gc.gridy++;
		gc.insets.left = 40;
		gc.anchor = GridBagConstraints.LINE_START;
		contentPane.add(quantityLabel, gc);

		gc.gridx++;
		gc.insets.left = 0;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(quantityField, gc);

		// Next Row
		gc.gridx = 0;
		gc.gridy++;
		gc.anchor = GridBagConstraints.LINE_END;
		contentPane.add(addBookButton, gc);

		gc.gridx++;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets.left = 150;
		contentPane.add(backButton, gc);
	}

	private void setListeners(JFrame parent) {
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String callNo = callNoField.getText();
				String name = nameField.getText();
				String author = authorField.getText();
				String publisher = publisherField.getText();
				
				Date addedDateTime = Calendar.getInstance().getTime();

				if (callNo.isEmpty() || name.isEmpty() || author.isEmpty() || publisher.isEmpty()
						|| quantityField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(AddBooksForm.this, "Don't leave empty field", "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					int quantity = Integer.parseInt(quantityField.getText());
					Book book = new Book(callNo, name, author, publisher, quantity, 0, addedDateTime);

					boolean flag = BookDao.addBooks(book);

					if (flag) {
						JOptionPane.showMessageDialog(AddBooksForm.this, "Added a book successfully!", "Successfully",
								JOptionPane.OK_OPTION);
						callNoField.setText("");
						nameField.setText("");
						authorField.setText("");
						publisherField.setText("");
						quantityField.setText("");
					} else {
						JOptionPane.showMessageDialog(AddBooksForm.this, "Failed to add a book!", "Add book failure",
								JOptionPane.OK_OPTION);
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
