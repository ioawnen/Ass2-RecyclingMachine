package com.perisic.beds;

/**
 * Represents a crate object
 * @author Jake Scott
 *
 */
public class Crate extends DepositItem {
	static int weight = 220; 
	static int size = 90; 
	/**
	 * 
	 */
	public Crate() { 
		value = 41; 
	}
	/**
	 * Returns the name of the object
	 */
	String getName() { 
		return "crate";
	}
}
