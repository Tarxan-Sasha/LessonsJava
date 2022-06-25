package LessonsJAVA;

public class TestFromBook {

	public void doStuff() {
		boolean b = true;
		go(4);
		
		System.out.println("Мы в первом методе");
	}
	public void go(int x) {
		int q = x+23;
		crazy();
		System.out.println("Мы в втором методе");
		/*
		 * 
		 */
	}
	public void crazy() {
		char c ='a';
		System.out.println("Мы в третьем методе");
	}
	static int q=7;
	TestFromBook testFromBook = new TestFromBook();
	
	public static void main(String [] args) {
		TestFromBook testFromBook = new TestFromBook();
		testFromBook.doStuff();
	}
}
