package com.problem.q18;

abstract class Abby {

	// Here we can see the strings we are going to use
	
	// I also used this as an opportunity to practice this() and super()
	// usages.
	Abby() {
		this("helLo", "what's uP", "5");
	}

	Abby(String a, String b, String c) {
		System.out.println("has uppercase?: " + checkUp(a) + "\nTo uppercase: " + lowToUp(b) + "\nString to Int: "
				+ stringToInt(c));
	}

	abstract boolean checkUp(String str);

	abstract String lowToUp(String str);

	abstract int stringToInt(String str);

}

public class Main extends Abby {

	Main() {
		super();
	}

	public static void main(String[] args) {

		// here I instantiate the Main object.
		// this calls the Main() constructor which
		// calls super() and then the Abby constructor calls this()
		// thus making it use the this(String a, String b, String c)
		@SuppressWarnings("unused")
		Main main = new Main();

	}

	@Override
	boolean checkUp(String str) {
		String check = str.toLowerCase();
		if (str.equals(check)) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	String lowToUp(String str) {
		return str.toUpperCase();
	}

	@Override
	int stringToInt(String str) {
		int i = 0;
		try {
			i = Integer.parseInt(str.trim());

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return i;
	}
}
