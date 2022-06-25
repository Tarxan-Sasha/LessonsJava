import java.util.Scanner;
public class ProgrammArrayOfMultiples {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int testLength = scanner.nextInt();

		int[] testArray=new int[testLength];
		int x=1;
		testArray[0]=num;
		for(int i=1; i<testLength; i++) {
			
			if(!(num%(x+1)==0)) {
				testArray[i]=num*(i+1);
				x++;
			}else {
				x++;
				i--;
			}
			
		}
		for(int j:testArray) {
			System.out.print(j+" ");
		}

	}
}
/*
	Программа создает массив с размером перемнной int testLength и заполняет его числами крастными переменной num
*/