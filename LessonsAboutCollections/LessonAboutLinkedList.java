package LessonsAboutCollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * LinkedList - это класс реализующий струтуру данных связной список, он реализует интерфейсы List, Dequeue и Queue
 * LinkedList отличаетсья от ArrayList, тем что его элементы связаны ссылками с друг другом, и не являються массивом.
 * Тогда как внутри ArrayList находиться массив.
 * Каждый элемент списка LinkedList имеет ссылку на прошлый(previous) элемент и на следующий(next).
 * В таком случае когда мы добавляем элемент в середину списка, мы НЕ сдвигаем все элементы вправо/влево на один
 * а просто меняем ссылки двух элементов, вставляя между ними нужный нам элемент
 * 
 * LinkedList копирует множество методов у ArrayList
 * Но у него есть и новые, такие как:
 * addFirst(), addLast() - методы для добавления элемента в начало/конец списка
 * peekFirst(), peekLast() - возвращают первый/последний элемент списка. Возвращают null, если список пуст.
 * pollFirst(), pollLast() -  возвращают первый/последний элемент списка и удаляют его из списка. Возвращают null, если список пуст
 * toArray() - возвращает массив из элементов списка
 * 
 */
public class LessonAboutLinkedList {
	public static void main(String [] args) {
		List<Demons> arrayList = new ArrayList<>();
		
		//LinkdList имеет два конструктора
		List<String> names = new LinkedList<>();//Обычный конструктор
		List<Demons> demons = new LinkedList<>(arrayList);//это конструтор где мы передаем в LinkedList другую колекцию, считай конфертируем её в LinkedList.
		   											      //Типы(generic'ы, то что в <>) должны быть одинаковы
		names.add("Ilyukha");
		names.add("Bobos");
		names.add("Lesha");
		/*
		 * Каждый элемент содержит не только значение, но и две переменные ссылки на прошлый(previous) элемент и на следующий(next)
		 * Ilyukha - previous = null, next = Bobos
		 * Bobos - previous = Ilyukha, next = Lesha
		 * Lesha - previous = Bobos, next = null
		 * 
		 */
		System.out.println(names);
		
		System.out.println(names.get(1));
		
		names.add(1,"Andrey");
		
		System.out.println(names.get(1));
		
		System.out.println(names);
		/*
		 * При добавлении элементамы не сдивагаем все элементы в сторону как было с ArrayList, а лишь меняем ссылки элементов по бокам
		 * в данном случае сменились сылки у Ilyukha и Bobos
		 * Ilyukha - previous = null, next = Andrey
		 * Andrey - previous = Ilyukha, next = Bobos
		 * Bobos - previous = Andrey, next = Lesha
		 * Lesha - previous = Bobos, next = null
		 * 
		 * Это дает нам большую скорость выполнения операции, ведь нам не нужно сдвигать целый массив в в сторону
		 * Но есть одна проблема, при указании места в ArrayList java понимает где он находиться, и сразу там работает
		 * Тогда как в LinkedList java идет по списку, как бы "ищит", нужный нам элемент, что тоже тратит время
		 *  
		 */
		testLinkedList();
		testArrayList();
		
		System.out.println(System.currentTimeMillis());
	}
	
	static void testLinkedList() {
	      List<Integer> list = new LinkedList<>();
	      
	      for(int i=0; i<=1000000; i++) {
	    	  list.add(i);
	      }
	      
	      long dysh=System.currentTimeMillis();
  
	      for(int i = 0; i<=5000; i++) {
	    	  list.add(10000, i);
	      }
	      
	      System.out.println(System.currentTimeMillis() - dysh);
	      
	   }
	static void testArrayList() {
		List<Integer> list = new ArrayList<>();
	     for(int i=0; i<=1000000; i++) {
	    	  list.add(i);
	      }
	      
	      long start=System.currentTimeMillis();

	      for(int i = 0; i<=5000; i++) {
	    	  list.add(10000, i);
	      }

	      System.out.println(""+ (System.currentTimeMillis() - start));
	   }
}

