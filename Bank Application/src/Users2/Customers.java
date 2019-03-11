package Users2;

import accountObjects.AccountObject;
import accountObjects.AccountParent;
import accountObjects.JointAccount;
import appDriver.MasterInfoFile;

public class Customers implements consumerSide {

	
	//Customer UserName
	public String Custname;
	
	//Customer Password
	public int password;
	
	//Social Security Number
	public int SSN;
	
	//Account Tracker
	public int acctTRKR = 0;
	
	//Variable to keep track of how many accounts customer has
	AccountParent[] AccountTraker = new AccountParent[5];
	
	
	public Customers(String Custname, int passW) {
		this.Custname = Custname;
		this.password = passW;
	}
	
	public Customers(String custname, int password, int sSN) {
		super();
		this.Custname = custname;
		this.password = password;
		this.SSN = sSN;
	}




	public int getSSN() {
		return SSN;
	}

	public void setSSN(int sSN) {
		SSN = sSN;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}


	public String getCustname() {
		return Custname;
	}

	public void setCustname(String custname) {
		Custname = custname;
	}

	

	@Override
	public void Login(String UserN, int PassW) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Logout() {
		System.out.println("Thank you, come again!");
		System.exit(0);
	}

	
	@Override
	public void Withdraw(String AccoutName, float bal, AccountParent Account) {
		if ((Account.getBalance()-bal) < 0) {
			//throw exception
		}
		else {
			Account.balance = Account.balance - bal;
		}
	}
	
	@Override
	public void Deposit(String AccoutName, float bal, AccountParent Account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Transfer(String AccoutName, String AccoutName2, float bal, AccountParent Account) {

		
	}


	
	
public AccountObject AccountCreate(String fName, String lName, int ssty, String UserN, String accountName) {
	AccountObject Acct = new AccountObject (fName, lName, ssty, UserN, accountName);
	return Acct;
	}
	
public JointAccount JAccountCreate(String FN1, String FN2, String LN1, String LN2, int SSN1, int SSN2, String UserN1, String UserN2, String accountname) {

	String[] firstN = {FN1,FN2};
	String[] lastN = {LN1,LN2};
	Integer[] SSN = {SSN1,SSN2};
	String[] UserN = {UserN1,UserN2};
	
	JointAccount JA = new JointAccount(firstN, lastN, SSN, UserN, accountname ); 
	return JA;
}
	// specific account viewing privileges

public void PushToQue(AccountObject AO) {MasterInfoFile.que.add(AO);}

public void PushToQue(JointAccount JAO) {MasterInfoFile.qu.add(JAO);}

public Customers Register(String UserN, int password, int SSN) {
	Customers customer = new Customers(UserN, password, SSN);
	//make exception to throw
	return customer;
}


	
}
