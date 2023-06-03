package LessonsAboutStreamsIO;
/*
 * BufferedReader и BufferedWriter имеют точно такую же функцию как их битовые братья BufferedInputStream и BufferedOutputStream
 * только BufferedReader и BufferedWriter работают символьными потоками.
 * 
 * BufferedReader - буферезируют символы для чтения, оптимизируя производительность чтения данных.
 * Наследуеться от класса Reader, имеет всего его методы и добавляет один:
 * String readLine() - читает сразу строку симовлов, а не по символу как это делает обычный read().
 * 
 * BufferedWriter - буферезируют символы для записи, бляагодаря чему поток меньше раз обращаеться к месту вывода
 * и потому проходит оптимизация производительности записи данных.
 * Наследуеться от Writer, имеет все его методы и добавляет один:
 * void newLine() - переносит запись на новую строку.
 * 
 * Нужно закрывать, и если закрыть BufferedReader и BufferedWriter то и их внутренний потоки автоматически закроються
 * все как у BufferedInputStream и BufferedOutputStream
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LessonAboutBufferedReaderAndBufferedWriter {

	public static void main(String[] args) {
		
		String word = "StarCraft2";
		//Конструкторы BufferedWriter
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/LessonsAboutStreamsIO/Games.txt"));//Принимает поток который наследуеться от Writer, буфер стандартного размера
			BufferedWriter bw1 = new BufferedWriter(new FileWriter("src/LessonsAboutStreamsIO/Games.txt"),32)){//Принимает поток которій наследуеться от Writer, а так же устанавливает размер буфера 32
			
			bw.write(word);
			bw.newLine();//Создает новую строчку с которой будет вестись запись
			bw.write(word+"\n");//Это слово будет с новой строчки, благодаря newLine(), без него это слово продолжало б строку прошлого слова
								/* Но можно обойтись и без метода newLine() в конце указав "\n", и тогда перенос строки тоже произойдет.
								 * Так же если мы отправляем сообщение в другое место где есть принимающий поток(например сокеты сервера или клиента), который будет читать наше сообщение
								 * принимающий поток с той стороны будет ждать "\n" как указатель конца строки, без него он будет считать что сообщение не полное и не законченное
								 * в общем сообщение тупо не отправиться
								 */
			bw.write(word);
			
			bw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Конструкторы BufferedReader
		try(BufferedReader br = new BufferedReader(new FileReader("src/LessonsAboutStreamsIO/Games.txt"));//Принимает поток который наследуеться от Reader, буфер стандартный
			BufferedReader br1 = new BufferedReader(new FileReader("src/LessonsAboutStreamsIO/Games.txt"),32)){//Принимает поток который наследуеться от Reader, ф так же устанавливает размер буфера 32
			
			while(br.ready()) {//Проверяет можно ли еще считывать данные, как только файл(источник) будет пуст выкинет false
				System.out.println(br.readLine());//читает сразу строку текста, а не символ
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//....................................................Запись в фал с клавиатуры.....................................................
		/*
		 * BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) - являеться стандартным потоком для чтения данных с клавиатуры,
		 * System.in - а именно in это поток БАЙТОВЫЙ от InputStream.
		 * in ложат в InputStreamReader, суть этого потока в том что он переводит байты в символы.
		 * И все это буферизируеться в BufferedReader.
		 */
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//Указываем чтение с клавиатуры
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/LessonsAboutStreamsIO/Games.txt"))){//Указываем куда будем записывать, а именно в файл
			
			writer.write(reader.readLine());//В условие метода write вписываем получившуюся строку из метода readLine(), который читает с клавиатуры
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
