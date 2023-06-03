package LessonsAboutExceptionAndError;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/* 
 * Второй способ обработки исключения - это перебрасывание 
 * С помощью ключевого слова throws мы обьявляем что метод может выбросить исключение,
 * и перебрасываем это исключение вверх по стеку.
 * Ну то есть в метод который вызывает наш "проблемный" метод.
 * Но исключение должно быть все равно обработано с помощью try catch.
 * Просто throws позволяет не обрабатывать исключение в своем методе, а переложить это на другой.
 * 
 * Обьявлять throws имеет смысл только проверяемые исключения, потому что
 * 1) Не проверяемые исключения под нашим контролем, мы можем их не допустить или просто исправить код устранив их
 * 2) Error не под нашим контролем, эти ошибки мы не можем ни исправить, ни устранить, формально даже обработать не выйдет
 *  
 * Так же можно после throws обьявить несколько исключений через запятую.
 */
public class LessonAboutThrows {

	public static void main(String[] args) throws FileNotFoundException{
		LessonAboutThrows lessonAboutThrows = new LessonAboutThrows();
			lessonAboutThrows.foo();	
	}
	
	public  void deleteOn0(int i) throws FileNotFoundException{
		File file = new File("ds"); 
		Scanner scanner = new Scanner(file);
	}
	
	public void foo(){
		LessonAboutThrows lessonAboutThrows = new LessonAboutThrows();
		try {
			lessonAboutThrows.deleteOn0(3);	 
		}catch(FileNotFoundException e) {
			System.out.println("Нет файла");
		}
			
	}
}
