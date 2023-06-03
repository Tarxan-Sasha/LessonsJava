package LessonsAboutInnerClasses;
/*
 * Статические вложенные классы
 * Может обходиться без обьекта внешнего класса при создании своего обьекта
 * Имеют доступ ко всем статическим полям и методам внешнего класса.
 * А к НЕ статическим полям и методам не имеют.
 * Как вариант получить доступ к НЕ статическим полям и методам можно через созданный обьект внешнего класса
 * 
 * 
 */
public class Plane {
	
	private static int maxPassengersCount = 300;
	private String color;

	
	public static class Drawing{
		
		
		public String getColor() {
			//System.out.println(color);//Ошибка без обьекта мы использовать эту переменую не можем
			Plane plane = new Plane();
			String color = plane.color;//Теперь мы можем взаемодействовать с этой переменной, изза обьекта
			return color;
		}
		public static int getMaxPassengersCount() {
			maxPassengersCount++;//С этой переменной мы взаемодйствовать можем, ведь она обявлена static
			return maxPassengersCount;
		}
	}
}
