package com.perisic.beds;


import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcClient;

import com.perisic.beds.CustomerPanel;


/**
 * A Simple Graphical User Interface for the Client in the HQ.
 * @author Marc Conrad
 *
 */
public class ClientGUI extends JFrame implements ActionListener  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5772727482959492839L;
	private String sessionCookie = ""; 
	private String serverUrl = "http://localhost:3133/RPC2";
	private Display displayGui = new Display();
	
	public void actionPerformed(ActionEvent e) {
		try { 
			XmlRpcClient server = new XmlRpcClient(serverUrl); //We will be sticking with port 3133
			if( e.getSource().equals(login) ) { 
				String message; 

				boolean loginSuccess = false; 
				while( loginSuccess == false && (message = JOptionPane.showInputDialog("Login please")) != null  ) { 
					Vector parms1 = new Vector();
					parms1.add(message); 
					Object result3 = server.execute("recycling.login", parms1); 
					String loginRequest = result3.toString(); 
					if(loginRequest.equals("wrong password")) { 
						System.out.println("Wrong Pasword. Try again!!!"); 
					} else { 
						sessionCookie = loginRequest; 
						System.out.println("Well done you made it! Correct password!");
						loginSuccess = true; 
					}
				}

			} else if( e.getSource().equals(numberOfItems)) { 
				Vector params = new Vector(); 
				params.add(sessionCookie); 
				Object result = server.execute("recycling.numberOfItems", params ); 
				int resultInt = new Integer(result.toString()); 
				if( resultInt == -1 ) { 
					System.out.println("Sorry no authentication there."); 
				} else { 
					System.out.println("The result is: "+resultInt);
					try {
						displayGui.print(""+resultInt);
					}
					catch(Exception ex) {
						System.out.println(ex);
					}
				} 
				
			}
			else if( e.getSource().equals(receipt)) { 
				Vector params = new Vector(); 
				params.add(sessionCookie); 
				Object result = server.execute("recycling.summaryText", params ); 
				String resultString = new String(result.toString()); 
				if( resultString == "-1" ) { 
					System.out.println("Sorry no authentication there."); 
				} else { 
					System.out.println("This is the summary statement: "+resultString);
					displayGui.print(resultString);
				}
			}
			else if( e.getSource().equals(summary)) { 
				Vector params = new Vector(); 
				params.add(sessionCookie); 
				Object result = server.execute("recycling.summaryText", params ); 
				String resultString = new String(result.toString()); 
				if( resultString == "-1" ) { 
					System.out.println("Sorry no authentication there."); 
				} else { 
					System.out.println("This is the summary statement: "+resultString);
					displayGui.print(resultString);
				}
			}
			else if( e.getSource().equals(logout)) { 
				Vector params = new Vector(); 
				params.add(sessionCookie); 
				Object result = server.execute("recycling.logout", params ); 
				System.out.println("Logout: "+result); 
			}
		} catch (Exception exception) {
			System.err.println("JavaClient: " + exception);
		}
	}

	JButton login = new JButton("Login to Machine"); 
	JButton numberOfItems = new JButton("No. of Items"); 
	JButton receipt = new JButton("View Receipt");
	JButton summary = new JButton("View Summary");
	JButton logout = new JButton("Logout"); 
	
	
	public ClientGUI() {
		super();
		setSize(200, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		//Layout Settings
		JPanel panel = new JPanel(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.insets = new Insets(5,5,5,5);
		c.gridx = 0;
		c.gridy = 0;	
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(login, c);
		c.gridy = 1;
		panel.add(numberOfItems, c);
		c.gridy = 2;
		panel.add(receipt, c);
		c.gridy = 3;
		panel.add(summary, c);
		c.gridy = 4;
		panel.add(logout, c);
		
		login.addActionListener(this); 
		numberOfItems.addActionListener(this); 
		receipt.addActionListener(this);
		summary.addActionListener(this);
		logout.addActionListener(this); 

		
		getContentPane().add(panel);
		panel.repaint();
		
	}
	
	public boolean startGUI(String inputIP) {
		
		try {
			serverUrl = inputIP;
			ClientGUI mainGui = new ClientGUI(); 
			mainGui.setVisible(true); 
			
			Display displayGui = new Display();
			displayGui.setVisible(true);
				
			return true;
		}
		catch (Exception ex) {
			System.err.println(ex);
			return false;
		}
	}
	
	public static void main(String [] args ) { 
	ClientGUI myGUI = new ClientGUI(); 
		myGUI.setVisible(true); 
		
	}

}
