package com.perisic.beds;

/**
 * Provides a description for the Bottle object.
 * @author Jake Scott
 *
 */
public class Bottle extends DepositItem {
	static int weight = 10; //weight in lbs
	static int size = 8; //size in cubic inches
	/**
	 * 
	 */
	public Bottle() { 
		value = 20; 
	}
	/**
	 * Outputs the name of the object if requested.
	 */
	String getName() { 
		return "bottle";
	}
}
