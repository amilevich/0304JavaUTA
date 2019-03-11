package Users;

//import Users2.Customers;
import Users2.consumerSide;
import accountObjects.AccountObject;
import accountObjects.AccountParent;
import accountObjects.JointAccount;

public class Admins extends Employees implements consumerSide{

	
	public Admins (String UserN, int PassW) 
		{super(UserN, PassW);
		}
	@Override
	public void Login(String UserN, int PassW) {
		// TODO Auto-generated method stub
		
	}
	
	public void Delete(AccountObject Account) {}
	
	public void Delete(JointAccount Joint) {}
	
	public int changeAcctState() {return 0;}
	
	
	
	@Override
	public void Withdraw(String AccoutName, float bal, AccountParent Account) {
	}



	@Override
	public void Deposit(String AccoutName, float bal, AccountParent Account) {
		// TODO Auto-generated method stub
		
	}
	




	@Override
	public void Transfer(String AccoutName, String AccoutName2, float bal, AccountParent Account) {
		// TODO Auto-generated method stub		
	}




	//inherited methods
	
	//cancel accounts
	
	//specific account viewing priveleges
}
