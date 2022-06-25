package LessonsJAVA;
/*
 * Наследование - это одна из концепций ООП програмирования. 
 * Класс который наследует другой, называетсья: Дочерний или Подкласс 
 * Класс который наследуеться, называеться: Родительский или Суперкласс
 * Что бы обозночить что один класс наследует другой, 
 * нужно после имени класса импользовать ключевое слово extends и после имя наследуемого класса:
 * class HeroOfDota extends UnitOfDota{
 * 
 * }
 * Дочерний класс\Подкласс перенимает все методы и параметры Родительского класса\Суперкласса
 * Дочерний класс\Подкласс может переопредлить метод Родительского класса\Суперкласса
 * Когда дочерний класс создает метод с именем метода родительского класса, и меняет его тело - это называеться переопреедлением метода.
 * 
 * Класс может наследовать лишь один класс!
 * 
 * 
 */
public class LessonAboutInheritance {
	public static void main(String [] args) {
		HeroOfDota heroOfDota = new HeroOfDota();
		heroOfDota.setName("Sven");
		heroOfDota.say();
		
		UnitOfDota creepOfDota = new CreepOfDota();

		
	}
}
class UnitOfDota{
	private String name;
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public void say() {
		System.out.println("i am unit of Dota");
		System.out.println("i am " + getName());
	}
}
class HeroOfDota extends UnitOfDota{
	public void say() {
		System.out.println("i am Sven");
	}
}
class CreepOfDota extends UnitOfDota{
	
}