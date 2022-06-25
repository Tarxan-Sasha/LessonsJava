/*
 * Абстракктция - это принцип ООП, согласно которому при проектировании классов и создании объектов необходимо выделять только главные свойства сущности, и отбрасывать второстепенные. 
 * то есть абстрактный класс представляет из себя шаблон чего то с основными методами/свойствами, к примеру:
 * У нас есть класс животное, но в мире нет "просто животных", есть медведи, львы, лошади и т.д.
 * Животное - это абстрактное понятие.
 * Абстрактный класс Animal являеться лишь шаблоном/чертежом для классов животных,
 * он имеет в себе абстрактные методы которые общие для всех животных.
 * 
 * Обозначить класс или метод абстрактным можно ключевым словом "abstract" перед словом "class".
 * 
 * Абстрактные методы не имеют в себе реализации, они ОБЬЯЗАНЫ быть переопределёными в дочерних классах.
 * Но Абстрактный класс может иметь обычные/НЕ абстрактные методы с реализацией, если такие нужны.
 * 
 * Класс называеться Абстрактным если в нем есть хотя бы ОДИН абстрактный метод, даже если он 1 из 100000.
 * (Класс МОЖНо сделать абстрактным и без абстрактных методов, но это херня...и люди просто тебя не поймут...типо НАХУЯ?)
 * 
 * Абстрактный класс не может иметь абстрактные конструкторы или абстрактные статические методы.
 * 
 * Создавать обьекты абстрактного класса НЕЛЬЗЯ
 * 
 */


package LessonsAboutAbstaract;

public abstract class Animal {
	 
	 public Animal() { // Пустой констурктор абстрактоного класса, иметь обьекты абстрактный класс не может, но конструктор МОЖЕТ.
		 
	 }
	

	 private boolean carnivorous=false; 
	 private String name;
	 
	 public void setCarnivorous(boolean carnivorous) {
		this.carnivorous = carnivorous;
	}
	 
	public boolean getCarnivorous() {
		return carnivorous;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public abstract void sleep(); //Абстрактный метод ДОЛЖЕн быть реализован/переопределен в дочернем классе
	public abstract void drink();//Абстрактный метод ДОЛЖЕн быть реализован/переопределен в дочернем классе
	
	public void eat() {//НЕ абстрактный метод может имеет право тут быть, если это требуется. Конечно же может быть переопределен.
		if(this.carnivorous==true) {
			System.out.println("Animal eating meat");
		}else {
			System.out.println("Animal eating plants");
		}
	}
	
	//////////////////////////
	
	public Animal(String name, boolean carnivorous){
		this.name = name;
		this.carnivorous = carnivorous;
		System.out.println("Мы в конструкторе Animal");
	}
	public void eatWithName() {
		if(this.carnivorous==true) {
			System.out.println(name+" eating meat");
		}else {
			System.out.println(name+" eating plants");
		}
	}
	
}
