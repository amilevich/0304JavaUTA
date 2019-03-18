package appTester;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckInt {

	@Test //Checks the CheckInt method on main driver
	public void test() {
		int num = 0; String string = "12345H";
		num = TestingSetup.CheckInt(num, string);
		assertEquals(1,num);
	}

}
