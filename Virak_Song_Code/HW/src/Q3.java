
public class Q3 {

	//Q3. Reverse a string without using a temporary variable.  
	//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hey!";
		
		System.out.println(s);
		
		//loop from high index of String
		for (int i=s.length()-1; i>=0; i--) {
			char result = s.charAt(i);
			System.out.print(result);
		}
		
	}

}
