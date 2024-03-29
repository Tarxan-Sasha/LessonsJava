package LessonsAboutInnerClasses;
/*
 * Локальный класс
 * Локальный класс создаеться в методе внешнего класса.
 * Локальный класс имеет точно такое же прямое отношение к внешнему классу, как и Внутрений не статический 
 * 
 * Локальный класс имеет доступ ко всем переменным и методам внешнего класса. Даже если они pivate.
 * К перменным метода, в котором создан локальный класс, локальный класс имеет доступ только если переменные с модификатором final
 * или же если они effective final(начиная с Java 8).
 * 
 * effective final - это когда в течении кода переменная не меняется
 * 
 * В самом методе обьект Локального класса можно создать только после обьявления самого Локального класса
 * Локальный класс не может быть private, public, protected или static
 * Локальный класс не может иметь в себе static (ни переменные, ни методы, ни классы)
 * Исключение это переменные с модификатором static final
 * 
 * Локальный класс может быть abstract или final.
 * 
 * Если Локальный класс обьявлен в статическом методе, то доступ он имеет только к статическим переменным внешнего класса
 * 
 */
public class City {
	private int postCode = 333222;//К этой переменной у локального класса есть дсступ, несмотря на то что она private

	
	public void createAddress() {
		
		int houseNumber= 43;//Эта переменная не меняеться потому она являеться effective final, и потому к ней есть доступ
		//houseNumber= 42;
		/*
		 *  Если мы сменим ей значение, даже до создания локального класса
		 *  она потеряет свое свойство effective final переменной
		 *  И станет просто переменной
		 */
		final int marketNumber=32;////К этой переменной у локального класса есть дсступ, потому что она final
		class Street{

			public void printAddress() {
					
					System.out.println("PostCode "+postCode );
					System.out.println("House "+houseNumber);
					System.out.println("marketNumber "+marketNumber );
		
				}
			}
			
			Street street = new Street();//Обьявить обьект Локального класса можно только после создания этого Локального класса
			street.printAddress();
	}

}
