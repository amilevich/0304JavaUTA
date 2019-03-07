package Question7;

public class Employee {
	
	private int age;           //all employee variables
	private String name;
	private String department;
	
	 
	public Employee(int age, String name, String department) {  //Employee contructor with values
		super();
		this.age = age;
		this.name = name;
		this.department = department;
	}
	@Override
	public String toString() {   //toString to print employee values
		return "Employee [age=" + age + ", name=" + name + ", department=" + department + "]";
	}
	public int getAge() {          //getters and setters
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
	
}
