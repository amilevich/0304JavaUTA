import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.bank.office.App;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner userInput = new Scanner(System.in);  // Create a Scanner object

		boolean t= false;
		do {
			System.out.println("Please Enter following key word to be continous.");
			System.out.println("register");
			System.out.println("login");
			System.out.println("exit");
			String s = userInput.nextLine();  // Read user input
			
		    switch (s){
		    	case "register": {
		    		//System.out.println("call register class");
		    		//App reg = new App();
		    		App.registerAccount(true);
		    		t = true;
		    		break;
		    	}
		    	case "login": {
		    		// need code search from text file whethr the user is admin, employee or customer roll.
		    		//String record="admin";// temporily hard code should be earch in text file to call as admin
		    		//System.out.println("call login/user class");
		    		System.out.println("Please Enter following key word to be continous.");
		    		System.out.println("admin");
		    		System.out.println("employee");
		    		System.out.println("customer");
		    		
		    		String record = App.input();
		    		User user = new User(record);
		    			try {
							user.run();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    		t = true;
		    		break;
		    	}
		    	case "exit": {
		    		System.out.println("Exit");
		    		t = true;
		    		System.exit(1);
		    		break;
		    	}
		    	default: System.out.println("Please your input is invalid");
		    		
		  }	    	
	    }while (t==false);
		
		
		
		
		
		/*Scanner userInput = new Scanner(System.in); 
		System.out.println("Enter username to register account:");
		String userName = userInput.nextLine();  // Read user input
		*/
		
	/*	ArrayList<Byte> list = new ArrayList<Byte>(); 
		for (byte i = 0; i < 10; i++) { 
		list.add(i); 
		} 
		Collections.shuffle(list); 
		String s="";
		for (byte i = 0; i < 10; i++) { 
			s=s+list.get(i).toString();
			}
		System.out.println(s); 
*/	
		
		
		
		/*User menuAdmin = new User("admin");
		User menuEmployee = new User("employee");
		User menuCustomer = new User("customer");
		
		menuAdmin.myUser();
		menuEmployee.myUser();
		menuCustomer.myUser();
		*/
		
		
		
	}

}
