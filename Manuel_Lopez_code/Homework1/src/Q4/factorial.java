package Q4;

public class factorial {

	public static void main(String[] args) {
		factorial(5);				//call factorial method
	}
	
	static void factorial(int x) {
		if(x==0) {
			System.out.println(1);					//if value passed is 0 print 1
		}
		else {										//else calculate factorial
			int temp=1;								
			for(int i=1; i<=x; i++) {
				temp=temp*i;						//use for loop to keep multiplying till n value or x in my case
				System.out.println(temp);			//print after each multiplication 
			}
			//System.out.println(temp);				//if you wanted just wanted to see factorial answer print outside of loop 
		}
	}

}
