package LessonsAboutStreamsIO;
/*
 * PushbackInputStream наследуеться от FilterInputStream, и так же являеться еще одним классом который реализовует буфереизацию
 * как классы BufferedInputStream и BufferedOutputStream.
 * 
 * Бывает ситуция когда нужно прочитать на пару байтов вперед что бы понять что делать с текущим байтом.
 * И в этом помогает класс PushbackInputStream. 
 * С помощью своего метода unread() он копирует прочитанный байт (методом read()) к себе в буфер возврата, 
 * и при повтороном вызове метода read(), он сначала считает байт в буфере возврата.
 * 
 * Короче более простыми словами(Это просто единстевнное что есть у этого класса):
 * Когда мы читаем байты, мы используем метод read(), но что если текущий прочитанный байт должен обрабатыватся подругому,
 * в зависимости от следующего байта. Например, если у нас за 1 идет 3, тогда мы должны вывести 2. 
 * Что бы это сделать мы должны знать что за 1 идет именно 3, и что бы это сделать 
 * мы используем метод read() снова, но результат сохраняем в новую переменную.
 * Теперь у нас в одной переменной 1, а в другой 3. Мы знаем что следующая переменная 3, потому можем вывести 2.
 * 
 * Но что если второй вызов read() покажет 4. Тогда выводить 2 нельзя. Тогда 4 нужно вернуть в поток,
 * что бы потом уже прочитать 4 первым методом read(), а вторым методом read() читать уже его соседа.
 * Но как вернуть? 
 * 
 * Именно для этого есть класс PushbackInputStream
 * У PushbackInputStream внутри есть буфер, для байтов на которые уже посмотрели/которых прочитали и которых надо вернуть обратно впоток.
 * Если этот буфер будет иметь хотя бы одно значение, метод read() сначала прочитает и выведет его из буфера, а потом уже следующий байт из потока.
 * Таким образом мы "возвращаем" элемент обратно в поток, копируя в буфер.
 * Что бы это сделать, нужно на прочитанный элемент вызвать метод unread(), этот метод сохранит элемент в буфер.
 * 
 * Есть три версии метода unread():
 * 1)unread(int b) - сохраняет одно число в буфер.
 * 2)unread(byte [] b) - сохраняет массив байтов в буфер.
 * 3)unread(byte [] b, int offset, int numBytes) - сохраняет numBytes байтов начиная с offset в массиве b.
 * 
 */
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * @author tarxa
 *
 */
public class LessonAboutPushbackInputStream {

	public static void main(String[] args) {
		byte [] array = {0,2,0,3,0,0,4,0,0,0,5};
		ByteArrayInputStream bais = new ByteArrayInputStream(array);
		//Констукторы PushbackInputStream
		try(PushbackInputStream pis = new PushbackInputStream(bais);//Принимает любой поток наследующийся от InputStream
			PushbackInputStream pis1 = new PushbackInputStream(bais, 32)){//Принимает любой поток наследующийся от InputStream, устанавливает размер буфера 32
		/*
		 * Суть программы у нас есть массив {0,2,0,3,0,0,4,0,0,0,5}, и если после 0 идет 0 тогда нужно выводить 1.
		 */
		int i;	
		while((i=pis.read())!= -1) {//Считываем первый байт, вместе с этим проверяем пустой ли источник
			if(i==0) {//Проверяем i равна 0, если да, тогда продолжаем.
				int q = pis.read();//Читаем следующий елемент, передавая его в переменую q
				if(q==0) {//Проверяем q равна 0, если да, тогда продолжаем.					i=1;//Устанавливаем i 1					pis.unread(q);//Ложим 0 в буфер, что бы при следующем i=pis.read() прочитать именно этот байт					System.out.print(i);				}else {					pis.unread(q);//В случае если q оказался не 0, сохраняем q в буфер для возвращения в поток и повтороного чтения					System.out.print(i);				}								}else {//Вывод i если i не равен 0					System.out.print(i);			}		}

		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
		
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	