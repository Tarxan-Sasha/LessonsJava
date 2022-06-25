package SpaceStation13;

public class Clown extends StationEmploee {
	public Clown(String name, String speciality, char sex, String race) {
		super(name, speciality, sex, race);
	}
	public Clown(String name, String speciality, String race) {
		super(name, speciality, race);
	}
	@Override
	public void voiceChat() {
		// TODO Auto-generated method stub
	
	}

	int bootsSize = 32;
	
	public void honk() {
		System.out.println(name+" ["+speciality+"] "+"хонкает");
	}

}
	
