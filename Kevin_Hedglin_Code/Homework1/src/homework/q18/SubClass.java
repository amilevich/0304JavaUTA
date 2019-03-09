package homework.q18;

public class SubClass extends SuperClass {

	public SubClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	//check if the string is fully uppercase
	@Override
	public boolean checkForUpperCase(String s) {
		for (int i = 0; i < s.length(); i++)
	    {
	        if (!Character.isUpperCase(s.charAt(i)))
	        {
	            return false;
	        }
	    }
		return true;
	}

	//convert the string to uppercase
	@Override
	public String toUpperCase(String s) {
		String upper = "";
		for (int i = 0; i < s.length(); i++)
	    {
	        upper += Character.toUpperCase(s.charAt(i));
	    }
		return upper;
	}

	//parse the string to an integer and add ten
	@Override
	public void addTen(String s) {
		int i = Integer.parseInt(s);
		i += 10;
		System.out.println("Your number + 10 is : " + i);
	}

}
