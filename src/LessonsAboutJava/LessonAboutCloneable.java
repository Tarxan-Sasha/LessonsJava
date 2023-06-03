package LessonsAboutJava;
/* Клонирование/Копирование
 * В Java когда мы создаем обьект, мы присваиваем его ссылке которая на него указывает.
 * Pistol pistol = new Pistol(); - создалась ссылка которая указывает/ссылается на обьект в памяти.
 * Если мы создадим обьект и присвоем ему значение прошлого через знак "=", тогда скопируеться именно ссылка на обьект, а не сам обьект.
 * Pistol pistol1 = pistol; - здесь скопирована именно ссылка на уже существующий обьект, новый обьект НЕ создался. 
 * Мы просто привязали еще одну ссылку к уже существуещему обьекту в памяти.
 * И когда мы захотим изменить параметр у обьекта через pistol1, тогда этот параметр измениться и у pistol.
 * Потому что обьект один на двоих.
 * 
 * Для решения задач, когда нам нужно создать несколько одинаковых обьектов по примеру другого обьекта, 
 * и при этом нам нужно иметь возможность изменить эти новые обьекты не трогая старый.
 * Есть клонирование/копирование.
 * 
 * За клонирование в Java отвечает маркерный интерфейс Сloneable.
 * Он не имеет ни каких методов или переменных, он просто указывает Java что обьекты класса имплиментируещего Сloneable можно клонировать.
 * А так же в Java, а именно у класса Object(Родитель всех классов) есть метод clone();.
 * clone() - один из стандартных методов класса Object. Он копирует/клонирует обьект передаваемый в параметр.
 * В случае если класс обьекта вызывающий метод clone() не импелементирует Сloneable, тогда будет выбрашенно исключение CloneNotSupportedException.
 * Так же метод clone() требуется переопределять, потому что:
 * 1) Он имеет модификатор доступа protected, который не позволяет ему вызываться в других пакетах
 * 2) Возвращаемый тип clone() - это Object. Это тоже следует изменить на имя класса обьекта.
 * Метод clone() реализует по дефолту Поверхностное клонирование, для глубокого его нужно модифицировать самому.
 * Внутри себя метод clone() реализует логику Констурктора копирования(Один из способов клонирования)
 * 
 * Для клонирования обьекта необходимо:
 * 1) Класс обьекта должен имплементировать интерфейс Сloneable.
 * 2) Класс обьекта должен переопределить метод clone()
 * 
 * Поверхностное клонирование - клонирует все переменные и методы клонируемого обьекта.
 * Но не клонирует обьекты внутри клонируемого обьекта.
 * Для выполнения поверхностного клонирваония, стоит просто выполнить все что написанно выше.
 * Опять таки метод clone() по умолчанию выполняет именно поверхностное клонирование
 * 
 * Глубокое клонирование - клонирует все переменные и методы клонируемого обьекта, А также обьекты внутри клонируемого обьекта.
 * Для выполнения глубокого клонирования, следует повторить написанные выше требования не только в классе обьекта вызывающего метод clone(), 
 * но и в тех классах чьи обьекты находяться в классе обькта вызывающего метод clone().
 * Да звучит пиздец...
 * ну короче, есть класс1 и в нем есть обьект класса2 и обьект класса1 вызывает метод clone().
 * Если класс1 имплементировал Cloneable и переопределил метод clone() - тогда это поверхностное клонирование (клонировось все, кроме обьекта класса2)
 * А если и класс2 имплементировал Cloneable и переопределил метод clone(), и класс1 вызвал реализацию clone() класса2 после своей - тогда это глубокое клонирование (склонировалось ВСЕ)
 * 
 * Клонирование может быть реализованно 
 * 1)Методом clone и имплементацией Сloneable.
 * 2)Контркором копирования
 * 3)Сериализацией
 */
public class LessonAboutCloneable {

	public static void main(String[] args) throws CloneNotSupportedException {//Метод clone() может выбросить исключение
		Zombie zombie1 = new Zombie();
		zombie1.hp=3;
		zombie1.name="Саша";
		zombie1.infection.stage = 1; 
		System.out.println(zombie1+" Обьект зомби Саша");
		System.out.println("Поверхностное копирование: ");
		Zombie zombie2 = zombie1.clone();
		System.out.println(zombie2+" Обьект склонировался с зомби Саша, склонировал все кроме обьекта infection. Он ссылаетсья на тот же обьект infection что и зомби Саша");
		zombie2.hp = 5;
		zombie2.name = "Леша";
		zombie2.infection.stage = 3; 
		System.out.println(zombie2+" Изменили параметры обьекта");
		System.out.println(zombie1+" А зомби Саша не пострадал, кроме обьекта infection он изменился");
		System.out.println("Склонировались и спокойно изменились переменные, но не внутренний обьект. Эти обьекты ссылаеються на один и тот же внутренний обьект");
		
		System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		
		System.out.println("Глубокое копирование: ");
		Zombie zombie3 = zombie2.deepClone();
		System.out.println(zombie3+" Обьект склонировался с зомби Леша, склонировал ВСЕ. Он ссылаетсья на другой уже обьект infection");
		zombie3.hp=7;
		zombie3.name = "Бобос";
		zombie3.infection.stage=5;
		System.out.println(zombie3+" Изменили параметры обьекта");
		System.out.println(zombie2+" А зомби Леша не пострадал ");
		System.out.println("Склонировались и спокойно изменились переменные и внутренний обьект. Эти обьекты ссылаеються на разные обьекты");
		
		System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		
		System.out.println("Конструктор поверхностоного копирования: ");
		Zombie zombie4 = new Zombie(zombie3);
		System.out.println(zombie4+" Обьект склонировался с зомби Бобоса, склонировал все кроме обьекта infection. Он ссылаетсья на тот же обьект infection что и зомби Бобос");
		zombie4.hp=9;
		zombie4.name="Илюха";
		zombie4.infection.stage=7;
		System.out.println(zombie4+" Изменили параметры обьекта");
		System.out.println(zombie3+" А зомби Бобос не пострадал, кроме обьекта infection он изменился");
		System.out.println("Склонировались и спокойно изменились переменные, но не внутренний обьект. Эти обьекты ссылаеються на один и тот же внутренний обьект");
		
		System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		
		System.out.println("Конструктор глубокого копирования: ");
		Zombie zombie5 = new Zombie(zombie4);
		System.out.println(zombie5+" Обьект склонировался с зомби Илюха, склонировал ВСЕ. Он ссылаетсья на другой уже обьект infection");
		zombie5.hp=11;
		zombie5.name="Андрей";
		zombie5.infection.stage=10;
		System.out.println(zombie5+" Изменили параметры обьекта");
		System.out.println(zombie4+" А зомби Илюха не пострадал, кроме обьекта infection он изменился");
		System.out.println("Склонировались и спокойно изменились переменные и внутренний обьект. Эти обьекты ссылаеються на разные обьекты");
	}

}

class Zombie implements Cloneable{//Для возможности клонирования мы обязательно имплементируем интерфейс маркер Cloneable
	int hp;
	String name;
	Infection infection = new Infection();
	@Override
	public Zombie clone() throws CloneNotSupportedException{//Переопределяем метод, меняя модификатор доступа с protected на public, и возвращаемый тип с Object на Zombie
		return (Zombie) super.clone();//Вызываем реализацию метода clone из родительского класса Object, с помощью ключевого слова super.
									  //Так же мы приводим клонируемый обьект к типу Zombie, записывая (Zombie). 
									  //Потому что метод clone() который вызывает super вернет обьект типа Object, а нам нужен Zombie.
	}
	
	//Метод для глубокого клонирования, в целом это все должно быть в обычном clone(), 
	//но мне хотелось разделить глубокое и поверхностное, потому я создал этот метод. НО В ИДЕАЛЕ ЭТО ПРОСТО ТОТ ЖЕ МЕТОД clone()
	public Zombie deepClone() throws CloneNotSupportedException{//Снова все переопределям и изменяем
		Zombie zombie = (Zombie) super.clone();//Обычное копирование из метода clone() выше, за исключением того что мы создаем новую ссылку\новую переменную куда сохраняем клонируемый обьект
		Infection infection = this.infection.clone();//Тут мы создаем переменную класса Infection и присваиваем клонируемый обьект класса Infection
													 //Через ключевое слово this(обозначает обьект вызвавший метод) мы вызываем обьект infection и у него вызываем метод clone().
													 //Так же слово this можно заменить на только-только созданный обьект zombie. Роли не играет, что то обьект Zombie что то обьект Zombie. 
		zombie.infection=infection;//Вызываем внутренний обьект infection у только что созданого обьекта zombie и присваиваем ему новый только что клонированный обьект infection.
		return zombie;//Возвращаем новый полностью клонированный(МОжнос казать глубоко клонированый) обьект zombie.
	}
	
	
	//Конструторы копирования
	public Zombie(){//Обычный стандартный пустой конструктор	
	}
	public Zombie(Zombie zombie) {//Конструктор поверхностного копирования, мы просто создаем
		this.hp = zombie.hp;//Передаем пареметр из обьекта в аргументах в новый обьект
		this.name = zombie.name;//Передаем пареметр из обьекта в аргументах в новый обьект
		this.infection = zombie.infection;//Передаем пареметр из обьекта в аргументах в новый обьект
	}
	public Zombie(Zombie zombie, int i) throws CloneNotSupportedException {//Конструктор гулбокого копирования, мы просто создаем
		this.hp = zombie.hp;//Передаем пареметр из обьекта в аргументах в новый обьект
		this.name = zombie.name;//Передаем пареметр из обьекта в аргументах в новый обьект
		this.infection = zombie.infection.clone();//Все то же самое что и в методе deepClone()
	}
	
	@Override
	public String toString() {
		return "Zombie [hp=" + hp + ", name=" + name + ", infection=" + infection + "]";
	}
}

class Infection implements Cloneable{
	int stage;
	@Override
	public Infection clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Infection) super.clone();
	}
	@Override
	public String toString() {
		return "Infection [stage=" + stage + "]";
	}
	
}

















