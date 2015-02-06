package com.perisic.beds;

import java.awt.Color;

import javax.swing.*; 
/* 
 * Displays text in a frame.
 */
public class GreenDisplay extends JFrame implements com.perisic.beds.PrintInterface {
	/**
	 * A serialVersionUID is required by the JFrame class. 
	 */
	private static final long serialVersionUID = -8505887234618184162L;
	private JTextArea outputWindow; 
	
	/*
	 * when constructed the display will be directly visible. 
	 */	
	public GreenDisplay() {
		super();
		setTitle("Display (Green)");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
		outputWindow = new JTextArea();
		outputWindow.setForeground(Color.GREEN);
		getContentPane().add(outputWindow);
		setVisible(true); 
		}
	/* 
	 * Prints the text str to the screen. Any previous text will be overwritten. 
	 */
	public void print(String str) { 
		outputWindow.setText(str); 
		outputWindow.repaint();
	}
	public void changeColour(String c) {
		System.out.println("fff");
	}

}