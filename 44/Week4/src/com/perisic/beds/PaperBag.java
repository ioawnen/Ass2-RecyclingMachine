package com.perisic.beds;

/**
 * Describes a Paper Bag object that can be added to the machine.
 * @author Jake Scott
 *
 */
public class PaperBag extends DepositItem {
	static int weight = 2; //weight in lbs
	static int size = 10; //size in cubic inches
	/**
	 * Describes the item
	 */
	public PaperBag() { 
		value = 10; 
	}
	/**
	 * returns name of item in lowercase
	 */
	String getName() { 
		return "paper bag";
	}
}
