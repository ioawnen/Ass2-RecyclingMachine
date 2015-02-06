package com.perisic.beds;

import java.awt.Color;

import javax.swing.*; 
/** 
 * Displays output text in a frame.
 */
public class Display extends JFrame implements com.perisic.beds.PrintInterface {
	/**
	 * A serialVersionUID is required by the JFrame class. 
	 */
	private static final long serialVersionUID = -8505887234618184162L;
	private JTextArea outputWindow; 
	
	/**
	 * The display is visible when constructed, originally set to pink text.
	 */	
	public Display() {
		super();
		setTitle("Output Display");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
		outputWindow = new JTextArea();
		outputWindow.setForeground(Color.MAGENTA); 
		getContentPane().add(outputWindow);
		setVisible(true); 
		}
	/** 
	 * Prints the text str to the screen. Any previous text will be overwritten. 
	 */
	public void print(String str) { 
		outputWindow.setText(str); 
		outputWindow.repaint();
	}
	/**
	 * changes the text colour if requested
	 */
	public void changeColour(String c) {
		if (c=="GREEN"){  //if new colour is to be green, changes to green
			outputWindow.setForeground(Color.GREEN);
		}
		else { 
			outputWindow.setForeground(Color.MAGENTA);	//changes text to magenta	
		}
	}

}

