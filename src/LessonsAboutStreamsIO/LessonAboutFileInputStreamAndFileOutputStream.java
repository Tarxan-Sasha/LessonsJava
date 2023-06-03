package LessonsAboutStreamsIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * FileInputStream и FileOutputStream это два класса которые предназначенны для роботы с файлами и байтами.
 * Эти классы созданны именно для работы с байтами, для записи и чтения двоичных файлов. 
 * С помощью них, конечно, можно и читать и записывать символы/текст, но для этого все таки есть другие более подходящие классы  
 * 
 * FileOutputStream - это класс Вывода, он создает байтовый поток который записывает данные(байты) в файл.
 * Наследуеться от OutputStream перенимая у него все методы, новые FileOutputStream не добавляет.
 * Вот основные его методы:
 * 1) void write(int i) - записывает один байт в поток. Принимает int значение, 
 * а потому не предетсья переводить указанное число в тип byte
 * 2) void write(byte[] buffer) - записывает в поток масив чисел типа byte 
 * 3) void write(byte[] buffer, int offset, int length) - записывает в поток указанное количество элементов в length, 
 * начиная с элемента под номером указанным в offset, в массиве указанным в buffer 
 * 4) void flush() - записівает все что должно было записаться, очищает буфер. 
 * В буфере храняться данные, и не все они могут успеть записаться. И этот метод записывает их всех, что бы точно все записались.
 * Это тема с буферизацией
 * 5) void close() - закрывает поток, после этого записывать уже нельзя. Автоматически вызывает метод flush()
 * 
 * FileOutputStream не так сильно привязан к файлу, в плане что если файла не будет он его создаст.
 * А если указанный файл, в его конструкторе, доступен лишь для чтения тогда произойдет ошибка.
 * Потому что FileOutputStream не читает, а записывает
 * 
 * FileInputStream - это класс Ввода, он создает байтовый поток который считывает/читает данные с файла.
 * Наследуэться от InputStream перенимая у него все методы, новые FileInputStream не добавляет.
 * 1) int read() - считывает один байт с потока, если байтов больше нет возвращает -1
 * 2) int read(byte [] buffer) - пытаеться прочесть количество байтов равное buffer.length(размеру массива) и сохранить их в массив
 * По итогу сохраняет все байты которых получилось реально получилось прочитать, если байтов больше нет возвращает -1
 * 3) int read(byte [] buffer, int offset, int length) - пытаеться прочитать length байтов, начиная с элемента offset.
 * Сохраняет все что удалось прочитать в масив buffer. Если байтов нет возвращает -1  
 * 4) int available() - возвращает количество байтов которых можно прочитать
 * 5) long skip(long byteCount) - пропускает указанное количество байтов, и возвращает число сколько смог пропустить
 * Пришла мысль, этот метод словно переставляет коунтер/точку с которой нужно считывать 
 * 6) void close() - закрывает поток, после этого попытка считать вернет исключение IOException
 * 
 * FileInputStream в отличие от FileOutputStream сильно привязан к файлу, если указанного файла не будет или он будет не доступен вернеться исключение
 * 
 */
public class LessonAboutFileInputStreamAndFileOutputStream{
	
	public static void main(String[] args) throws IOException {
		byte array [] = {0,1,2,3,4,5,6};
		File file = new File("src/LessonsAboutStreamsIO/Games/Dota.txt");
		
		try {
			//Конструкторы FileOutputStream  
			FileOutputStream fos1 = new FileOutputStream("src/LessonsAboutStreamsIO/Games/Dota.txt");//Принимает для подключения путь файла
			FileOutputStream fos2 = new FileOutputStream(file);//Принимает для подключения обьект класса File
			FileOutputStream fos3 = new FileOutputStream("src/LessonsAboutStreamsIO/Games/Dota.txt", true);//Принимает для подключения путь файла, true - данные будут записываться в конец файла
			FileOutputStream fos4 = new FileOutputStream(file, false);//Принимает для подключения обьект класса File, false - файл будет перезаписыватсья полностью
			
			fos1.write(0);//Записываем одно челочисленное значение 
			fos1.write(array);//Записываем массив типа byte
			fos1.write(array,4,3);//Записываем 3 числа начиная с 4(включительно) в массиве array
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//////////////////////////////////////////////////////////////////////////
		try {
			//Конструкторы FileInputStream
			FileInputStream fis1 = new FileInputStream("src/LessonsAboutStreamsIO/Games/Dota.txt");//Принимает для подключения путь файла
			FileInputStream fis2 = new FileInputStream(file);//Принимает для подключения обьект класса File
			int i;
			System.out.println(fis1.available());//Выводим на экран сколько байтов мы можем прочитать
			//System.out.println(fis1.skip(2));//Пропускаем первые два байта
			//Считываем по одному байту, передавая в переменую i. Проверяем равно ли i -1(ведь возвращения методом read() -1 означает конец файла), если i не равна -1 тогда продолжаем
			while( (i=fis1.read()) != -1) {
				System.out.print(i+" ");//Выводим по одному байту на экран
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

