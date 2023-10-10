package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
 *	collect - терминальная операция, которая конвертирует вывод потока в колекцию.
 *	Обычно поток выводит в терминальных операциях одно или пару чисел в потоке, но очень круто переупаковувать их в колекцию.
 *	В целом возможность перемещять данные из колеции в поток на обработку, а потом из потока в колекцию - это очень мощная важная штука
 *
 *	У collect есть три метода:
 *	1) toList() - переобразовует к типу List
 *	2) toSet() - переобразовует к типу Set
 *	3) toMap() - переобразовует к типу Map
 *
 *	Все эти методы статические класса Collectors, в целом их можно пеереопределить но они и так уже реализованы.
 *	Для того что бы конвертировать вывод стрима, надо в оперции collect вызвать один из методов выше через класс Collectors, например:
 *	collect(Collectors.toList());
 *
 *	Для toMap() чуть сложнее. Map это структура даных которая использует ключ значение, а потому когда мы конвертируем в Map нам нужно
 *	в условии toMap() указать ключ и значение в виде лямд функций. 
 *	(Если ключ будет одинаковыми то, конечно же, будет ошибка)
 *	Пример реализации toMap():
 *	collect(Collectors.toMap(x -> x, x -> x));
 *
 *	Иногда нужно что бы операция collect конвертировала вывод в определенную коллекцию, например в LinkedList, ArrayList, PriorityQueue, HashSet и так далее
 *	Для этого у collect есть вторая версия его реализации, но в целом обычно всегда хватает уже выше указаных методов.
 *	Сначала создаем обьект нужной нам колекции, затем вызываем у неё метод добавления (например, add()), а потом типо соединяем...
 *	Вот условие: <R> R collect ( S1.1pplier<R> target , BiConsumer<R, ? super Т> accumulator , B.iConsumer <R, R> combiner ) 
 *	и я плохо понимаю что и зачем combiner. Везде написано вот так: "бинарная функция, которая объединяет два объекта".
 *	В книге написано что accumulator и combiner в collect делают тоже самое что и в reduce.
 *	Короче вот пример:
 *	collect(() -> new LinkedList<Integer>(), (x,y) -> x.add(y), (x,y) -> x.addAll(y));
 *	
 *	(Я спросил в чатике и мне сказали, что combiner используеться в паралельных потоках. Но если мы паралельные потоки не используем, 
 *	то мы все равно пишем combiner хоть это и не имеет смысла).
 *
 *	Но так же, можно писать не только лямдой функцией, а и ссылками на методы, пример:
 *	collect(LinkedList::new, LinkedList::add(), LinkedList::addAll);
 *
 *	Опять таки это более подробный метод для большего контроля над процесом, ОБЫЧНО хватает методов toList(), toSet() и toMap().
 *
 */
public class Lesson_collect {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(1);
		numbers.add(2);
		
		//toList()_______________________________________________________________________________________________________________
		List<Integer> newNumbers = numbers.stream().map(x -> x+5).filter(x -> x>6).collect(Collectors.toList());//Конвертируем в коллекцию типа List
		newNumbers.stream().forEach(x -> System.out.print(x+" "));
		
		System.out.println();
		
		//toSet()_______________________________________________________________________________________________________________
		Set<Integer> setNumbers = numbers.stream().collect(Collectors.toSet());//Конвертируем в коллекцию типа Set
		setNumbers.stream().forEach(x -> System.out.print(x+" "));
		
		System.out.println();
		
		//Map()_______________________________________________________________________________________________________________
		List<Artefact> artefacts = new ArrayList<Artefact>();
		artefacts.add(new Artefact(1, "Strange_Book"));
		artefacts.add(new Artefact(2, "Fire_Sword"));
		artefacts.add(new Artefact(3, "Void_Stave"));
		
		Map<Integer, String> mapArtefacts = artefacts.stream().collect(Collectors.toMap(x -> x.getNumber(), x -> x.getName()));//Конвертируем в коллекцию типа Map, с использованием методов другого класса
		mapArtefacts.forEach((x,y) -> System.out.print(x+" "+y+" "));
		System.out.println();
		
		Map<Integer, Integer> mapNumbers = numbers.stream().collect(Collectors.toMap(x -> x, x -> x ));
		mapNumbers.forEach((x,y) -> System.out.print(x+" "+y+" "));
		
		System.out.println();
		
		//Если требуется перенести содержимое в определённый тип колекции
		Queue<Integer> queueNumbers = numbers.stream().collect(() -> new PriorityQueue<Integer>(),//Создаем обьект нужной колекции
				(queue, element) -> queue.add(element), //Добавляем элементы в список
				(queue1, queue2) -> queue1.addAll(queue2));//Обьеденяем две коллекций
		queueNumbers.forEach(x -> System.out.print(x+" "));
		
		LinkedList<Integer> listNumbres = numbers.stream().collect(LinkedList::new, //Сылка на конструктор класса LinkedList, для создания обьекта 
				LinkedList::add, //Ссылка на метод add(), для добавления элемента
				LinkedList::addAll);//Ссылка на метод addAll(), для обьеденения двух коллекций
		listNumbres.stream().forEach(x -> System.out.print(x+" "));
		System.out.println();
	}

}


class Artefact{
	String name;
	int number;
	public Artefact(int number, String name) {
		super();
		this.name = name;
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}