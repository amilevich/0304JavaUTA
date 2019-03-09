package com.problem18;

public class Child extends SuperAbstract {

	@Override
	public boolean isUpperCase(String str) {
		boolean check1 = !str.equals(str.toLowerCase()); //if all lowercase, it will return false
		System.out.println(check1);
		return check1;
	}

	@Override
	public String toUpperCase(String str) {
//		for(int i=0; i<str.length(); i++) {
//			if(str.charAt(i).equals(str.charAt(i).toLowerCase())) {
//				
//			}
//		}
		return str;
	}

	@Override
	public int toInteger(String int1) {
		int conversion = Integer.parseInt(int1);	 //converts to integer
		conversion += 10; //add 10
		System.out.println(conversion);
		return conversion;
	}



}
