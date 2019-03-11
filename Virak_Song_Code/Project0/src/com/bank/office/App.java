package com.bank.office;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import com.bank.customer.customer;

public class App {
	
	private String s="AB";
	
	
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int withDraw(int DrawMoney) {
		
		return 20;
	}
	
	public void deposit(int depositMoney) {
		System.out.print("Deposite");
	}
	
	public void transfer() {
		System.out.println("Transfer");
	}
	
	public void  checking() {
		System.out.println("checking");
		
	}
	
	public void joinAcc() {
		System.out.println("joinAcc");
	}
	
	boolean Autherize(char T) {
		boolean t=false;
		
		switch (T){
			case 'y': 
				t=true;
				break;
			case 'n': 
				t=false;
				break;
				
		}
		return t;
			
	}
	
	static void createAccount(boolean t) {
		//search and approve account from tempAccount text file to new customer account;
	
	}
	
	public static void registerAccount(boolean t) {
		 if (t==true) {
		 try {
			 
			/*//System.out.println(Math.random());
		 	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		 	//System.out.println("");
		    System.out.println("Enter username:");
		    String userName = myObj.nextLine();  // Read user input
		   // System.out.println("Username is: " + userName);  // Output user input 
			 */		    
		    String input;
		    boolean tt = false;
		    
		    ArrayList<String> list = new ArrayList<String>();
		    
		    list.add("NP"); //NP:not yet approve yet, AP:Aprroved
		    
		    System.out.println("Would you like to open individual or join an account?");
		    System.out.println("1. Join");
		    System.out.println("2. individual");
		    //System.out.println("3. Exit");
		    do {
			    input = App.input();  
			    switch (input) {
			    	case "1":	{
						list.add("Join");
						tt= true;
						break;
						}
			    	case "2": {
						list.add("individual");
						tt= true;
						break;
					}
					default: System.out.println("Please input valid key");
					/*else if (input =="3") {
						//exit
						tt= true;
					}*/
			    }
						
			}while (tt==false);	

		    System.out.println("Usename:");
			   input = App.input();
		       list.add(input);	
		       
		   System.out.println("Password:");
			   input = App.input();
		       list.add(input);
	    	
			System.out.print("First:");
		    	input = App.input();  
		    	list.add(input);
			
		    System.out.println("Last");
		    	input = App.input();
		    	list.add(input);
		    	
		    System.out.println("DOB:");
		        input = App.input();
		        list.add(input);
		     
		    System.out.println("SSN:");
			    input = App.input();
		        list.add(input);
		    
		    System.out.println("Stree:");
			    input = App.input();
		        list.add(input);
		    
		    System.out.println("City:");   
		        input = App.input();
		        list.add(input);
		    
		   System.out.println("Zip:");
			   input = App.input();
		       list.add(input);
		       
		   System.out.println("Tel:");
			   input = App.input();
		       list.add(input);		   
		  
			
			App app = new App();
			list.add(app.getS()); // random send account number to this.set and this.get past string account to list.
			
		    HashMap<String, String> userfile = new HashMap<String, String>();
		   // userfile.put("Admin", userName.toString()); //write input from user store on Hashmap.
		    userfile.put(list.get(2)+"%"+list.get(3).toString(), list.toString());
		    //System.out.println(userfile);
		    
		   
		    //userfile.clear(); // remove all from text file
		   // userfile.remove("Admin"); remove specific record on text file. 
		    	    
	        FileWriter writer = new FileWriter("./customerAccount.txt",true);// true allow to write a new line and keep old data on text file; false overwrite every open the file
	       // FileWriter writer = new FileWriter("./MyFile.txt",false);// false allow to overwrite every open the file
	        BufferedWriter bufferedWriter = new BufferedWriter(writer);
	        	            
	        bufferedWriter.write(userfile.toString()); //store Hashmap into text file
	        bufferedWriter.newLine();
	      
	        System.out.println("The account is now temporily created to be approved to open the account "+userfile.toString());
	        // bufferedWriter.write("See You Again!");
	
	        bufferedWriter.close();
	        writer.close();
	        
		 } catch (IOException e) {
	         e.printStackTrace();
	     }
	 } //end if 
		
	}
	
	void deleteAccount() {
		
	}
	
	void updateAccount() {
		
	}
	
	void randomNumber() {
		ArrayList<Byte> list = new ArrayList<Byte>(); 
		for (byte i = 0; i < 10; i++) { 
		list.add(i); 
		}  
		Collections.shuffle(list); 
		
		for (byte i = 0; i < 10; i++) { 
			this.setS(s+list.get(i).toString());
			}
		//System.out.println(s); 
		
		
	}
	
	public static String input() {
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	 	//System.out.println("");
	    //System.out.println("Enter username:");
	    String in = myObj.nextLine();  // Read user input
	   // System.out.println("Username is: " + userName);  // Output user input 
		return in;
	}
	
	public String search(String name) throws IOException {
		FileReader file;
		String textContent = "";
		boolean q = false;
			file = new FileReader("./customerAccount.txt");
	        BufferedReader read=new BufferedReader(file);    
	        String ii="";
	       // 	System.out.print(read.lines());
	        String i; 
	        HashMap<String, String> userfile = new HashMap<String, String>();
	        //userfile.put("Admin", list.toString()); 
	       // userfile.get(key)
	        
	        while((i=read.readLine()) != null){
	        	
	        	 String [] line = i.split("=\\[");
	        	 String hashIndex = line[0].toString().replaceAll("\\{", "");
	        	 line[1] = line[1].toString().replaceAll("\\]\\}", "");
	        	 String [] c = line[1].toString().split(", ");
	        	 
	        	 if (c[0].toString().equals("NP")) {
	        		 
	        		 break;
	        		 
	        	 }
	        	// System.out.print("hell" + "y" dfd "+);
	        	 customer customer = new customer();
	        	
	        	 customer.setStatus(c[0].toString());
	        	 
	        	 //joinAcc
	        	 customer.setJoinAcc(c[1].toString());
	        	 
	        	 //username
	        	 customer.setUsername(c[2].toString());
	        	 
	        	 //password
	        	 customer.setUsername(c[3].toString());
	        	 
	        	 //first
	        	 customer.setUsername(c[4].toString());
	        	 
	        	 //last
	        	 customer.setLast(c[5].toString());
	        	 
	        	 //dob
	        	 customer.setDob(c[6].toString());
	        	 
	        	 //ssn
	        	 customer.setSsn(c[7].toString());
	        	 
	        	 //address
	        	 customer.setAddress(c[8].toString());

	        	 //city
	        	 customer.setCity(c[9].toString());

	        	 //zipcode
	        	 customer.setZipcode(c[10].toString());

	        	 //telephone
	        	 customer.setTelephone(c[11].toString());
	        	 
	        	 //telephone
	        	 customer.setTelephone(c[11].toString());
	        	 
	        	 //account Number
	        	 customer.setAccountnumber(c[12].toString());
	        	 
	        	 userfile.put(hashIndex, customer.toString());
	        	 
	        	
	      	
	      	
	       	read.close();    
	        file.close();  
	        }
	        return i;
	       // return the whole line about the customer to be viewed prior to be approved to open account
	    }
	
	        public void update(String name) throws IOException {
	    		FileReader file;
	    		String textContent = "";
	    		boolean q = false;
	    			file = new FileReader("./customerAccount.txt");
	    	        BufferedReader read=new BufferedReader(file);  
	    	        
	    	        String ii="";
	    	       // 	System.out.print(read.lines());
	    	        String i; 
	    	        HashMap<String, String> userfile = new HashMap<String, String>();
	    	        //userfile.put("Admin", list.toString()); 
	    	       // userfile.get(key)
	    	        

	    		    ArrayList<String> list = new ArrayList<String>();
	    	        
	    	        while((i=read.readLine()) != null){
	    	        	
	    	        	 String [] line = i.split("=\\[");
	    	        	 String hashIndex = line[0].toString().replaceAll("\\{", "");
	    	        	 line[1] = line[1].toString().replaceAll("\\]\\}", "");
	    	        	 String [] c = line[1].toString().split(", ");
	    	        	 
	    	        	 if (c[0].toString().equals("NP")) {
	    	        		 c[0]=name;
	    	        		
	    	        		 
	    	        	 }
	    	        	// System.out.print("hell" + "y" dfd "+);
	    	        	 /*customer customer = new customer();
	    	        	
	    	        	 customer.setStatus(c[0].toString());
	    	        	 
	    	        	 //joinAcc
	    	        	 customer.setJoinAcc(c[1].toString());
	    	        	 
	    	        	 //username
	    	        	 customer.setUsername(c[2].toString());
	    	        	 
	    	        	 //password
	    	        	 customer.setUsername(c[3].toString());
	    	        	 
	    	        	 //first
	    	        	 customer.setUsername(c[4].toString());
	    	        	 
	    	        	 //last
	    	        	 customer.setLast(c[5].toString());
	    	        	 
	    	        	 //dob
	    	        	 customer.setDob(c[6].toString());
	    	        	 
	    	        	 //ssn
	    	        	 customer.setSsn(c[7].toString());
	    	        	 
	    	        	 //address
	    	        	 customer.setAddress(c[8].toString());

	    	        	 //city
	    	        	 customer.setCity(c[9].toString());

	    	        	 //zipcode
	    	        	 customer.setZipcode(c[10].toString());

	    	        	 //telephone
	    	        	 customer.setTelephone(c[11].toString());
	    	        	 
	    	        	 //telephone
	    	        	 customer.setTelephone(c[11].toString());
	    	        	 
	    	        	 //account Number
	    	        	 customer.setAccountnumber(c[12].toString());
	    	        	 
	    	        	 userfile.put(hashIndex, customer.toString());*/
	    	        	 

	    			       list.add(c[0].toString());	
	    			       list.add(c[1].toString());	
	    			       list.add(c[2].toString());	
	    			       list.add(c[3].toString());	
	    			       list.add(c[4].toString());	
	    			       list.add(c[5].toString());	
	    			       list.add(c[6].toString());	
	    			       list.add(c[7].toString());	
	    			       list.add(c[8].toString());	
	    			       list.add(c[9].toString());	
	    			       list.add(c[10].toString());	
	    			       list.add(c[11].toString());	
	    			       list.add(c[12].toString());	
		    	        	 
		    	        	 userfile.put(hashIndex, list.toString());
		       	        	 
		       	        	
	    	       	 
	    	     // return i;// return the whole line about the customer to be viewed prior to be approved to open account
	    	    } //end while
	    	        
	    	        	FileWriter writer = new FileWriter("./customerAccount.txt",true);// true allow to write a new line and keep old data on text file; false overwrite every open the file
	       	  	       // FileWriter writer = new FileWriter("./MyFile.txt",false);// false allow to overwrite every open the file
	       	  	        BufferedWriter bufferedWriter = new BufferedWriter(writer);
	       	  	        	            
	       	  	        bufferedWriter.write(userfile.toString()); //store Hashmap into text file
	       	  	        bufferedWriter.newLine();
	       	  	      //  bufferedWriter.close();
   	        	 

 	    	      	System.out.println(userfile.toString());
 	    	      	
	    	       	read.close();    
	    	      //  file.close();  
	        }
		
	
	
	
	

}
