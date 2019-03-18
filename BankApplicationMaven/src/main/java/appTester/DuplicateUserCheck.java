package appTester;

import static org.junit.Assert.*;

import org.junit.Test;

public class DuplicateUserCheck {


	@Test
	public void test() throws Exception {
		String UserN = "Jimmy";
		boolean check = DuplicateUserTester.CheckForDuplicateUser(UserN, DuplicateUserTester.setUp());
		assertEquals(true, check); //true means duplicate
	}

}
