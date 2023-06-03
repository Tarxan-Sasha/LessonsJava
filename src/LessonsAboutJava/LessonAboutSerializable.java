package LessonsAboutJava;

import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*	
 * Сериализация - это название процесса сохранения состояния обьектов в поток.
 * Если немного обширней то обьект сжимаеться превращаясь/конвертируясь в байты и после этого записывается в поток.
 * При сериализации сохраняеться все переменные обьекта, и переменные других обьектов которые находяться в обьекте,
 * и переменные обьектов других обьектов находящихся в обьектах:3
 * В общем весь этот путь сохранений из обьекта в обьект называеться Графом Исходного Обьекта.
 * 
 * Десирилизация - это обратный процесс превращения/конвертирования байтов из потока в обьект.
 * Сериализация и Десирилизация не привязана к платформе, а это значит что мы можем серилизовать обьекты в одном месте,
 * а десирилизовать в другом.
 * 
 * Сериализация в основном используеться в таких технологиях как:
 * Hibernate, RMI, JPA, EJB и JMS.
 * Так же часто сериализация используеться для перемещения обьектов по сети.
 * 
 * Для сериализации класс обьекта должен имплементировать интерфейс Serializable.
 * Этот интерфейс являетсья маркерным, то есть он не имеет в себе нечего(ни методов, ни переменных), 
 * он лишь указывает системе на то что обьекты этого класса дуступны для сериализации.
 * Или же, как вариант, класс обьекта должен наследоватся(быть дочерним) от другого класа который имплементирует интерфейс Serializable.
 * Так же вспоминая Граф исходного обьекта, все обьекты которые есть в серилизуемом обьекте и обьекты в этих обьектах и так далее
 * должны иметь возможность сериализации: Их класс должен имплементировать интерфейс Serializable, 
 * или классы должны быть дочерними от классов с имплементированным интерфейсом Serializable. 
 * 
 * Для реализации сериализации есть поток ObjectOutputStream. 
 * Который принимает в свой контструктор другой поток вывода байтов(который наследует OutputStream).
 * ObjectOutputStream имплементирует интерфейс ObjectOutput, который уже имплементирует DataOutput, AutoCloseable.
 * Что дает ему кучку методов по записыванию различных данных в поток, а так же возможность закрыватся с помощью try-with-resources.
 * ObjectOutputStream имеет особый метод writeObject(Object o) который и совершает саму сериализацию обьекта.
 * writeObject(Object o) конвертирует/превращает состояние обьекта в байты и записывает их в поток.
 * 
 * Для реализации десирилизации есть поток ObjectInputStream.
 * Который принимает в свой конструктор другой поток ввода байтов(который наследует InputStream)
 * ObjectInputStream имплементирует интерфейс ObjectInput, который уже имплементирует DataInput, AutoCloseable.
 * Что дает ему кучку методов по записыванию различных данных в поток, а так же возможность закрываться с помощью try-with-resources.
 * ObjectInputStream имеет особый метод readObject() который и совершает десирилизацию обьекта.
 * readObject() конвертирует/превращает байты из потока в обьекты ( и именно в том состоянии в котором они были сериализованы)
 * 
 * Статические(static) переменные сирилизоваться не будут.
 * (статические(static) переменные это достояние класса, а не обьекта. А серелизуеться именно обьект)
 * Статическая переменная не измениться при десиарилизации.
 * Так же могут быть случаи когда не нужно что б какая то переменная серилизовалась
 * для этого есть ключевое слово transient.
 * transient - ключевое слово которое не позволяет переменной серилизоваться, 
 * при десерилизации переменной с transient будет присвоенно значение по умолчанию(Для String null, для boolean false, для int 0 и т.д.)
 * 
 */
public class LessonAboutSerializable {

	public static void main(String[] args) {
		File file = new File("src/LessonsAboutJava/TestSerialization.dat");
		SpaceMarine spaceMarine1 = new SpaceMarine("Bobas","Red");
		SpaceMarine spaceMarine2  = new SpaceMarine("Ilyha","White");
		Gun gun = new Gun("ew","ew"); 
//		List<SpaceMarine> group = new ArrayList<SpaceMarine>();
//		group.add(spaceMarine1);
//		group.add(spaceMarine2);
		
		//Конструкторы ObjectOutputStream
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){//Принимает на вход обьект другого класса который наследуется от OutputStream
//			oos.writeObject(group);
			oos.writeObject(spaceMarine1);//Сериализуем обьект, конвертируем/превращаем обьект в байты и отправляем по по потоку в внутрений поток, а затем в файл.
			oos.writeObject(spaceMarine2);//Сериализуем обьект, конвертируем/превращаем обьект в байты и отправляем по по потоку в внутрений поток, а затем в файл.
			oos.writeObject(gun);//Сериализуем обьект, конвертируем/превращаем обьект в байты и отправляем по по потоку в внутрений поток, а затем в файл.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Конструкторы ObjectInputStream
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){//Принимает на вход обьект другого класса который наследуется от ObjectInputStream
			ois.readObject();//Десиарилизуем обьект, превращаем/конвертируем байты которые мы читаем в потоке в обьект
			ois.readObject();//Десиарилизуем обьект, превращаем/конвертируем байты которые мы читаем в потоке в обьект
//			ArrayList<SpaceMarine> sm = (ArrayList<SpaceMarine>) ois.readObject();
//			for(SpaceMarine s : sm) {
//				System.out.println(s);
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}



class Gun extends SpaceMarine {//Тут мы наследуемся от класса который имплементирует интерфейс Serializable, потому обьекты класса Gun сериализуемы

	Gun(String name, String color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}
	
}


class SpaceMarine implements Serializable{//Имплементируем Serializable для возможности сериализации обьектов этого класса
	private String name;
	private String color;
	private static int number=0;//Эта переменная серилизоватсья не будет, при десериализации она не измениться
	private transient int kills;//Эта переменная не будет сериализоваться из-за слова transient, мы сами явно/вручную исключили ей эту возможность
								//при десиарилизации эта переменая будет иметь значение по умолчанию, в случае с int 0
	
	
	SpaceMarine (String name, String color) {
		this.name = name;
		this.color = color;
		number++;
	}
	
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "SpaceMarine [number="+number+", name=" + name + ", color=" + color + "]";
	}

}