package SpaceStation13;

public class SecurityOfficer extends StationEmploee{
	public SecurityOfficer(String name, String speciality, char sex, String race) {
		super(name, speciality, sex, race);
	}
	public SecurityOfficer(String name, String speciality, String race) {
		super(name, speciality, race);
	}
	@Override
	public void voiceChat() {
		// TODO Auto-generated method stub
		
	}
	public void patrol() {
		System.out.println(name+" ["+speciality+"] "+"отправился в патруль");
	}
}
