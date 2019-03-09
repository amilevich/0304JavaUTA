package Q3;

public class Reverse {

	public static void main(String[] args) {
		reverse();		//call our reverse method
	}
	
	public static void reverse() {
		String x ="this";						//String to be reversed
		char list[] = x.toCharArray();			//convert our string to character array and store in array list[]
		for(int i =x.length()-1; i>=0; i--)		//iterate through array starting at array length instead of 0 while decrementing
		{
			System.out.print(list[i]);			//print the array character
		}
	}

}
