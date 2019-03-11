package com.bank.office;

import java.io.IOException;

public class adminClass {
	private boolean T = false;
	private char validation;
	int money; 
	
	public adminClass() {
		
	}
	
//	public adminClass(char t) {
//		this.validation = t;
//	}
		
	public char getValidation() {
		return validation;
	}

	public void setValidation(char validation) {
		this.validation = validation;
	}

	public adminClass(int Money) {
		money = Money;
		
	}
	
	public void run() {
		/*// search in text file for new customer who has apply to open account
		// need to approve or reject
		// need to send 'y' for approve or 'n' for reject
*/		
		boolean checkUserInput= false;
		
		System.out.println("Please Enter following key word to be continous.");
		System.out.println("1: Approve/reject");
		System.out.println("2: view customer account");
		System.out.println("3: edit customer account ");
		System.out.println("4: cancel customer account");
		System.out.println("5: transfer customer");
		System.out.println("6: exit");
		
		String inputUser = App.input();
		do {
			switch (inputUser) {
				case "1":{
					//App app = new App();
					//System.out.println("Please Enter C:");
					App app= new App();
					try {
						System.out.println(app.search("NP"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					System.out.println("Please Enter following key word to be continous.");
					System.out.println("y: for approve");
					System.out.println("n: for reject account");
					String tem = App.input();
					this.setValidation(tem.charAt(0)); //temperily hard code first.
					
					this.T = app.Autherize(this.getValidation());
					
					if (this.T==true) {
						//App.createAccount(this.T); // not write code to create the account yet
						try {
							app.update("AP");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("the account is now created");
					}else {
						System.out.println("reject account delete from text file customerAccount account menthod");
						
					}
					checkUserInput = true;break;
				}
				case "2":{ System.out.print("call view method");} checkUserInput = true; break;
				
				case "3":{  System.out.println("call edit"); } checkUserInput = true; break;
				
				case "4": { System.out.println("call del "); } checkUserInput = true; break;
				case "5":{ System.out.println("call trander account");  } checkUserInput = true; break;
				case "6":{ System.out.println("exit program") ; } checkUserInput = true; break;
				default: System.out.println("please enter valid keyword to be continoue or enter to exit");
				checkUserInput = false;
				} 
		}while (checkUserInput==false);
						
	}

}
