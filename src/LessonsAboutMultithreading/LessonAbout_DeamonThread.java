package LessonsAboutMultithreading;
/*
 * Демон - вообще это понятие которое означает фоновую программу.
 * В многопоточности java это что то похожее, это фоновый поток который создан и создаеться для того что бы обслуживать обычные/основные/пользовательские потоки.
 * Пользовательский поток или user thread - это так называют обычный поток.
 * 
 * Жизнь потоков демонов полностью зависит от пользовательских потоков, 
 * когда пользовательские потоки заканчивается, java автоматически выключает все deamon потоки.
 *  
 * Deamon потоки имеют самый низкий приоритет.
 * 
 * 1) setDeamon(boolean d) - с помощью этого метода можно установить будет ли текущий поток Deamon, true = deamon, false = не deamon
 * 2) isDeamon() - проверяет являиться ли поток демоном
 * 
 */
public class LessonAbout_DeamonThread {

	public static void main(String[] args) {
		
		Thread tdt = new Thread(new DeamonThread());
		Thread tdf = new Thread(new DeamonThread());
		
		tdt.setDaemon(true);
		
		tdt.start();
		tdf.start();
		
	}
}

class DeamonThread implements Runnable{

	@Override
	public void run() {
		if(Thread.currentThread().isDaemon()) {
			System.out.println("Deamon");
		}else {
			System.out.println("User-Thread");
		}
		
	}

}