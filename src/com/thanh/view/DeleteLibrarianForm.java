package com.thanh.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.thanh.dao.LibrarianDao;

public class DeleteLibrarianForm extends JFrame {
	private JPanel contentPane;
	private JLabel idLabel;
	private JTextField idField;
	private JButton deleteButton;
	private JButton backButton;
	private Font font = new Font("Tahoma", Font.PLAIN, 18);

	public DeleteLibrarianForm(JFrame parent) {
		super("Delete Librarian Form");

		contentPane = new JPanel();
		idLabel = new JLabel("Enter ID");
		idField = new JTextField(10);
		deleteButton = new JButton("Delete");
		backButton = new JButton("Back");

		idField.setFont(font);
		idLabel.setFont(font);
		deleteButton.setFont(font);
		backButton.setFont(font);

		backButton.setPreferredSize(deleteButton.getPreferredSize());

		setPreferredSize(new Dimension(350, 250));
		pack();
		setLocationRelativeTo(null);
		createContentPaneLayout();
		parent.setVisible(false);
		setVisible(true);

		setListeners(parent);
	}

	private void createContentPaneLayout() {
		setContentPane(contentPane);

		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		gc.gridwidth = 1;
		gc.anchor = GridBagConstraints.LINE_END;

		contentPane.add(idLabel, gc);
		gc.gridx++;
		gc.anchor = GridBagConstraints.CENTER;
		contentPane.add(idField, gc);

		gc.gridx = 0;
		gc.gridy++;
		gc.gridwidth = 2;
		contentPane.add(deleteButton, gc);

		gc.gridy++;
		contentPane.add(backButton, gc);

	}

	public void setListeners(JFrame parent) {
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(idField.getText());

				boolean flag = LibrarianDao.deleteLibrarianById(id);

				if (flag) {
					JOptionPane.showMessageDialog(DeleteLibrarianForm.this, "Deleted a librarian with ID = " + id,
							"Deleted successfully", JOptionPane.OK_OPTION);
					idField.setText("");
				} else {
					JOptionPane.showMessageDialog(DeleteLibrarianForm.this, "Failed to delete a librarian", "Failed",
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
