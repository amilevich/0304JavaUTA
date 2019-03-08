package question18;

public class Dog extends Animal {
	
	void method1(String userString) {
		boolean stringHasUppercase = !userString.equals(userString.toUpperCase()); //returns true if "userString" contains at least one uppercase letter
		if(!stringHasUppercase) {
			System.out.println("True, string contains uppercase letter(s)\n");
		}
		else {
			System.out.println("False, string does NOT contain uppercase letter(s)\n");
		}
	};
	
	void method2(String userString) {
		String userStringUppercase = userString.toUpperCase();
		System.out.println("Your uppercase string: " + userStringUppercase + "\n");
		//return userStringUppercase;
	}
	
	void method3(String userString) { //this method could potentially take in a String
		//String numberString = userString; //"numberString" is a String, but the String is a number
		int stringToInt = Integer.parseInt(userString);
		System.out.println("Your string is now an integer: " + stringToInt);
		System.out.println("Proof of this: " + userString + " + " + "10" + " = " + (stringToInt+10));
		//System.out.println("Proof that your string is now an integer: " + stringToInt + 1);
	}

}

//if(!hasUppercase)System.out.println("Must have an uppercase Character");
//boolean hasUppercase = !password.equals(password.toLowerCase());
//ch = scan.next().charAt(0);