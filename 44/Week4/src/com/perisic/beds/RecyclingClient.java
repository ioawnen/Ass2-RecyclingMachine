package com.perisic.beds;

import java.util.*;

import javax.swing.JOptionPane;

import org.apache.xmlrpc.*;

public class RecyclingClient {
 public static void main (String [] args) {
  try {
   
   XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); //
   
   //Object result = server.execute("recycling.numberOfItems", new Vector() );   //Retrieves number of items
   Object result = server.execute("recycling.summaryText", new Vector() );     //Gets summary statement
   
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

