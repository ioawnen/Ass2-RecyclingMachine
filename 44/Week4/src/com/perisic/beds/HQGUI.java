package com.perisic.beds;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.apache.xmlrpc.WebServer;

public class HQGUI extends JFrame {
	
	private static final long serialVersionUID = -8505887234675184162L; //id required
	
	JButton mach1 = new JButton("Machine 1"); 
	JButton mach2 = new JButton("Machine 2"); 
	JButton mach3 = new JButton("Machine 3"); 
	JButton mach4 = new JButton("Machine 4");

	
	
	public HQGUI() {
		super();
		setTitle("Recycling HQ Maintenance System");
		setSize(400, 150);
		setLocation(500,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(mach1); 
		panel.add(mach2);
		panel.add(mach3); 
		panel.add(mach4);
		
		//mach1.addActionListener(this); 
		//mach2.addActionListener(this); 
		//mach3.addActionListener(this); 
		//mach4.addActionListener(this);
		
		
		
		
		
		getContentPane().add(panel);
		panel.repaint();
	
	}
	
	public static void main(String [] args ) { 
		HQGUI myGUI = new HQGUI(); 
		myGUI.setVisible(true); 
		try {
			   System.out.println("Starting the Recycling HQ Server..."); 
			   WebServer server = new WebServer(80);
			   server.addHandler("recycling", myGUI);
			   server.start();
			  } catch (Exception exception) {
			   System.err.println("JavaServer: " + exception);
			   }
	}

}