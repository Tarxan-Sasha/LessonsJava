package LessonsAboutCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Human implements Comparable<Human>{
	int age;
	String name;
	public Human(int age , String name) {
		this.age=age;
		this.name=name;
	}

	public int getAge() {
		return age;
	}

	public static void main(String[] args) {
		HumanNameComparator humanNameComparator = new HumanNameComparator();
		Set<Human> list =new TreeSet<>();
		
		Human human1 = new Human(12,"Ivan");
		Human human2 = new Human(34,"Boris");
		Human human3 = new Human(78,"Vlodimer");
		Human human4 = new Human(45,"Pashka");
		
		
		list.add(human1);
		list.add(human2);
		list.add(human3);
		list.add(human4);
		
		System.out.println(human1);
		
		System.out.println(list);
		
		System.out.println(list);
		
		//Collections.sort(list, humanNameComparator);

		System.out.println(list);
	}
	
	
	@Override
	public int compareTo(Human o) {
		if(this.age > o.age && this.name.length()>o.name.length()) {
			return 1;
		}else {
			if(this.age < o.age && this.name.length()<o.name.length()) {
				return -1;
			}else {
				return 0;
			}
		}
	}

	
	@Override
	public String toString() {
		return "Human [age=" + age + ", name=" + name + "]";
	}

}
