package LessonsAboutCollections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/*
 * Iterator - это обобщенный интерфейс который наследуют все колекции.
 * С помощью кторого можно итерироваться/перебирать элементы коллекции
 * А так же удалять.
 * Iterator добавляет следующие методы:
 * 1)hasNext() - проверяет на наличие следующего элемента
 * 2)next() - возвращает следуюющий элемент, если такого нет вернет исключение.
 * 3)remove() - удаляет элемент на который указывает метод next().
 * Важно!: Метод remove() нельзя вызвать, не вызвав передним метод next()
 * 
 * ListIterator - этот интерфейс расширяет Iterator, и используеться классами которые реализуют интерфейс List.
 * Этот инетрфейс добавляет методы для двухсторонего обхода списка, то есть как с конца так и начала:
 * 1)hasPrevious() - проверяет наличие предыдущего эелемента.
 * 2)previous() - возвращает придыдущий элемент.
 * Так же добавлены методы на возвращение индексов элементов:
 * 1)nextIndex() - возвращает индекс следующего элемента, если его нет вернет размер списка.
 * 2)previousIndex() - возвращает индекс предыдущего элемента, если его нет вернет -1
 * 3)add() - вставляет новый элемент, который будет возвращен следующим вызовом next()
 * 4)set() - вствляет элемент на место элемента который был вызван методами next() и previous() последним.
 * 
 * Iterable - это интерфейс который показыват что класс можно проитерировать (в for each)
 * он реализует один метод iterator(), в котром нужно вернуть iterator.
 * 
 * for each создает и скрывает свой интератор/указатель, делая его не доступным, а потому вызвать метод remove() нельзя.
 * Также for each лишь перебирает элементы, он не может изменить количество элементов в наборе.
 * Если удалить элемент в колекции во время перебора for each, тогда колекция уменьшиться и инедксы сменяться.
 * Из-за чего будет ошибка.
 * Для безопасного удаления элемента нужен доступ к итератору. А доступ к нему for each не дает.
 * Для удаления элементов при переборе нужно использовать Iterator
 * 
 * 
 * 
 * For each можно проитырировать массивы и обьекты классов которые имплементируют интерфейс Iterable
 */
public class LessonAboutIterator {

	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("Bobos");
		names.add("Lesha");
		names.add("Illya");
		names.add("Sasha");
		
		for(String i:names) {
			System.out.println(i);
		}
		
		System.out.println();
		
		Iterator<String> itr = names.iterator();//Тут мы создаем обьект итератора, который и позволяет вызвать метод iterator() на колекции
		while(itr.hasNext()) {//И уже используя этот итератор мы можем итерировать коллекцию
			System.out.println(itr.next());
			
		}
		

		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		ListIterator<Integer> listItr = numbers.listIterator(numbers.size());//здесь мы указываем номер с которого нужно начать отчет
	
		while(listItr.hasPrevious()) {
			System.out.println(listItr.previous());
		}
	
	}

}








