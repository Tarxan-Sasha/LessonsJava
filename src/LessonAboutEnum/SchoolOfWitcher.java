package LessonAboutEnum;

public enum SchoolOfWitcher {
	SchoolOfWolf("Школа Волка"), SchoolOfBear, SchoolOfCat, SchoolOfSnake, SchoolOfGriffon;
	
	String translation;
	SchoolOfWitcher(){
		
	}
	SchoolOfWitcher(String translation){
		this.translation = translation;
	}
	
	String getTranslation() {
		return translation;
	}
	
}
