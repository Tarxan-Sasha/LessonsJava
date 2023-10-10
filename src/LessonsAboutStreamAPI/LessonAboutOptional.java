package LessonsAboutStreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Некоторые операции (такие как: min max findFirst findAny) возвращают обьект класса Optional.
 * Потому что эти методы возвращают определенное значение.
 * И если поток пуст они могут вернуть null и это приведет к исключению java.util.NoSuchElementException.
 * NoSuchElementException - посути означает что елемента нет, пусто.
 * Для того что б избежать ошибки и дропа программы результат потока обертываеться в обьект класса Optional.
 * 
 * В таком случае результат потока можно получить вызвав у обьекта Optional метод get().
 * 
 * Но если поток был пуст, и мы у обьекта Optional вызовим метод get(), у нас снова возникнет исключение NoSuchElementException и дроп программы.
 * Потому что мы хотим получить то чего нет, поток был пуст.
 * Но при этом сам поток отработает БЕЗ исключения, благодаря обвертыванию результата в обьект класса Optional.
 * То есть при работе потока все будет хорошо, но как только мы захотим получить этот пустой/null эллемент методом get(), снова возникнет исключение и программа вылетит. 
 * 
 * На такие случаи класс Optional имеет методы для избегания исключения NoSuchElementException:
 * 1)isPresent() - обычная првоерка наличия хоть какого то элемента, если элемент есть тогда выдаст true если нет то false
 * 2)orElse() - позволяет задать число по умолчанию, в случае если значения нет будет возвращено указанное число в параметре
 * 3)orElseGet() - с помощью этого метода можно задать лямда функцию которая выполниться в случае если значения нет.
 * При этом мы должны написать функцию без параметров, то есть вот так: () -> 3*7, а не вот так: x -> x*7.
 * Потому что x отвечает за существующий параметр, которого нет.
 * 4)orElseThrow() - позволяет задать в параметры исключение, которое будет выброшено в случае если значения нет.
 * 
 * 
 * Так же у класса Optional есть методы что бы обработать существующее значение:
 * 1)ifPresent() -  в параметры этого метода можно указать лямбду функуцию с одним параметром которое сработает если значение есть.
 * Но если значения нет, то исключения все равно не будет.
 * 2)ifPresentOrElse() - с помощью этого метода можно написать две лямбды функции, одна на случай если значения есть, вторая на случай если его нет.
 * Вписывать функции в параметры нужно именнов порядке: сначала функция С параметром, а потом уже функция БЕЗ параметра. 
 * Иначе ошибка.
 * 
 */


public class LessonAboutOptional {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		Optional<Integer> resultStream = numbers.stream().map(x -> x+2).max(Integer::compare);//ошибки не будет, ведь результат обернут в обьект Optional
		System.out.println(resultStream);//И если мы хотим просто вывести на экран обьект, то исключения не будет выведеиться просто "Optional.empty"
		//Но если мы захоти получить значение, тогда выскочит исключение, ведь значения НЕТ.
		//System.out.println(resultStream.get());
		
		//isPresent()
		Optional<Integer> resultStream1 = numbers.stream().map(x -> x+2).max(Integer::compare);
		if(resultStream1.isPresent()) {
			System.out.println(resultStream1.get());
		}
		
		//orElse
		Optional<Integer> resultStream2 = numbers.stream().map(x -> x+2).max(Integer::compare);
		System.out.println(resultStream2.orElse(0));
		
		//orElseGet
		Optional<Integer> resultStream3 = numbers.stream().map(x -> x+2).max(Integer::compare);
		System.out.println(resultStream3.orElseGet(() -> 33+3 ));

		//orElseThrow
		Optional<Integer> resultStream4 = numbers.stream().map(x -> x+2).max(Integer::compare);
		//тут будет выбрашено исключение
		/*
		try {
			System.out.println(resultStream4.orElseThrow(MyException::new ));
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//ifPresent
		Optional<Integer> resultStream5 = numbers.stream().map(x -> x+2).max(Integer::compare);
		resultStream5.ifPresent(x -> System.out.println(x));//Тут нечего не выдаст, потому как поток пуст и нет финального значения
		
		//ifPresentOrElse
		Optional<Integer> resultStream6 = numbers.stream().map(x -> x+2).max(Integer::compare);
		resultStream6.ifPresentOrElse(
				x -> System.out.println(x), //Указываем варианты действий, первая функция СО значением на случай если значение есть
				() -> System.out.println("ifPresentOrElse: Значения нет"));//вторая функция БЕЗ значения на случай если значения нет.

	}
	
}

class MyException extends Exception{
	
	@Override
	public String toString() {
		return "ОШИБКА САШУНЧИК!!!!";
	}
	
}







