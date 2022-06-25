package TestGround;

public class Monkey extends Animal {
	public Monkey(String name, int age) {
		super(name,age);
		System.out.println("Я куколд обезяна без супера");
	}
	
	
	String i="123";
	public void fuckSuper() {
		System.out.println(super.i);
	}
	
	public void sleep() {
		System.out.println(getName()+" sleeps");
	}
	
}
