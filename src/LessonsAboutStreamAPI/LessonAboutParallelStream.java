package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * До этого момента были показаны только последовательные потоки, которые работают стабильно с лева на право,
 * выводят ожидаемый результат и задействуют лишь одно ядро процесора.
 * 
 * Но в Stream API есть и паралельные потоки. 
 * Такие потоки задействуют несколько ядер процесора, от чего программа по сути ДОЛЖНА выполняться быстрее, повышая производительность,
 * грубо говоря делая программу более эфективной.
 * Но, это только в теории, на практике паралельные потоки не гарантируют повышения производительности, 
 * и в каждом конкретном случае нужно проверять и тестировать.
 * 
 * Для создания паралельного потока есть два метода:
 * 1) parallel() - этот метод первращает существующий последовательный поток в паралельный поток
 * 2) parallelStream() - этот метод интерфейса Collection и доступен только колекциям, с помощью этого метода поток сразу становиться паралельным
 * 
 * Не все последовательные потоки можно безопастно перевести на паралельные. 
 * Потому что паралельный поток, по сути разбивает задачи на части и каждую часть выполняет свое ядро процессора.
 * После все части склеиваються и выполняеться последняя финальная/терминальная операция.
 * И из-за того что некоторые части могут выполниться быстрее чем другие, может произойти сбой и результат будет не точным.
 * Потому для корректного перевода из последовательного потока в паралельный, требуетсья что бы паралельный поток был ассоциативный.
 * То есть он давал один и тот же результат независимо от того с какой стороны он выполняеться, пример:
 * 5*2*3*5 = 150
 * Этот пример ассоциативный, он даст один и тот же рузельтат как бы мы не смешивали числа.
 * Последоваетльный поток, по сути, должен быть таким же. А именно иметь один результат независимо в какой последовательности будут запускаться операции.
 * 
 * Причины которые могут повлиять на производительность паралельного потока:
 * 1) Количество ядер - если компютер одноядерный то применение паралельных потоков не имеет смысла. В теории чем ядер больше тем программа будет работать быстрее, НО ЭТО В ТЕОРИИ!
 * 2) Размер данных - если данные большие тогда и скорость их разделения, а затем сведения тоже увеличиваеться.
 * 3) Структура данных - чем она проще, тем быстрее с ней будет работать паралельный поток. к примеру:
 * Структура данных список в ArrayList это последовательные не связаные данные, с такой структурой паралельному потоку легче работать
 * А вот LinkedList это связной список где каждый элемент связан с следующим и предыдущим, с такой структурой паралельному потоку работать труднее.
 * 4) Примитывы - с примитавами паралельному потоку работать легче и проще, чем с обьектами классов
 * 
 * 
 * Самый легйкий и доступный способ увидеть как паралельный поток нарушает последовательность можно на примере терминальной операции forEach()
 * В последоваетльных потоках сохраняетсья порядок элементов, то есть в каком порядке они поступили в поток, в таком они с него и выйдут.
 * Паралельыне потоки тоже так стараються делать, но в операции forEach() вывод элементов все равно осуществляетсья в произвольном порядке.
 * Связи с этим есть две операции:
 * 1) forEachOrdered() - это терминальная операция которая заменяет обычный forEach(), она сохраняет порядок элементов.
 * Но нужно помнить что сохранение порядка это дополнительная нагрузка для потока из-за чего следует потеря скорости и т.д.
 * 2) unordered() - это промежуточная операция которая нужна когда порядок нам в обще не нужен, эта операция выключает сохранение порядка в целом.
 * Конечно же не соблюдение порядка ускорит выполнение паралельного потока.
 * 
 * (Тест: тест показал что если сначала запустить unordered(), а потом forEachOrdered() порядок будет сохранен)
 * 
 */
public class LessonAboutParallelStream {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		Collections.addAll(numbers, 11,93,4,5,76);
		
		//Последовательный поток
		numbers.stream().forEach(x -> System.out.print(x+" "));
		
		System.out.println();
		//Паралельный поток c использованием метода parallelStream()
		numbers.parallelStream().forEach(x -> System.out.print(x+" "));
		
		System.out.println();
		
		//паралельный поток созданый из последовательного потока методом parallel(), сохраняем порядок операцией forEachOrdered()
		numbers.stream().filter(x -> x<50).parallel().forEachOrdered(x -> System.out.print(x+" "));
		
		System.out.println(); 
		//паралельный поток созданый из последовательного потока методом parallel(), здесь мы умышленно нарушаем порядок операцией unordered()
		numbers.stream().filter(x -> x<50).parallel().unordered().forEachOrdered(x -> System.out.print(x+" "));
		
	}

}