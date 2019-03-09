
public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		int F0 = 0;
		int F1 = 1;
		int F2 = 0;
		
		System.out.print(F0 +" "+ F1 + " ");
		
		for (int i = 0; i<25; i++) {
			
			F2 = F0 + F1;
			System.out.print(F2 + " ");
						
			F0 = F1; // move backward one step for F0 store value F1
			F1 = F2; // move backward one step for F1 store value F2
		}
		
	}

}
