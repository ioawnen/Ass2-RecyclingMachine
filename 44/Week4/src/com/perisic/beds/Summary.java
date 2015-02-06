package com.perisic.beds;
import java.util.Vector;
/** 
 * This class is used to aggregate and construct a summary statement.
 */
public class Summary {
	public int totalI = 0; //Total number of items in machine
	private Vector<DepositItem> itemList = new Vector<DepositItem>(); //used to hold list of items
	
	/**
	 * adds the item being added to a list of all items in machine
	 * @param item
	 */
	public void addItem(DepositItem item) { 
		itemList.add(item); 
		item.number = itemList.indexOf(item); //number is position in list
		totalI = totalI + 1; //total number of items incremented
	}
	/**
	 * Constructs the summary statement and calculates what is in the machine
	 * @return
	 */
	public String summary() {
		int cans = 0;   //number of cans
		int canVal = 0;  //total value of cans
		int bottles = 0; //number of bottles
		int botVal = 0; //total value of bottles
		int crates = 0; //number of crates
		int cratVal = 0; //total value of crates
		int bags = 0;  //number of bags
		int bagVal = 0; //total value of bags
		int totalV = 0; //total value of all items
		String fullSummary = "";
		for(int i=0; i < itemList.size(); i++ ) { //for each item in list
			DepositItem item = itemList.get(i);
			if (item.getName()=="can") { //gets what type of item it is, adds to totals
				cans++;
				canVal = canVal + item.value;
			} else if (item.getName()=="bottle") {
				bottles++;
				botVal = botVal + item.value;
			} else if (item.getName()=="crate") {
				crates++;
				cratVal = cratVal + item.value;
			} else if (item.getName()=="paper bag") {
				bags++;
				bagVal = bagVal + item.value;
			} 
			totalV = (canVal + botVal + cratVal + bagVal); //calculates total value
			//summary string then constructed
			fullSummary = "There have been " + cans + " Cans added, with a total value of " + canVal +"."+ System.getProperty("line.separator") + "There have been " + bottles + " Bottles added, with a total value of " + botVal + "."+ System.getProperty("line.separator") + "There have been " + crates + " Crates added" + ", with a total value of " + cratVal + "."+ System.getProperty("line.separator") + "There have been " + bags + " Paper Bags added, with a total value of " + bagVal + "."+ System.getProperty("line.separator") + "In total, " + totalI + " items have been added, with a value of " + totalV +".";
		}
		return fullSummary; //string returned
	}
}
