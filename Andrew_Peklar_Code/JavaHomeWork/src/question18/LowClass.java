package question18;

public class LowClass extends HighClass {

	public LowClass() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isItUppercase(String str) {
		// Based on the ASCII values of each individual char.
		// If there are any lower case letters, output is false.
		// An input of all non-alphabetical chars will result in "true" by default
		return !str.chars()
			   .mapToObj(c -> (int) c)
			   .anyMatch(c -> c > 96 & c < 123);
	}

	@Override
	public String makeUppercase(String str) {
		return str.toUpperCase();
	}

	
	@Override
	public int stringToInt(String str) {
		// If a number, return number as int and add 10
		// 48 through 57 are the ASCII values of numerical chars
		if (str.chars().mapToObj(c -> (int) c).allMatch(c -> c > 47 & c < 57))
			return Integer.parseInt(str) + 10;
		// If not all chars are numeric, ASCII
		// returns sum of character ASCII values + 10
		// I was unsure of what the desired output was
		else
			return str.chars().sum() + 10;
	}
}
