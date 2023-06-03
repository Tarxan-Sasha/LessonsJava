package LessonsAboutLambda;
/*
 * В java 8 вместе с Лямбдой было добавленно несколько функциональных интерфейсов
 * все они доступны в библиотетке java.util.function.
 * 
 * Predicate функциональный интерфейс принимает на вход значение, првоеряет условие, и возвращает true или false
 * 
 * BinaryOperator Predicate функциональный интерфейс принимает на вход два значения одного типа, 
 * и после операции над ними возвращает результат в том же типе
 * 
 * UnaryOperator функциональный интерфейс принимает на вход значение, и после операции над ним возвращет его
 * 
 * Function функциональный интерфейс принимает на вход два значения разных типов, зачастую используеться как перевод значений из одного в другой
 * 
 * Consumer функциональный интерфейс принимает на вход значение, но не возвращает его. 
 * используеться когда надо произвести действие над значением но не нужно его возвращять, например вывод в консоль
 * 
 * Supplier функциональный интерфейс нечего не принимает, но возвращает.
 * используеться когда значения не передаються но нужно результат вернуть
 * 
 */
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LessonAboutLambda3 {

	public static void main(String[] args) {
		
		Predicate<Integer> predicate = (t)->t==0; 
		
		BinaryOperator<Integer> binaryOperator = (x, y)->x*y;
		
		UnaryOperator<Integer> inaryOperator = (b)->b+b;
		
		Function<Integer, String> function = (f)->String.valueOf(f)+" грн";
		
		Consumer<Integer> consumer = (o)->System.out.println(0);
		
		int x=3;
		int y=3;
		Supplier<Integer> supplier = ()->x-y;
		
	}

}
