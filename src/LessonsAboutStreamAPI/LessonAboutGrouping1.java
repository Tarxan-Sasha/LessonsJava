package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 *  Групировка
 *  Методы: groupingBy(), partitioningBy(), counting(), summing().
 *  
 *  Для группировки в Stream API используються методы класса Collectors, которые нужно вызывать в аргументах операции collect().
 *  Результат потока должен сохраняться в коллекцию Map.
 *  
 *  1)groupingBy() - групирует по указаному в аргументах признаку, например:
 *  
 *  collect(Collectors.groupingBy(Fruit::getType));
 *  
 *  Результатом потока будет String переменная указовающая на тип фрукта, она будет ключом в новой колекции Map.
 *  Потому при обьвлении Map нужно указать в дженериках что ключом будет String, а значением уже обьект Fruit.
 * 	Map<String, List<fruit>>
 * 
 * 	2)partitioningBy() - групирует по соответствию условию указаному в аргументах этого метода.
 * 	Грубо говоря те кто прошли условие и вернули true, идут в одну группу, те кто не прошли и получили false идут в другую группу, например:
 * 	
 * 	collect(Collectors.partitioningBy(x -> x.getType() == "Lemon"));
 * 
 * 	Результатом потока будет Boolean переменная которая указывает на результат условия, эта переменная будет ключом в новой колекции Map
 * 	Потому при обьявлении Map нужно указать в дженериках что ключом будет Boolean, а значением обьект Fruit
 * 	Map<Boolean<List<Fruit>>>
 * 
 * 	3)counting() - этот метод считает и возвращает количество элементов в каждой отсортированной группе.
 * 	Этот метод вписываеться в аргументы метода groupingBy(), пример:
 * 	
 *  collect(Collectors.groupingBy(Fruit::getType, Collectors.counting()));
 *  
 *  То есть в начале нам нужно в аргумент метода groupingBy положить сначала параметр по которому групировать, а потом положить выполнение метода counting().
 *  В новой колекции Map ключом будет переменная параметра групировки, у нас String, а значением будет результат метода counting() который нужно указывать как Long
 *  Map<String, Long>
 *  
 *  4)summing() - подсчитывает сумму указаного в аргументах значения каждого элемента в отсортированной группе.
 *  Этот метод как и прошлый нужно вызвать вторым аргументом в методе groupingBy(), пример:
 *  
 *  collect(Collectors.groupingBy(Fruit::getType, Collectors.summingInt(Fruit::getAmount)));
 *  
 *  То есть тут тоже, сначала groupingBy() групирует по указаному признаку, 
 *  а потом уже в каждой группе срабатывает summing() в который мы влаживаем значение по которому мы сумируем элементы.
 *  В новой колекции Map ключом будет переменная параметра групировки, у нас это String, а значением будет результат метода summing().
 *  Метод summing() имеет три вариации взависимости от типа который он должен сумировать:
 *  1) Для int значений используеться метод summingInt()
 *  2) Для long значений используеться метод summingLong()
 *  3) Для double значений используеться метод summingDouble()
 *  
 *  Мы используем summingInt, потому в нашем случае колекция Map будет такой:
 *  Map<String, Integer>
 *  
 *  
 */


public class LessonAboutGrouping1 {

	public static void main(String[] args) {
		List<Fruit> fruit = new ArrayList<Fruit>();
		fruit.add(new Fruit("Lemon",3));
		fruit.add(new Fruit("Orange",5));
		fruit.add(new Fruit("Lemon",5));
		fruit.add(new Fruit("Pineapple",1));
		fruit.add(new Fruit("Lemon",2));
		fruit.add(new Fruit("Pineapple",22));
		
		//Collectors.groupingBy()___________________________________________________________________________
		Map<String, List<Fruit>> typeFruit = fruit.stream().collect(Collectors.groupingBy(Fruit::getType));	
		
		for(Map.Entry<String, List<Fruit>> x : typeFruit.entrySet()) {
			System.out.println(x.getKey());
			for(Fruit f : x.getValue()) {
				System.out.println(f.toString());
			}
		}
		System.out.println("---------------------------------");
		//Collectors.partitioningBy()________________________________________________________________________
		Map<Boolean, List<Fruit>> typeFruit1 = fruit.stream().collect(Collectors.partitioningBy(x -> x.getType() == "Lemon")); 
		
		for(Map.Entry<Boolean, List<Fruit>> x : typeFruit1.entrySet()) {
			System.out.println(x.getKey());
			for(Fruit f : x.getValue()) {
				System.out.println(f.getType());
			}
		}
		System.out.println("---------------------------------");
		//Collectors.counting()________________________________________________________________________
		Map<String, Long>  typeFruit2 = fruit.stream().collect(Collectors.groupingBy(Fruit::getType, Collectors.counting()));
	
		for(Map.Entry<String, Long> x : typeFruit2.entrySet()) {
			System.out.println(x.getKey()+" - "+x.getValue());
		}
		System.out.println("---------------------------------");
		//Collectors.summing()________________________________________________________________________
		Map<String, Integer> typefruit3 = fruit.stream().collect(Collectors.groupingBy(Fruit::getType, Collectors.summingInt(Fruit::getAmount)));
		
		for(Map.Entry<String, Integer> x : typefruit3.entrySet()) {
			System.out.println(x.getKey()+" - "+x.getValue());
		}
		
		
	}
	
}

class Fruit{
	private String type;
	private int amount;
	public Fruit(String type, int amount) {
		super();
		this.type = type;
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Fruit [type=" + type + ", amount=" + amount + "]";
	}
	
	
	
}