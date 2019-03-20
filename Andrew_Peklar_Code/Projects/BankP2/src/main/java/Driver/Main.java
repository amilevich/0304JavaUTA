package Driver;
import com.dbbank.dao.*;
import com.dbbank.model.*;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;



//import oracle.jdbc.*;
import org.apache.log4j.Logger;
public class Main {
	
	
	public static Scanner scan = new Scanner(System.in);
	final static Logger logger = Logger.getLogger(Main.class.getName());
	
	
	public static void main(String[] args) {
		//SchemaUtils.viewUsers();
		mainMenu();
	}

	
	public static void mainMenu() {
		// header
		logger.info("Main Menu Entered");
		System.out.println("\r\n" + "\t                                    __            \r\n"
				+ "\t|  | _| _ _  _  _  |_ _   |_|_  _  |__) _  _ |   \r\n"
				+ "\t|/\\|(-|(_(_)|||(-  |_(_)  |_| )(-  |__)(_|| )|(  \r");
		// user prompt
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Please select an option matching a value: \r" + "\n\t 1. Login to account"
				+ "\n\t 2. Register for an account" + "\n\t 3. Perform a safe Shut Down");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("Option: \t");

		// loop through inputs until valid

	//	String menuInputs = menuInput(3, scan.next());

		// route from selection
		switch (scan.next()) {
		case "1":
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			login();
			break;
		case "2":
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			register();
			break;
		case "3":
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("\r\n" + 
					"                                                                                                                                             \r\n" + 
					"                                                                                                      ,,                                     \r\n" + 
					"`7MMF'  `7MMF'                                    db            .g8\"\"\"bgd                           `7MM      `7MM\"\"\"Yb.                     \r\n" + 
					"  MM      MM                                     ;MM:         .dP'     `M                             MM        MM    `Yb.                   \r\n" + 
					"  MM      MM   ,6\"Yb.`7M'   `MF'.gP\"Ya          ,V^MM.        dM'       `   ,pW\"Wq.   ,pW\"Wq.    ,M\"\"bMM        MM     `Mb  ,6\"Yb.`7M'   `MF'\r\n" + 
					"  MMmmmmmmMM  8)   MM  VA   ,V ,M'   Yb        ,M  `MM        MM           6W'   `Wb 6W'   `Wb ,AP    MM        MM      MM 8)   MM  VA   ,V  \r\n" + 
					"  MM      MM   ,pm9MM   VA ,V  8M\"\"\"\"\"\"        AbmmmqMA       MM.    `7MMF'8M     M8 8M     M8 8MI    MM        MM     ,MP  ,pm9MM   VA ,V   \r\n" + 
					"  MM      MM  8M   MM    VVV   YM.    ,       A'     VML      `Mb.     MM  YA.   ,A9 YA.   ,A9 `Mb    MM        MM    ,dP' 8M   MM    VVV    \r\n" + 
					".JMML.  .JMML.`Moo9^Yo.   W     `Mbmmd'     .AMA.   .AMMA.      `\"bmmmdPY   `Ybmd9'   `Ybmd9'   `Wbmd\"MML.    .JMMmmmdP'   `Moo9^Yo.  ,V     \r\n" + 
					"                                                                                                                                     ,V      \r\n" + 
					"                                                                                                                                  OOb\"       \r\n" + 
					"");
			scan.next();
			break;
		default: // should be impossible to reach here
			System.out.println("\n\n\n\n\n\n\n");
			mainMenu();
			break;
		}
	}
	
	private static void register() {
		// TODO Auto-generated method stub
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t\t\tREGISTRATION");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("To go back, simply enter \"b\"");

		System.out.print("\nPlease enter your desired username: \t");
		String username = scan.next();
		if (username.equals("b"))		mainMenu();

		System.out.print("\nPlease enter a password: \t");
		String password = scan.next();
		if (password.equals("b"))		mainMenu();
		
		new UserDaoImpl().unregisteredUser(username, password);
		System.out.println("\n\n\n\n\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		System.out.println("\t\t\t    THANK YOU");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		System.out.println("\t\tThanks for applying to our bank!");
		System.out.println("\tAn associate will verify your application shortly.");
		System.out.println("You will not be able to log in until our review process is complete");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n\n\n");
		System.out.println("Enter any key to retrun to main menu");
		scan.next();
		System.out.println("\n\n\n\n\n\n");
		mainMenu();


	}


	private static void login() {
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t\t\tLOGIN SCREEN");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("To go back, simply enter \"b\"");

		System.out.print("\nPlease enter your Username: \t");
		String username = scan.next();
		if (username.equals("b"))		mainMenu();

		System.out.print("\nPlease enter your Password: \t");
		String password = scan.next();
		if (password.equals("b"))		mainMenu();
		
		while(!SchemaUtils.UserLoginCheck(username, password)) {
			System.out.println("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Invalid Username or Password!\n\nPlease try again...");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n");
			System.out.print("\nPlease enter your Username: \t");
			username = scan.next();
			if (username.equals("b"))		mainMenu();

			System.out.print("Please enter your Password: \t");
			password = scan.next();
			if (password.equals("b"))		mainMenu();
		}
		
		int i = SchemaUtils.setUser(username, password).getAccountType();
		SchemaUtils.userCheck();
		
		switch(i) {
			case 0 :
				customerMenu(new CustomerDaoImpl().selectCustomerByID(SchemaUtils.getUser().getUserID()));
				break;
			case 1 :
				employeeMenu(SchemaUtils.getUser());
				break;
			case 2 : 
				adminMenu(SchemaUtils.getUser());
				break;
			default:
				System.out.println("\n\nAccount is waiting for approval from an administratior.");
				System.out.println("Please try again later...\n\n");
				mainMenu();
		}

	}



	public static void adminMenu(Users thisUser) {
		System.out.println("\n\n\n\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\t\t\tADMIN MENU");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		//System.out.println(thisUser.toString());
		// TODO Auto-generated method stub
		int input = -1;
		System.out.println("Hello " + thisUser.getUserName());
		System.out.println("Please select an option: ");
		System.out.print("\t 1. View Single Users Account" + 
					   "\n\t 2. View Applications" + 
					   "\n\t 3. Withdraw Customer Funds"+ 
					   "\n\t 4. Deposit Customer Funds" + 
					   "\n\t 5. Transfer funds between" + 
					   "\n\t 6. Delete User/Accounts" + 
					   "\n\t 7. List All Customers" + 
					   "\n\t 8. List all Accounts on file" + 
					   "\n\t 9. Logout");
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("Options:\t");

		while (!scan.hasNextInt()) {
			System.out.println("\n\n\tINVALID ENTRY! \n\tPlease try again...");
			System.out.print("\n\nOptions: :\t");
			scan.next();
		}
			
		input = scan.nextInt();
		
                            
		switch (input) {
		case 1:
			System.out.println("\n\n\n\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t\t\tACCOUNTS");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			SchemaUtils.viewUserAccounts();
			break;
		case 2:
			System.out.println("\n\n\n\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t\t\tAPPLICATIONS");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			SchemaUtils.viewApplications();
			break;
		case 3:
			SchemaUtils.withdrawFromCustomer();
			break;
		case 4:
			SchemaUtils.depositToCustomer();
			break;
		case 5:
			SchemaUtils.transferFromCustomer();
			break;
		case 6:
			System.out.println("\n\n\n\n\n\n\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t\t\tDELETION");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			SchemaUtils.deleteUser();
			break;
		case 7:
			SchemaUtils.listCustomers();
			scan.next();
			break;
		case 8:
			SchemaUtils.listAllAcounts();
			scan.next();
			break;
		case 9:
			mainMenu();
			break;
		default:
			System.out.println("Something went horribly wrong!");
		}
		adminMenu(thisUser);
	}


	private static void employeeMenu(Users thisUser) {
		// TODO Auto-generated method stub
		System.out.println("\n\n\n\n\t\t\t ---------- IN THE Employee MENU ----------");
		System.out.println(thisUser.toString());
		
	}


	private static void customerMenu(Customer selectCustomerByID) {
		System.out.println("\n\n\n\n\t\t\t ---------- IN THE CUSTOMER MENU ----------");
		System.out.println(selectCustomerByID.toString());
		scan.next();
		mainMenu();
	}

	
}
