package Users2;

import Users.AllUsers;
import accountObjects.AccountParent;

public interface consumerSide extends AllUsers {

	
	public void Login(String UserN, int PassW);
	public void Logout();


	public void Deposit(String AccoutName, float bal, AccountParent Account);
	
	public void Transfer(String AccoutName, String AccoutName2, float bal, AccountParent Account);

	public void Withdraw(String AccoutName, float bal, AccountParent Account);
	

	
//secure account method
}
