/* Классы Обертки\оболочки - по сути это классы которые представляют собой расширенные версии обычных примитивных типов.
 * Они имеют названия очень схожие с обычными типами:
 * Примитивный тип|	Оболочка  | Аргументы конструктора
 *  byte		  |  Byte 	  |  byte or String
 *  short 	      |  Short 	  |  short or String
 *  int	          |  Integer  |	 int or String
 *  long 	      |  Long	  |	 long or String
 *  double        |	 Double	  |  double or String
 *  float	      |  Float	  |	 float, double, or String
 *  char		  |  Character|	 char
 *  boolean	      |  Boolean  |  boolean or String
 * 
 * Классы Обёртки имеют два конструктора. Один принимает значение примитивного типа, а второй типа String.
 * В случае со вторым типом String, если будет указано не значение подходящего типа, а например слово. Тогда будет ошибка. Например:
 * Integer integer1 = new Integer("Bobos"); - ошибка.
 * 
 * (Исключением являеться класс Character он принимает только char. А так же с Float он принимает и float, и double, и String)
 * 
 * Если в Boolean ввести что угодно но не true, будет faulse.
 * 
 * По сути эти классы переносят значения в обьекты, для дальнейшего использования, например в Колекциях.
 * По мимо того эти классы имеют дополнительные методы, например несколько из них:
 * 	1) valueOf() - Может служить заменой обычного создания обьекта. А так же, если передать перевое число в типе String, а второе в типе int.
 * 	Тогда можно переревести первое число в другую систему исчисления укзаную вторым числом.
 *  2) parseXxx() - переобразовует строку в нужный приметивный тип. В классе Double - это метод parseDouble(), в классе Long - parseLong() и так далее.
 *  
 *  Все ЧИСЛОВЫЕ классы наследуються от класса Number который даёт им методы, такие как переобразовать заданное число в обьекте в любой другой числовой тип.
 *  
 *  Классы оболочки имеют и константы, например:
 *  Integer имеет константы MIN_VALUE – минимальное int значение и MAX_VALUE – максимальное int значение.
 *  (вызываються как и любая другая статическая константа через собственный класс: Integer.MIN_VALUE и Integer.MAX_VALUE)
 *  Классы обертки числовых типов Float и Double так же дополнительно содержат следующие константы: 
 *  NEGATIVE_INFINITY – отрицательная бесконечность;
 *  POSITIVE_INFINITY – положительная бесконечность;
 *  NaN – не числовое значение (расшифровывается как Not a Number).
 *  
 *  Зачем нужны примитивы, если есть классы?
 *  Из-за производимости.
 *  Примитивные типы потому и называют примитивными, потому что они лишены многих “тяжелых” особенностей объектов. Да, у объекта есть много удобных методов, но ведь они не всегда нужны.
 * 
 */
package LessonsJAVA;

public class LessonAboutWrapperClasses {

	public static void main(String[] args) {
		int i = 3;// Обычное обьявление переменной int
		Integer integer = new Integer(3);// Обьявление через класс Integer помещая число
		Integer integer1 = new Integer("3");// Обьявление через класс Integer помещая число типом String
	    Integer Integer2 = Integer.valueOf(3);// Обьявляем через метод, передавая число
	    Integer Integer3 = Integer.valueOf("3");// Обьявляем через метод, передавая число типом String
		// Все эти пять вариантов являються верными, и по сути одинаковыми.
		
		// Integer integer2 = new Integer("Some Number"); // - Ошибка!!!
		// Компилятор не выдает ошибку при написании, но при запуске будет ошибка. 
		//Даже при написании в виде типа String, строка должна иметь число, а не слово.
	    
		Byte byte1 = new Byte("3"); // Обьявление через класс Byte помещая число типом String
		Short short1 = new Short("4");// Обьявление через класс Short помещая число типом String
		Integer int1 = new Integer(5);// Обьявление через класс Integer помещая число
		Long long1 = new Long(8786L);// Обьявление через класс Long помещая число
		Float float1 = new Float(2.3F);// Обьявление через класс Float помещая число
	    Double double1 = new Double(5.6);// Обьявление через класс Double помещая число
	    Character char1 = new Character('@');// Обьявление через класс Character помещаем символ
	    Boolean boolean1 = new Boolean(true);// Обьявление через класс Boolean помещаем значение true
	    Boolean boolean2 = new Boolean("Bobas");// Если мы положим какой-то любой другой текст, тогда обьект примет значение faulse
	    
	    System.out.println("byte1: "+byte1+", short1: "+short1+", int1: "+int1+", long1: "+long1+", float1: "+float1+", double1: "+double1+", char1: "+char1+", boolean1: "+boolean1+", boolean2: "+boolean2);
	    
	    Integer int2 = Integer.valueOf("1000", 2);// Второе свойство метода valueOf это перевод первого числа в типе String, в систему исчисления указанной вторым значением int
	    System.out.println("Число 1000 переведенное в 2-ную систему: "+int2);
	    
	    String s1 = "10";
	    //int i1 = s1+3;// Вот так добавить мы не можем
	    Integer integer4 = Integer.parseInt(s1);// Но с помощью метода parseInt мы смогли его перестроить в нужный нам тип
	    System.out.println("Integer:"+integer4);
	    Double double2 = Double.parseDouble(s1);// С помощью метода parseDouble мы смогли его перестроить в нужный нам тип
	    System.out.println("Double: "+double2);
	    // Ну и по быстрому для остальных типов:
	    System.out.println("Float.parseFloat: "+Float.parseFloat(s1));
	    System.out.println("Byte.parseByte: "+Byte.parseByte(s1));
	    System.out.println("Short.parseShort: "+Short.parseShort(s1));
	    System.out.println("Long.parseLong: "+Long.parseLong(s1));
	    integer4 = Integer.parseInt(s1, 2);// Второе свойство метода parseInt это перевод первого числа в типе String, в систему исчисления указанной вторым значением int
	    System.out.println(integer4);
	    
	    //одни из констант
	    System.out.println("Максимальное значение типа int: "+Integer.MAX_VALUE);
	    System.out.println("Минимальное значение типа int: "+Integer.MIN_VALUE);
	    System.out.println("Отрицательная бесконечность типа double: "+Double.NEGATIVE_INFINITY );
	    System.out.println("Положительная бесконечность типа double: "+Double.POSITIVE_INFINITY);	    

/* 
 * Автоупаковка и Авторазпаковка
 * Когда мы обьекту класса обёртки присваиваем значение обычной перемной/примитива - это Упаковка:
 * Integer i = 100;
 * 
 * Когда мы обычной переменной/примитиву присваиваем обьект класса обёртки - это Распаковка:
 * Integer bob=3; 
 * int i = bob;
 * 
 */
	   Integer jop = 100;//Автоупаковка
	   Integer bob=3; 
	   int h = bob;//Авторазпаковка
	   
	}	

}
