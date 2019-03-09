/*Q4. Write a program to compute N factorial. 
note: n! ex: 3! => 3x2x1*/

public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m=1; // intial m=1 and increase n by 1 every time multiple to have 5!=1*2*3*4*5
		for (n=1; n<5; n++) {
			
			m = (n+1) * m;
			
			//System.out.println(m);
		}
		
		System.out.println(m);
	}

}
