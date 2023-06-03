package LessonsAboutStreamsIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Для чтения и записывания байтов есть классы ByteArrayInputStream и ByteArrayOutputStream
 * ByteArrayOutputStream - класс вывода, записывает байты в массив(Буфер, внутренний массив), который можно потом записать в другой массив или в другие потоки.
 * (Использует место назначения байтовый массив внутри себя)
 * В целом ByteArrayOutputStream используют как "Буфер", для записи какой то простой информации, 
 * а позже передачи её сразу в несколько потоков(файлов например)
 * (Сам буферный масив находиться в классе, его можно увидеть во втором конструкторе buf = new byte[size];, нажать ctrl+ПКМ на класс)
 * Имеет три дополнительних метода:
 * 1)toByteArray() - передает масив(Буфер) байтов в другой массив, размер и содеражние будет скопировано в новый массив
 * 2)writeTo(OutputStream o) - записывает содержимое потока(буферный массив байтов) в другой выходной(output) поток.
 * 3)reset() - сбрасывает количество байтов в буферном массиве до нуля, поток становиться чистым(пустым) и записать данные уже не может,
 * его нужно заполнить заново.
 * 
 * ByteArrayInputStream - класс ввода, используэться для чтения байтов с массива. 
 * (Как источник использует байтовый массив)
 * Он также имеет буферный массив внутри себя, но он с него лишь считывает данные.
 * Если потребуеться буферный масив может рашириться/увеличиться
 * 
 * Также для ByteArrayInputStream и ByteArrayOutputStream не требуеться закрывать поток ни методом close(), ни try-with-resources.
 * Можно закрыть, но это не даст никакого эфекта, хоть ошибкой и не считаеться
 */
public class LessonAboutByteArrayInputStreamAndByteArrayOutputStream {

	public static void main(String[] args) {
		//Конструкторы ByteArrayOutputStream
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//Создается поток который имеет масив(буфер) с размером 32 байта
		ByteArrayOutputStream baos1 = new ByteArrayOutputStream(2);//Создается поток который имеет масив(буфер) с указаным размером.
																   //Если потребуетсья он увеличится/расшириться сам
		byte [] buf = {1,2,3,4,5,6};//Создаем массив который мы впишем в поток
		try {//Метод write может выдать/выкинуть исключение потому мы помещаем его в try catch
			baos.write(buf);//Записываем масив в наш поток, в тот самый буферный масив
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte [] array = baos.toByteArray();//Передаем данные с буферного масива в новый масив, этот масив скопирует все от содержмого до размера
		for(int i : array) {
			System.out.print(i+" ");
		}
		
		try(FileOutputStream fos = new FileOutputStream("src/LessonsAboutStreamsIO/Games/Dota.txt")){//Создаем новый поток в файл, 
																									 //с помощью try-with-resources, нам не требуеться его закрывать
			baos.writeTo(fos);//Записываем содержимое нашего ByteArrayOutputStream в другой поток FileOutputStream (а уже этот поток записывает данные в файл)
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		baos.reset();//Сбрасываем содержимое потока до 0
		System.out.println();
		
		//__________________________________________________________________
		
		//Конструкторы ByteArrayInputStream
		ByteArrayInputStream bais = new ByteArrayInputStream(array);//Указываем как источник массив байтов, который будем считывать/читать
		ByteArrayInputStream bais1 = new ByteArrayInputStream(array, 2, 3);//Указываем масив байтов который будем читать - array,
																		   //Указываем с какого места будем читать - 2,
		   																   //Указываем сколько байтов будем читать - 3,
		int i;
		while((i=bais.read())!=-1) {//Пишем что если i НЕ равена -1, тогда продолжай. (Если источник пуст, тогда read() вернет -1. -1 = это конец)
			System.out.print(i);
		}
		
		System.out.println();
		
		while((i=bais1.read())!=-1) {
			System.out.print(i);
		}
		
	}

}
