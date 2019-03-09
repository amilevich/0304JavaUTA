package Q7;

public class Employee {
	
	private int age;												//
	private String name;											//employee variables
	private String department;										//
	
	public Employee(int age, String name, String department) {		
		super();													//
		this.age=age;												//employee constructor
		this.name=name;												//
		this.department=department;									//
	}																

	public int getAge() {											//getters and setters for employee
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	@Override														//toString that prints employee values
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", department=" + department + "]";
	}
	
	

}
