
public class Q16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		int i = 0;
		int j = 0;
	
		for (String s: args) { //read each word at a time
            System.out.print(s); // Print each word
            i = s.length();     // count number of character 
            j=j+i;              // keep count number of character 
            System.out.print(" "); // print space
            
           System.out.println(i);  //print number of character each time
            
        }
		System.out.println("The number of character is " + j);  // print total of character
		
		
		
	}

}
