package Question5;

public class Substring {
	
		public static void main(String[] args) {
			
			String str = "Hello World";
			int idx = 6;	
			System.out.println(subString(str, idx)); //call method
			
		}
		
		
		public static String subString(String str, int idx) { //Method
			char[] s1 = str.toCharArray();					  //Convert str to array and give variable s1
			char ans[] = new char[idx];						  //Initialize array ans with size that we need
			for(int i = 0; i < idx -1; i++) {				  //Loop through from 0 - idx -1 or else we get exception
				ans[i] = s1[i];								  //set ans = s1 but only up until we hit the length idx - 1 that we want
			}
			
			//System.out.println(ans); 						  //print to check
			return String.copyValueOf(ans);					  //return
		}
}
