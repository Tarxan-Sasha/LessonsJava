/*
 * Этот класс не имеет нечего общего с животными и машиной, но он тоже может двигаться потомоу реализует интерфейс Moveable.
 * 
 */
package LessonsAboutAbstaract;

public class Janitor implements Moveable {
	@Override
	public void move() {// переопределяем метод интерфейса Moveable
		System.out.println("Janitor is moving");
	}
}
