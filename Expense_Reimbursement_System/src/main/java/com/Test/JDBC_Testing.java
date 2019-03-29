package com.Test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Model.Reimbursement;
import com.Model.User;
import com.Reimbursement.Dao.ReimbursementDaoImpl;
import com.User.Dao.UserDaoImpl;


public class JDBC_Testing {

static UserDaoImpl UDI = new UserDaoImpl();
static ReimbursementDaoImpl RDI = new ReimbursementDaoImpl();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		UDI.insertUser(new User("JimmyD","123456","Jay","3Legs","Jay3Legs",1));
		RDI.insertReimbursement(new Reimbursement(23.4,"JimmyD","Went to Reynosa",0,"Travel"));
	}

	@Test
	public void test() {
		User FM = UDI.selectUserByName("JimmyD");
		String First = FM.getFirstName();
		assertEquals("Jay",First);				
	}
	
	@Test
	public void test2() {
		ArrayList<Reimbursement> RIM = (ArrayList<Reimbursement>) RDI.selectAllReimbursementsByName("JimmyD");
		Reimbursement RMBR = RIM.get(0);
		Timestamp tm = RMBR.getSubmitTime();
		System.out.println(tm);
		String Username = RMBR.getTicketAuthor();
		assertEquals("JimmyD",Username);
	}
	
	@AfterClass
	public static void reset() {
		UDI.deleteUser("JimmyD");
		
	}
}
