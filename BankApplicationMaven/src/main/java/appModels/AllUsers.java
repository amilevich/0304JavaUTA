package appModels;

import java.util.List;

public interface AllUsers {

	//Login
		public void Login(String UserN, int PassW);
		//Logout
		public void Logout();
		
		public List<Accounts> ViewAccounts();
		
		
		//Username
		//String UserName;
		
		//PassWord
		//int Password;
		
		
}
