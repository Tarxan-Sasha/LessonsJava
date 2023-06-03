package LessonsAboutStreamsIO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * DataOutputStream и DataInputStream - это классы которые позволяют записывать и считывать примитивные типы данных.
 * Они наследуються от классов FilterOutputStream и FilterInputStream.
 * Имплементируют интерфейсы:
 * Closeable - позволяет закрывать поток
 * AutoCloseable - позволяет использовать закрытие с помощью try-with-resources
 * Flushable - дает метод flush()
 *
 * Если закрыть DataOutputStream и DataInputStream поток внутри тоже закрываеться
 * 
 * Все эти классы имеют методы своих родителей, но уникальность этим классам дают именно свои личные методы, 
 * которые дают им интерфейсы которых DataOutputStream и DataInputStream импелменетируют:
 * DataOutputStream имплементирует интерфейс DataOut
 * DataInputStream имплементирует интерфейс DataInput
 * 
 * Методы DataOutputStream DataInputStream переоброзовуют примитивные значения в байты и обратно
 * Методы DataOutputStream:
 * writeboolean(boolean b), writeByte(byte b), 
 * writeChar(int b), writeDouble(double b), 
 * writeFloat(float b), writeInt(int  b), 
 * writeLong(long b), writeShort(int b) - все они записывают в поток значение своего типа
 * writeUTF(String s) - записывает в поток строку в кодировке UTF-8
 * 
 * Методы DataInputStream:
 * boolean readBoolean(), byte readByte(),
 * char readChar(), double readDouble(),
 * float readFloat(), int readInt(),
 * long readLong(), short readShort() - все эти методы читают из потока значение своего типа
 * String readUTF() - считывает из потока строку в кодировке UTF-8
 * int skipBytes(int n) - пропускает при чтении из потока n байтов
 * 
 */
public class LessonAboutDataOutputStreamAndDataInputStream {

	public static void main(String[] args) {
		File file = new File("src/LessonsAboutStreamsIO/Games.txt");
		
		//Конструторы DataOutputStream
		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));//Принимает в себя обьект/поток OutputStream	
			DataInputStream dis = new DataInputStream(new FileInputStream(file))){//Прнимает в себя обьект/поток InputStream
		
			dos.writeBoolean(true);//Записываем в поток значение типа boolean
			dos.writeDouble(3.3);//Записываем в поток значение типа double
			dos.writeInt(456);//Записываем в поток значение типа int
			dos.writeChar('#');//Записывает в поток значение типа char
			dos.flush();//Убеждаемся что буфер в середине пустой, выталкиваем все, очищая буфер поток
			
			boolean b = dis.readBoolean();//Считывает значение из потока типа boolean
			double d = dis.readDouble();//Считывает значение из потока типа double 
			int i = dis.readInt();//Считывает значение из потока типа int
			char c = dis.readChar();//Считывает значение из потока типа char
			System.out.println("Прочитанные примитивные данные с файла: "+b+" "+d+" "+i+" "+c);
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
