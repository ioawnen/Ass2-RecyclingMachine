package com.perisic.beds;
//import GreenDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.perisic.beds.CustomerPanel;
import javax.swing.*;

import org.apache.xmlrpc.WebServer;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * Each 'slot' is used for a different type of item
 * @author Jake Scott
 *
 */
public class RecyclingGUI extends JFrame implements ActionListener  {
	
	public static boolean green = false; //initially text is pink, not green
	public static WebServer server = null;

	private static final long serialVersionUID = -8505887234678184162L; //id required
	private String storedPasswd = "password"; // needs some thinking with encryption etc
	private String storedCookie = null; // some random string to be used for authentication

	CustomerPanel myCustomerPanel = new CustomerPanel( new Display());  //display window constructed
	JLabel status = new JLabel(); //status 
	
	/**
	 * Defines what happens when a button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {

	
		if (e.getSource().equals(slot1)) {  //if slot 1 is pressed, a can is added to the machine
			if (capacity != 0){ //if the machine is not full
			myCustomerPanel.itemReceived(1);
			capacity--;
			status.setText("Can Inserted. " + capacity + " spaces remaining.");
			} else
			{
				status.setText("The machine is full");
			}
		} else if (e.getSource().equals(slot2)) {
			if (capacity != 0){
			myCustomerPanel.itemReceived(2);
			capacity--;
			status.setText("Bottle Inserted. " + capacity + " spaces remaining.");
			} else
			{
				status.setText("The machine is full");
			}
		} else if (e.getSource().equals(slot3)) {
			if (capacity != 0){
			myCustomerPanel.itemReceived(3);
			capacity--;
			status.setText("Crate Inserted. " + capacity + " spaces remaining.");
			} else
			{
				status.setText("The machine is full");
			}
		} else if (e.getSource().equals(slot4)) {
			if (capacity != 0){
			myCustomerPanel.itemReceived(4);
			capacity--;
			status.setText("Paper Bag Inserted. " + capacity + " spaces remaining.");
			} else
			{
				status.setText("The machine is full");
			}
		} else if (e.getSource().equals(receipt)) { //receipt is output when this button is pressed
			status.setText("");
		myCustomerPanel.printReceipt(); //prints the receipt
		} else if (e.getSource().equals(printer)) { //pressing the button changes text colour between pink and green
			status.setText("");
			changeDisplay(); 
		} else if (e.getSource().equals(summary)) { //summary is output when this button is pressed
			myCustomerPanel.printSummary();
			status.setText("");
		}
	}
	/*
	 * Declaration of GUI elements
	 */
	JButton slot1 = new JButton("Slot 1"); 
	JButton slot2 = new JButton("Slot 2"); 
	JButton slot3 = new JButton("Slot 3"); 
	JButton slot4 = new JButton("Slot 4");
	JButton printer = new JButton("Change to Green Display");
	JButton summary = new JButton("Summary");
	JButton receipt = new JButton("Receipt"); 
	
	int capacity = 15;
	/**
	 * Describes the GUI for the machine
	 */
	public RecyclingGUI() {
		super();
		setTitle("Recycling Machine");
		setSize(400, 150);
		setLocation(500,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(slot1); 
		panel.add(slot2);
		panel.add(slot3); 
		panel.add(slot4);

		slot1.addActionListener(this); 
		slot2.addActionListener(this); 
		slot3.addActionListener(this); 
		slot4.addActionListener(this);
		
		panel.add(receipt); 
		receipt.addActionListener(this); 
		printer.addActionListener(this);
		panel.add(printer);
		summary.addActionListener(this);
		panel.add(summary);
		panel.add(status);
		
		
		
		getContentPane().add(panel);
		panel.repaint();
	
	}
	/*
	 * Shuts down the server connection when closed
	 */
	public static void attachShutDownHook(){  
		  for(int i =0; i<10;i++){
		   Runtime.getRuntime().addShutdownHook(new Thread() {
		    @Override
		    public void run() {    
		     //System.out.println("Inside Add Shutdown Hook : " + Thread.currentThread().getName()) ;
		     server.shutdown();
		    }
		   }); 
		  }
	}
	/*
	 * Creates GUI, which will be visible upon creation mft
	 */
	public static void main(String [] args ) { 
		
		RecyclingGUI myGUI = new RecyclingGUI(); 
		myGUI.setVisible(true); 
		try {
			   System.out.println("Starting the Recycling Server..."); 
			   server = new WebServer(3133);
			   server.addHandler("recycling", myGUI);
			   server.start();
			   System.out.println("Server started successfully.");
			  } 
		catch (Exception exception) {
			   System.err.println("JavaServer: " + exception);
			   }
		finally {
			attachShutDownHook();
		}
		
	}
	/**
	 * Web service to authenticate the user with proper password. 
	 * @param passwd
	 * @return
	 */
	 public String login(String passwd) { 
		
		 if( passwd.equals(storedPasswd)) { 
			 storedCookie = "MC"+Math.random(); 
			 return storedCookie; 
		 } else { 
		 	 return "wrong password"; 
		 	} 		 
		 }
	 /**
	  * Web service to logout from the system. 
	  */
	 
	public String logout(String myCookie ) { 
		if( storedCookie == null ) { 
			return "(no cookie set)"; 
		} else if( myCookie.equals(storedCookie)) { 
			storedCookie = null;  
			return "cookie deleted: OK"; 
		} 
		else { 
			return "could not delete anything; authentication missing"; 
		}
		
	}
	
	
	/**
	 * Used to change the colour of the text in the display window. Eventually passed to Display class.
	 */
	public void changeDisplay(){
		if (green==false){ //if the text is not set to green, sets to green
			green = true;
			printer.setText("Change to Pink Display"); //text on button changed
			myCustomerPanel.changeColour("GREEN");
		} else {
		green = false; //if it is currently green, the text is set to pink
		printer.setText("Change to Green Display");
		myCustomerPanel.changeColour("PINK");
	}
	}
	public int numberOfItems(String myCookie) {
		if( storedCookie == null ) { 
			return -1; 
		} else if( myCookie.equals(storedCookie)) { 
			return myCustomerPanel.getNumberOfItems(); 
		} 
		else { 
			return -1; 
		}
		 }
	public String summaryText(String myCookie) {
		if( storedCookie == null ) { 
			return "-1"; 
		} else if( myCookie.equals(storedCookie)) { 
			  return myCustomerPanel.getSummaryText();  
		} 
		else { 
			return "-1"; 
		}

		 }
	public String receiptText(String myCookie) {
		if( storedCookie == null ) { 
			return "-1"; 
		} else if( myCookie.equals(storedCookie)) { 
			  return myCustomerPanel.getReceiptText();  
		} 
		else { 
			return "-1"; 
		}

		 }
	
	
}

	

