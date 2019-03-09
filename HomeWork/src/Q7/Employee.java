package Q7;

public class Employee {

													//Employee attributes
	String name;
	String department;
	int age;
	
	public Employee(String n, String d, int num) //Employee constructor with getters and setters
	{
		this.name = n;
		this.department = d;
		this.age = num;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
