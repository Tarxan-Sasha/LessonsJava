package LessonsAboutLambda;

import java.util.Random;

/*
 * Лямбды можно передавать в параметры методов.
 * Лямбды могут быть результатом методов
 */
interface Moveable{//Функциональный интерфейс
	boolean isMoving(int speed);
}

@FunctionalInterface
interface Operation{
	int execute(int x, int y);
}


public class LessonAboutLambda2 {
	
	public static void main(String[] args) {
	
		Moveable moveable = (i)->{//Лямбда которая определяет стоит ли человек или нет
			if(i>5) {
				return true;
			}
			else {
				return false;
			}
		};
		
		run("Sasha", moveable);//Здесь мы передаем переменную со значением лямбды
		
		run("Bobos", (i)->false);//Здесь мы не создаем переменную интерфейса, а сразу вставляем лямбду
	
		
		Operation operation=action(2);//Выбираем лямбду
		System.out.println(operation.execute(3, 5));//Расчитываем с помощью выбранной лямбды
		
		System.out.println(actionMath(3,5,6));//Вариант без лямбды
	}
	
	static void run(String name, Moveable moveable) {
		Random random =new Random();
		int speed = random.nextInt(10);//Случайное число от 0 до 10
		
		if(moveable.isMoving(speed)==true) {
			System.out.println(name+" running");
		}else {
			System.out.println(name+" stay");
		}
	}
	

	
	/*
	 * Этот метод возвращает лямбда выражение 
	 */
	static Operation action(int n) {
		switch(n) {
		case 1: 
			return (x, y)->x+y;
		case 2:
			return (x, y)->x-y;
		case 3:
			return (x, y)->x*y;
		default:
			return (x, y)->0;
		}
	}
	

	
	// Тоже самое толлько без лямбд
	static int actionMath(int x, int y, int c) {
		switch(x) {
		case 1:
			return y+c;
		case 2:
			return y-c;
		default:
			return y+c;
		}
	}
	
}
