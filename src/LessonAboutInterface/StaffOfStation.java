package LessonAboutInterface;

public abstract class StaffOfStation {
	
	String name;
	String speciality;
	StaffOfStation(String name, String speciality ){
		this.name = name;
		this.speciality = speciality;
	}
	
	public String getName() {
		return name;
	}
	public String getSpeciality() {
		return speciality;
	}
	
	public abstract void voiceChat(StaffOfStation staffOfStation);
	
	public void PDA(StaffOfStation staffOfStation, StaffOfStation staffOfStation1) {
		System.out.println(staffOfStation.name+"["+staffOfStation.speciality+"]"+" chats with "+staffOfStation1.name+"["+staffOfStation1.speciality+"]");
	}
	
}
