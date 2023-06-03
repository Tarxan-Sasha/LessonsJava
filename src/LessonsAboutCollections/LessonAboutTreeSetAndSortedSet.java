package LessonsAboutCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * Comparator и Comparable - это функциональные интерфейсы их можно реализовать лямбдой(ну и анонимным классом)
 * Comparator - это интерфейс для более частных случаев,
 * для него обычно создаеться отдельный класс.
 * Comparable - это интрефейс для "Естественного порядка", 
 * то есть с помощью него мы указываем какой метод\алгоритм сортировки будет для этого класса дефолтным.
 * 
 * Все они имеют внутри себя конвенцию, по которой они сортируют или должны сортировать:
 * 01 > 02 = 1 - true
 * 01 < 02 = -1 - false
 * 01 == 02 = 0 - равны
 * 
 * SortedSet - это интерфейс который расширяет Set и сортируют колекцию по возрастанию.
 * NavigableSet - это интерфейс расширяющий интрефейс SortedSet, 
 * добавляет методы для удобного поиска\извлечения элементов из коллекции.
 * TreeSet - это класс реализующий интерфейс NavigableSet, элементы в нем сортируются сразу, по возрастанию.
 *	
 */
public class LessonAboutTreeSetAndSortedSet {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		DemonsNameComparator demonsNameComparator1 = new DemonsNameComparator();
		
		Set<String> name = new TreeSet<>();//Обычный конструктор
		Set<Integer> name2 = new TreeSet<>(numbers);//это конструтор где мы передаем в TreeSet другую колекцию, считай конфертируем её в TreeSet.
			  										//Типы(generic'ы, то что в <>) должны быть одинаковы
		Set<Demons> name3 = new TreeSet<>(demonsNameComparator1);//Создаеться пустое дерево, в котором добавляемые элементы будут сортироваться заданным Comparator
		

		name.add("Sasha");
		name.add("Lesha");
		name.add("Bobos");
		name.add("Illya");
		System.out.println(name);
		
		List<String> name1 = new ArrayList<>();
		name1.add("Sasha");
		name1.add("Lesha");
		name1.add("Bobos");
		name1.add("Illya");
		System.out.println(name1);
		Collections.sort(name1);
		System.out.println("Отсортированный "+name1);
		
		System.out.println();
		
		
		
		Demons d1 = new Demons(43, "Gogl");
		Demons d2 = new Demons(21, "Adramalic");
		Demons d3 = new Demons(3, "Imp");
		Set<Demons> demons = new TreeSet<>();
		demons.add(d1);
		demons.add(d2);
		demons.add(d3);
		System.out.println(demons);
		
		System.out.println();
		
		List<Demons> demons1 = new ArrayList<>();
		demons1.add(d1);
		demons1.add(d2);
		demons1.add(d3);
		System.out.println(demons1);
		Collections.sort(demons1);
		System.out.println(demons1);
		
		DemonsNameComparator demonsNameComparator = new DemonsNameComparator();
		Collections.sort(demons1, demonsNameComparator);
		System.out.println(demons1);
		
	}

}
