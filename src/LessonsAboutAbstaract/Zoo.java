/*
 * Абстрактные классы не могут имееть обьекты.
 * Но Абстрактные классы можно использовать для создания ссылок на обьекты:
 * Animal animal = new Bear();
 * 
 */

package LessonsAboutAbstaract;

public class Zoo {
	public static void main(String [] args) {
		/*
		Bear bear = new Bear();
		bear.setCarnivorous(true);
		bear.eat();
		bear.drink();
		bear.sleep();
		bear.scratch();
		
		
		//Animal animal1 = new Animal(); // ЭТО ОШИБКа
		Animal animal = new Bear();// Вот так делать можно
		
		Lama lama = new Lama();
		lama.setCarnivorous(false);
		lama.eat();
		lama.drink();
		lama.sleep();
		lama.spiting();
		
		*/
		////////////////////////
		
		Bear bear1 = new Bear("Bob",true);
		bear1.eatWithName();
		Lama lama1 = new Lama("Ema", false);
		lama1.eatWithName();
	
	}
}
