package com.perisic.beds;



/**
 * Provides the output to the customer. 
 * @author Marc Conrad
 *
 */
public class ReceiptPrinter implements PrintInterface {
	/**
	 * The passed in string is printed to the screen
	 * @param str
	 */
	public void print(String str) { 
		System.out.println(str);
	}
	
	public void changeColour(String c){
		
	}
}
