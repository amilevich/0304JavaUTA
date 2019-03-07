package Question2;

public class Main {
	public static void main(String[] args) {
		
		int x = 0;						//Starting case
		int y = 1;
		int ans = 0;
		System.out.println("0: " + x);	//print
		System.out.println("1: " + y);
		for(int i = 2; i < 26; i++) {	//loop to find the rest of the numbers
			ans = x + y;				//add to find current fibonacci number
			x = y;						//update numbers we need to add
			y = ans;
			System.out.println(i + ": " + ans);	//print
			
		}
	}
}
