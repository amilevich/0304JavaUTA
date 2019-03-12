package question07;

public class Employee {
	private int age;
	private char name;
	private char department;
	
	public Employee(char name, int age, char department) {
		this.age = age;
		this.name = name;
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + " age=" + age + " department=" + department + "]";
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public char getDepartment() {
		return department;
	}

	public void setDepartment(char department) {
		this.department = department;
	}
	
	
}