package LessonsAboutCollections;

import java.util.Comparator;

public class HumanNameComparator implements Comparator<Human>{

	@Override
	public int compare(Human o1, Human o2) {
		return o2.name.length()-o1.name.length();
	}
	
}