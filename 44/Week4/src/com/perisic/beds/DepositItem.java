package com.perisic.beds;

/**
 * Describes an item that is entered into the recycling machine.
 * Stores the number, which is when it was inserted in order, the name, and the value of the item.
 * @author Jake Scott
 *
 */
public abstract class DepositItem {
	int number; //represents order in array
	int value; //value of item
	
	String getName() { 
		String out = getClass().getSimpleName(); //gets name
		return out.toLowerCase();  //returns in lower case
	}
}
