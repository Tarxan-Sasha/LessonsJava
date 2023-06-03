package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * forEach() - терминальная/конечная операция, для перебора элементов потока.
 * По сути выполняет туже функцию что и форыч.
 * 
 * filter() - промежуточная операция которая фильтрует поток.
 * В услове кладеться лямбда выражение которое должно отвечать true или false,
 * и по которому фильтруеться все элементы потока.
 * В потоке остаються те элементы которые прошли фильтрацию, то есть вызвали true
 *
 * map() - промежуточная операция которая изменяет/переобразовует поток.
 * В условие кладеться лямбда выражение, которое применяеться ко всем елементам потока.
 * Возвращает элементы измененные условием этой лямбды.
 * По сути ты просто пишешь как ты хочешь изменить элементы потока.
 * Можно взять колекцию обьектов и вызвать у них методы, и тогда это будет поток состоящий из вывода этих методов, а не обьектов.
 * Или можно взять написать в лямбду условие примера, например: x->x+3 и тогда 3 добавиться к каждому элементу потока, и тем самым поток измениться и переабразуеться.
 * Для того что бы переобразить элементы в Integer, Long, Double есть специальные методы mapToInt(), mapToLong() и mapToDouble()
 * 
 * flatMap() - промежуточная операция, переводит двухуровневый поток в одноуровненвый.
 * Блять..это просто ыыыыгггг...
 * Иногда бывает когда нужно обработать многоуровненвый массив или колекцию которая состоит из других колекций,
 * и тогда обрабатывать их сложно. 
 * И для этого есть промежуточная операция flatMap() - которая занимаеться сглаживанием потока, перебразовует двумерный массив в одномерный,
 * превращает колекцию List<List<Integer>> в List<Integer>.
 * Есть даже такое понятие Flattening(сглаживание) - это обьединение нескольких колекций/масивов в один.
 * К примеру, было так:
 * [[1,2][3,4]]
 * а стало так:
 * [1,2,3,4]
 * как я понял, эта операция словно вызвает отедльный поток для каждого элемента, тем самым отделяя их друг от друга. А потом склеивает обратно но уже в одном потоке
 * без многоуровневости.
 * 
 * 
 * 
 */
public class LessonAbout_forEach_filter_map_flatMap {
		public static void main(String [] args) {
			List<Integer> numbers  = new ArrayList<Integer>();
			numbers.add(1);
			numbers.add(2);
			numbers.add(3);
			numbers.add(4);
			//forEach()
			Stream<Integer> streamNumbers = numbers.stream();
			streamNumbers.forEach(x -> System.out.print(x + " "));//Перебирает элементы потока
			System.out.println();//Перенос строки
			numbers.forEach(System.out::print);//Сокращенная версия с ссылкой на метод print() или println(), так же перебирает элементы потока
			System.out.println();//Перенос строки
			//filter()
			numbers.stream().filter(x -> x < 3).forEach(System.out::print);//Устанавливаем булевое условие для фильтрации элементов потока
			System.out.println();//Перенос строки
			//map()
			numbers.stream().map(x -> x*2).forEach(System.out::print);//Устанавливаем условие которое выполняеться для каждого элемента в потоке
			System.out.println();//Перенос строки
			numbers.stream().mapToDouble(x -> x).forEach(System.out::print);//Переводим каждый элемент типа Integer в тип Double
			System.out.println();//Перенос строки
			//flatMap()
			List<Integer> listArry1 = Arrays.asList(1, 2);//Создаем список с помошью метода asList,превращая мессив в колекцию
			List<Integer> listArry2 = Arrays.asList(3, 4);//Создаем список с помошью метода asList,превращая мессив в колекцию
			
			List<List<Integer>> listOfArrays = new ArrayList<List<Integer>>();
			listOfArrays.add(listArry1);
			listOfArrays.add(listArry2);
			System.out.println("Вывод колекции до flatMap "+listOfArrays);
			
			List<Integer> list = listOfArrays.stream().flatMap(x -> x.stream()).toList();//Создаем новый список, с помощью flatMap мы вызываем поток для каждого элемента,
																						 //а после этого переобржаем все в список методом toList
			System.out.println("Вывод колекции после flatMap "+list);
			

			
		}
}

