package LessonsAboutStreamsIO;

import java.io.File;

/*
 * Класс File несмотря на то что находиться в пакете java.io, не работает с потоками ввода/вывода 
 * Класс File работает с файлами и каталогами, с помощью него можно узнать самую разную информацию о файле:
 * Путь, время и дата создания, когда последний раз изменялся, файл ли, каталог ли, и т.д.
 * Можно переименовать и даже удалить файл или каталог.
 * 
 * У обьектов класса File которые являються каталогами есть немного отличий:
 * Что бы создать каталог нужно использовать методы mkdir() и mkdirs().
 * 1) mkdir() - создает каталог с именем указаным в конструкторе обьекта
 * 2) mkdirs() - создает каталог и весь его путь к нему с именами указаными в конструкторе обьекта
 * У каталога можно вызвать метод list(), который вернет список всех его файлов и каталогов масивом с типом String,
 * или можно вызвать метод listFiles(), который вернет список всех файлов и каталогов на как обьекты класса File
 * 
 * 
 * 
 */
public class LessonAboutFile {

	public static void main(String[] args) {
		
		// Виды конструкторов класса File
		File file1 = new File("src/LessonsAboutStreamsIO/Games/Rainbow.txt");//Пишем путь к файлу
		File file2 = new File("src/LessonsAboutStreamsIO/Games");//Пишем путь к каталогу/папке
		File file3 = new File("src/LessonsAboutStreamsIO/Games", "Dota.txt");//Пишем путь к каталогу/папке, а вторым значением указываем имя файла
		
		System.out.println("Являється ли Rainbow.txt файлом? - "+file1.isFile());
		System.out.println("Являється ли Games Директорией/катлогом/папкой? - "+file2.isDirectory());
		System.out.println("Являється ли Dota.txt файлом? - "+file3.isFile());
		
		//Папки
		File file4 = new File("src/LessonsAboutStreamsIO/Games/MOBA");
		System.out.println("Являється ли MOBA Директорией/катлогом/папкой? - "+file4.isDirectory());
		//file4.mkdir(); //При использывании этого метода, несуществующий каталог MOBA создаться
		//System.out.println(file4.isDirectory());
		
		File file5 = new File("src/LessonsAboutStreamsIO/Games/RPG/Skyrim");
		System.out.println("Являється ли Skyrim Директорией/катлогом/папкой? - "+file5.isDirectory());
		//file5.mkdirs(); //При использывании этого метода, несуществующий каталог Skyrim создаться, вместе с несуществуеющимк каталогом RPG
		//System.out.println(file5.isDirectory());
		
		
		String [] arr = file2.list();//передаем массив с содержимым папки Games в масив String ввиде строк
		for(String i:arr) {
			System.out.println(i);
		}
		
		File [] arr1 = file2.listFiles();//передаем массив с содержимым папки Games в масив File ввиде обьектов класса File
		for(File i:arr1) {
			System.out.println(i);
		}

	}

}
