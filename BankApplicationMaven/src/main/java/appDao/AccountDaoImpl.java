package appDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Logger;

import appModels.Accounts;
import appModels.Customer;
import appModels.Employee;

public class AccountDaoImpl implements AccountDao {

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cmseb0jui8wp.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "AlimWooden"; //Username
	private static String password = "Donkey123"; //Password
		
	//Logger Log = Logger.getGlobal();
	
	@Override
	public int insertAccount(Accounts A) {//COMMITS AT END
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Accounts VALUES(?,?,?,?,?,?,?)");//NUMBER OF QUESTION MARKS CORRESPOND TO TABLE COLUMNS
					ps.setInt(1, A.getAutoGeneratedNum());//sequence variable may have to switch to null
					ps.setString(2, A.getAccount_Name());
					ps.setString(3, A.getUsername1());
					ps.setString(4, A.getUsername2());
					ps.setString(5, A.getAccount_type());
					ps.setInt(6, A.getBalance());
					ps.setInt(7, A.getAccount_State());
					ps.executeQuery();
					//Log.info("Account was created");
		}
		catch(SQLException e){e.printStackTrace();}
		
		return 0;//for debugging purposes
	}
	
	
	@Override
	public Accounts selectOneCustAccount(int AC) {
		Accounts account = null;
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("Select *  FROM Accounts WHERE account_Number=?");//NUMBER OF QUESTION MARKS CORRESPOND TO TABLE COLUMNS
			ps.setInt(1, AC);
			ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						account = new Accounts (rs.getString("account_Name"), rs.getString("customer_Username"), rs.getString("customer_Username2"), rs.getString("account_Type"), rs.getInt("account_Balance"), rs.getInt("account_State"));
					}
		}catch(SQLException e) {e.printStackTrace();}
		return account;
	}	


	@Override
	public ArrayList<Accounts> selectCustAccounts(String Username1) {
		ArrayList<Accounts> accounts = new ArrayList<Accounts>();
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("Select *  FROM Accounts WHERE customer_Username=?");//NUMBER OF QUESTION MARKS CORRESPOND TO TABLE COLUMNS
			ps.setString(1, Username1);
			ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						accounts.add(new Accounts (rs.getInt("account_Number"),rs.getString("account_Name"), rs.getString("customer_Username"), rs.getString("customer_Username2"), rs.getString("account_Type"), rs.getInt("account_Balance"), rs.getInt("account_State")));
					}
		}catch(SQLException e) {e.printStackTrace();}
		return accounts;
	}

	@Override
	public ArrayList<Accounts> selectAllAccounts() {
		ArrayList<Accounts> accounts = new ArrayList<Accounts>();
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = conn.prepareStatement("Select *  FROM Accounts");//NUMBER OF QUESTION MARKS CORRESPOND TO TABLE COLUMNS
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						accounts.add(new Accounts (rs.getInt("account_Number"),rs.getString("account_Name"), rs.getString("customer_Username"), rs.getString("customer_Username2"), rs.getString("account_Type"), rs.getInt("account_Balance"), rs.getInt("account_State")));
					}
		}catch(SQLException e) {e.printStackTrace();}
		return accounts;
	}

	@Override
	public int updateAccount(Accounts a) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("UPDATE Accounts SET account_State=?, account_Name=?, customer_Username=?, customer_Username2=?, account_Type=?, account_Balance=? WHERE account_Number=?");
			ps.setInt(1, a.getAccount_State());
			ps.setString(2, a.getAccount_Name());
			ps.setString(3, a.getUsername1());
			ps.setString(4, a.getUsername2());
			ps.setString(5, a.getAccount_type());
			ps.setInt(6, a.getBalance());
			ps.setInt(7, a.getAutoGeneratedNum());
			//Log.info("Approaching Update");
			ps.executeUpdate();
			//Log.info("Executing Update");
		}catch(SQLException e){ e.printStackTrace();}
		return 0;
	}

	@Override
	public int deleteAccount(Accounts A , Employee E) {
		if (E.getAdmin_privileges() == 1) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Accounts WHERE account_Number=?");
			ps.setInt(1, A.getAutoGeneratedNum());
			ps.executeUpdate();
		}catch(SQLException e){ e.printStackTrace();}}
		
		else {System.out.println("You Don't Have Access");}
		return 0;
	}

	@Override
	public int Withdraw(Accounts A, int request, Customer C) {
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			CallableStatement cs = conn.prepareCall("{CALL WITHDRAW(?,?,?,?,?)}");
			cs.setInt(1, request);
			cs.setString(2, C.getUsername());
			cs.setInt(3, A.getAutoGeneratedNum());
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.INTEGER);
			//Log.info("Query Approached");
			cs.executeQuery();
			//Log.info("Query executed");
			String message = cs.getString(4);
			int balance = cs.getInt(5);
			System.out.println("" + message + "Your Remaining balance " + balance);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	

	@Override
	public int Deposit(Accounts A, int request,Customer C) {
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			CallableStatement cs = conn.prepareCall("{CALL DEPOSIT(?,?,?,?,?)}");
			cs.setInt(1, request);
			cs.setString(2, C.getUsername());
			cs.setInt(3, A.getAutoGeneratedNum());
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.INTEGER);
			//Log.info("Query Approached");
			cs.executeQuery();
			//Log.info("Query executed");
			String message = cs.getString(4);
			//Log.info(message);
			int balance = cs.getInt(5);
			System.out.println("" + message + "Your Remaining balance " + balance);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int Transfer(Accounts A, Accounts B, int request) {
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			CallableStatement cs = conn.prepareCall("{CALL TRANSFER(?,?,?,?,?,?)}");
			cs.setInt(1, request);
			cs.setInt(2, A.getAutoGeneratedNum());
			cs.setInt(3, B.getAutoGeneratedNum());
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.INTEGER);
			cs.registerOutParameter(6, Types.INTEGER);
			//Log.info("Query Approached");
			cs.executeQuery();
			//Log.info("Query executed");
			String message = cs.getString(4);
			int balance1st = cs.getInt(5);
			//int balance2nd = cs.getInt(6);
			System.out.println("" + message + "Your Remaining balance " + balance1st);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int AutoApproveDeny(Customer C) {
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			CallableStatement cs = conn.prepareCall("{CALL Approve_Deny(?,?,?)}");
			cs.setInt(1, C.getCreditscore());
			cs.setString(2, C.getUsername());
			cs.registerOutParameter(3, Types.VARCHAR);
			//Log.info("Auto Approved Query Approached");
			cs.executeQuery();
			//Log.info("Auto Approved Query Executed");
				String message = cs.getString(3);
				//Log.info(message);		

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public int Withdraw(Accounts A, int request, String UserName) {
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			CallableStatement cs = conn.prepareCall("{CALL WITHDRAW(?,?,?,?,?)}");
			cs.setInt(1, request);
			cs.setString(2, UserName);
			cs.setInt(3, A.getAutoGeneratedNum());
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.INTEGER);
			//Log.info("Query Approached");
			cs.executeQuery();
			//Log.info("Query executed");
			String message = cs.getString(4);
			int balance = cs.getInt(5);
			System.out.println("" + message + "Your Remaining balance " + balance);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public int Deposit(Accounts A, int request, String UserName) {
		try (Connection conn = DriverManager.getConnection(url,username,password)){
			CallableStatement cs = conn.prepareCall("{CALL DEPOSIT(?,?,?,?,?)}");
			cs.setInt(1, request);
			cs.setString(2, UserName);
			cs.setInt(3, A.getAutoGeneratedNum());
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.INTEGER);
			//Log.info("Query Approached");
			cs.executeQuery();
			//Log.info("Query executed");
			String message = cs.getString(4);
			//Log.info(message);
			int balance = cs.getInt(5);
			System.out.println("" + message + "Your Remaining balance " + balance);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}


}
