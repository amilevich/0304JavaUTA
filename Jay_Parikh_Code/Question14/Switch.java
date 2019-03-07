package Question14;

public class Switch {

	public static void main(String[] args) {
		int i = 3;    //which case you want from the switch statement
		
		switch(i){
		//case 1 performs the square root of a double 
        case 1:   
        	double d = 9;       
            System.out.println(Math.sqrt(d));
            break;
        //case 2 prints out the date
        case 2: 
            System.out.println("Today is 3/7/19");
            break; 
        //case 3 splits the sentence into an array of words that were separated by a space(" ") 
        case 3: 
            String str = "I am learning Core Java"; 
            String[] strSplit = str.split(" ");
            for(String s : strSplit) {   //print statement for all strings in the strSplit array
            	System.out.println(s);
            }
            break; 
		}
	}
}
