import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Q14 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		//request= "Square", "DateTime", or "word" 
		String request="word";
	
		
		switch(request) {
			case "Square":{
				Math.sqrt(n);
				System.out.println(Math.sqrt(n));
				break;
			}
			case "DateTime":{
				DateFormat dateFormat = new SimpleDateFormat("MM:dd:yy HH:mm:ss");
				Date dateObj = new Date();
				System.out.println(dateFormat.format(dateObj));
				break;
			}
			case "word":{
				String s="I am learning Core Java";
				String[] word = s.split(" "); // split each word when has space between each word and store in String array
					
				for (int i=0; i<word.length; i++) { //the length array word and print out each word
					System.out.println(word[i]);
				}
				break;
			}
		}
		
	}
	
}
