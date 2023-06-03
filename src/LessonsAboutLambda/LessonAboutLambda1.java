package LessonsAboutLambda;
/*
 * Лямда появилась в java 8.
 * Лямда - это можно сказать метод без имени. 
 * Который можно передать в переменную и вызывать где угодно.
 * Лямбда - выражение не появляеться само по себе, это выполнение
 * метода из функционального интерфейса.
 * 
 * Функциональный интерфейс - это интерфейс содержащий только один метод без реализации.
 * 
 * Лямбда делиться на:
 * 1) Список параметров выражения, скобочки()
 * 2) Стрелка -> 
 * 3) Тело 
 * 
 * Параметры Лямбды должны соотвествовать параметрам метода интерфейса.
 * 1) Тип параметров можно и не писать, а можно и написать, как угодно роли не играет.
 * 2) Если метод не принимает никаких параметров тогда скобки пишутся пустыми.
 * 3) Если метод принимает лишь один параметр, тогда можно скобки не писать.
 *  
 * Лямбда может использовать переменные обьявленные в классе и в методе:
 * 1) Переменную на уровне класса, статическую, можно использовать и изменить.
 * 2) Переменную локальную, на уровне метода, можно использовать
 * НО изменить нельзя, локальная переменная должна быть помечена final
 * или быть effective final.
 * 
 * 
 * 
 */
import java.util.Scanner;
@FunctionalInterface //Это анотация которая показывает что интерфес должен быть функциональным 
interface OperationAble{
	int calculate(int x, int y);
}

@FunctionalInterface
interface OperationAble1{
	int calculate(int x);
}

@FunctionalInterface
interface OperationAble2{
	int calculate();
}

@FunctionalInterface
interface OperationAble3{
	void calculate(String s);
}

public class LessonAboutLambda1 {
	
	static int q = 30;

	public static void main(String [] args) {

		int t=20;
		int n;

		OperationAble operation;
		operation = (int x,int y)-> x - y;//Лямбда в одну строку, можно типы переменных и не писать.
		System.out.println(operation.calculate(3, 2));
		
		operation = (x, y)-> x*y;//Лямбда в одну строку, без типов данных
		System.out.println(operation.calculate(2, 3));

		OperationAble1 operation1;
		operation1 = x -> x+x;//Лямбда в одну строку, так как метод принимает лишь один параметр скобочки можно не писать
		System.out.println(operation1.calculate(4));
		
		OperationAble2 operation2;
		operation2 = () -> 45+43;//Лямбда в одну строку, так как метод нечего не принимает, скобочки пустые
		System.out.println(operation2.calculate());
		
		OperationAble3 operation3= s -> System.out.println(s);//Терминальные лямда выражения, они нечего не возвращают
		operation3.calculate("Hello");
		
		
		operation = (x, y)->{//Лямда с использованием статичных переменных(переменных на уровне класса)
			q=40;
			return x-y+q;
		};
		System.out.println(operation.calculate(3, 2));
		
		operation = (x, y)->{//Лямда с использованием локальных переменных
			//t=10;//Ошибка потому что локальные переменные в лямбде менять нельзя
			return x*y+t;
		};
		System.out.println(operation.calculate(4, 2));
		
		n = operation.calculate(1, 1);//Можно передать результат в переменную 
		System.out.println(n);

		
	}


}
