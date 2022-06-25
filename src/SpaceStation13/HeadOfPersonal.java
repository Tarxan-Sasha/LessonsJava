package SpaceStation13;

public class HeadOfPersonal extends StationEmploee{
	
	public HeadOfPersonal(String name, String speciality, char sex, String race) {
		super(name, speciality, sex, race);
		
	}
	public HeadOfPersonal(String name, String speciality, String race) {
		super(name, speciality, race);

	}

	@Override
	public void voiceChat() {

		
	}
	
	public void amountEmploee() {
		System.out.println("Работиков на станции : "+amount);
	}
}
