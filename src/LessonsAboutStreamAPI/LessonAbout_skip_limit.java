package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.List;

/*
 * Два метода стримов skip и limit.
 * 
 * skip(long n) - промежуточная операция, пропускает указанное число элементов начиная с начала, выбирает все оставшиеся.
 * если задать число большее чем количество элементов в потоке, тогда просто пропустяться все эелементы и поток будет пуст.
 * 
 * limit(long maxSize) - промежуточная операция, устанавливает лимит(максимальное число) элементов в потоке начиная с начала, элементы за лимитом будут пропущены/выброшены.
 * Если задать число большее чем количество элементов в потоке, тогда просто выбируться все.
 * 
 * Эти два метода часто используют в паре для выборки нужного элемента.
 */
public class LessonAbout_skip_limit {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(0);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		
		numbers.stream().skip(2).forEach(x -> System.out.print(x+" "));//Пропускаем 2 элемента в начале 
		System.out.println();
		numbers.stream().limit(2).forEach(x -> System.out.print(x+" "));//Устанавливаем максимальный размер потока вытесняя другие элементы, по сути выбираем первые 2 элемента
		
		//Работа в паре, например нам нужно достать 3-ий элемент
		System.out.println();
		System.out.print("третий елемент: ");
		numbers.stream().skip(2).limit(1).forEach(x -> System.out.print(x+" "));//Пропустили первые 2 елемента методом skip, 
																				//а после с помощью метода limit выбираем первый элемнт, выбрасывая остальные
	}

}
