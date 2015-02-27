package com.perisic.beds;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcClient;

import com.perisic.beds.CustomerPanel;


public class FeedbackPane extends JFrame implements ActionListener {
	
	
	
	private static final long serialVersionUID = -5772727482959492839L;
	
	private String inputString = "";
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(confirmButton)) {
			onConfirmButtonPressed();			
		}
		else if(e.getSource().equals(cancelButton)) {
			onCancelButtonPressed();	
		}
	}
	
	JTextArea inputField = new JTextArea(6, 8);
	JButton confirmButton = new JButton("Confirm");
	JButton cancelButton = new JButton("Cancel");
	
	public FeedbackPane() {
		
		super();
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		JPanel panel = new JPanel(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.insets = new Insets(5,5,5,5);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(inputField, c);
		c.gridwidth = 1;
		c.gridy = 1;
		panel.add(confirmButton, c);
		c.gridx = 1;
		panel.add(cancelButton, c);
		
		confirmButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		getContentPane().add(panel);
		panel.repaint();
		
		
			
	}
	
	
	public boolean startGUI() {
		try {
			FeedbackPane feedbackPane = new FeedbackPane();
			feedbackPane.setVisible(true);
			return true;
		}
		catch(Exception ex) {
			System.err.println(ex);
			return false;
		}
	}
	
	public String getInput() {
		return inputString;
	}
		
	public void onCancelButtonPressed() {
		System.err.println("DO SOMETHING HERE");
		
	}		
	public void onConfirmButtonPressed() {
		inputString = inputField.getText();	//Get yo input
		
	}
	
}
