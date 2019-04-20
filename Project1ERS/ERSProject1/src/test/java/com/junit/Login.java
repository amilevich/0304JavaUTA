package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Login {

	Values tester = new Values();
	
	@Test
	public void areUsersEqual() {
		assertEquals("Should be equal", true, tester.areUsersEqual("Bob", "Bob"));
		System.out.println("method to check for equality of strings");
	}
}
