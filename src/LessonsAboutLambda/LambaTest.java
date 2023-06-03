package LessonsAboutLambda;


public class LambaTest {


	
	public static void main(String[] args) {
//		b2 − 4ac	
//		EatAble e = (b, a, c) -> (b*b) - 4*a*c;
//		
//		int answer = e.eat(2, 3, 4)+5;
//		System.out.println(answer);
		
		LambaTest lt = new LambaTest();
		
		Plus p = LambaTest::plus1;

	}

	
	int plus(int x, int y) {
		return x+y;
	}
	
	static int plus1(int x, int y) {
		return x+y;
	}
	
}
interface Plus{
	int plus(int x, int y);
}