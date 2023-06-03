package LessonsAboutStreamsIO;
/*
 * CharArrayWritter и CharArrayReader по сути тоже самое что и ByteArrayOutputStream вместе с ByteArrayInputStream
 * единственное отличие это то что CharArrayWritter и CharArrayReader для символов, 
 * а ByteArrayInputStream и ByteArrayOutputStream для байтов.
 * 
 * CharArrayWritter - имеет тоже предназначение что и его байтовый брат ByteArrayOutputStream, но с символами.
 * Он так же используеться для записи уже символов в массив или в другие потоки.
 * CharArrayWritter можно использовать как буфер для записи простой симовльной информации,
 * а после передачи её сразу в несколько потоков которые наследуют класс Writter(например FileWriter)
 * 
 * CharArray в названии CharArrayWritter - это массив который находиться в CharArrayWritter, который выступает местом назначения записи данных.
 * А уже после, с этого массива происходит запись в другие потоки и в другие массивы.
 * Так же если потребуеться, внутренний массив увеличиться.
 * (Все как и у ByteArrayOutputStream)
 * 
 * Он имеет похожие методы:
 * 1)char[] toCharArray() - передает содержимое из внутренего массива в другой массив, размер так же копируеться
 * 2)writeTo(Writer w) = передает информацию в другой поток который наследуеться от Writer
 * ////////////////////////////////////////////////////////////////////////////////////////////////////
 * 
 * CharArrayReader такой же как и ByteArrayInputStream, но с символами.
 * Читатет данные из массива.
 * Так же имеет в себе внутренний масив, который расширяеться по мере надобности
 * 
 * CharArrayWritter и CharArrayReader не нуждаються в закрытии потока, 
 * написать close() можно, но это не принесет єфекта и ошибкой не считаеться
 * 
 */
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LessonAboutCharArrayWriterAndCharArrayReader {

	public static void main(String[] args) {
		String word ="Hello from arrayChar";
		//Конструкторы CharArrayWriter
		CharArrayWriter caw = new CharArrayWriter();//Не принимает нечего, и создает внутренний массив состандартным размером
		CharArrayWriter caw2 = new CharArrayWriter(20);//Устанавливает размер внутренего массива
		
		try(FileWriter fw = new FileWriter("src/LessonsAboutStreamsIO/Games.txt")){
			caw.write(word);//записываем массив в поток
			caw.writeTo(fw);//записываем содержимое потока в другой поток
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		char [] arrayChar = caw.toCharArray();//Передает содержимое из внутренего массива в новый массив, также передает и размер
		
		CharArrayReader car = new CharArrayReader(arrayChar);//Принимает массив символов который будет читать
		CharArrayReader car2 = new CharArrayReader(arrayChar,2,4);//Принимает массив символов который будет читать, 
																  //после указывает с какой позиции (2) нужно начать читать и сколько символов(4)
		try{
			int i;
			while((i=car.read()) !=-1 ) {
				System.out.print((char) i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
