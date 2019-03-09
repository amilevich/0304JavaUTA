package Q18;

public class Child extends Interface{
	
	
	public Boolean checkUpperCase(String x) {			//method to check uppercase
														//
		for(int i = 0; i < x.length(); i++) {        	//iterate through string
			if(Character.isUpperCase(x.charAt(i))) {    //If found uppercase string,
				return true;						    //return true
			}											//
		}												//
		return false;									//if no uppercase strings then return false
	}
	
	
	public String convertLowerCase(String x) {			//method to convert to uppercase
		String up = x.toUpperCase();					//Convert all lowercase strings to uppercase
		return up;										//return string
	}
	

	public Integer convertString(String x) {   			//method to convert string to int and add 10
		int i = Integer.parseInt(x);					//i turns into integer string version
		return i + 10;									//return the integer + 10
	}
}
