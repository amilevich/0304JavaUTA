package com.homework.question18;

public class Child extends Uppercase {
	


	@Override
	public boolean CheckUpCase(String s) {
		
		String Caps="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		boolean T = false;
		
		for (int j=0; j<s.length(); j++) {
		
		
			for(int i=0; i<Caps.length();i++) {
				if (s.charAt(j)==Caps.charAt(i)){
					T = true;
					break;
				}else {
					T = false;
				}
				
			}
			if (T==true) {
				break;
			}
		}
		/*if (T==true) {
			System.out.println("The word has Upcase. It is True");
			
		}else {
			
			System.out.println("The word has no lower case. It is False");
		
			
		}*/
		return T;
	}

	@Override
	public String ConvertToUpCase(String s) {
		// TODO Auto-generated method stub
		return s.toUpperCase();
	}

	@Override
	public int ConvertToInt(String s) {
		// TODO Auto-generated method stub
		int x= Integer.parseInt(s)+10;
		return x;
	}
	
	
	


}
