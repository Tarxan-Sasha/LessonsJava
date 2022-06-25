package SpaceStation13;
import java.util.Random;

public abstract class StationEmploee {
	Random random=new Random();
	protected int id = random.nextInt(6000000);
	protected String name;
	protected String speciality;
	protected String race;
	protected char sex;
	static int amount=0;
	
	public StationEmploee(String name, String speciality, char sex, String race){
		this.name=name;
		this.speciality=speciality;
		this.race=race;
		this.sex=sex;
		
		amount++;
	}
	public StationEmploee(String name, String speciality, String race){
		this.name=name;
		this.speciality=speciality;
		this.race=race;
		
		amount++;
	}

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public String getRace() {
		return race;
	}
	
	public abstract void voiceChat();
	
	public void showId() {
		System.out.println("ID card ["+id+"]");
		System.out.println("Имя : "+name);
		System.out.println("Специальность : "+speciality);
		System.out.println("Пол : "+sex);
		System.out.println("Раса : "+race);
		System.out.println(" ");
	}

}
