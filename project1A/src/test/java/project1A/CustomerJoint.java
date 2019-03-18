package project1A;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerJoint {
	@Test
	public void check() {
		TestingClass T = new TestingClass();
		
		assertEquals("this should be true",true,T.check(true));
	}

}
