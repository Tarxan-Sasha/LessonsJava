package LessonsAboutStreamsIO;

/*
 * SequenceInputStream это поток который читает сразу несколько потоков которые наследуються от InputStream.
 * Он считывает потоки по порядку, как только информация в первом потоке заканчиваеться, SequenceInputStream начинает считывать следующий.
 * Считываемые потоки автоматически закрываються, но если SequenceInputStream закрыть, то он закроет и все потоки которые еще открыты внутри него.
 * SequenceInputStream не добавляет никаких новых методов.
 * 
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class LessonAboutSequenceInputStream{

	public static void main(String[] args) {
		byte [] array = {0,1,2};
		byte [] array1 = {3,4,5};
		ByteArrayInputStream bais = new ByteArrayInputStream(array);
		ByteArrayInputStream bais1 = new ByteArrayInputStream(array1);
		Vector<InputStream> vector= new Vector<InputStream>();
		vector.add(bais1);
		vector.add(bais);
		Enumeration enumeration =vector.elements();
		//Конструторы SequenceInputStream
		SequenceInputStream sis = new SequenceInputStream(bais, bais1);//Принимает на вход два потока коорые наследуютсья от InputStream
		SequenceInputStream sis1=new SequenceInputStream(enumeration);//Принимает на вход перечисление(Enumeration) обьектов InputStream
	
		int i;
		try {
			while((i=sis.read()) != -1) {
				System.out.print(i+" ");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

