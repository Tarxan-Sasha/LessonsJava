import java.util.Scanner;

public class Killer implements Runnable {
	public static void main(String [] args) {
		Thread thread=new Thread(new Killer());
		thread.start();

	}

	@Override
	public void run() {
		char man = '0';
		char way[] = {man,'_','_','_','_','_'};
			for(int i=0; i<=way.length;i++) {
				System.out.print(i);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			}
		}
		

