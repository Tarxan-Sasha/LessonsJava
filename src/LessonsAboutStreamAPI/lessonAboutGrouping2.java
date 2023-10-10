package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * Это продолжение к LessonAboutGrouping1, 
 * все методы которые тут есть ДОЛЖНЫ вписываться вторым параметром в метод groupingBy()
 *
 * 1) maxBy - возвращает максимальное число из созданной групы.
 * 	  minBy - возвращает минимальное значение из созданной групы.
 * В аргументы этих методов нужно положить метод компоратора, в который нужно положить параметр который будет отфильтрован, пример:
 * Collectors.maxBy(Comparator.comparing(Fruit1::getAmount))
 * Так же возращаемый тип этих методов это Optional<Требуемый тип, если int тогда вписываем Integer>, 
 * потому что эти методы возвращают контретное число и они могут вернуть null если поток будет пустым.
 * В нашем случае возвращаемый тип это: Optional<Fruit1>.
 * И новая коллекция Map будет выглядеть вот так:
 * Map<String, Optional<Fruit1>>
 *
 * 2) summarizing - этот метод обьединяет указаные значения группы в набор данных, с которыми можно будет потом работать. 
 * summarizingInt() - это версия метода для Integer значения, елементы такого набора становяться обьектами класса IntSummaryStatistics
 * потому в дженерики новой колекции Map требуеться вписать этот класс как значение, пример:
 * Map<T, IntSummaryStatistics>
 * summarizingLong() - это версия метода для Long значения, елементы такого набора становяться обьектами класса LongSummaryStatistics
 * потому в дженерики новой колекции Map требуеться вписать этот класс как значение, пример:
 * Map<T, LongSummaryStatistics>
 * summarizingDouble() - это версия метода для Double значения, елементы такого набора становяться обьектами класса DoubleSummaryStatistics
 * потому в дженерики новой колекции Map требуеться вписать этот класс как значение, пример:
 * Map<T, DoubleSummaryStatistics>
 * 
 * У всех этих обьектов есть методы для обработки нового набора данных
 * 		1) getAverge() - возвращает средние значение набора
 * 		2) getCount() - возвращает колчиестов элементов в наборе
 * 		3) getMin() - возвращает минимальное значение в наборе
 * 		4) getMax() - возвращает максимальное значение в наборе
 * 		5) getSum() - возвращает сумму єлементов в наборе
 * 		6) accept() - добавляет новій єлементв набор
 *  
 *  3) mapping - этот метод конвертирует, как я понимаю, поток из одного типа в другой.
 *  Его не обязательно использовать в методе groupingBy()
 *  И, как я понимаю, он принимает два параметра:
 * 	первый параметр это что он принимает, а второй во что он его переводит.
 *  Так вот второй параметр как я понимаю, должен быть метод Collectors. 
 * 
 * 
 */

public class lessonAboutGrouping2 {

	public static void main(String[] args) {
		List<Fruit1> fruit1 = new ArrayList<Fruit1>();
		fruit1.add(new Fruit1("Orange",4));
		fruit1.add(new Fruit1("Lemon",2));
		fruit1.add(new Fruit1("Banana",6));
		fruit1.add(new Fruit1("Orange",3));
		fruit1.add(new Fruit1("Banana",12));
		
		//maxBy minBy
		Map<String, Optional<Fruit1>> maxFruit = fruit1.stream().collect(Collectors.groupingBy(Fruit1::getType, Collectors.maxBy(Comparator.comparing(Fruit1::getAmount))));
		
		for(Map.Entry<String, Optional<Fruit1>> i: maxFruit.entrySet()) {
			System.out.println(i.getKey()+" - "+i.getValue().get().getAmount());
		}
		//
		System.out.println("-----------------------------------------------------");
		//summarizing
		Map<String, IntSummaryStatistics> summarizingIntFruit = fruit1.stream().collect(Collectors.groupingBy(Fruit1::getType, Collectors.summarizingInt(Fruit1::getAmount))); 
		
		for(Map.Entry<String, IntSummaryStatistics> i : summarizingIntFruit.entrySet()) {
			System.out.println(i.getKey()+" - "+i.getValue().getAverage());
		}
		//
		System.out.println("-----------------------------------------------------");
		
		//mapping
		Map<String,List<Integer>> mappingFruit = fruit1.stream().collect(Collectors.groupingBy(Fruit1::getType, Collectors.mapping(Fruit1::getAmount, Collectors.toList())));
		
		for(Map.Entry<String, List<Integer>> i : mappingFruit.entrySet()) {
			System.out.println(i.getKey()+" - "+i.getValue());
		}
		//Без groupingBy
		Optional<Integer> mappingFruit1 = fruit1.stream().collect(Collectors.mapping(Fruit1::getAmount, Collectors.maxBy(Integer::compareTo)));
		System.out.println(mappingFruit1.get());
		//Без groupingBy и колекция из обычныхх чисел, а не обьектов Fruit
		List<Integer> n = Arrays.asList(1,2,4,5);
		System.out.println(n.stream().collect(Collectors.mapping(x -> x, Collectors.minBy(Integer::compareTo))));
	}

}




class Fruit1{
	private String type;
	private int amount;
	public Fruit1(String type, int amount) {
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
		return "Fruit1 [type=" + type + ", amount=" + amount + "]";
	}
	
	
}