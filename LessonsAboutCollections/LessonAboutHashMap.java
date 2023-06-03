package LessonsAboutCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*	
 * Map - это интерфейс где каждый элемент сохраняеться в паре. Пара "ключ-значение".
 * Ключ должен быть уникальным, а значение нет.
 * Если добавить новое значение с уже повторным ключом, тогда этот новый элемент заменит прошлый
 * Map не расширяет интерфейс Collections, 
 * одна из основных причин это потому что Map принимает элементы в паре "ключ-значение", то етсь по два элемента.
 * Тогда как Collections один элемент. И все методы Collections основаны на принятии и работы с одним элементом.
 * 
 * Интерфейс реализуют классы:
 * HahMap - Это один из основных классов которые реализуют Map.
 * Внутри себя HahMap содержит Хєш таблицу. Так же для более точной работы стоит переопределить equals() и hashcode().
 * Так же HahMap из-за хеширования не гарантирует порядка.
 * Одни из основных методов:
 * put(K k, V v) - тоже самое что и add(), довабляет элемент в таблицу.
 * get(Object k) - получить єлемент с таблицы, по ключу. 
 * containsKey(Object k) - проверка на наличие ключа.
 * containsValue(Object v) - првоерка на наличие значения.
 * remove(Object k) - удаляет обьект по ключу
 * size() - возвращает количество элементов в коллекции
 * keySet() - метод для получения ТОЛЬКО ключей. Так как они уникальны они должны извлекаться в Set  
 * values() - метод для получения только значений.
 *   
 * LinkedHashMap - Так же как в Set, сохраняет порядок ввода элементов.
 * Интерфейс расширяют интерфейсы:
 * SortedMap - Так же как в Set, сортирует по возрастанию ключей
 * NavigableMap - Так же как в Set, добавляет больше методов для выборки, извлечения элементов на основе ключей
 * И эти интерфейсы реализует класс:
 * TreeMap -  Так же как в Set, сразу сортрует колекцию по возрастанию ключей. 
 * Для корректной и правильной работы, как и в случае с Set, нужна реализация Comparator и Comparable.
 * 
 * Так же есть интерфейс Map.Entry который расширяет Map. давая возможность итерироваться.
 * entrySet() - возвращает список всех пар "ключ-значение"
 */
		
public class LessonAboutHashMap {


	public static void main(String []args) {
		Map<Integer, String> people = new HashMap<>();
		people.put(1, "Illya");
		people.put(2, "Bobas");
		people.put(3, "Lesha");
		//people.put(3, "Lesha12");
		
		System.out.println(people);

		Set<Integer> id = new HashSet<>(people.keySet());
		System.out.println(id);
		
		List<String> names = new ArrayList<>(people.values());
		System.out.println(names);
		
		for(Map.Entry entry:people.entrySet()) {
			System.out.println(entry);
		}

		
	}
}
















