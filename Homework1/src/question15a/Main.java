package question15a;

public class Main {
	
	public static void main(String[] args) {
		
		int varOne = 10;
		int varTwo = 5;
		
		ClassImplementsInterface myAdd = new ClassImplementsInterface();
		//myAdd.addMethod(varOne, varTwo);
		System.out.println(varOne + " + " + varTwo + " = " + myAdd.addMethod(varOne, varTwo));
		
		ClassImplementsInterface mySub = new ClassImplementsInterface();
		//myAdd.addMethod(varOne, varTwo);
		System.out.println(varOne + " - " + varTwo + " = " + mySub.subtractMethod(varOne, varTwo));
		
		ClassImplementsInterface myMul = new ClassImplementsInterface();
		//myAdd.addMethod(varOne, varTwo);
		System.out.println(varOne + " * " + varTwo + " = " + myMul.multiplyMethod(varOne, varTwo));
		
		ClassImplementsInterface myDiv = new ClassImplementsInterface();
		//myAdd.addMethod(varOne, varTwo);
		System.out.println(varOne + " / " + varTwo + " = " + myDiv.divideMethod(varOne, varTwo));
	}

}
