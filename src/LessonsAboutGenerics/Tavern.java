package LessonsAboutGenerics;
/*
 * Обобщения(Generics)
 * Обобщения нужны тогда когда у нас есть данные тип которых мы точно не знаем на верняка.
 * В универсальный тип(Это тип в <>) можно подставить все что угодно (Любой класс). 
 * Название у универсального типа обычно какая то буква, но может быть что угодно.
 * Обобщенным может быть класс, интерфейс, метод и конструктор.
 * 
 * При определении обьекта, при вызове метода или импелементации интерфейса в скобочки(<>) 
 * надо вписать тип который будет сипользоваться вместо универсального
 * 
 * Можно использовать сразу несколько обобщенных универсальных типов
 * <E, R>
 * 
 * Ограничение обобщений
 * Для того что бы ограничить обощения надо использовать слово exdends как при наследовании
 * и унаследоваться от дргого класса, пример:
 * class Transaction<T extends Account>
 * Теперь вместо T можно подставить либо сам класс Account или его наследников
 * 
 * Можно так же вписать и интерфейсы
 * Так же ограничения могут быть множественными
 * class Transaction<T extends Person & Account>
 * 
 * 
 * 
 */


class Elf<E> implements Archer<E> {
	E age;
	String name;
	
	Elf(E age, String name){
		this.age=age;
		this.name=name;
	}
	<H>Elf(H age){
		
	}
	public E getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	
	public <T> void sleep(T hours){//обощенный метод
		System.out.println(name+" спит "+hours+" часов");
	}
	
	@Override
	public E getArrows(E numberOfArrows) {//метод который возвращает обобщенное значение
		return numberOfArrows;
	}
	@Override
	public void shotFromBow() {
		System.out.println(name+" стреляет из лука");
		
	}


}

public class Tavern {

	public static void main(String[] args) {
		
		Elf<String> elf0 = new Elf<String>("312", "Alister");
		Elf<Archer> elf = new Elf<Archer>(elf0, "Alister");
		Elf<Integer> elf1 = new Elf<Integer>(450, "Lendr");
		Elf<Double> elf2 = new Elf<Double>(640.2, "El");
		Elf<Double> elf3 = new Elf<Double>(640.2);
		
		elf.getAge();
		elf1.getAge();
		elf1.shotFromBow();
		
		elf.<Integer>sleep(4);
		elf1.<String>sleep("5");

	}

}
