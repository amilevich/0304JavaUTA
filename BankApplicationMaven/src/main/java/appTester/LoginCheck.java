package appTester;

import static org.junit.Assert.*;


import org.junit.Test;


public class LoginCheck {



	@Test
	public void test() throws Exception {
		String UserN = "Jimmy"; int i = 123456;
		boolean check = LoginTester.CheckForCustomers(UserN, i, LoginTester.setUp());
		assertEquals(true,check);
		
	}

}
