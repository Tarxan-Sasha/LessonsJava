package LessonsAboutExceptionAndError;

import java.io.FileNotFoundException;

/*
 * В Java есть почти 400 проверямых классов исключений
 * Но все равно различных ситуаций бывает слишком много и описать все возможные исключения невозможно.
 * Потому можно сделать свои исключения.
 * 
 * Класс который будет исключением нужно назвать так что б он заканчивался на "Exception"(это по конвенции),
 * а так же этот класс должен наследоваться от класса Exception.
 * Класс Exception не имеет никаких дополнительных методов, но он делает класс исключением.
 * 
 * И в самом коде нужно это исключение выкинуть, это позволяет сделать ключевое слово throw
 * Само исключение - это обьект.
 * Потому после ключевого слова throw нужно написать обьект класса исключения
 * 
 * С помощью ключевого слова throw можно выкинуть не только свое исключение, но и любое другое.
 * Главное только выбрасываемые исключения потом обработать try catch или throws.
 * 
 */
public class LessonAboutMyException {

	public static void main(String[] args)  {
		LessonAboutMyException car = new LessonAboutMyException();
	try {
		car.start(-2);
		throw new  FileNotFoundException();//Свободное выбрасывание случайного исключения
		}
		catch(SpeedCarException e) {
			System.err.println("Скорость не может быть равной или меньше 0");
		}
		catch(FileNotFoundException e) {
			System.err.println("Файл?");
		}

		
	}
	
	public void start(int speed) throws SpeedCarException{
		if(speed <= 0) {
			//Можно выбросить исключения по обычному: просто создав обьект и передав его по имени
			//SpeedCarException speedCarException = new SpeedCarException();
			//throw speedCarException;
			
			throw new SpeedCarException();//Сокращенный вариант выбрасывания обьекта исключения, без имени обьекта

		}
		System.out.println("Вы поехали со скоростю: "+speed);
	}
	
}



class SpeedCarException extends Exception{

	@Override
	public String toString() {
		return "SpeedCarException [] Скорость не может быть равна 0";
	}
	
}
