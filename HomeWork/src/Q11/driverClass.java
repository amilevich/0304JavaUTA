package Q11;

public class driverClass {

	public static void main(String[] args) {
		Q11a.floatVar1 FV1 = new Q11a.floatVar1(); //instantiate object from package Q11a
		Q11b.floatVar2 FV2 = new Q11b.floatVar2(); //instantiate object from package Q11b
		float f1 = FV1.getNum1();//set float equal to getter in fv1
		float f2 = FV2.getNum2();//set float equal to getter in fv2
		System.out.println("The two floats are " + f1 + " and " + f2); //prints out result
		
	}

}
