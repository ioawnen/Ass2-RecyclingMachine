package com.perisic.beds;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.apache.xmlrpc.WebServer;

public class HQGUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -8505887234675184162L; //id required
	
	public void actionPerformed(ActionEvent e) {
		
		ClientGUI clientgui = new ClientGUI("");
		try {
			System.out.println(e.getSource());
			if( e.getSource().equals(mach1) ) {
				clientgui.startGUI("http://localhost:3133/RPC2");
			}	
			else if( e.getSource().equals(mach2) ) {
				clientgui.startGUI("http://10.1.27.192:31331/RPC2");
			}			
			else if( e.getSource().equals(mach3) ) {
				clientgui.startGUI("Cabbage");
			}
			else if( e.getSource().equals(mach4) ) {
				clientgui.startGUI("Cabbage");
			}
			else if( e.getSource().equals(inputMach) ) {
				clientgui.startGUI(inputField.getText());
			}
			else {
				System.out.println("Well fuck.");
				clientgui.dispose();
			}
		}
		catch(Exception exception) {
			System.err.println("JavaClient: " + exception);
		}
		
	}
	
	JLabel title = new JLabel("Login");
	JButton mach1 = new JButton("Machine 1"); 
	JButton mach2 = new JButton("Machine 2"); 
	JButton mach3 = new JButton("Machine 3"); 
	JButton mach4 = new JButton("Machine 4");
	JTextField inputField = new JTextField(50);
	JButton inputMach = new JButton("Connect");

	public HQGUI() {
		super();
		setTitle("Recycling HQ Maintenance System");
		setSize(200, 300);
		setLocation(500,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.insets = new Insets(5,5,5,0);
		c.gridx = 0;
		c.gridy = 0;	
		panel.add(title, c);
		c.gridy = 1;
		panel.add(mach1, c);
		c.gridy = 2;
		panel.add(mach2, c);
		c.gridy = 3;
		panel.add(mach3, c); 
		c.gridy = 4;
		panel.add(mach4, c);
		c.gridy = 5;
		c.ipadx = 90;
		panel.add(inputField, c);
		c.gridy = 6;
		c.ipadx = 0;
		panel.add(inputMach, c);
		
		mach1.addActionListener(this); 
		mach2.addActionListener(this); 
		mach3.addActionListener(this); 
		mach4.addActionListener(this);
		inputMach.addActionListener(this);
	
		getContentPane().add(panel);
		panel.repaint();
	
	}
	
	public static void main(String [] args ) { 
		HQGUI myGUI = new HQGUI(); 
		myGUI.setVisible(true); 
	}

}
