package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

/* 
 * Еще операции стримов:
 * 
 * count() - терминальная операция, которая возвращает количество елментов в поток.
 * 
 * allMatch() - терминальная операция, которая вернет true, если ВСЕ елементы удовлетворяют условие.
 * anyMatch() - терминальная операция, которая вернет true, если ХОТЯ БЫ ОДИН элемент удовлетворяет условие.
 * noneMatch() - терминальная операция, которая вернет true, если НИ ОДИН элемент удовлетворяет условие.
 * 
 * findFirst() - терминальная операция, вернет первый элемент в потоке
 * findAny() - терминальная операция вернет случайный елемент в потоке
 * findAny() эта операция по сути она нужна именно для паралельных потоков.
 * Потому что вывод этой операции пердугадать нельзя - она может выбрать любой элемент потока.
 * это свойство обеспечивает максимальную производительность в паралельных потоках.
 * О паралельных потоках потом.
 * Просто: в паралельных потоках он выведет случайное число, а в последовательных(как у нас сейчас, в обычных) вернет первый элемент. 
 * 
 * min() - терминальная операция которая вернет минимальное значение из потока
 * max() - терминальная операция которая вернет максимальное значение из потока
 * Эти две операции могут сравнивать только если внутрь передать ссылку на метод компоратора.
 * Это все сделанно потому что эелменты потока могут быть разными, и даже обьектами классов,
 * и что бы понять как их сравнивать нужно передать метод компоратора.
 * (Что бы сделать ссылку на метод нужно после обьекта написать :: и название метода, например:
 * 		обьектА::методКомпоратора;
 *  Или если метод компоратора статический, тогда вместо обьекта пишем название класса, пример:
 *  	названиеКлассаА::методКомпоратора)
 * 
 * Последние 4 операции возвращают элемент потока который обернут в обьект класса Optional
 * Класс Optional это класс который может обрабатывать и принимать значение null, без выбрасивыния исключения NoSuchElementException.
 * Почему findFirst() findAny() max() min() возвращают елемент обернутый в класс Optional?
 * Потому что может быть такое что поток пустой, и тогда они не смогут вернуть ни первый, ни максимальный, ни минимальный и ни любой элемент.
 * им придеться вернуть null,  а это приведет к NoSuchElementException, и следом краш всей програмы.
 * Для этого и нужен класс Optional. Но о нем потом.
 * 
 */

public class LessonAbout_count_findFirst_findAny_allMatch_anyMatch_noneMatch {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);

		System.out.println(numbers.stream().count());//Возвращаем количество элементов потока 
		
		System.out.println(numbers.stream().allMatch(x -> x<10));//Вернем true, если все элементы меньше 10
		System.out.println(numbers.stream().anyMatch(x -> x<2));//Вернем true, если хоть один элемент меньше 2
		System.out.println(numbers.stream().noneMatch(x -> x==0));//Вернем true, если ни один элемент не равен 0
		
		
		System.out.println(numbers.stream().findFirst());//Возвращает первый элемент обернутый в обьект Optional, ведь первого элемента может и не быть
		System.out.println(numbers.stream().findAny());//Возвращает любой елемент, 
													   //но из-за того что это не паралельный поток, а последовательный он возвращает первый элемент
													   //Обернутый в обьект Optional, ведь первого или любого элемента может и не быть

		System.out.println(numbers.stream().min(Integer::compare));//Возвращаем минимальное значение, 
																   //передавая в условие ссылку на статический метод Comparator'а класса Integer, 
																   //потому как элементы потока int можно воспользоваться методом из класса Integer.
		System.out.println(numbers.stream().max(Integer::compare));//Возвращаем максимальное значение
																   //передавая в условие ссылку на статический метод Comparator'а класса Integer, 
																   //потому как элементы потока int можно воспользоваться методом из класса Integer.
		
		//Пример с другим классом
		List<Games> games = new ArrayList<Games>();
		games.add(new Games("Withcer3"));
		games.add(new Games("Skyrim"));
		games.add(new Games("StarCrat"));//Создали список игр															
		System.out.println(games.stream().min(new GamesComporator()::compare));//Передали обьект в аргумент, создав его, и сразу сослались на его метод compare
		/* На консоле видно что обьект который мы получили обернут в Optional, это сделанно на всякий случай ведь: А ВДРУГ єлементов нет, и вернеться null и ВСЕ КРАХ ПРОГРАММЫ
		 * Как достать элемент из класса Optional, потом.
		 */
	}
}


class Games{
	String name;
	public Games(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Games [name=" + name + "]";
	}	
}
class GamesComporator implements Comparator<Games>{
	@Override
	public int compare(Games o1, Games o2) {
		return o1.getName().length()-o2.getName().length();
	}
	
}



