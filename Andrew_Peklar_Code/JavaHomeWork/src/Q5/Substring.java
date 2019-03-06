package Q5;

import java.util.Arrays;

public class Substring {
	
	public static void main(String[] args) {
		String tmp = "hello";
		String subTmp = subString(tmp, 3);
		System.out.println(subTmp);
		
	}
	
	//can do with IntStream via ".char" as well.
	//need this extra step though".mapToObj(c -> (char)c)"
	//".collect(Collectors.joining(""))" works for final step, 
	//however, it uses stringBuilder;
	public static String subString(String strg, int n) {
		return Arrays.stream(strg.split(""))
        			 .skip(n)
        			 .map(Object::toString)
        			 .reduce("", String::concat); 
	}
}
