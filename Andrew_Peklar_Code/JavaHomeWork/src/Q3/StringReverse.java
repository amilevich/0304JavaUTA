package Q3;

public class StringReverse {

	public static void main(String[] args) {
		String s = "happy";
		System.out.println(reverseString(s));
	}
	public static String reverseString(String strg) {
		return	strg.chars()
					.mapToObj(c -> (char)c)
					.reduce("", (s,c) -> c+s, (s1,s2) -> s2+s1);
	}
}
