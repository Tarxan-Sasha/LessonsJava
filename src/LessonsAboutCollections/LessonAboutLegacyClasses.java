package LessonsAboutCollections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

/*
 * Legacy classes - это старые классы которые были добавлены в java в версии 1.0/1.1
 * Они все ще где то используються более медленные, но потокобезопастные.
 * Они существуют с момента создания java.
 * 
 * Vector - это синхронизированый класс который реализует интерфейс List.
 * Он очень схож с ArrayList, но с двумя отличиями:
 * 1) Vector - синхронизированный, а значит потокобезопастный (потому он работает медленее)
 * 2) Vector имеет кучку методов которые не являються частью колекции, можно сказать старых.
 * Лучше использовать ArrayList.(если программа не использует многопоточность, не требует синхронизации)
 * 
 * Stack - это синхронизированный класс который наследуетсья от Vector.
 * Реализует очередь LIFO - first in first out\последний зашел последний вышел.
 * Это по сути обычный Stack из темы Stack и Heap (Стек и куча)
 * 
 * Dictionary - это абстрактный класс, который предоставляет возможность хранить пары "ключ значения"
 * Полностью заменим Map, а потому считаеться устаревшим.
 * 
 * Hashtable - был прямой реализацией Dictionary, но с появлением колекций был переоделан на реализацию Map.
 * Такой же как HashMap, только синхронизированый - а значит потокобезопастный.
 * 
 * Properties - это класс наследуеться от Hashtable. В целом множество классов его наследуют.
 * Он принимает на вход пару ключ-значения, но оба они имеют тип String.
 * С помощью этого класса можно записывать значения в файл.properties
 * И возвращать от туда. Так же можно вернуть данные из системы.
 * Properties еще одно полезное свойсто, это возможность установить дефолтное значение
 * которое будет возвращяться, если задаваемый ключ не был найден.
 * 
 * Enumeration - это класс с помощью которого можно перечислить\итерировать элементы колекций.
 * Полностью был заменим интерфейсом Iterator.
 * Но некоторые классы такие как Vector и Properties все еще его используют, потому он существует.
 * А в java 5 стал обобщенным.
 * 
 */
public class LessonAboutLegacyClasses {
	public static void main(String [] args) throws IOException {
		FileReader reader = new FileReader("src/LessonsAboutCollections/dwarfs.properties");
		Properties property = new Properties();		
		property.setProperty("Ori", "Swordman");//Этот метод вызывает внутри себя метод put() от Hashtable
		property.setProperty("Balin", "Maceman");//Этот метод вызывает внутри себя метод put() от Hashtable
		
		System.out.println(property);//Сама колекция
		
		System.out.println("Получаем данные из коллекции, по ключу"); 
		System.out.println(property.getProperty("Balin"));
		System.out.println(property.getProperty("Ori"));
		
		//Тут мы пытаемся вызвать значене по ключу, которого нет. Во втором аргументе мы указываем default значение, которок нужно выбрасывать если запрашиваемого ключа нет
		System.out.println(property.getProperty("Nori", "Peasant"));
		
		System.out.println("Подгружаем данные из файла"); 
		property.load(reader);//Метод загружает данные из файла в колекцию.
		System.out.println("Получаем данные из файла"); 
		System.out.println(property.getProperty("Dwalin"));
		
		System.out.println(property);//Сама колекция
		
		FileOutputStream fops=null;
		try {
			fops = new FileOutputStream("src/LessonsAboutCollections/dwarfs.properties");
			property.store(fops, "We are here");//Метод записывает в файл, во втором значении это коментарий
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
