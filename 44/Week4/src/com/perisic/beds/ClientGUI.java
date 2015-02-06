package com.perisic.beds;



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
	
	public void actionPerformed(ActionEvent e) {
		try { 
			XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2");
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
				}
				
			} else if( e.getSource().equals(logout)) { 
				Vector params = new Vector(); 
				params.add(sessionCookie); 
				Object result = server.execute("recycling.logout", params ); 
				System.out.println("Logout: "+result); 
			}
		} catch (Exception exception) {
			System.err.println("JavaClient: " + exception);
		}
	}

	JButton login = new JButton("Login"); 
	JButton numberOfItems = new JButton("#Items"); 
	JButton logout = new JButton("Logout"); 
	
	
	public ClientGUI() {
		super();
		setSize(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(login); 
		panel.add(numberOfItems);
		panel.add(logout); 
		
		login.addActionListener(this); 
		numberOfItems.addActionListener(this); 
		logout.addActionListener(this); 

		
		getContentPane().add(panel);
		panel.repaint();
		
		
	
	}
	
	public static void main(String [] args ) { 
	ClientGUI myGUI = new ClientGUI(); 
		myGUI.setVisible(true); 
		
	}

}
