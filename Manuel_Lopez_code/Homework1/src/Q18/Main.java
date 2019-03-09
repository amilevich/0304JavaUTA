package Q18;

public class Main {

	public static void main(String[] args) {
		
		Interface x = new Child();																		//constructors
		
		String s = "This String";																		//
		String lowerCaseOnly = "this other string";															//variables
		String i = "17";																				//
			
		System.out.println("Any upper case? -> " + x.checkUpperCase(s));								//method to check upper case
		System.out.println("Any upper case? -> " + x.checkUpperCase(lowerCaseOnly));					//method to check upper case
		System.out.println("Converting to upper case -> " + x.convertLowerCase(s));						//method to convert to upper case
		System.out.println("Converting to upper case -> " + x.convertLowerCase(lowerCaseOnly));			//method to convert to upper case
		System.out.println("Converting to integer and adding 10 -> " + x.convertString(i));				//method to convert integer and add 10
	}

}
