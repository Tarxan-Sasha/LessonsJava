/*
 * Если класс реализует Интерфейс, тогда при создании обьекта 
 * можно вместо названия класса написать имя Интерфейса, например:
 * Moveable clown = new Clown();
 * В таком случаее обьект clown может импользовать ТОЛЬКО те члены класса
 * которые описаны в Интерфейсе
 *  
 */

package LessonAboutInterface;

public class Station {
	public static void main(String[] args) {
		Clown clown = new Clown("Bibo","Clown");
		SecurityOfficer securityOfficer = new SecurityOfficer();
		Mime mime = new Mime("Pedro","Mime");
		clown.PDA(clown, mime);
		mime.PDA(mime, clown);
		
		
		mime.voiceChat(mime);
		clown.voiceChat(clown);
		

		
		
	/*	Moveable.HearStep();
		

		
		clown.moveDown();
		clown.Honk();
		
		securityOfficer.moveUp();
		System.out.println(securityOfficer.kick()+" Клоуна");
		
		Moveable clown1 = new Clown("Koko","Clown");	
		
		//Moveable moveable = new Moveable(); Ошибка ИНЕТЕРФЕЙСЫ НЕ МОГУТ ИМЕТЬ обьекты.
		clown1.moveDown();

		System.out.println("Клоун "+clown.run());	
		
	*/
		
	
	}
	
	
	public static void shuttle(Moveable moveable) {
		System.out.println("Shuttle comed");
		System.out.println("comed");
	}
/*
	static public void moveDown(Moveable moveable) {
		moveable.moveDown();
	}
*/	
	
}
