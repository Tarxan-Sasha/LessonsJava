package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * sorted() - промежуточная операция сортировки.
 * Иногда требуеться отсортировать колекцию или массив, и в Stream API это можно сделать с помощью метода sorted()
 * Это обычная сортировка, как это было в TreeSet или в TreeMap.
 * Все как было в колециях с сортировкой:
 * Сортируються только те обьекты которые имплементировали интерфейс Comparable.
 * Если обьекты в колекции не имплементировали его или нужен особый способ сортировки тогда изпользуем Comparator,
 * в атрибут метода sorted() вписываем обьект класса реализовуещего Comparator. 
 * Пример:
 * sorted(new OrcComparator())
 * 
 */
public class LessonAbout_sorted {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();//Просто набор чисел в колекции
		numbers.add(0);
		numbers.add(76);
		numbers.add(3);
		numbers.add(1);
		
		numbers.stream().sorted().forEach(x -> System.out.print(x+" "));//Сортируем и выводим, в операцию sorted() нечего не ложим, она отсартирует по "Естественному порядку"
																		//"Естественный порядок" - для чисел от меньшего к большему, а слова/буквы по алфавиту
		
		List<Orc> orcs = new ArrayList<Orc>();//Набор орков
		orcs.add(new Orc("Tog"));
		orcs.add(new Orc("Kolks"));
		orcs.add(new Orc("Shak"));
		
		orcs.stream().sorted(new OrcComparator()).forEach(x -> System.out.print(x+" "));//Сортируем орков по длинне их имени, с помощью Comparator (для орков OrcComparator).
																						//Обьект Comparator мы передаем в параметр sorted(new OrcComparator()).
		//Пример с массивом чисел
		System.out.println();//Перенос сторки
		int [] array = {3,1,2,5};//Массив чисел
		Arrays.stream(array).sorted().forEach(System.out::print);//Сортировка массива чисел
	}
}
class Orc{//Класс орков не реализуещий интерфейс Comparable, а значит операция sorted() не сможет отсортировать обьекты этого класса
	String name;
	public Orc(String name) {
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
		return "Orc [name=" + name + "]";
	}
}
class OrcComparator implements Comparator<Orc>{//Класс реализации Comparator для класса Orc
	@Override
	public int compare(Orc o1, Orc o2) {
		int x =o1.getName().length();
		int y =o2.getName().length();
		return x-y;
	}	
}