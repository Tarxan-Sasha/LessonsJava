package LessonsAboutCollections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/*
 * Set - это интерфейс который реализует Набор.
 * Он расширяет интерфейс Collection, но новых методов не добавляет.
 * 
 * Set не пропускает дублированых элементов, 
 * если добавить существующий элемент в колекцию, тогда метод add() веренёт false и не добавит элемент, потому что такой уже есть.
 * Уникальность єлементов определяеться с помощью метода equals(), который принято переопределять
 * 
 * Интерфейс реализуют классы:
 * 1)HashSet - Это класс который расширяет интерфейс Set, он так же содержит лишь уникальные элементы.
 * (HashSet под капотом имеет реализацию HashMap, HashSet упрощенная версия HashMap)
 * Внутри себя HashSet имеет Хеш-Таблицу, куда кешируються и помещяються элементы за своим хешем(id обьекта).
 * (Соответственно HashSet имеет переопределённый метод hashcode())
 * Хеширование позволяет HashSet быстро определять обьекты на уникальность.
 * Так же хеширование делает следующие методы крайне быстрыми.:
 * add() - добавление
 * contains() - проверка на наличие
 * remove() - удаление
 * size() - количество элементов
 * 
 * HashSet из-за хеширования не гарантирует порядка элементов, это можно считать его минусом.
 * 
 * Так же HashSet имеет два параметра это Начальная емкость (initial capacity) и Коэффициент загрузки (load factor) которые можно установить в конструкторе.
 * 
 * 1)Начальная емкость (initial capacity) - это начальное количество ячеек/бакетов. Если их будет не достаточно, их количество увеличится.
 * 
 * 2)Коэффициент загрузки (load factor) - это показатель того на сколько таблица должна быть заполнена, после которого она увеличится.
 * Когда количество элементов становиться больше чем initial capacity*load factor, хэш-таблица ре-хешируеться увеличивая количество ячеек/бакетов в два раза
 * (Так же при ре-хешировании: все хешкоды, каждого элемента обновляються. А так же элементы перестраиваються взависмиости со своим хешем)
 * Самым оптимальное значение коэффициента загрузки (load factor) - 0.75(Дефолтный)
 * но его можно изменить в конструкторе.
 * 
 * 2)LinkedHashSet - Это класс который расширяет интерфейс Set и наследуетсья от HashSet.
 * Его особенность в том что он поддерживает порядок данных в коотором они были вставленны в колекцию.
 * 
 *
 * 
 * 
 */
public class LessonAboutHashSet {

	public static void main(String[] args) {
		List<Demons> demons = new ArrayList<>();
		//Конструкторы HashSet
		Set<String> name = new HashSet<>();//Дефолтный, capacity - 16, load factor - 0.75
		Set<Integer> name1 = new HashSet<>(10);//Здесь мы указываем capacity, load factor будет равен - 0.75
		Set<String> name2 = new HashSet<>(10, 0.50f);//Указываем capacity(int) и load factor(float)
		Set<Demons> name3 = new HashSet<>(demons);//это конструтор где мы передаем в HashSet другую колекцию, считай конфертируем её в HashSet.
		   										  //Типы(generic'ы, то что в <>) должны быть одинаковы
		name.add("Sasha");
		name.add("Bobos");
		name.add("Lesha");
		name.add("Ilyua");
		name.add("Ilyua");
		
		System.out.println(name);
		
		for(String n:name) {
			System.out.println(n);
		}

		Set<Integer> linkedHashSet = new LinkedHashSet<>();//Дефолтный, capacity - 16, load factor - 0.75
		Set<Integer> linkedHashSet1 = new LinkedHashSet<>(10);//Здесь мы указываем capacity, load factor будет равен - 0.75
		Set<Integer> linkedHashSet2 = new LinkedHashSet<>(10, 0.50f);//Указываем capacity(int) и load factor(float)
		Set<Demons> linkedHashSet3 = new LinkedHashSet<>(demons);//это конструтор где мы передаем в HashSet другую колекцию, считай конфертируем её в HashSet.
			  													//Типы(generic'ы, то что в <>) должны быть одинаковы
		linkedHashSet.add(2);
		linkedHashSet.add(1);
		linkedHashSet.add(3);
		linkedHashSet.add(1);
		
		name1.add(3);
		name1.add(2);
		name1.add(3);
		name1.add(1);
		
		for(int i:linkedHashSet) {
			System.out.println(i);
		}
		System.out.println(" ");
		for(int i:name1) {
			System.out.println(i);
		}
		
	}

}
