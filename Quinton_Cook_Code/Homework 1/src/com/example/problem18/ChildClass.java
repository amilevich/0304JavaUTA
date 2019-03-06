package com.example.problem18;

public class ChildClass extends BassClass {

	@Override
	public boolean checkUpper(String s) {
		if(s.matches(".*[A-Z].*+")) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public String lowerToUpper(String s) {
		
		return s.toUpperCase();
	}

	@Override
	public int toInteger(String s) {
		int sum = 0;
		
		for(char c : s.toCharArray()) {
			sum += c;
		}
		
		return sum+10;
	}

}
