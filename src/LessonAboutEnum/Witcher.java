package LessonAboutEnum;
import java.util.Scanner;
public class Witcher {

	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		SchoolOfWitcher schoolOfWitcher = SchoolOfWitcher.SchoolOfWolf;
	
		switch(schoolOfWitcher) {
		case SchoolOfWolf:
			System.out.println("Выбрана школа Волка");
			break;
		case SchoolOfBear:
			System.out.println("Выбрана школа Ведьмедя");
			break;
		case SchoolOfCat:
			System.out.println("Выбрана школа Кота");
			break;
		case SchoolOfSnake:
			System.out.println("Выбрана школа Змеи");
			break;
		case SchoolOfGriffon:
			System.out.println("Выбрана школа Грифона");
			break;
		}
		
		
	}
}
