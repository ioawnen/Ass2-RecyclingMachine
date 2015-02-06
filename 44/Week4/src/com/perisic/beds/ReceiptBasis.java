package com.perisic.beds;
import java.util.Vector; 

/**
 * The database of the system. 
 * @author Jake Scott
 *
 */
public class ReceiptBasis {
	private Vector<DepositItem> myItems = new Vector<DepositItem>();
	/**
	 * adds the item being added to a list of all items in machine
	 * @param item
	 */
	public void addItem(DepositItem item) { 
		myItems.add(item); 
		item.number = myItems.indexOf(item);  //number is position in list
	}
	/**
	 * Calculate the total amount of all items inserted. 
	 * @return The sum total of the items. 
	 */
	public String computeSum() { 
		String receipt = ""; 
		int sum = 0; 
		for(int i=0; i < myItems.size(); i++ ) { //for each item 
			DepositItem item = myItems.get(i); 
			receipt = receipt + (item.number + 1) +": "+item.value +" - A "+item.getName()+" has been inserted into the machine."; 
			receipt = receipt + System.getProperty("line.separator"); //new line
			sum = sum + item.value; //total value 
			
		}
		receipt = receipt + "Total: "+sum; 
		myItems = null;
		return receipt;  
	}

	}
