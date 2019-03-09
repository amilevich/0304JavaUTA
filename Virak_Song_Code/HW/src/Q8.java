import java.util.ArrayList;

public class Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("karan");
		arrayList.add("madam");
		arrayList.add("tom");
		arrayList.add("civic");
		arrayList.add("radar");
		arrayList.add("sexes");
		arrayList.add("jimmy");
		arrayList.add("kayak");
		arrayList.add("john");
		arrayList.add("refer");
		arrayList.add("billy");
		arrayList.add("did");
	ArrayList<String> arrayPalidrom = new ArrayList<String>();
	
	    for (String i:arrayList) {
	    	System.out.print(i +" ");
	    	
	    }
	    System.out.println("");
				
		//loop in arrayList
		for (String i:arrayList) {
			String s = i; // store each element of arrayList to string variable
			
		//	System.out.print(" test "+ s);
			
			String result="";			// initial new string each time of loop
			for (int k=s.length()-1; k>=0; k--) {
				result = result+ s.charAt(k);	//reverse string using charAt and connection String to be a string
			}
			// s and result match is palindromes, add to new arrayList
			//System.out.print(" test2 "+ result);
			if (s.equals(result)) {// if String object is equal to each other add to new arrayList 
				arrayPalidrom.add(s);
			}
			
		}
		//System.out.println("");
		//System.out.println("size"+arrayPalidrom.size());
		System.out.println("This is Palidrom");
		for (String i:arrayPalidrom) {
			System.out.print(i+" ");
		}
	
	}

}
