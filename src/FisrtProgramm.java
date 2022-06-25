import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;
public class FisrtProgramm extends Thread {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();		
		HashSet <String>inventory = new HashSet<String>();
		List<String> items= new ArrayList<String>();	
		FisrtProgramm tread = new FisrtProgramm();
		tread.start();
		items.add("Mute");
		items.add("Smoke");
		items.add("Mozzie");
		items.add("Maverick");
		items.add("Dokkaebi");
		String firstAction = scanner.nextLine();
		int money = 0;
		while(firstAction.equals("run")) {
			String secondAction = scanner.nextLine();
			if(secondAction.equals("start")) {
				int item = random.nextInt(5);
				if(!(inventory.contains(items.get(item)))) {
					System.out.println(items.get(item));
					inventory.add(items.get(item));
				}else {
					money=money+400;
					System.out.println(items.get(item)+"+400$");
				}
			}
			if(secondAction.equals("check")) {
				for(String i:inventory) {
					System.out.println(i);
				}
			}
			if(secondAction.equals("money")) {
				System.out.println(money+"$");
			}
			if(secondAction.equals("stop")) {
				break;
			}
		
		}
	}

}
