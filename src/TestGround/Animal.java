package TestGround;

public class Animal {
	private int age;
	private String name;
	
	int i=23;
	
	
	public Animal(String name, int age){
		this.name=name;
		this.age=age;
		System.out.println("Здарова ссука из ЕНИМАЛА");
	}
	
	
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void sleep() {
		System.out.println("I am sleeping");
	}
}
