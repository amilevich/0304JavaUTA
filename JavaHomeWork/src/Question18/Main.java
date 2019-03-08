package Question18;


public class Main {

	public static void main(String[] args) {
		
		//Constructors
		ParentInterface x = new ChildClass();
		
		//Variables
		String s = "Hello World";
		String lowerCaseOnly = "goodbye world";
		String i = "10";
			
		//Methods and print
		System.out.println("Any upper case? -> " + x.checkUppercase(s));
		System.out.println("Any upper case? -> " + x.checkUppercase(lowerCaseOnly));
		System.out.println("Converting to upper case -> " + x.convertLowercase(s));
		System.out.println("Converting to upper case -> " + x.convertLowercase(lowerCaseOnly));
		System.out.println("Converting to integer and adding 10 -> " + x.convertString(i));
		
		
		
		
	}

}
