package question18;

public class Main {

	public static void main(String[] args) {
		
		String [] t1 = {"9", "thiS iS A seNteNce", "HELLO"};
		LowClass Lowdy = new LowClass();
		
		// check if string is uppercase or not
		// note: strings with no alphabetical chars evaluate ato true by default
		int idx = t1.length;
		while(--idx != -1)
			System.out.println("Is " + t1[idx]  + " all uppercase? " + Lowdy.isItUppercase(t1[idx]));
		
		// Testing makeUppercase method
		System.out.println("\n\nTo Uppercase: \"" + t1[1] + "\" ------> \"" + Lowdy.makeUppercase(t1[1]) 
																							 +"\"\n\n");
		
		// Testing numerical string --> int
		// subtracted 10 in print statement below to offset the "+ 10" 
		System.out.printf("t1[0] = %d ------> %d - 10 = %d ------> %d + 9 = %d\n", Lowdy.stringToInt(t1[0]),
				  Lowdy.stringToInt(t1[0]), Lowdy.stringToInt(t1[0])-10, Lowdy.stringToInt(t1[0])-10, 
				  (Lowdy.stringToInt(t1[0])-10 + 9));
		
		// Testing alphabetical string --> sum of String ASCII values + 10
		System.out.println("String \"" + t1[1] + "\" ------> \"" + Lowdy.stringToInt(t1[1]) +"\"");
			
	}

}
