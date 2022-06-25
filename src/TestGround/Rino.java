package TestGround;

public class Rino {
	private int age;
	private String name;
	
	public Rino(String name, int age){
		this.name=name;
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
