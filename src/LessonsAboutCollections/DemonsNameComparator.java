package LessonsAboutCollections;

import java.util.Comparator;
/*
 * Camparator - интерфейс для сравнения и сортировки колекции.
 * Он используеться для более частных случаев, для более редких.
 * Camparator имеет один метод, от чего являеться функциональным.
 * Логика метода должна иметь в себе конвенцию:
 * 01 > 02 = 1 - true
 * 01 < 02 = -1 - false
 * 01 == 02 = 0 - равны
 * 
 * Так же Camparator являеться параметризированным интерфейсом,
 * и в <> нужно передавать тот класс, который надо сортировать
 * 
 * Обычно под этот интерфейс создают отдельный класс, но так как
 * интерфейс являеться функциональным его можно реализовать с помощью:
 * 1) лямбды
 * 2) анонимного класса
 * 
 * Что бы отсортировать колекцию с помощью Comparator
 * нужно при вызове метода sort, через запятую после колекции указать обьект Comparator, пример:
 * Collections.sort(demons, demonsNameComparator)
 * 
 */
public class DemonsNameComparator implements Comparator<Demons>{
	@Override
	public int compare(Demons o1, Demons o2) {
		if(o1.name.length() < o2.name.length()) {
			return 1; // true
		}else {
			if(o1.name.length() > o2.name.length()) {
				return -1; // false
			}else {
				return 0; //ровны
			}
		}
	}
}
