package LessonsAboutLambda;


@FunctionalInterface
interface Number{
	int calculate(int a);
	
}


public class TestLambda{

	
	public static void main(String[] args) {

		
		Number number1;

		number1=s-> s+s;

		number1.calculate(4);

		
		int x=31;
		int x1=31;
		int x2=31;
		int x3=31;
		
		int g = x*x1;
		
		
		
	
	}

}
