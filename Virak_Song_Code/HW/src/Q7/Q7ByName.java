package Q7;

import java.util.Comparator;

public class Q7ByName implements Comparator<Q7Emp> { //implement Comparator from Employee class
	
	@Override
	public int compare(Q7Emp o1, Q7Emp o2) {
		if (o1.getName().compareTo(o2.getName()) > 0) {  //q1 name > q2 name return 1
			return 1;
		} else if (o1.getName().compareTo(o2.getName()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}

}
