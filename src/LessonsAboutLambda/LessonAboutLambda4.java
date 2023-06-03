package LessonsAboutLambda;

import java.util.Random;
/*
 * Сылки на методы, это тоже самое что и лямбда.
 * Если мы ссылаемся на статический метод, тогда пишем:
 * ИмяКласса::ИмяМетода
 * Если мы ссылаемся на нестатический метод
 * ИмяОбьекта::ИмяМетода
 * 
 */
@FunctionalInterface
interface Moveable1{//Функциональный интерфейс
	boolean isMoving(int speed);	
}

class MoveableHelp{
	static boolean isStay(int i) {
		if(i>5) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean isStay1(int i) {
		if(i>5) {
			return true;
		}
		else {
			return false;
		}
	}
}

public class LessonAboutLambda4 {
	
	public static void main(String[] args) {
	
		Moveable1 moveable = (i)->{//Лямбда которая определяет стоит ли человек или нет
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		};
		run("Sasha", moveable);//Здесь мы передаем переменную со значением лямбды
		run("Bobos", (i)->false);//Здесь мы не создаем переменную интерфейса, а сразу вставляем лямбду
		
		
		run("Ilya", MoveableHelp::isStay);
		MoveableHelp moveableHelp = new MoveableHelp();
		run("Lesha", moveableHelp::isStay1);
	
	}
	
	static void run(String name, Moveable1 moveable) {
		Random random =new Random();
		int speed = random.nextInt(10);//Случайное число от 0 до 10
		if(moveable.isMoving(speed)==true) {
			System.out.println(name+" running");
		}else {
			System.out.println(name+" stay");
		}
	}

	
}