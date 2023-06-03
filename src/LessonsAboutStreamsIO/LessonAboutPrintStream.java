package LessonsAboutStreamsIO;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/*
 * PrintStream - это класс\поток который занимаеться тем что выводит информацию в другой поток.
 * Так же он используеться для вывода информации в консоль, меотды println() и print() именно его.
 * 
 * System.out.println(); - Это класс System который вызывает свою статическую переменную обьект out.
 * out - это обьект/поток класса PrintStream, который если его не переопределить выведет информацию на консоль.
 * С помщью метода setOut() в классе System, можно переопределить out на вывод куда то в другое место(поток или файл).
 * После переопределение методом setOut(), любой вызов System.out.println() будет выводить информацию не на консоль,
 * а в то место куда мы указали в методе setOut.
 * println() - это метод класса PrintStream который вызвает out (обьект класса PrintStream).
 * 
 * Помимо print() и println() PrintStream имеет метод printf().
 * printf() - этот метод форматирует строку, с помощью него можно задать выводимым данным какой-то формат
 * Так же в PrintStream реализованны и другие методы от родителя OutputStream, такие как writer
 * 
 * ////////////////////////////////////////////////////////////////////
 * 
 * PrintWriter - это класс такой же как и PrintStream, просто более ориантированный на символы,
 * Его родителям являеться Writer.
 * Имеет все тоже самое что и PrintStream
 * Отличие PrintWriter от PrintStream это то что: 
 * PrintStream записывает байты, он на них ориентрован больше. 
 * Если мы хотим передать символы через PrintStream, тогда он внутри себя сначала превратит эти символы в байты, а потом уже запишет
 * Чего конечно же PrintWriter не делает.
 * Так же я прочитал что файлы созданные с помощью PrintWriter более совместимы чем файлы созданные с PrintStream.
 * И там же советуют использовать чаще PrintWriter. Но в целом: 
 * Для байтов - PrintStream
 * Для симовлов - PrintWriter
 * 
 * Но когда мы испоьзуем System.out.println();, в System.out используеться PrintStream по стандарту
 * ////////////////////////////////////////////////////////////////////
 * 
 * System.in 
 * Когда мы пишем ввод текста с клавиатуры, мы используем сканнер:
 * Scanner scanner = new Scanner(System.in);
 * System.in в констуркторе - это вызов потока ввывода который базово/по умолчанию читает ввод с клавиатуры
 * in - это обьект класса InputStream
 * Для потока in источник данных это клавиатура, но это можно изменить:
 * Если создать обьект/поток класса наследника InputStream, например ByteArrayInputStream.
 * И передать его в аргумент метода System.setIn()
 * Тогда при вызове System.in, чтение будет производиться не из клавиатуры, а из того потока который мы указали
 * 
 */
import java.util.Scanner;

public class LessonAboutPrintStream {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File file = new File("C:\\Users\\tarxa\\Desktop\\Test1.txt");
		try(FileOutputStream fos = new FileOutputStream("C:\\Users\\tarxa\\Desktop\\Test2.txt")) {
			//Конструкторы PrintStream все тоже самое есть и у PrintWriter
			PrintStream ps = new PrintStream(fos);//Принимает другой поток OutputStream
			PrintStream ps1 = new PrintStream(fos, true);//Принимает другой поток OutputStream, так же устанавливем true или false для автоматического срабатывания метода flush()
			PrintStream ps2 = new PrintStream(fos, true, "UTF-8");//Принимает другой поток OutputStream, так же устанавливем true или false для автоматического срабатывания метода flush(), 
																  //так же устанавливаем кодировку символов
			PrintStream ps3 = new PrintStream("C:\\Users\\tarxa\\Desktop\\Test3.txt");//Принимает путь\имя фала. Если по заданому пути указаного файла нет, PrintStream его создаст
			PrintStream ps4 = new PrintStream("C:\\Users\\tarxa\\Desktop\\Test4.txt", "UTF-8");//Принимает путь\имя фала, так же устанавливаем кодировку символов
			PrintStream ps5 = new PrintStream(file);//Принимает на вход обьект класа File
			PrintStream ps6 = new PrintStream(file, "UTF-8");//Принимает на вход обьект класа File, так же устанавливаем кодировку символов
			
			ps.print("Hello File2");//Выводит строку не в консоль как по стандарту, а в указанный файл 
			ps3.println("Hello File3");//Выводит строку не в консоль как по стандарту, а в указанный файл 
			ps4.printf("%h",123);//Форматирует число указывая его хеш-код, и выводит не в консоль как обычно, а в указаный файл 
			System.out.printf("%h",123);//Форматирует число указывая его хеш-код, но вывод в консоль
			
			//System.setOut(ps5);//Перепоределяем переменную out, заменяя вывод не на консоль, а в указаный поток/файл
			//System.out.println("Hello Test1");//Эта строчка выведетсья уже не на консоль, а в указаный файл
			
			System.out.println();
			testSystemIn();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	////////////////////////////////////////////////////////
	public static void testSystemIn() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Обычное чтение in  с клавиатуры: "+scanner.next());
		
		//Изменим/переопределим источник от куда читает System.in
		String word = "Hello";//Обычная строчка String
		byte [] array = word.getBytes();//У String есть метод getBytes() который переводит строку в байты, эти байты ложим в массив
		ByteArrayInputStream bais = new ByteArrayInputStream(array);//Создаем поток чтения с этого масива 
		System.setIn(bais);//Устанавливаем что бы поток in читал не с клавиатуры, а с указаного нами потока 
		/*
		 * Создаем BufferedReader (Это буферизированный поток для символов) куда ложим обьект класса InputStreamReader
		 * InputStreamReader(Этот класс мост между байтовыми и симольными потоками, он занимаеться тем что переводит байты в символы)
		 * В InputStreamReader уже ложим наш System.in, который уже читает НЕ с клавиатуры, а с нашего массива
		 *
		 */
		try(BufferedReader bisr  = new BufferedReader (new InputStreamReader(System.in))){
			String s;
			while((s = bisr.readLine()) != null ) {//readLine() - это метод который дает BufferedReader, он читает строку
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}