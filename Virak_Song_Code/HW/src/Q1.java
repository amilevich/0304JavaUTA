
public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	int[] a= {1,0,5,6,3,2,3,7,9,8,4};
	int swap = -1 ;
	
	System.out.println("Before bubble sorting " + a.length);
	for (int j=0; j<a.length; j++) {
		System.out.print(a[j] + " ");
	}
	
	//swap is not 0 continoue loop
	while (swap!=0) {
		swap = 0;//reset swap to zero
		//loop entire array
		for (int i=0; i<a.length-1; i++) {
			
			if (a[i]>a[i+1]) {
					//swap array if a[i]>a[i+1]
					int temp = a[i+1];//store second element in temp
					a[i+1] = a[i]; // store first element in the second
					a[i] = temp;
					swap++; // keep track swap 
			}
			
		}
		System.out.print(swap);
		
	}
	
	
		System.out.println("After bubble sorting");
			for (int j=0; j<a.length; j++) {
			System.out.print(a[j] + " ");
			}
		
	}

}
