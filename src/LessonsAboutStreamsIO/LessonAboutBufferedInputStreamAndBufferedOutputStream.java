package LessonsAboutStreamsIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
 * BufferedInputStream и BufferedOutputStream являються потомками FilterInputStream и FilterOutputStream 
 * Эти классы оптимизируют процесс чтения или записи данных в потоки.
 * Они создают в памяти дополнительный буфер к существующим потокам ввода/вывода, с помощью которого повышают производительность.
 * 
 * Как это работает, буфер предоставленный BufferedInputStream и BufferedOutputStream накапливает в себе вводимые или выводимые байты.
 * В случае с BufferedInputStream, в буфер загружеться некое количество байтов.
 * Внутренний поток InputStream, который буферизируетсья, считывает данные уже с буфера, а не с "прямого" источника.
 * Таким образом чтение из потока оптимизируеться повышая производительность
 * (Хорошая аналогия: Когда мы хотим насыпать сахар в чай, мы не идем к мешку сахара с чайной лошкой - это долго и неудобно,
 * мы насыпаем сахар в сахарницу и уже с него насыпаем себе сахар. Сахарница - буфер)
 * 
 * В случае с BufferedOutputStream буфер копит в себе байты вывода
 * и как только буфер заполняеться, происходит запись байтов во внутренний буферизированный поток OutputStream.
 * (Хорошая аналогия: Мы не относим каждый элемент мусора сразу в мусорный контейнер(во дворе) - это долго и неудобно, 
 * Мы сначала все ложим в ведро\кулек, а потом уже его выбрасываем когда он заполнитсья. Ведро\кулек для мусора - буфер)
 * 
 * Наличие даже самого маленького буфера уже оптимизирует програму и лишним не будет. 
 * 
 */
public class LessonAboutBufferedInputStreamAndBufferedOutputStream {

	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//Конструкторы BufferedOutputStream
		try(BufferedOutputStream bos = new BufferedOutputStream(baos);//Всовуем поток наследующийся от OutputStream
			BufferedOutputStream bos1 = new BufferedOutputStream(baos, 32)){//Всовуем поток наследующийся от OutputStream, а так же устанавливаем размер буфера
		byte buf [] = {0,1,2,3,4,5,6};
			bos.write(buf);//Записываем массив а поток, write переопределен и он записывает не в поток bos, а во внутренний поток baos
			bos.flush();//Принудительно записываем все байты буфера, очищая буфер 
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte array [] = baos.toByteArray();
		
		for(byte i:array) {
			System.out.print(i+" ");
		}
		System.out.println();
		//____________________________________________________________________________________
		ByteArrayInputStream bais = new ByteArrayInputStream(array);
		//Конструкторы BufferedInputStream
		try(BufferedInputStream bis = new BufferedInputStream(bais);//Всовуем поток наследующийся от OutputStream
			BufferedInputStream bis1 = new BufferedInputStream(bais, 32)){//Всовуем поток наследующийся от OutputStream, а так же устанавливаем размер буфера
		int i;
			while((i=bis.read())!=-1) {
				System.out.print(i+" ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
