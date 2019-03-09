
public class Q12 {
	public static void main(String[] args) {
		int[] a = new int[100];
		int j=1;
		int k=0;
		for (int i=0; i<100; i++) {
			a[i]=j++;	
		}
		for (int i:a) {
			k=a[i-1];
			if (k%2 !=0) {
			System.out.print(a[i-1] +" ");
			}
				
		}
			
		
	}
}
