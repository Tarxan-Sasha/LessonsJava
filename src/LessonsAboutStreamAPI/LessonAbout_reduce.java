package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * reduce() - терминальная операция, которая нужна тогда когда необходимо свести весь поток в одно значение.
 * Например, нам надо все перемножить или сумировать, и что бы в потоке остался только один элемент.
 * 
 * У этой операции в аргументах есть три значения:
 * Optional<U> reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
 * 1) U identity - оно обозначет базовое значение которое будет выдано в случае если поток будет пустым, 
 * а так же оно предоставляет начальное значение для второго параметра BiFunction.
 * То есть это значение identity так же добавиться в лямбде выражение BiFunction.
 * А так же это значение не обязательно вписывать, имеет возвращаемый тип как у reduce.
 * 
 * reduce() имеет возвращаемый тип обернутый в класс Optional<>, ТОЛЬКО в кнострукции БЕЗ первого значения (identity).
 * identity - гарантирует одно значение, по умолчанию, а без него в потоке может нечего и не быть.
 * Вызов операции reduce() на пустом потоке приведет к null.
 * Потому значение обвалакиваесться в обьект Optional<> во избежания ошибок.
 * 
 * 2) BiFunction<U,? super T,U> accumulator - это лямбда выражение которое принимает два значения. 
 * Сначала эти два значения это первый и второй элемент, а после первой итерации уже первый элемент это результат прошлой итерации.
 * Как то сложно описал просутю вещь... То есть: 1,2,3.
 * x1 + x2.
 * Первая итерация: 1 + 2 = 3.   Вторая итерация: 3+3.
 * То есть да, reduce() сохраняет результат, а потом к этому результату и следующему элементу применяет указанное лямбда выражение.
 * 3) BinaryOperator<U> combiner - это свойство пишиться и используеться только тогда когда поток являеться паралельным.
 * О паралельных потоках позже(надо будет дописать тут, блять)
 * 
 * 
 * 
 * 
 * 
 */
public class LessonAbout_reduce {

	public static void main(String[] args) {
		Stream<Integer> numbers = Stream.of(1,2,3,4);
		int i = numbers.reduce(0,(x,y)->x+y);//Сумируем  все значения потока в одно значение, в случае пустого потока выведеться 0
		System.out.println(i);
		
		double [] array = {};
		double d = Arrays.stream(array).reduce(1.0,(x,y)->x+y);//Сумируем дроби, но массив пуст, и если первого значения 1.0 не будет, будет ошибка null.
		System.out.println(d);
		////////////////////////////////////////ЭКСПЕРИМЕНТ
		/*
		 * Тут я подумал а в чем разница между reduce() и map()? что та можно спокйно добавить что тут
		 * Дело в том что reduce() именно что принимает 2 значения и он склеивает результаты в одно число,
		 * тогда как map() лишь добавляет и меняет элементы. Видно в конслое.
		 * 
		 */
		System.out.println("С помощью map(), видно что элементы просто добавили себя к себе и остались на местах: ");
		int [] arrayInt = {1,2,3,4};//Массив
		IntStream is = Arrays.stream(arrayInt);//Создаем поток на основе массива int, для массивов типа int есть специальзированый поток IntStream
		is.map(x -> x+x).forEach(x -> System.out.print(x+" "));//Пытаемся сумировать елменты в один элемент операцией map()
		
		System.out.println();
		System.out.println("С помощью reduce(), а тут все элементы добавились и склеились в одно значение: ");
		IntStream is1 = Arrays.stream(arrayInt);//Создаем поток на основе массива int, для массивов типа int есть специальзированый поток IntStream
		System.out.println(is1.reduce((x,y) -> x+y));//Сумируем уже операцией reduce, видим что элементы сумируеться в один элемент.
													//Мы не указали нечего первым параметром, а потому на выходе получили элемент обернутый в спасительную рубашку OptionalInt 
		///////////////////////////////////////
		System.out.println();
		List<String> names = new ArrayList<String>();
		names.add("Ilyukha");
		names.add("Bobas");
		names.add("Lescha");
		Optional<String> os = names.stream().reduce((x,y) -> x+y);//Обвалакиваем в Optional потому как мы не установили первое значение по умолчанию. 
																  //И поток может быть пустым
		System.out.println(os);
		
	}

}
