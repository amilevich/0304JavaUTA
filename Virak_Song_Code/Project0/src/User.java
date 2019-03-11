
import java.io.IOException;

import com.bank.office.App;
import com.bank.office.adminClass;

public class User {
	
	String menu ;
	
	public User (String u) {
		menu = u;
	}
	
	public void run() throws IOException {
	boolean t = false;	
		
		do {
			switch (this.menu) {
				case "admin": 
						//call method admin 
						//admin can have all access
						//System.out.println("call admin can have all acess");
				{
					
					adminClass admin = new adminClass();
					admin.run();
					t = true;
				}
						
						break;
				case "employee": // call method emp
					System.out.println("call Emp can veiw all customer account");
						t = true;
						break;
				case "customer": // call method customer 
					System.out.println("call Cust only view");
					App app=new App();
					//app.search();
						t = true;
						break;
			}
		}while (t==false);

	}

}
