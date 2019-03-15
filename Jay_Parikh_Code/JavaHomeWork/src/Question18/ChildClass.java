package Question18;

//Inheriting from abstract class
public class ChildClass extends ParentInterface {

	//Method to check uppercase
	public Boolean checkUppercase(String s) {
		
		for(int i = 0; i < s.length(); i++) {         //Loop through string
			if(Character.isUpperCase(s.charAt(i))) {  //If found uppercase string
				return true;						  //then return true
			}	
		}
		return false;			//No uppercase strings? then return false
	}
	
	//Method to convert to uppercase
	public String convertLowercase(String s) {
		String up = s.toUpperCase();	//Convert all lowercase strings to uppercase
		return up;		//return
	}
	
	//Method to convert string to int and add 10
	public Integer convertString(String s) {   
		int i = Integer.parseInt(s);	//i turns into integer version of string
		return i + 10;					//return the integer version + 10
	}
	
}
