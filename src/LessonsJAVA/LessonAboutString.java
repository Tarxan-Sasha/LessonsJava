package LessonsJAVA;
/*
 *	String
 *	String это класс который позволяет нам создавать строки.
 *	String являеться не расширяемым, то есть имеет модификатор final
 *	(модификатор final для классов означает что класс не может иметь дочерних классов, ну или быть родительским)
 *	String являеться неизменяемым(immutable), это значит что при изменении строки, сама строка не изменяеться,
 *	а просто создаеться новая строка в String Pool, что засаряет память мусором, если программа должна часто изменять строки.
 *	Но так же неизменяемость делает String потокобезопастным.
 *	Для String переопределён оператор конкатенации "+", что упрощет сложение строк.
 *	(В середине  java оператор "+" выполняется методом append() классов StringBuffer либо StringBuilder)
 *	String - это посути набор символов, потому к нему можно применить метод length() что бы узнать длину строки.
 *
 *	String Pool
 *	String Pool это участок памяти в java, который находиться в куче(Heap)
 *	String Pool хранит в себе все строки созданные в проэкте.
 *	Каждый раз при создании новой строки java сначала проверяет String Pool на наличие такой же строки,
 *	если такая строка была найдена, тогда новая строка в String Pool не создается.
 *	Новая переменная просто ссылаеться на уже созданую строку в String Pool.
 *	Этот процесс помогает секономить место в памяти.
 *	Эсли создать обьект способом:
 *	String name = new String("Bobos");	
 *	Тогда обьект создаться сразу в куче.
 *	Его можно всунуть в String Pool, с помощью метода intern().
 *
 *	StringBuffer
 *	StringBuffer это тоже самое что и String, но с парой отличий:
 *	1) StringBuffer являеться изменяемым(mutable), то есть при изменении строки,
 *	не создаеться новая строка, а изменяеться текущая. Что экономит место.
 *	2) StringBuffer являеться потокобезопастным. Потому что его методы синхронизированы,
 *	и его обьекты могут использоваться сразу несколькими потоками одновременно.
 *	Но синхронизированные методы медленее обычных.
 *	Вместо оператора конкатенации "+", используеться метод append().
 *
 *	StringBuilder (появился в java 5)
 *	StringBuilder тоже самое что и StringBuffer, но с одним отличием:
 *	1) StringBuilder не потокобезопастный. От чего он быстрее чем StringBuffer.
 *	
 *						String					|	StringBuffer					|	StringBuilder
 *	Изменяемость		Immutable (нет)			|	mutable (да)					|	mutable (да)
 *	Расширяемость		final (нет)				|	final (нет)						|	final (нет)
 *	Потокобезопасность	Да, за счет 			|	Да, за счет						|	Нет
 *						неизменяемости			|	синхронизации					|
 *	Когда использовать	При работе со строками,	|	При работе со строками, 		|	При работе со строками, 
 *						которые редко будут 	|	которые часто будут изменяться,	|	которые часто будут изменяться	
 *						модифицироваться		|	в многопоточной среде			|	в однопоточной среде
 *
 *
 */
public class LessonAboutString {
	public static void main(String [] args ) {
		String name  = "Bobos";//Создаеться новая стркоа в String Pool
		String name1 = "Bobos";//НЕ создаеться новая строка, переменная name1 просто ссылаеться на уже существующую в String Pool
		String name2 = new String("Bobos");// Создаеться новый обьект в куче
		String name3 = new String(new char[] {'I','l','y','u','k','h','a'});
		//Все эти методы по-итогу равны

		System.out.println(name);
		System.out.println(name1);
		System.out.println(name2);
		System.out.println(name3);
		
		System.out.println();
		
		System.out.println(name==name1);//Сравниваем ссылки на обьекты в памяти, они равны и выдают true,потому как ссылаються на одну строку в String Pool
		System.out.println(name==name2);//Сравниваем ссылки на обьекты в памяти, они НЕ равны и выдают false,потому как name в String Pool, а name2 просто в куче(Heap)
		String n = name2.intern();//Вставляем строку name2 в String Pool, передавая значение новой переменной n
		System.out.println(name==n);//Сравниваем ссылки на обьекты в памяти, они равны и выдают true
		
		System.out.println();
		
		name.toUpperCase();
		//Изменяем строку с помощью одного из доступных методов в String, создаеться новая строка, к которой мы обратиться не можем...она как бы без именни в String Pool
		System.out.println(name);//Нечего не изменилось переменная досих пор ссылаетсья на изначальную строку
		System.out.println(name==name1);//Сравненине показывает true
		name = name.toUpperCase();//Переопределяем переменую
		System.out.println(name);//Теперь она изменилась
		System.out.println(name==name1);//Сравненине показывает false, так как теперь ссылки разные
		
		System.out.println();
		
		StringBuffer weapon = new StringBuffer("Sword"); 
		StringBuilder weapon1 = new StringBuilder("Bow");
		
		System.out.println(weapon);
		System.out.println(weapon1);
		
		weapon.append(" ");
		weapon.append(weapon1);
		
		System.out.println(weapon);
	}
}
