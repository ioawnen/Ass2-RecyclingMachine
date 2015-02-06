package com.perisic.beds;

import java.util.*;

import javax.swing.JOptionPane;

import org.apache.xmlrpc.*;

public class RecyclingClient {
 public static void main (String [] args) {
  try {
   
   XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); //
   String message; 
   String sessionCookie = ""; 
   boolean loginSuccess = false; 
   while( loginSuccess == false && (message = JOptionPane.showInputDialog("Login please")) != null  ) { 
	   Vector parms1 = new Vector();
	   parms1.add(message); 
	   Object result3 = server.execute("recycling.login", parms1); 
	   String loginRequest = result3.toString(); 
	  //  System.out.println("The result3 is: "+ loginRequest.toString()); 
	   if(loginRequest.equals("wrong password")) { 
		   System.out.println("Wrong Pasword. Try again!!!"); 
	   } else { 
		   sessionCookie = loginRequest; 
		   loginSuccess = true; 
	   }
   }

   System.out.println("You are now logged into the Recycling Machine!!!"); 
   
   Vector params = new Vector(); 
     
   params.add(sessionCookie); 
   
   Object result = server.execute("recycling.numberOfItems", new Vector() );   //Retrieves number of items
   //Object result = server.execute("recycling.summaryText", new Vector() );     //Gets summary statement
   
   System.out.println("The result is: "+result.toString()); //Prints result
   
  
  } catch (Exception exception) {
   System.err.println("JavaClient: " + exception);
   }
  }
 //public Object Summary() {
	// Object result = server.execute("recycling.summaryText", new Vector() );     //Gets summary statement
	// return result;
 //}
 
 }

