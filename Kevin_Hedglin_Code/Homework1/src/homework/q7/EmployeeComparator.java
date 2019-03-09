package homework.q7;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) 
	{
		int c = o1.getName().compareTo(o2.getName());
		if(c == 0)
		{
			c = o1.getDepartment().compareTo(o2.getDepartment());
			if(c == 0)
			{
				if(o1.getAge() > o2.getAge())
				{
					c = 1;
				}
				else if (o1.getAge() == o2.getAge())
				{
					c = 0;
				}
				else
				{
					c = -1;
				}
			}
		}

		return c;
	}
}
