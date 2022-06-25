import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Dwarfs {
	public static void main(String [] args) {
		
		Map<Integer, String> dwarfsList = new HashMap<>();
		Weapon weapon = new Weapon("Sword",34);
		/*dwarfsList.put(78, "Dwalin");
		dwarfsList.put(65, "Dori");
		dwarfsList.put(85, "Bobosita");
		dwarfsList.put(67, "Igor");*/
		weapon.toString();
		
		Dwarfs dwarfs= new Dwarfs();
		dwarfs.viewDwarfs(dwarfsList);
		System.out.println(" ");
		dwarfsList = new LinkedHashMap<>();
		dwarfs.viewDwarfs(dwarfsList);
		System.out.println(" ");
		dwarfsList = new TreeMap<>();
		dwarfs.viewDwarfs(dwarfsList);

		System.out.println(weapon);
	
	}
	public void viewDwarfs(Map <Integer, String> map) {
		
		map.put(78, "Dwalin");
		map.put(65, "Dori");
		map.put(85, "Bobosita");
		map.put(67, "Igor");
		
		for(Map.Entry<Integer, String> entry:map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}
class Weapon{
	private int dammage;
	private String name;
	Weapon(String name, int dammage){
		this.name=name;
		this.dammage = dammage;	
	}
	@Override
	public String toString() {
		return "Dammage=" + dammage + " and Name=" + name + "";
	}
	
	
	
	
}
