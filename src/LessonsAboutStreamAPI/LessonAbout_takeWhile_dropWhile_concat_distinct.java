package LessonsAboutStreamAPI;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * takeWhile() - промежуточная операция которая выбирает элементы из потока пока они соответствуют условию(true).
 * В условие метода кладется лямбда выражение которое должно отвечать true или false.
 * Как только элемент потока выдает false, метод останавливает свою работу.
 * Можно подумать что он похож и делает тоже самое что и filter().
 * Но отличие в том что:
 * takeWhile() остановиться на элементе false и не будет идти дальше, даже если там будут элементы которые вернут true.
 * 
 * dropWhile() - промежутоная операция, тоже самое что и takeWhile() НО НАОБОРОТ.
 * dropWhile() ПРОПУСКАЕТ все элементы которые выдадут true, 
 * и начинает выдавать элементы когда встретит элемент который выдадит false.
 * Другими словами, как только попадаеться элемент который НЕ соответствует условию - dropWhile() начинает работу.
 * Ну и конечно же, dropWhile() будет идти дальше после элемента false, даже если там будут элементы которые вернут true.
 * 
 * concat() - прмоежуточная операция, которая обьединяет два потока.
 * В условие метода кладеться два потока, и они соединяються в один.
 * 
 * distinct() - промежуточная операция, которая возвращает в поток лишь уникальные элементы 
 * 
 */
public class LessonAbout_takeWhile_dropWhile_concat_distinct {

	public static void main(String[] args) {
		int [] array = {1,2,9,5,4,3};
		Arrays.stream(array).takeWhile(x -> x<6).forEach(x -> System.out.print(x+" "));//takeWhile() проверяет каждый элемент на свое условие, и как только встречает false ОСТАНАВЛИВАЕТЬСЯ.
		
		System.out.println();//Перенос строки
		
		int [] array1 = {1,3,-1,2,2,3};
		Arrays.stream(array1).dropWhile(x -> x>0).forEach(x -> System.out.print(x+" "));//dropWhile() провреяет каждый элемент на свое условие, и как только встречает false ЗАПУСКАЕТЬСЯ
		
		System.out.println();//Перенос строки
		
		IntStream as = Arrays.stream(array);//Поток на основе массива, так как массив типа int используем особенный поток IntStream именно для int массивов 
		IntStream as1 = Arrays.stream(array1);//Поток на основе массива, так как массив типа int используем особенный поток IntStream именно для int массивов 
		IntStream.concat(as,as1).forEach(x -> System.out.print(x+" "));//Обьединяем два потока методом concat
		
		System.out.println();//Перенос строки
		
		Arrays.stream(array1).distinct().forEach(x -> System.out.print(x+" "));//Убираем все повторяющийся элементы из потока, оставляя лишь уникальные
	}

}