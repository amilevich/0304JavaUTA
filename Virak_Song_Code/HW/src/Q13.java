
public class Q13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		int y = 1;
		
		boolean T=true;
		
			//loop down
	      for (int i=1; i<=4; i++) {
	 
	         
	    	  //loop to the right
	         for (int j=0;j<i; j++) {
	        	if (T) {   // T is true
	            System.out.print(x);
	        	}else {  // T is false
	        	System.out.print(y);
	        	}
	        	T=!T; //change true to false or vice versa each time ending Horizental loop
	         }
	         System.out.println(); // new line end of horizental loop
	      }
		
				
		
			
	}
}
