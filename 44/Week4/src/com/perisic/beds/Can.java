package com.perisic.beds;

/**
 * Represents a can to be inserted into the machine. 
 * @author Jake Scott
 *
 */
public class Can extends DepositItem {
	static int weight = 4; 
	static int size = 5; 
	/**
	 * 
	 */
	public Can() { 
		value = 13; 
	}
	/**
	 * Returns the name of the object
	 */
	String getName() { 
		return "can";
	}
}
