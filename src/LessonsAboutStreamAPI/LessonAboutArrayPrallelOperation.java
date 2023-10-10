package LessonsAboutStreamAPI;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Это не операции в потоке, это методы над массивами.
 * Эти методы вышли в JDK 8 и доступны в классе Array.
 * Эти методы не паралеьные операции в Stream API, да и в целом это никакие не операции в Stream API.
 * Они просто работают так же или похожим образом как паралельные операции в Stream API.
 * То есть тоже, розбивают выполнение над массивом по ядрам процессора, а потом все склеивают обратно.
 * 
 * Вот эти методы:
 * 1) parallelSetAll() - производит вычесления или устанавливает значения с помощью переданной в аргументы лямбды функции 
 * 2) parallelSort() - сортирует элементы массива. В случае если в массиве лежат обьекты класса, тогда нужно положить обьект 
 * компортора для этого класса вторым аргументом.
 * 3) parallelPrefix() - производит вычесления над элементами массива.
 * 
 * 
 * 
 */
public class LessonAboutArrayPrallelOperation {

	public static void main(String[] args) {
		
		int array [] = {22,3,20,98,15};
		System.out.println("Просто вывод массива: ");
		for(int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
		//.....................................................................
		System.out.println("Вывод массива parallelSetAll: ");
		Arrays.parallelSetAll(array, x -> array[x]-1);
		for(int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
		//.....................................................................
		System.out.println("Вывод массива parallelSort: ");
		Arrays.parallelSort(array);
		for(int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
		//.....................................................................
		System.out.println("Вывод массива parallelPrefix: ");
		Arrays.parallelPrefix(array, (x, y)-> x+y);
		for(int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//.....................................................................
		System.out.println("Вывод массива Animals методом parallelSort: ");
		Animals [] animalsArray = {new Animals("Cats",3), new Animals("Dogs",2), new Animals("Hamsters",16), new Animals("Birds",5) };
		Arrays.parallelSort(animalsArray, new AnimalsComparator());
		for(Animals a:animalsArray) {
			System.out.print(a.getCount() + " ");
		}
		
	}

	
}

class Animals{
	private String type;
	private int count;
	public Animals(String type, int count) {
		super();
		this.type = type;
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public int getCount() {
		return count;
	}
}
class AnimalsComparator implements Comparator<Animals>{

	@Override
	public int compare(Animals o1, Animals o2) {
		return o1.getCount() - o2.getCount() ;
	}
	
}





