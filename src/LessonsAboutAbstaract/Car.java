/*
 * Этот класс не имеет нечего общего с животными и уборщиком, но он тоже может двигаться потмоу реализует интерфейс Moveable.
 * 
 * Поусти этот класс тоже модет быть абстрактным, потому как:
 * машина - это абстрактное понятие.
 * 
 */

package LessonsAboutAbstaract;

public class Car implements Moveable {
	@Override
	public void move() {// переопределяем метод интерфейса Moveable
		System.out.println("Car is moving");
	}
}
