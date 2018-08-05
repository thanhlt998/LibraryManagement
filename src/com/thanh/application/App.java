package com.thanh.application;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.thanh.view.LibraryManagement;

public class App {
	private static JFrame mainFrame;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				mainFrame = new LibraryManagement();
				mainFrame.setVisible(true);
			}
		});
	}
}
