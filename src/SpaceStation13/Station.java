package SpaceStation13;

public class Station {
	
	public void shutlle(boolean come) {
		String color = "White";
		int speed = 100;
		if(come == true) {
			System.out.println(color + " Shuttle is coming");
		}else {
			System.out.println(color + " Shuttle isn`t coming");
		}
	}
	
	
	public static void main(String [] args) {
		Clown clown = new Clown("Albert","Clown","Grey");
		Clown clown1 = new Clown("Grraxs","Clown",'M',"Vox");
		SecurityOfficer securityOfficer= new SecurityOfficer("Karl","Security",'M',"People");
		
		HeadOfPersonal headOfPersonal = new HeadOfPersonal("Bob","HeadOfPersonal",'M',"People");
		SecurityOfficer securityOfficer2= new SecurityOfficer("Taras","Security",'M',"People");
		
		clown.honk();
		clown.showId();
		clown1.showId();
		
		securityOfficer.showId();
		securityOfficer.patrol();
		
		headOfPersonal.showId();
		headOfPersonal.amountEmploee();
		
		Station station = new Station();
		station.shutlle(true);
	}
}
