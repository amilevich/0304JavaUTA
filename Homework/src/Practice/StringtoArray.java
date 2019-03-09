package Practice;

public class StringtoArray {
	
	public static void main(String[] args) {
		String str = "Yousef Mohammed";
		char array[] = new char[15];
		
		str.getChars(0, 15, array, 0);
		
		System.out.println(array);
		
	} 

}
