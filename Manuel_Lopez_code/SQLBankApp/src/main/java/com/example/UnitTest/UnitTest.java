package com.example.UnitTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.example.User.User;

public class UnitTest {
	
	public UnitTest() {
		
	}
	
	private static String url = "jdbc:oracle:thin:@myfreedatabase.crugo2u5mbej.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "meme7";
	private static String password = "Arkange1";
	
	@Before
	public void before() {
		System.out.println("Starting new test");
	}
	
	@After
	public void after() {
		System.out.println("Test completed");
	}
	
	//Customer Tests*****************************
	@Test
	public void makeDeposit() {
		User user = new User("Test", "Chester");
		User c = new User();
		c.setUserName(user.getUserName());
		//assertEquals("this should be true", true, c.makeDeposit(100));
		//assertEquals("should be true", true, c.makeDeposit(100));
		c.setAcctNum(100);
		System.out.println(c.getFirstName()); // this should be 200
		if(c.getUserAcctStatus()==200)
			System.out.println("deposit success");
	}

	@Test
	public void makeWithdrawl() {
		User user = new User("Chester", "Test_Chester");
		User c = new User();
		c.setUserName(user.getUserName());
		int with=200;
		if(with<=100) {
			c.getUserKey(); // this should be allowed because withdrawlAmount is 100 or less
			System.out.println("withdrawl success");
		}
		else {
			System.out.println("withdrawl failure"); //which is also kinda a success
		}
	}
	
	@Test
	public int withdraw(int acctNum, double w) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ACCOUNTS SET balance=? WHERE acct_num=?");
			ps.setDouble(1, w);
			ps.setInt(2, acctNum);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Test
	public int deposit(int acctNum, double d) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE ACCOUNTS SET balance=? WHERE acct_num=?");
			ps.setDouble(1, d);
			ps.setInt(2, acctNum);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
