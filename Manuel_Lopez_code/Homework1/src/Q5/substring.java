package Q5;

public class substring {

	public static void main(String[] args) {
		String temp = "This string";							//string to split
		int index = 5;											//index where string will be split
		System.out.println(substring(temp, index));				//call substring method that will split string
	}
	
	public static String substring(String x, int y) {			//
		char[] temp_array = x.toCharArray();					//temp array to store string to be split
		char split[] = new char[y];								//new array where split string will be stored split[]
		for(int i=0; i < y-1; i++) {							//
			split[i] = temp_array[i];							//store characters where of split string in split array 
		}														//
		return String.copyValueOf(split);						//return split string
	}															//
}
