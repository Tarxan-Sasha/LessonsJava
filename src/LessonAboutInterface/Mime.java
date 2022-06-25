package LessonAboutInterface;

public class Mime extends StaffOfStation implements Run {
	
	public Mime(String name, String speciality) {
		super(name, speciality);
	}
	
	@Override
	public void voiceChat(StaffOfStation staffOfStation) {
		System.out.println(staffOfStation.name+" speaks");
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void moveDown() {
		System.out.println("Мим идет в низ");
	}
	@Override
	public void moveLeft() {
		System.out.println("Мим идет в лево");
	}
	@Override
	public void moveRight() {
		System.out.println("Мим идет в право");
	}
	@Override
	public void moveUp() {
		System.out.println("Мим идет в верх");
	}
	

}
