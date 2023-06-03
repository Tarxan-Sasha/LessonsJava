package LessonsAboutStreamsIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Reader и Writer - это абстрактные классы потоков ввода/вывода
 * Они почти идентичны с InputStream и OutputStream, но созданы для работы напрямую с символами.
 * Reader и Writer являються родителями для всех классов потоков которые работают с символами, 
 * как InputStream и OutputStream для всех классов потоков которые работают с байтами.
 * 
 * Reader и Writer реализуют такие интерфейсы как Closeable и AutoClosable, что дает возможность их потомкам закрывать поток
 * не только методом close(), а и способом try-with-resources.
 * Так же Writer реализует интерфейс Flushable и Appendable которые дают ему методы flush() и append(char c).
 * А Reader наследуется от Readable что дает ему метод read()
 * 
 * Пару полезных и интересных новых методов в этих классах
 * Reader:
 * boolean ready() - возвращает true, если еще остались байты в потоке. Короче true если можно еще читать поток, false - нельзя
 * Wrietr:
 * append (char c) - добавляет элемент типа char в конец потока.
 * 
 * И у обоих:
 * getEncoding() - возвращает кодировку потока
 * ////////////////////////////////////////////////////////////////////////////////////
 * 
 * FileWriter - это класс который позволяет записывать символы в файл.
 * Наследуюется от класса Writer, потому имеет все его методы.
 * Если указаного файла в конструкторе нет, он его создаст
 * Нужно закрывать.
 * 
 * Filereader - это класс с помощью которого можно читать символы с файла
 * Наследуеться от класса Reader, потому имеет все его методы.
 * Если указаного файла нет, выдаст исключение NotFoundFileException.
 * Нужно закрывать.
 */
public class LessonAboutFileReaderAndFileWriter {

	public static void main(String[] args) {
		File file = new File("src/LessonsAboutStreamsIO/Games.txt");
		//Констуркторы FileWriter
		try(FileWriter fw = new FileWriter(file);//Принимает обьект класса File
			FileWriter fw2 = new FileWriter(file,true);//Принимает обьект класса File, и определяет будет ли символы записываться в конец или файл будет перезаписан.
													   //Если true тогда символы будут записаны в конец файла, а если false тогда файл перезапишиться с 0 (по умолчанию стоит false)
			FileWriter fw3 = new FileWriter("src/LessonsAboutStreamsIO/Games.txt");//Принимает путь к файлу, если такого нет FileWriter создаст
			FileWriter fw4 = new FileWriter("src/LessonsAboutStreamsIO/Games.txt", true)){//Принимает путь к файлу, если такого нет FileWriter создаст, и определяет будет ли символы записываться в конец или файл будет перезаписан.
																								//Если true тогда символы будут записаны в конец файла, а если false тогда файл перезапишиться с 0 (по умолчанию стоит false)
			String s = "Dota 2 моя любимая игра";
			fw.write(s);
			fw.append('♥');//Записываем символ в конец 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Конструкторы FileReader
		try(FileReader fr = new FileReader(file);//Принимает обьект класса File
			FileReader fr2 = new FileReader("src/LessonsAboutStreamsIO/Games.txt")){//Принимает путь к файлу, если файла нет выдаст исключение
			
			while(fr.ready()) {//проверяем есть ли еще символы для четния, если true - продолжаем чтение
				System.out.print((char) fr.read());
			}
			
			//Старый вариант без ready() тоже уместен и доступен 
			System.out.println();
			int i;
			while((i=fr2.read()) != -1) {
				System.out.print((char) i);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
