//Q6. Write a program to determine if an integer is
//even without using the modulus operator (%)

public class Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int m=0, n=4;
	// loop decrease by 2 until false in order exit the loop when n<=1;
	do {
		m = n - 2; 
		n = m ;
		//System.out.println(m);
	} while (n>1);
	
	if (n==1) {
		System.out.println("Odd");
	}else if (n==0) {
		System.out.println("even");
	}
	
	}

}
