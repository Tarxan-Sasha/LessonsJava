/*
 * Что бы релализовать Интерфейс нужно указать ключевое слово implements, а после имя Интерфеса.
 * Класс может реализоувать несколько Интерфейсов, после слова implements нужно указать имена Интерфесов через запитую.
 * Класс должен всегда реализовувать/переопределять методы ВСЕХ Интерфейсов которых он реализует/имплементирует.
 * Если класс реализует не все методы Интерфеса, тогда класс должен быть помечен ключевым словом abstract
 * Класс, конечно же, может создавать свои методы
 * 
 * Интерфейсы маркеры - это интерфейсы, у которых не определены ни методы, ни переменные.
 * Реализация этих интерфейсов придает классу определенные свойства.
 * Например, интерфейсы Cloneable и Serializable, отвечающие за клонирование и сохранение объекта в информационном потоке, являются интерфейсами маркерами.
 * 
 * 
 */
package LessonAboutInterface;

public class Clown extends StaffOfStation implements Moveable, Run {
	
	public Clown(String name, String speciality) {
		super(name, speciality);
	}
	
	@Override
	public void voiceChat(StaffOfStation staffOfStation) {
		System.out.println(staffOfStation.name+" speaks");
	}
	

	
	@Override
	public void moveDown() {
		System.out.println("Клоун идет в низ");
	}
	@Override
	public void moveLeft() {
		System.out.println("Клоун идет в лево");
	}
	@Override
	public void moveRight() {
		System.out.println("Клоун идет в право");
	}
	@Override
	public void moveUp() {
		System.out.println("Клоун идет в верх");
	}
	
	public void Honk(){
		System.out.println("Клоун хонкает");
	}

}
