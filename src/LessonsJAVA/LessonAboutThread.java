package LessonsJAVA;

public class LessonAboutThread {
	public static void main(String [] args) {
		 TestThread testThread = new  TestThread();
		 testThread.start();
	}
}
class TestThread extends Thread{
	volatile int s=3;
	public void run() {
		System.out.println("Hello from thread one");
	}
}