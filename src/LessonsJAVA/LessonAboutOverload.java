package LessonsJAVA;

public class LessonAboutOverload {
	String name;
	public LessonAboutOverload(){
		
	}
	public LessonAboutOverload(String name){
		this.name=name;
	}
	
	public static void main(String [] args) {
		LessonAboutOverload human = new LessonAboutOverload("Илюхa");
	
		human.work();
		human.work(3);
		human.work("Илюхой");
		human.work("Бобасом", 2);
	}
	
	void work() {
		System.out.println("я работаю все время");
	}
	
	void work(int hour) {
		System.out.println("я работаю "+hour+" часов");
	}
	
	void work(String name) {
		System.out.println("я работаю вместе с "+name);
	}
	
	void work(String name,int hour) {
		System.out.println("я работаю вместе с "+name+" "+hour+" часов");
	}
	
}
