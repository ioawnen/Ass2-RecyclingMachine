package com.perisic.beds;

/**
 * User Interface. It interacts only with the Deposit Item Received; doens't know about anything
 * else. 
 * @author Jake Scott
 *
 */
public class CustomerPanel {
	
	DepositItemReceiver receiver = null;
	
	
	public CustomerPanel(PrintInterface myPrinter) {
		super();
		this.receiver = new DepositItemReceiver(myPrinter); 
	}
	/**
	 * An item is entered into the recycling machine.
	 * @param slot
	 */
	public void itemReceived(int slot) { 
		receiver.classifyItem(slot); 
	}
	/**
	 * A request is made for a receipt. 
	 */
	public void printReceipt() { 
		receiver.printReceipt();
	}
	/**
	 * A request is made for a summary.
	 */
	public void printSummary() {
		receiver.printSummary();
	}
	public void changeColour(String c) {
		receiver.changeColour(c);
	}
	public int getNumberOfItems() { 
		return receiver.getNumberOfItems(); 
	}
	public String getSummaryText() { 
		return receiver.getSummaryText(); 
	}
	public String getReceiptText() { 
		return receiver.getReceiptText(); 
	}
}
